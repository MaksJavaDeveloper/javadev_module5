--Створюю таблицю worker
CREATE TABLE worker (
	id IDENTITY PRIMARY KEY,
	name VARCHAR(999) NOT NULL 
	CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 999),
	birthday DATE CHECK (YEAR(birthday) > 1900),
	level VARCHAR(10) NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')), 
	salary BIGINT NOT NULL CHECK (salary >= 100 AND salary <= 100000)
);


-- Створюю таблицю client
CREATE TABLE client (
	id IDENTITY PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 999)
);

-- Створюю таблицю project
CREATE TABLE project (
	id IDENTITY PRIMARY KEY,
	client_id BIGINT,
	start_date DATE, 
	finish_date DATE
);

--Створюю таблицю project_worker 
CREATE TABLE project_worker (
  PROJECT_ID BIGINT NOT NULL,
  WORKER_ID BIGINT NOT NULL,
  PRIMARY KEY (PROJECT_ID, WORKER_ID),
  FOREIGN KEY (PROJECT_ID) REFERENCES project (id),
  FOREIGN KEY (WORKER_ID) REFERENCES worker (id)
);
	