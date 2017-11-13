[![N|Solid](http://otrude.net/company_img/78d6e3a3e0b075b420128c52b3c07b3d.jpg)](http://otrude.net/company_img/78d6e3a3e0b075b420128c52b3c07b3d.jpg)
# Завдання
### Створення БД
- Створити БД InfoTech
- Створити таблицю Developer (ID, FIRST_NAME, LAST_NAME, SPECIALTY, SALARY)
- Створити таблицю Project (ID, NAME, DESCRIPTION)
- Створити таблию Project_Developer (PROJECT_ID, DEVELOPER_ID)
### Constraints
- Додати атрибут AUTO_INCREMENT до ID для таблиць Developer, Project
- Додати обмеження PRIMARY KEY до ID для таблиць Developer, Project
- Додати обмеження PRIMARY KEY до пари (PROJECT_ID, DEVELOPER_ID) для таблиці Project_Developer
### Наповнення таблиць
- Додати 5+ записів в таблицю Developer. Прослідкувати, щоб були 2-3 різні SPECIALTY
- Додати 5+ записів в таблицю Project
- Додати 10+ записів в таблицю Project_Developer (зв’язати розробників з проектами)
### Вибірка даних – 1
- Показати імена всіх розробників
- Показати імена розробників для певної технології (наприклад, лише Java розробники)
- Показати імена розробників, у яких зарплата вища ніж 1000 у.о.
- Показати імена розробників, у яких довжина імені від 3 до 7 символів включно
- Показати імена розробників, чиї імена починаються на якусь певну букву
### Вибірка даних - сортування
- Вивести всіх розробників, відсортованих по імені у прямому/зворотньому порядку
- Вивести всіх розробників, відсортованих по довжині імені – спочатку найдовші імена, потім коротші
- Вивести всіх розробників по технології, яку вони використовують. Спочатку Java, потім C#, потім UI/UX.
### Вибірка даних - 2
- Вибрати розробника з найбільшою кількістю проектів
- Показати розробників із зарплатою, більшою за середню
- Показати розробника із найменшою зарплатою
- Показати імена розробників без повторів
### Вибірка даних - 3
- Показати ID і назви проектів, в яких бере участь певний розробник. Два варіанта – без JOIN, з JOIN
- Показати пари Розробник-Проект. Два варіанта – без JOIN, з JOIN
- Показати розробників для кожної технології з найвищою ЗП. Наприклад - “John, Java, 1000”
- Показати середню ЗП для кожної технології
### Вибірка даних - 4
- Показати розробників з найменшою і найбільшою ЗП. Варіант з UNION та без UNION
- Показати розробників, у яких кількість проектів більша за середню для кожного розробника
### Оновлення даних (UPDATE)
- Замінити одне ім’я на інше
- Встановити ім’я JOHN для всіх, у кого прізвище починається або закінчується на букву “а”
- Підвищити всім заробітну плату на 30%
- Підвищити заробітну плату лише Java-розробникам
- Подвоїти заробітну плату розробникам, які приймають участь хоча б у одному проекті
- Знизити заробітну плату розробникам, які не приймають участі у жодному проекті
### Оновлення даних – UPDATE 2
- Встановити ЗП в 10 000 у.о. розробникам, в яких більше ніж 3 проекти
- Встановити опис (DESCRIPTION) “No developers” для проектів, у яких немає розробників
- Встановити опис (DESCRIPTION) “Need more developers” для проектів, у яких лише один розробник
### Видалення даних (DELETE)
- Видалити всіх розробників, які не приймають участі у жодному проекті
- Видалити всі проекти, над якими ніхто не працює
- Видалити найменшу групу розробників. Наприклад, якщо у нас 3 Java розробники, і 5 C# - видаляємо всіх Java розробників (їх лише 3)
### Очистка БД
- Очистити всі таблиці без TRUNCATE
- Очистити всі таблиці, використовуючи TRUNCATE
- Видалити всі таблиці. Врахуйте, що між таблицями є зв’язки, тому таблиці мають видалятись у певному порядку
- Видалити базу даних




