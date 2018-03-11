USE Module1_HomeWork;

# 8 DEVELOPERS
INSERT INTO developers(name) VALUES ('Richard');
INSERT INTO developers(name) VALUES ('Leonard');
INSERT INTO developers(name) VALUES ('Frederick');
INSERT INTO developers(name) VALUES ('Vincent');
INSERT INTO developers(name) VALUES ('Theodore');
INSERT INTO developers(name) VALUES ('Roberto');
INSERT INTO developers(name) VALUES ('Mathew');
INSERT INTO developers(name) VALUES ('Jonathan');

# 7 SKILLS
INSERT INTO skills(name) VALUES ('Java');
INSERT INTO skills(name) VALUES ('C++');
INSERT INTO skills(name) VALUES ('PHP');
INSERT INTO skills(name) VALUES ('Python');
INSERT INTO skills(name) VALUES ('Ruby');
INSERT INTO skills(name) VALUES ('JavaScript');
INSERT INTO skills(name) VALUES ('Swift');

# 12 PROJECTS
INSERT INTO projects(name) VALUES ('Project01');
INSERT INTO projects(name) VALUES ('Project02');
INSERT INTO projects(name) VALUES ('Project03');
INSERT INTO projects(name) VALUES ('Project04');
INSERT INTO projects(name) VALUES ('Project05');
INSERT INTO projects(name) VALUES ('Project06');
INSERT INTO projects(name) VALUES ('Project07');
INSERT INTO projects(name) VALUES ('Project08');
INSERT INTO projects(name) VALUES ('Project09');
INSERT INTO projects(name) VALUES ('Project10');
INSERT INTO projects(name) VALUES ('Project11');
INSERT INTO projects(name) VALUES ('Project12');

# 4 COMPANIES
INSERT INTO companies(name) VALUES ('Company01');
INSERT INTO companies(name) VALUES ('Company02');
INSERT INTO companies(name) VALUES ('Company03');
INSERT INTO companies(name) VALUES ('Company04');

# 6 CUSTOMERS
INSERT INTO customers(name) VALUES ('Customer01');
INSERT INTO customers(name) VALUES ('Customer02');
INSERT INTO customers(name) VALUES ('Customer03');
INSERT INTO customers(name) VALUES ('Customer04');
INSERT INTO customers(name) VALUES ('Customer05');
INSERT INTO customers(name) VALUES ('Customer06');


INSERT INTO developers_skills VALUES (1, 2);
INSERT INTO developers_skills VALUES (1, 4);
INSERT INTO developers_skills VALUES (2, 1);
INSERT INTO developers_skills VALUES (3, 6);
INSERT INTO developers_skills VALUES (3, 7);
INSERT INTO developers_skills VALUES (4, 5);
INSERT INTO developers_skills VALUES (5, 3);
INSERT INTO developers_skills VALUES (5, 4);
INSERT INTO developers_skills VALUES (5, 6);
INSERT INTO developers_skills VALUES (6, 2);
INSERT INTO developers_skills VALUES (7, 1);
INSERT INTO developers_skills VALUES (8, 1);
INSERT INTO developers_skills VALUES (8, 7);

INSERT INTO projects_developers VALUES (1, 1);
INSERT INTO projects_developers VALUES (1, 2);
INSERT INTO projects_developers VALUES (2, 4);
INSERT INTO projects_developers VALUES (2, 5);
INSERT INTO projects_developers VALUES (2, 6);
INSERT INTO projects_developers VALUES (3, 1);
INSERT INTO projects_developers VALUES (4, 3);
INSERT INTO projects_developers VALUES (4, 5);
INSERT INTO projects_developers VALUES (4, 7);
INSERT INTO projects_developers VALUES (4, 8);
INSERT INTO projects_developers VALUES (5, 3);
INSERT INTO projects_developers VALUES (5, 6);
INSERT INTO projects_developers VALUES (6, 2);
INSERT INTO projects_developers VALUES (7, 3);
INSERT INTO projects_developers VALUES (7, 8);
INSERT INTO projects_developers VALUES (8, 3);
INSERT INTO projects_developers VALUES (8, 4);
INSERT INTO projects_developers VALUES (9, 1);
INSERT INTO projects_developers VALUES (9, 3);
INSERT INTO projects_developers VALUES (9, 4);
INSERT INTO projects_developers VALUES (10, 5);
INSERT INTO projects_developers VALUES (11, 2);
INSERT INTO projects_developers VALUES (11, 3);
INSERT INTO projects_developers VALUES (12, 6);
INSERT INTO projects_developers VALUES (12, 7);
INSERT INTO projects_developers VALUES (12, 8);

INSERT INTO companies_projects VALUES (1, 1);
INSERT INTO companies_projects VALUES (1, 2);
INSERT INTO companies_projects VALUES (1, 3);
INSERT INTO companies_projects VALUES (2, 4);
INSERT INTO companies_projects VALUES (2, 5);
INSERT INTO companies_projects VALUES (2, 6);
INSERT INTO companies_projects VALUES (2, 7);
INSERT INTO companies_projects VALUES (3, 8);
INSERT INTO companies_projects VALUES (3, 9);
INSERT INTO companies_projects VALUES (3, 10);
INSERT INTO companies_projects VALUES (4, 11);
INSERT INTO companies_projects VALUES (4, 12);

INSERT INTO customers_projects VALUES (1, 1);
INSERT INTO customers_projects VALUES (1, 2);
INSERT INTO customers_projects VALUES (2, 3);
INSERT INTO customers_projects VALUES (2, 4);
INSERT INTO customers_projects VALUES (3, 5);
INSERT INTO customers_projects VALUES (3, 6);
INSERT INTO customers_projects VALUES (4, 7);
INSERT INTO customers_projects VALUES (5, 8);
INSERT INTO customers_projects VALUES (5, 9);
INSERT INTO customers_projects VALUES (6, 10);
INSERT INTO customers_projects VALUES (6, 11);
INSERT INTO customers_projects VALUES (6, 12);