#3. Вычислить общую ЗП всех Java разработчиков.
SELECT SUM(salary) AS 'Total Java' FROM developers WHERE id IN(SELECT developer_id FROM developers_skills WHERE skill_id=1)
