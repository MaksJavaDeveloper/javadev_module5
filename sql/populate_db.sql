--Додаю 12 працівників
INSERT INTO worker (name, birthday, level, salary) 
VALUES 
('Maxim Mikhaylov', '1997-12-15', 'Trainee', 950),
('Kate Volkova', '1999-04-17', 'Junior', 1600),
('Steve Jobs', '1955-02-24', 'Senior', 99999),
('Vlad Shumko', '1992-10-14', 'Middle', 3500),
('Evgeniy Vazko', '1985-05-12', 'Senior', 12600),
('Alex Ivanchik', '1995-08-31', 'Middle', 5200),
('Anatoliy Nesterov', '2000-01-12', 'Trainee', 870),
('Anton Pokemon', '2002-10-05', 'Junior', 1850),
('Svetlana Svetova', '1975-12-12', 'Middle', 4700),
('Larisa Patrich', '1974-11-02', 'Senior', 25200),
('Busya Dusya', '2001-03-12', 'Junior', 2200),
('Vlad Mikhaylov', '1995-03-20', 'Trainee', 900);

--Додаю 6 клієнтів
INSERT INTO client (name)
VALUES
('Sergey Petrov'),
('Maksim Demidov'),
('Nikita Nikitich'),
('Well Boy'),
('Alisa Kisa'),
('Stanislav Boklan');

--Додаю 10 проєктів
INSERT INTO project (client_id, start_date, finish_date)
VALUES 
(2, '2022-12-15', '2023-03-15'),
(4, '2023-01-05', '2023-02-19'),
(1, '2022-10-13', '2023-06-13'),
(6, '2023-03-17', '2023-04-20'),
(3, '2022-11-20', '2024-11-21'),
(5, '2021-08-21', '2025-09-01'),
(1, '2023-05-15', '2023-09-12'),
(2, '2020-04-03', '2024-04-23'),
(6, '2023-12-01', '2025-12-01'),
(4, '2022-06-06', '2023-10-14');

--Додаю працівників до проєкту 
--(Над кожним проєктом має працювати від 1 до 5 працівників)
INSERT INTO project_worker(project_id, worker_id) 
VALUES 
(2,1),
(3,1),
(1,2),
(4,3),
(6,5),
(8,10),
(10,9),
(9,12),
(7,11),
(5,4),
(3,6),
(2,4),
(10,5);




