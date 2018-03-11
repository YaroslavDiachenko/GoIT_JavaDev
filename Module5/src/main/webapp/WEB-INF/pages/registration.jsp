<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head><title>Registration</title></head>

<body>
<style>
    body, input, button, select, option {
        font-family: Arial, sans-serif;
        font-size: 13px;
    }
    input, select {
        margin-top: 3px;
        margin-bottom: 8px;
    }
</style>

    <p><b>Registration:</b></p>
    <form:form action="/registration" method="post" modelAttribute="userForm">
        First name:<br>
        <form:input path="firstName"/><br>
        Last name:<br>
        <form:input path="lastName"/><br>
        E-mail:<br>
        <form:input path="email"/><br>
        Password:<br>
        <form:password path="password"/><br>
        <input type="submit" value="Register"/>
    </form:form>

</body>
</html>