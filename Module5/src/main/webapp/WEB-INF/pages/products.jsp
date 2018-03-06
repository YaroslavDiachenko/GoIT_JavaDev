<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<html>
<body>
<h2 style="font-weight: bold;">Products:</h2>

<%-- LIST ALL --%>
    <table>
        <tr bgcolor = #BDBDBD>
            <th width=30>Id</th>
            <th width=150>Name</th>
            <th width=100>Price</th>
            <th width=150>Manufacturer</th>
            <th width=60>Edit</th>
            <th width=80>Delete</th>
        </tr>

        <c:if test="${!empty products}">
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
                    <td align="center"><a href="<c:url value='/products/edit/${product.id}'/>"> edit </a></td>
                    <td align="center"><a href="<c:url value='/products/remove/${product.id}'/>"> remove </a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <br/>
    <form:form action="/products/add" method="GET">
        <input type="submit" value="New"/>
    </form:form>

    <%-- ADD --%>
    <c:if test = "${action == 'add'}">
        <h3 style="font-weight: bold;">Add product:</h3>
        <form:form action="/products/add" method="POST" modelAttribute="product">
            Name:<br>
            <form:input path="name"/><br>
            Price:<br>
            <form:input path="price"/><br>
            Manufacturer:<br>
            <form:select path="prodManufacturer.id">
                <form:option value="-" label=" -- select -- "/>
                <form:options items="${manufacturers}" itemLabel="name" itemValue="id"/>
            </form:select>
            <br/>
            <input type="submit" value="Add"/>
        </form:form>
    </c:if>


    <%-- EDIT --%>
    <c:if test = "${action == 'edit'}">
        <h3 style="font-weight: bold;">Edit product:</h3>
        <form:form action="/products/edit" method="POST" modelAttribute="product">
            <form:hidden path="id"/>
            Name:<br>
            <form:input path="name"/><br>
            Price:<br>
            <form:input path="price"/><br>

            Manufacturer:<br>
            <form:select path="prodManufacturer.id">
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <option <c:if test="${manufacturer.id == product.prodManufacturer.id}">selected="selected"</c:if>
                            value="${manufacturer.id}">${manufacturer.name} </option>
                </c:forEach>
            </form:select>
            <input type="submit" value="Save"/>
        </form:form>
    </c:if>
</body>
</html>