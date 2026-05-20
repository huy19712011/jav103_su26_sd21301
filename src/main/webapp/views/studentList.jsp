<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/20/2026
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h2>Students</h2>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    <c:forEach var="tempStudent" items="${students}">
        <tr>
            <td>${tempStudent.id}</td>
            <td>${tempStudent.name}</td>
            <td>${tempStudent.email}</td>
            <td>${tempStudent.phone}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
