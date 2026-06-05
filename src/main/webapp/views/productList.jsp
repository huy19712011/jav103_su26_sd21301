<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .delete-btn {
            background: none;
            border: none;
            color: blue;
            cursor: pointer;
            text-decoration: underline;
            padding: 0;
            font: inherit;
        }
        .delete-btn:hover {
            color: darkblue;
        }
    </style>
</head>
<body>
<h2>Products</h2>
<a href="${pageContext.request.contextPath}/products/new">Add new Product</a>

<table border="1">
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Actions</th>

    </tr>
    <c:forEach var="tempProduct" items="${products}" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${tempProduct.id}</td>
            <td>${tempProduct.name}</td>
            <td>${tempProduct.price}</td>
            <td>${tempProduct.category.name}</td>

            <td>
                <a href="${pageContext.request.contextPath}/products/edit?id=${tempProduct.id}">Edit</a>
                <form method="POST" action="${pageContext.request.contextPath}/products/delete" style="display:inline;">
                    <input type="hidden" name="id" value="${tempProduct.id}">
                    <input type="submit" value="Delete" class="delete-btn">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
