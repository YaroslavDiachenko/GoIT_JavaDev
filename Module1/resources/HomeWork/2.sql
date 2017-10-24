#2. Найти самый дорогой проект (исходя из ЗП разработчиков).

SELECT MAX(ALL COUNT()) AS 'The most expensive project'

SELECT SUM(salary) FROM developers WHERE id IN(SELECT developer_id FROM projects_developers WHERE project_id =  )

