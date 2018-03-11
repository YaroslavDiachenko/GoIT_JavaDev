<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head><title>Manufacturing</title></head>

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
    input {
        margin-top: 10px;
    }
</style>

<form id="logoutForm" method="post" action="${pageContext.request.contextPath}/logout">
    Logged in user: ${currentUser.firstName} ${currentUser.lastName}
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <a href="#" onclick="this.parentNode.submit();">Logout</a>
</form><br/>

<p><b>Manufacturing</b></p>

<table>
    <tr>
        <th>#</th>
        <th>Entity</th>
    </tr>
    <tr>
        <td>1</td>
        <td><a href="<c:url value="/manufacturers"/>" target="_blank">Manufacturers</a></td>
    </tr>
    <tr>
        <td>2</td>
        <td><a href="<c:url value="/products"/>" target="_blank">Products</a></td>
    </tr>
    <c:if test="${not empty pageContext.request.userPrincipal}">
        <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
            <tr>
                <td>3</td>
                <td><a href="<c:url value="/users"/>" target="_blank">Users</a></td>
            </tr>
        </c:if>
    </c:if>
</table>
</body>
</html>

