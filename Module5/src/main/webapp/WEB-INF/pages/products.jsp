<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head><title>Products</title></head>

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

<c:set var="user" value="${empty pageContext.request.userPrincipal ? 'nonadmin' : pageContext.request.isUserInRole('ROLE_ADMIN') ? 'admin' : 'nonadmin'}"/>

<p><b>Products</b></p>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <c:if test="${user == 'admin'}">
            <th>Edit</th>
            <th>Delete</th>
        </c:if>
    </tr>

    <c:if test="${not empty products}">
        <c:set var="numberOfRows" value="0"/>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>
                    <c:set var="numberOfRows" value="${numberOfRows + 1}"/>
                        ${numberOfRows}
                </td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.prodManufacturer.name}</td>
                <c:if test="${user == 'admin'}">
                    <td align="center"><a href="<c:url value='/products/edit/${product.id}'/>"> edit </a></td>
                    <td align="center"><a href="<c:url value='/products/remove/${product.id}'/>"> remove </a></td>
                </c:if>
            </tr>
        </c:forEach>
    </c:if>
</table>

<c:if test="${user == 'admin'}">
    <c:if test="${empty action}">
        <br>
        <form:form action="/products/add" method="get">
            <input type="submit" value="Add"/>
        </form:form>
    </c:if>

    <c:if test = "${action == 'add' or action == 'edit'}">
        <p><b>${action == 'add' ? 'New product:' : 'Edit product:'}</b></p>
        <form:form action="${action == 'add' ? '/products/add' : '/products/edit'}" method="post" modelAttribute="product">
            <form:hidden path="id"/>
            Name:<br>
            <form:input path="name"/><br>
            Price:<br>
            <form:input path="price"/><br>
            Manufacturer:<br>
            <form:select path="prodManufacturer.id">
                <c:if test = "${action == 'add'}">
                    <form:option value="-" label=" -- select -- "/>
                </c:if>
                <form:options items="${manufacturers}" itemLabel="name" itemValue="id"/>
            </form:select><br>
            <input type="submit" value="${action == 'add' ? 'Submit' : 'Save'}"/>
        </form:form>
    </c:if>
</c:if>

</body>
</html>