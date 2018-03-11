#4. Добавить поле (cost - стоимость) в таблицу Projects.

USE Module1_HomeWork;

ALTER TABLE projects ADD COLUMN cost DECIMAL NOT NULL;

UPDATE projects SET cost = 4600 WHERE id = 1;
UPDATE projects SET cost = 7600 WHERE id = 2;
UPDATE projects SET cost = 2900 WHERE id = 3;
UPDATE projects SET cost = 9000 WHERE id = 4;
UPDATE projects SET cost = 7400 WHERE id = 5;
UPDATE projects SET cost = 2500 WHERE id = 6;
UPDATE projects SET cost = 4200 WHERE id = 7;
UPDATE projects SET cost = 7500 WHERE id = 8;
UPDATE projects SET cost = 9800 WHERE id = 9;
UPDATE projects SET cost = 2800 WHERE id = 10;
UPDATE projects SET cost = 6000 WHERE id = 11;
UPDATE projects SET cost = 7000 WHERE id = 12;