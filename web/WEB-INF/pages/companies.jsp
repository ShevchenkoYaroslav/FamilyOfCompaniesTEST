<%--
  Created by IntelliJ IDEA.
  User: Valsorya94
  Date: 05.07.2017
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Companies Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Company List</h1>

<c:if test="${!empty listCompanies}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCompanies}" var="company">
            <tr>
                <td>${company.id}</td>
                <td><a href="/companiesdata/${company.id}" target="_blank">${company.companyName}</a></td>
                <td>${company.companyName}</td>
                <td>${company.price/100}${company.price%100}</td>
                <td><a href="<c:url value='/edit/${company.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${company.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Company</h1>

<c:url var="addAction" value="/companies/add.form"/>

<form:form action="${addAction}" commandName="company">
    <table>
        <c:if test="${!empty company.companyName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idOfCompany" readonly="true" size="8" disabled="true"/>
                        <%--<form:hidden path="idOfCompany"/>--%>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="companyName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="nameOfCompany"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="annualIncome"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty company.companyName}">
                    <input type="submit"
                           value="<spring:message text="Edit Company"/>"/>
                </c:if>
                <c:if test="${empty company.companyName}">
                    <input type="submit"
                           value="<spring:message text="Add company"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>