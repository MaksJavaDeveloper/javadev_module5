--знайти проєкт з найбільшою тривалістю
SELECT 
  CASE WHEN DATEDIFF('MONTH', start_date, finish_date) = (
    SELECT MAX(DATEDIFF('MONTH', start_date, finish_date))
    FROM project
  ) THEN 'Project A'
  ELSE CONCAT('Project ', CHAR(ASCII('A') + ROW_NUMBER() OVER (ORDER BY start_date))) 
  END AS name,
  DATEDIFF('MONTH', start_date, finish_date) AS month_count
FROM project
WHERE DATEDIFF('MONTH', start_date, finish_date) = (
  SELECT MAX(DATEDIFF('MONTH', start_date, finish_date))
  FROM project
);