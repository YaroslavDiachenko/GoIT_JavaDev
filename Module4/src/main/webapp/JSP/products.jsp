<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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


        <c:set var="numberOfRows" value="0"/>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>
                    <c:set var="numberOfRows" value="${numberOfRows + 1}"/>
                    ${numberOfRows}
                </td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getManufacturer().getName()}</td>
                <td align="center"><a href=products-edit?id=${product.getId()}> edit </a></td>
                <td align="center"><a href=products-delete?id=${product.getId()}> delete </a></td>
            </tr\n>
        </c:forEach>
    </table>

    <br/>
    <form action="/products-add" method="get">
    <input type="submit" value="New"/>
    </form>

<%-- ADD --%>
    <c:if test = "${action == 'add'}">
        <h3 style="font-weight: bold;">Add product:</h3>
        <form action="/products-add" method="post">
            Name:<br>
            <input type="text" name="name" value="${empty product.name ? '' : param.name}"/><br/>
            Price:<br>
            <input type="text" name="price" value="${empty product.price ? '' : param.price}"/><br/>
            Manufacturer:<br>
            <c:choose>
                <c:when test="${empty product.getManufacturer()}">
                    <select name="selected">
                    <option value="noSelected" selected="selected"> -- select from list -- </option>
                        <c:forEach items="${manufacturers}" var="manufacturer">
                            <option value="${manufacturer.getId()}">${manufacturer.name}</option>
                        </c:forEach>
                    </select><br>
                </c:when>
                <c:otherwise>
                    <select name="selected">
                        <c:forEach items="${manufacturers}" var="manufacturer">
                            <option value="${manufacturer.id}" ${manufacturer.id == product.getManufacturer().getId() ? 'selected' : ''}>${manufacturer.name}</option>
                        </c:forEach>
                    </select><br><br>
                </c:otherwise>
            </c:choose>
            <br/>
            <input type="submit" value="Add"/>
        </form>
    </c:if>

<%-- EDIT --%>
    <c:if test = "${action == 'edit'}">
        <h3 style="font-weight: bold;">Edit product:</h3>
        <form action="/products-edit" method="post">
            <input type="hidden" name="id" value="${product.getId()}" readonly="true"/>
            Name:<br>
            <input type="text" name="name" value="${product.name}"/><br>
            Price:<br>
            <input type="text" name="price" value="${product.price}"/><br>
            Manufacturer:<br>
            <select name="selected">
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <option value="${manufacturer.id}" ${manufacturer.id == product.getManufacturer().getId() ? 'selected' : ''}>${manufacturer.name}</option>
                </c:forEach>
            </select><br><br>
            <input type="submit" value="Save"/>
        </form>
    </c:if>

<%-- VALIDATION MESSAGES --%>

    <c:if test = "${!empty errorMessagesList}">
        <c:forEach items="${errorMessagesList}" var="message">
            <p bgcolor = ##ff0000> ${message} </p><br>
        </c:forEach>
    </c:if>
