<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<body>
<h2 style="font-weight: bold;">Manufacturers:</h2>

    <%-- LIST ALL --%>
    <table>
        <tr bgcolor = #BDBDBD>
            <th width=30>#</th>
            <th width=150>Name</th>
            <th width=300>Products</th>
            <th width=60>Edit</th>
            <th width=80>Delete</th>
        </tr>

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
                <td align="center"><a href="<c:url value='/manufacturers/edit/${manufacturer.id}'/>"> edit </a></td>
                <td align="center"><a href="<c:url value='/manufacturers/remove/${manufacturer.id}'/>"> remove </a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <form:form action="/manufacturers/add" method="GET">
        <input type="submit" value="New"/>
    </form:form>


    <%-- ADD --%>
    <c:if test = "${action == 'add'}">
        <h3 style="font-weight: bold;">Add manufacturer:</h3>
        <form:form action="/manufacturers/add" method="POST" modelAttribute="manufacturer">
            Name:<br>
            <form:input path="name"/><br/><br/>
            <input type="submit" value="Add"/>
        </form:form>
    </c:if>















    <%-- EDIT --%>
    <c:if test = "${action == 'edit'}">
        <h3 style="font-weight: bold;">Add manufacturer:</h3>
        <form:form action="/manufacturers/edit" method="POST" modelAttribute="manufacturer">
            <form:hidden path="id"/>
            Name:<br>
            <form:input path="name"/><br/><br/>
            <input type="submit" value="Save"/>
        </form:form>
    </c:if>
</body>
</html>

























