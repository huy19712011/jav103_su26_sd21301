<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World! from JSP" %>
</h1>

<form action="filterInput">
    <label>Username</label>
    <input type="text" name="name">
    <br>
    <label>Password</label>
    <input type="text" name="password">
    <br>
    <button type="submit">Submit</button>
</form>

<p>SD21301</p>
<%--1. expressions--%>
<p>The time on server: <%= new java.util.Date() %> </p>
<p>Converting to Upper Case: <%= new String("hello world").toUpperCase()%></p>
<p>Summary of 3 and 5: <%= 3 + 5%></p>

<%--2. scriptlet--%>
<%
    for (int i = 1; i < 4; ++i) {

        out.println("Item " + i);
        out.println("<br>");
    }
%>
<%--3. declaration--%>
<%!
    String makeItLower(String data) {

        return data.toLowerCase();
    }
%>
<p>Lower case of HELLO WORLD: <%= makeItLower("HELLO WORLD") %> </p>

<form action="StudentServlet">
    First name: <input type="text" name="firstName">
    <br>
    Last name: <input type="text" name="lastName">
    <br>
    <select name="country">
        <option>Lao</option>
        <option>CPC</option>
        <option>VN</option>
    </select>
    <br>
    <input type="checkbox" name="favoriteLang" value="Java">Java
    <input type="checkbox" name="favoriteLang" value="C#">C#
    <input type="checkbox" name="favoriteLang" value="Javascript">Javascript
    <input type="checkbox" name="favoriteLang" value="PHP">PHP
    <br>
    <input type="submit" value="Submit">
</form>


<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>