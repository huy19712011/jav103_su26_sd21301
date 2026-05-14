<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/14/2026
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h1>Student Information</h1>

    <p>
<%--        <b>First Name:</b> <%= request.getParameter("firstName") %>--%>
        <b>First Name:</b> ${firstName}
    </p>

    <p>
<%--        <b>Last Name:</b> <%= request.getParameter("lastName") %>--%>
        <b>Last Name:</b> ${lastName}
    </p>

    <p>
<%--        <b>Country:</b> <%= request.getParameter("country") %>--%>
        <b>Country:</b> ${country}
    </p>

     <p>
        <b>Favorite Programming Languages:</b>
<%--        <%--%>
<%--            String[] favoriteLangs = request.getParameterValues("favoriteLang");--%>
<%--            for (int i = 0; i < favoriteLangs.length; i++) {--%>
<%--                out.print(favoriteLangs[i]);--%>
<%--                if (i < favoriteLangs.length - 1) {--%>
<%--                    out.print(", ");--%>
<%--                }--%>
<%--            }--%>
<%--        %>--%>
    </p>
    <c:forEach var="temp" items="${favoriteLangs}">
        <p>${temp}</p>
    </c:forEach>

    <p>
        <a href="<%= request.getContextPath() %>/">Back to Home</a>
    </p>
</body>
</html>
