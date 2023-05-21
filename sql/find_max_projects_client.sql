--знайти клієнта з найбільшою кількістю проєктів
SELECT client.name, COUNT(*) as project_count
FROM project
JOIN client ON project.client_id = client.id
GROUP BY client.name
HAVING COUNT(*)= (
	SELECT MAX(project_count) 
	FROM(
		SELECT COUNT(*) as project_count
		FROM project
		GROUP BY client_id
		) as subquery
	);