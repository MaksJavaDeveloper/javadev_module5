--знайти найстаршого та наймолодшого працівника

SELECT
  CASE
    WHEN birthday = (SELECT MAX(birthday) FROM worker) THEN 'YOUNGEST'
    WHEN birthday = (SELECT MIN(birthday) FROM worker) THEN 'OLDEST'
  END AS TYPE,
  name AS NAME,
  birthday AS BIRTHDAY
FROM worker
WHERE birthday IN (
  SELECT MIN(birthday) FROM worker
  UNION
  SELECT MAX(birthday) FROM worker
)
ORDER BY (CASE WHEN 
  CASE
    WHEN birthday = (SELECT MAX(birthday) FROM worker) THEN 'YOUNGEST'
    WHEN birthday = (SELECT MIN(birthday) FROM worker) THEN 'OLDEST'
  END = 'YOUNGEST' THEN 1 ELSE 2 END);