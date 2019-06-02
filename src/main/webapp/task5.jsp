<%--
  Created by IntelliJ IDEA.
  User: farkas
  Date: 16/05/19
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task5 results:</title>
</head>
<body>
<c:if test="${empty task5Results}">
    <span> </span>
</c:if>
<c:if test="${not empty task5Results}">
    <table border="1">
        <tr>
            <th>Company</th>
            <th>ProductName</th>
            <th>ProductPrice</th>
        </tr>
        <c:forEach var="result" items="${task5Results}">
            <tr>
                <td>${result.getCompanyName()}</td>
                <td>${result.getProductName()}</td>
                <td>${result.getProductPrice()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h2>Search by Company Name</h2>
<form action="task5" method="post">
    <input type="text" name="companyName" placeholder="Company Name">
    <c:forEach var="result" items="${task5FResults}">
        <option value="<c:out value="${result.getCompanyName()}"/>">Product name: ${result.getProductName()}, Product price: ${result.getProductPrice()}</option>
    </c:forEach>
    <input type="submit" value="Search">
</form>
<p></p>
<h2>Search by Product Name</h2>
<form action="task5" method="post">
    <c:forEach var="result" items="${task5FResults}">
        <option value="<c:out value="${result.getProductName()}"/>">Company name: ${result.getCompanyName()}, Product price: ${result.getProductPrice()}</option>
    </c:forEach>
</form>

<a href="index.html">Go back to the <em>index</em> page.</a>
<br>
</body>
</html>

