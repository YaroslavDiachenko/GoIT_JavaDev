CREATE DATABASE Module1_HomeWork;
USE Module1_HomeWork;

CREATE TABLE skills (
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(100)    NOT NULL
);

CREATE TABLE developers (
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(100)    NOT NULL
);

CREATE TABLE projects (
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(100)    NOT NULL
);

CREATE TABLE companies (
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(100)    NOT NULL
);

CREATE TABLE customers (
  id   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(100)    NOT NULL
);

# Dependencies:

CREATE TABLE developers_skills (
  developer_id INT NOT NULL,
  skill_id     INT NOT NULL,
  FOREIGN KEY (developer_id) REFERENCES developers (id),
  FOREIGN KEY (skill_id) REFERENCES skills (id),
  UNIQUE (developer_id, skill_id)
);

CREATE TABLE projects_developers (
  project_id   INT NOT NULL,
  developer_id INT NOT NULL,
  FOREIGN KEY (project_id) REFERENCES projects (id),
  FOREIGN KEY (developer_id) REFERENCES developers (id),
  UNIQUE (project_id, developer_id)
);

CREATE TABLE companies_projects (
  company_id INT NOT NULL,
  project_id INT NOT NULL,
  FOREIGN KEY (company_id) REFERENCES companies (id),
  FOREIGN KEY (project_id) REFERENCES projects (id),
  UNIQUE (company_id, project_id)
);

CREATE TABLE customers_projects (
  customer_id INT NOT NULL,
  project_id  INT NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customers (id),
  FOREIGN KEY (project_id) REFERENCES projects (id),
  UNIQUE (customer_id, project_id)
);

