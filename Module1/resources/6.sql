#6. Вычислить, среднюю ЗП программистов в проекте, который приносит наименьшую прибыль.

USE Module1_HomeWork;

SELECT table1.project_name, table1.project_profit, table1.average_salary
FROM (
       SELECT projects.name AS project_name, projects.cost - sum(developers.salary) AS project_profit, AVG(developers.salary) AS average_salary
       FROM projects
       JOIN projects_developers ON projects.id = projects_developers.project_id
       JOIN developers ON developers.id = projects_developers.developer_id
       GROUP BY projects.name, projects.cost
     ) AS table1
WHERE table1.project_profit = (
      SELECT 	min(table2.project_profit)
      FROM (
             SELECT projects.cost - sum(developers.salary) AS project_profit
             FROM projects
             JOIN projects_developers ON projects.id = projects_developers.project_id
             JOIN developers ON developers.id = projects_developers.developer_id
             GROUP BY projects.name, projects.cost
           ) AS table2)
