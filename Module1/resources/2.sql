#2. Найти самый дорогой проект (исходя из ЗП разработчиков).

# SOLUTION_1 (via sorting):


USE Module1_HomeWork;
SELECT projects.name, sum(developers.salary) AS project_cost
FROM projects,developers,projects_developers
WHERE projects.id = projects_developers.project_id AND developers.id = projects_developers.developer_id
GROUP BY projects.name
ORDER BY sum(developers.salary) DESC
LIMIT 1;

# SOLUTION_2 (via nested subquery):

USE Module1_HomeWork;

SELECT table1.name, table3.max_cost
FROM (
       SELECT (projects.name) AS name, sum(developers.salary) AS project_cost
       FROM projects, developers, projects_developers
       WHERE projects.id = projects_developers.project_id and developers.id = projects_developers.developer_id
       GROUP BY projects.id)
      AS table1
JOIN (
       SELECT max(table2.project_cost) AS max_cost
       FROM (
              SELECT (projects.name) AS name, sum(developers.salary) AS project_cost
              FROM projects, developers, projects_developers
              WHERE projects.id = projects_developers.project_id and developers.id = projects_developers.developer_id
              GROUP BY projects.id
            )
              AS table2
      ) AS table3
ON table1.project_cost = table3.max_cost;

# SOLUTION_3 (using temporary tables):

DROP TABLE IF EXISTS TABLE1;
DROP TABLE IF EXISTS TABLE2;

CREATE TEMPORARY TABLE TABLE1 AS (
  SELECT (projects.name) AS name, sum(developers.salary) AS project_spending
  FROM projects, developers, projects_developers
  WHERE projects.id = projects_developers.project_id and developers.id = projects_developers.developer_id
  GROUP BY projects.id);

CREATE TEMPORARY TABLE TABLE2 AS (
  SELECT max(TABLE1.project_spending) AS max_project_spending FROM TABLE1);

SELECT TABLE1.name, TABLE1.project_spending FROM TABLE1,TABLE2 WHERE TABLE1.project_spending = TABLE2.max_project_spending;