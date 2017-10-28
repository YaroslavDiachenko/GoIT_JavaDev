#3. Вычислить общую ЗП всех Java разработчиков.

USE Module1_HomeWork;

SELECT sum(salary) AS total_java_salary
FROM developers
WHERE id IN (
    SELECT developer_id
    FROM developers_skills
    WHERE skill_id = 1)