INSERT INTO developers VALUES (1,'Richard');    #Java,C++
INSERT INTO developers VALUES (2,'Leonard');    #Python
INSERT INTO developers VALUES (3,'Frederick');  #Java,Python,Ruby
INSERT INTO developers VALUES (4,'Vincent');    #Swift
INSERT INTO developers VALUES (5,'Theodore');   #PHP,JavaScript
INSERT INTO developers VALUES (6,'Roberto');    #C++,Ruby
INSERT INTO developers VALUES (7,'Mathew');     #JavaScript

INSERT INTO skills VALUES (1,'Java');
INSERT INTO skills VALUES (2,'C++');
INSERT INTO skills VALUES (3,'PHP');
INSERT INTO skills VALUES (4,'Python');
INSERT INTO skills VALUES (5,'Ruby');
INSERT INTO skills VALUES (6,'JavaScript');
INSERT INTO skills VALUES (7,'Swift');

INSERT INTO projects VALUES (1,'Project1');   #Theodore,Mathew
INSERT INTO projects VALUES (2,'Project2');   #Frederick
INSERT INTO projects VALUES (3,'Project3');   #Richard
INSERT INTO projects VALUES (4,'Project4');   #Leonard,Frederick
INSERT INTO projects VALUES (5,'Project5');   #Roberto
INSERT INTO projects VALUES (6,'Project6');   #Vincent,Theodore

INSERT INTO customers VALUES (1,'CocaCola');  #Project1,Project2
INSERT INTO customers VALUES (2,'Siemens');   #Project3,Project4
INSERT INTO customers VALUES (3,'Facebook');  #Project5
INSERT INTO customers VALUES (4,'Apple');     #Project6

INSERT INTO companies VALUES (1,'Microsoft'); #Project1
INSERT INTO companies VALUES (2,'Oracle');    #Project2,Project3,Project6
INSERT INTO companies VALUES (3,'Symantec');  #Project1,Project5
INSERT INTO companies VALUES (4,'Cisco');     #Project3
INSERT INTO companies VALUES (5,'VMware ');   #Project6
INSERT INTO companies VALUES (6,'Fiserv');    #Project5,Project6

#разработчики могут иметь много навыков
INSERT INTO developers_skills VALUES (1, 1);
INSERT INTO developers_skills VALUES (1, 2);
INSERT INTO developers_skills VALUES (2, 4);
INSERT INTO developers_skills VALUES (3, 1);
INSERT INTO developers_skills VALUES (3, 4);
INSERT INTO developers_skills VALUES (3, 5);
INSERT INTO developers_skills VALUES (4, 7);
INSERT INTO developers_skills VALUES (5, 3);
INSERT INTO developers_skills VALUES (5, 6);
INSERT INTO developers_skills VALUES (6, 2);
INSERT INTO developers_skills VALUES (6, 5);
INSERT INTO developers_skills VALUES (7, 6);

#каждый проект имеет много разработчиков, которые над ним работают
INSERT INTO projects_developers VALUES (1, 5);
INSERT INTO projects_developers VALUES (1, 7);
INSERT INTO projects_developers VALUES (2, 3);
INSERT INTO projects_developers VALUES (3, 1);
INSERT INTO projects_developers VALUES (4, 2);
INSERT INTO projects_developers VALUES (4, 3);
INSERT INTO projects_developers VALUES (5, 6);
INSERT INTO projects_developers VALUES (6, 4);
INSERT INTO projects_developers VALUES (6, 5);

#компании выполняют много проектов одновременно
INSERT INTO companies_projects VALUES (1, 1);
INSERT INTO companies_projects VALUES (2, 2);
INSERT INTO companies_projects VALUES (2, 3);
INSERT INTO companies_projects VALUES (2, 6);
INSERT INTO companies_projects VALUES (3, 1);
INSERT INTO companies_projects VALUES (3, 5);
INSERT INTO companies_projects VALUES (4, 3);
INSERT INTO companies_projects VALUES (5, 6);
INSERT INTO companies_projects VALUES (6, 5);
INSERT INTO companies_projects VALUES (6, 6);

#заказчики имеют много проектов
INSERT INTO customers_projects VALUES (1, 1);
INSERT INTO customers_projects VALUES (1, 2);
INSERT INTO customers_projects VALUES (2, 3);
INSERT INTO customers_projects VALUES (2, 4);
INSERT INTO customers_projects VALUES (3, 5);
INSERT INTO customers_projects VALUES (4, 6);