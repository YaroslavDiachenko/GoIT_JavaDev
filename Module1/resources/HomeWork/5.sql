#5. Найти клиента (customer), которая приносит меньше всего прибыли компании (company) для каждой из компаний.


# SOLUTION_1 (using subqueries):
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
ON table1.company = table3.company AND table1.profit_per_customer = table3.min_profit_per_customer;




# SOLUTION_2 (using temporary tables):
USE Module1_HomeWork;

DROP TABLE IF EXISTS TASK5_TABLE1;
DROP TABLE IF EXISTS TASK5_TABLE2;
DROP TABLE IF EXISTS TASK5_TABLE3;

# calculate profit per project = income (project cost) - spending (developers' salaries per project))
CREATE TEMPORARY TABLE TASK5_TABLE1 AS (
      SELECT projects.name AS project_name, projects.cost AS project_income, sum(developers.salary) AS project_spending, projects.cost - sum(developers.salary) AS project_profit
      FROM projects, developers, projects_developers
      WHERE projects.id = projects_developers.project_id AND developers.id = projects_developers.developer_id
      GROUP BY projects.id);

# link upper table with companies and customers and calculate profit per customer
CREATE TEMPORARY TABLE TASK5_TABLE2 AS (
      SELECT companies.name AS company_name, customers.name AS customer_name,
            sum(TASK5_TABLE1.project_income) AS income_per_customer,
            sum(TASK5_TABLE1.project_spending) AS spending_per_customer,
            sum(TASK5_TABLE1.project_profit) AS profit_per_customer
      FROM companies, projects, customers, companies_projects, customers_projects, TASK5_TABLE1
      WHERE companies.id = companies_projects.company_id
            AND projects.id = companies_projects.project_id
            AND projects.id = customers_projects.project_id
            AND customers.id = customers_projects.customer_id
            AND projects.name = TASK5_TABLE1.project_name
      GROUP BY companies.name, customers.name);

# define minimum profit per customer for each company
CREATE TEMPORARY TABLE TASK5_TABLE3 AS (
SELECT company_name AS company, min(profit_per_customer) AS min_profit_per_company
FROM TASK5_TABLE2
GROUP BY company_name);

# show all information per company about customer with minimum profit
SELECT company_name, customer_name AS customer_with_min_profit, income_per_customer, spending_per_customer, profit_per_customer
FROM TASK5_TABLE2, TASK5_TABLE3
WHERE TASK5_TABLE2.company_name = TASK5_TABLE3.company AND TASK5_TABLE2.profit_per_customer = TASK5_TABLE3.min_profit_per_company
ORDER BY company_name;

DROP TABLE TASK5_TABLE1;
DROP TABLE TASK5_TABLE2;
DROP TABLE TASK5_TABLE3;

