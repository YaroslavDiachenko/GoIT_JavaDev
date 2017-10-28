#5. Найти клиента (customer), которая приносит меньше всего прибыли компании (company) для каждой из компаний.

USE Module1_HomeWork;

SELECT table1.company, table1.customer AS customer_with_min_profit, table1.income_per_customer, table1.spending_per_customer, table1.profit_per_customer
FROM (
       SELECT companies.name AS company, customers.name AS customer, sum(profit_table.project_income) AS income_per_customer, sum(profit_table.project_spending) AS spending_per_customer, sum(profit_table.project_profit) profit_per_customer
       FROM companies
       JOIN companies_projects ON companies.id = companies_projects.company_id
       JOIN projects ON projects.id = companies_projects.project_id
       JOIN customers_projects ON projects.id = customers_projects.project_id
       JOIN customers ON customers.id = customers_projects.customer_id
       JOIN (
                SELECT projects.name AS project_name, projects.cost AS project_income, sum(developers.salary) AS project_spending, projects.cost - sum(developers.salary) AS project_profit
                FROM projects
                JOIN projects_developers ON projects.id = projects_developers.project_id
                JOIN developers ON developers.id = projects_developers.developer_id
                GROUP BY projects.name, projects.cost
              ) AS profit_table
           ON projects.name = profit_table.project_name
       GROUP BY companies.name, customers.name
     ) AS table1
JOIN (
       SELECT 	table2.company, min(table2.profit_per_customer) AS min_profit_per_customer
       FROM (
              SELECT companies.name AS company, sum(profit_table.project_profit) profit_per_customer
              FROM companies
              JOIN companies_projects ON companies.id = companies_projects.company_id
              JOIN projects ON projects.id = companies_projects.project_id
              JOIN customers_projects ON projects.id = customers_projects.project_id
              JOIN customers ON customers.id = customers_projects.customer_id
              JOIN (
                     SELECT projects.name AS project_name, projects.cost - sum(developers.salary) AS project_profit
                     FROM projects
                     JOIN projects_developers ON projects.id = projects_developers.project_id
                     JOIN developers ON developers.id = projects_developers.developer_id
                     GROUP BY projects.name, projects.cost
                    ) AS profit_table
                  ON projects.name = profit_table.project_name
              GROUP BY companies.name, customers.name
              ) AS table2
       GROUP BY table2.company
       ) AS table3
ON table1.company = table3.company AND table1.profit_per_customer = table3.min_profit_per_customer