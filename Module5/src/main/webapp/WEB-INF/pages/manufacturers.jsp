<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head><title>Manufacturers</title></head>

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
        margin-top: 3px;
        margin-bottom: 8px;
    }
</style>

<c:set var="user" value="${empty pageContext.request.userPrincipal ? 'nonadmin' : pageContext.request.isUserInRole('ROLE_ADMIN') ? 'admin' : 'nonadmin'}"/>

<p><b>Manufacturers</b></p>
<table>
<tr>
    <th>#</th>
    <th>Name</th>
    <th>Products</th>
    <c:if test="${user == 'admin'}">
        <th>Edit</th>
        <th>Delete</th>
    </c:if>
</tr>

<c:if test="${not empty manufacturers}">
    <c:set var="numberOfRows" value="0"/>
    <c:forEach items="${manufacturers}" var="manufacturer">
        <tr>
            <td>
                <c:set var="numberOfRows" value="${numberOfRows + 1}"/>
                    ${numberOfRows}
            </td>
            <td>${manufacturer.name}</td>
            <td>
                <c:forEach items="${manufacturer.manProducts}" var="product" varStatus="loop">
                    ${product.name}
                    <c:if test="${!loop.last}">, </c:if>
                </c:forEach>
            </td>
            <c:if test="${user == 'admin'}">
                <td align="center"><a href="<c:url value='/manufacturers/edit/${manufacturer.id}'/>"> edit </a></td>
                <td align="center"><a href="<c:url value='/manufacturers/remove/${manufacturer.id}'/>"> remove </a></td>
            </c:if>
        </tr>
    </c:forEach>
</c:if>
</table>

<c:if test="${user == 'admin'}">
    <c:if test="${empty action}">
        <br>
        <form:form action="/manufacturers/add" method="GET">
            <input type="submit" value="Add"/>
        </form:form>
    </c:if>

    <c:if test = "${action == 'add' or action == 'edit'}">
        <p><b>${action == 'add' ? 'New manufacturer:' : 'Edit manufacturer:'}</b></p>
        <form:form action="${action == 'add' ? '/manufacturers/add' : '/manufacturers/edit'}" method="post" modelAttribute="manufacturer">
            <form:hidden path="id"/>
            Name:<br>
            <form:input path="name"/><br/>
            <input type="submit" value="${action == 'add' ? 'Submit' : 'Save'}"/>
        </form:form>
    </c:if>
</c:if>

</body>
</html>

























