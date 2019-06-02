<%--
  Created by IntelliJ IDEA.
  User: farkas
  Date: 16/05/19
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task2 results:</title>
</head>
<body>

<c:if test="${not empty task2Results}">
    <table border="1">
        <tr>
            <th>Company</th>
            <th>NumberOfProducts</th>
        </tr>
        <c:forEach var="result" items="${task2Results}">
            <tr>
                <td>${result.getCompanyName()}</td>
                <td>${result.getNumberOfProducts()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Search by Number of products</h2>
<form action="task2" method="post">
    <input type ="text" name="numberOfProducts" placeholder="Number of products">
    <c:forEach var="result" items="${task2FResults}">
        <option value="<c:out value="${result.getNumberOfProducts()}"/>">${result.getCompanyName()}</option>
    </c:forEach>
    <input type="submit" value="Search">
</form>

<a href="index.html">Go back to the <em>index</em> page.</a>
<br>
</body>
</html>

