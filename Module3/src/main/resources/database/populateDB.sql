USE Module3;

INSERT INTO developers(first_name,last_name,salary) VALUES
  ('Richard','Wilson',1000),
  ('Leonard','Taylor',1500),
  ('Frederick','Harris',3000),
  ('Vincent','Martin',2500),
  ('Theodore','Robinson',1900),
  ('Roberto','Clark',2200),
  ('Mathew','Allen',2800),
  ('Jonathan','Lewis',2800);

INSERT INTO skills(name) VALUES
  ('Java'),
  ('C++'),
  ('PHP'),
  ('Python'),
  ('Ruby'),
  ('JavaScript'),
  ('Swift');

INSERT INTO projects(name,cost) VALUES
  ('Project01',4600),
  ('Project02',7600),
  ('Project03',2900),
  ('Project04',9000),
  ('Project05',7400),
  ('Project06',2500),
  ('Project07',4200),
  ('Project08',7500),
  ('Project09',9800),
  ('Project10',2800),
  ('Project11',6000),
  ('Project12',7000);

INSERT INTO companies(name) VALUES
  ('Company01'),
  ('Company02'),
  ('Company03'),
  ('Company04');

INSERT INTO customers(name) VALUES 
  ('Customer01'),
  ('Customer02'),
  ('Customer03'),
  ('Customer04'),
  ('Customer05'),
  ('Customer06');

INSERT INTO developers_skills VALUES 
  (1, 2),
  (1, 4),
  (2, 1),
  (3, 6),
  (3, 7),
  (4, 5),
  (5, 3),
  (5, 4),
  (5, 6),
  (6, 2),
  (7, 1),
  (8, 1),
  (8, 7);

INSERT INTO projects_developers VALUES 
  (1, 1),
  (1, 2),
  (2, 4),
  (2, 5),
  (2, 6),
  (3, 1),
  (4, 3),
  (4, 5),
  (4, 7),
  (4, 8),
  (5, 3),
  (5, 6),
  (6, 2),
  (7, 3),
  (7, 8),
  (8, 3),
  (8, 4),
  (9, 1),
  (9, 3),
  (9, 4),
  (10, 5),
  (11, 2),
  (11, 3),
  (12, 6),
  (12, 7),
  (12, 8);

INSERT INTO companies_projects VALUES 
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 4),
  (2, 5),
  (2, 6),
  (2, 7),
  (3, 8),
  (3, 9),
  (3, 10),
  (4, 11),
  (4, 12);

INSERT INTO customers_projects VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4),
  (3, 5),
  (3, 6),
  (4, 7),
  (5, 8),
  (5, 9),
  (6, 10),
  (6, 11),
  (6, 12);