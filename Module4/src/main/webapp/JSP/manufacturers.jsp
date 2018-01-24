<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <td>${manufacturer.getName()}</td>
                <td>
                    <c:forEach items="${manufacturer.getProducts()}" var="product" varStatus="loop">
                        ${product.getName()}
                        <c:if test="${!loop.last}">, </c:if>
                    </c:forEach>
                </td>
                <td align="center"><a href=manufacturers-edit?id=${manufacturer.getId()}> edit </a></td>
                <td align="center"><a href=manufacturers-delete?id=${manufacturer.getId()}> delete </a></td>
            </tr\n>
        </c:forEach>
    </table>

    <br/>
    <form action="/manufacturers-add" method="get">
    <input type="submit" value="New"/>
    </form>


<%-- ADD --%>
    <c:if test = "${action == 'add'}">
        <h3 style="font-weight: bold;">Add manufacturer:</h3>
        <form action="/manufacturers-add" method="post">
            Name:<br>
            <input type="text" name="name"/><br/><br/>
            <input type="submit" value="Add"/>
        </form>
    </c:if>


<%-- EDIT --%>
    <c:if test = "${action == 'edit'}">
        <h3 style="font-weight: bold;">Add manufacturer:</h3>
        <form action="/manufacturers-edit" method="post">
            <input type="hidden" name="id" value="${manufacturer.getId()}" readonly="true"/>
            Name:<br>
            <input type="text" name="name" value="${manufacturer.getName()}"/><br><br>
            <input type="submit" value="Save"/>
        </form>
    </c:if>