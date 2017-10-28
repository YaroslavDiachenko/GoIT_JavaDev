#Добавить разаработчикам поле (salary - зарплата).

USE Module1_HomeWork;

ALTER TABLE developers ADD COLUMN salary DECIMAL NOT NULL;

UPDATE developers SET salary = 1000 WHERE id = 1;
UPDATE developers SET salary = 1500 WHERE id = 2;
UPDATE developers SET salary = 3000 WHERE id = 3;
UPDATE developers SET salary = 2500 WHERE id = 4;
UPDATE developers SET salary = 1900 WHERE id = 5;
UPDATE developers SET salary = 2200 WHERE id = 6;
UPDATE developers SET salary = 2800 WHERE id = 7;
UPDATE developers SET salary = 2800 WHERE id = 7;



