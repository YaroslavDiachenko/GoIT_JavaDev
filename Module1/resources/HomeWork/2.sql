#2. Найти самый дорогой проект (исходя из ЗП разработчиков).

# SOLUTION_1:


USE Module1_HomeWork;
SELECT projects.name, sum(developers.salary) AS project_cost
FROM projects,developers,projects_developers
WHERE projects.id = projects_developers.project_id AND developers.id = projects_developers.developer_id
GROUP BY projects.name
ORDER BY sum(developers.salary) DESC
LIMIT 1;

# SOLUTION_2:

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