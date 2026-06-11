<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <meta name="contextPath" content="<%= request.getContextPath() %>">
<%--    <script src="js/student.js"></script> will not works!--%>
    <script src="js/student.js?v=<%= System.currentTimeMillis() %>"></script>
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

<hr>
<h3>Post new Student using Ajax</h3>
<form id="">
    <div id="responseDiv"></div>
    <div>
        <label>Id</label>
        <input type="text" id="student_id" name="student_id">
    </div>
    <div>
        <label>Name</label>
        <input type="text" id="student_name" name="student_name">
    </div>
    <div>
        <label>Email</label>
        <input type="text" id="student_email" name="student_email">
    </div>
    <div>
        <label>Phone</label>
        <input type="text" id="student_phone" name="student_phone">
    </div>
    <div>
        <button type="button" onclick="saveStudent()">Add</button>
        <button type="button" onclick="showStudents()">List of Students</button>
    </div>
</form>


<a href="hello-servlet">Hello Servlet</a>
</body>
</html>