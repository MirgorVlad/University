
-- insert lectors
INSERT INTO lectors (id, name, salary, degree)
VALUES (1, 'John Doe', 1500, 'PROFESSOR'),
       (2, 'Sigmund Estelle', 1000, 'ASSOCIATE_PROFESSOR'),
       (3, 'Nickolas Waller', 300, 'ASSISTANT'),
       (4, 'Harriet Rennold', 250, 'ASSISTANT'),
       (5, 'Lilliana Langdon', 120, 'ASSISTANT'),
       (6, 'Opaline Acker', 2200, 'PROFESSOR'),
       (7, 'Amberly Weaver', 800, 'ASSOCIATE_PROFESSOR'),
       (8, 'Alphonzo Gladwyn', 850, 'ASSOCIATE_PROFESSOR'),
       (9, 'Shavonne Vernon', 350, 'ASSISTANT');

-- insert departments
INSERT INTO departments (id, name, head_of_department_id)
VALUES (1, 'security', 1),
       (2, 'economy and finance', 6);

-- insert lectors to departments
INSERT INTO department_lector (department_id, lector_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 6),
       (2, 7),
       (2, 8),
       (2, 9),
       (2, 2),
       (2, 3),
       (2, 4);
