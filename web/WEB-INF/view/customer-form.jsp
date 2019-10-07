<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <%--embed id for update --%>
        <form:hidden path="id"/>
        <table>
            <tr>
                <td><lable>First Name: </lable></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><lable>Last Name: </lable></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><lable>Email: </lable></td>
                <td><form:input path="email"/></td>
            </tr>
        </table>
        <input type="submit" value="Save" class="add-button"/>
    </form:form>
</div>
</body>
</html>
