<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Sayantan
  Date: 9/30/2019
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Management</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <%--button to add customer--%>
        <input type="button" value="Add Customer"
               onclick="window.location.href='showRegisterForm'; return false;" class="add-button"/>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Project</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${customers}">

                <%--create url for update with embedded customer id--%>
                <c:url var="updateLink" value="/customer/showUpdateForm">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>

                <%--create url to delete with embedded customer id--%>
                <c:url var="deleteLink" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>

                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${fn:join(customer.projects.toArray(), ",")}</td>
                    <td>
                        <a href="${updateLink}"><u>Update</u> | </a><a href="${deleteLink}"><u>Delete</u></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
