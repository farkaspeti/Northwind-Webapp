<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task1 results:</title>
</head>
<body>

<c:if test="${not empty task1Results}">
    <table border="1">
        <tr>
            <th>Company</th>
            <th>Product</th>
        </tr>
        <c:forEach var="result" items="${task1Results}">
            <tr>
                <td>${result.getCompanyName()}</td>
                <td>${result.getProductName()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h2>Search by Company Name</h2>
<form action="task1" method="post">
    <input type ="text" name="companyName" placeholder="Company Name">
        <c:forEach var="result" items="${task1FResults}">
            <option value="<c:out value="${result.getCompanyName()}"/>">${result.getProductName()}</option>
        </c:forEach>
    <input type="submit" value="Search">
</form>

<a href="index.html">Go back to the <em>index</em> page.</a>
<br>
</body>
</html>
