<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head><title>Users</title></head>

<body>
<style>
    body, input, button, select, option, table, td, th, tr {
        font-family: Arial, sans-serif;
        font-size: 13px;
    }
    table {
        border-collapse: collapse;
    }
    td, th {
        border: 1px solid #ddd;
        padding: 8px;
    }
    tr:nth-child(even){background-color: #f2f2f2;}
    tr:hover {background-color: #ddd;}
    th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: center;
        background-color: #4CAF50;
        color: white;
    }
    input, select {
        margin-top: 3px;
        margin-bottom: 8px;
    }
</style>

<p><b>Users</b></p>
<table>
    <tr>
        <th>#</th>
        <th>First name</th>
        <th>Last name</th>
        <th>E-mail</th>
        <th>Roles</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:if test="${not empty users}">
        <c:set var="numberOfRows" value="0"/>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <c:set var="numberOfRows" value="${numberOfRows + 1}"/>
                    ${numberOfRows}
                </td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>
                    <c:forEach items="${user.userRoles}" var="role" varStatus="loop">
                        ${role.name}
                        <c:if test="${!loop.last}">, </c:if>
                    </c:forEach>
                </td>
                <td align="center"><a href="<c:url value='/users/edit/${user.id}'/>"> edit </a></td>
                <td align="center"><a href="<c:url value='/users/remove/${user.id}'/>"> remove </a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<c:if test="${empty action}">
    <br>
    <form:form action="/users/add" method="GET">
        <input type="submit" value="Add"/>
    </form:form>
</c:if>

<c:if test = "${action == 'add' or action == 'edit'}">
    <p><b>${action == 'add' ? 'New user:' : 'Edit user:'}</b></p>
    <form:form action="${action == 'add' ? '/users/add' : '/users/edit'}" method="post" modelAttribute="user">
        <form:hidden path="id"/>
        First name:<br>
        <form:input path="firstName"/><br>
        Last name:<br>
        <form:input path="lastName"/><br>
        E-mail:<br>
        <form:input path="email"/><br>
        <c:if test = "${action == 'add'}">
            Password:<br>
            <form:password path="password"/><br>
        </c:if>
        <c:if test = "${action == 'edit'}">
            <form:hidden path="password"/>
        </c:if>
        Roles:<br>
        <form:select multiple="true" path="selectedRoles" items="${roles}" itemLabel="name" itemValue="id" />
        <input type="submit" value="${action == 'add' ? 'Submit' : 'Save'}"/>
    </form:form>
</c:if>

</body>
</html>