<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/10/2024
  Time: 3:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/Update" method="post">
    <label>Id:</label>
    <input type="text" name="id" readonly value="${timNew.id}">
    <br>
    <label>Title:</label>
    <input type="text" name="title" required value="${timNew.title}">
    <br>
    <label>Content:</label>
    <input type="text" name="content" required value="${timNew.content}">
    <br>
    <label>Img:</label>
    <input type="text" name="img" required value="${timNew.img}">
    <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
