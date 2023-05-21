SELECT
  CONCAT('Project ', CHAR(64 + seq_num)) AS NAME,
  SUM(worker.salary * (DATEDIFF('MONTH', project.start_date, project.finish_date) + 1)) AS PRICE
FROM
  project_worker
  JOIN worker ON worker.id = project_worker.worker_id
  JOIN project ON project.id = project_worker.project_id
  JOIN (
    SELECT project_id, ROW_NUMBER() OVER (ORDER BY SUM(worker.salary * (DATEDIFF('MONTH', project.start_date, project.finish_date) + 1)) DESC) AS seq_num
    FROM project_worker
    JOIN worker ON worker.id = project_worker.worker_id
    JOIN project ON project.id = project_worker.project_id
    GROUP BY project_id
  ) AS project_seq ON project_seq.project_id = project.id
GROUP BY project_seq.project_id
ORDER BY NAME ASC, seq_num DESC;
