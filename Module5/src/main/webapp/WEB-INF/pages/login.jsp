<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head><title>Authentication</title></head>

<body>
<style>
    body, input, button, select, option {
        font-family: Arial, sans-serif;
        font-size: 13px;
    }
    input {
        margin-top: 3px;
        margin-bottom: 8px;
    }
</style>

    <p><b>Authentication:</b></p>
    <a href="<c:url value='/registration'/>">Registration</a><br><br>
    <form action="/login" method="post">
        <label style="color: red">${error}</label>
        <label style="color: green">${message}</label>
        <br/>
        E-mail:<br/>
        <input type="text" name="email"/><br>
        Password:<br/>
        <input type="password" name="password"/><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Log in"/>
    </form>
</body>
</html>