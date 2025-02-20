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
    <title>Add</title>
</head>
<body>
<form action="/AddData" method="post">
    <label>Id:</label>
    <input type="text" name="id" required placeholder="Nhập id">
    <br>
    <label>Title:</label>
    <input type="text" name="title" required placeholder="Điền title">
    <br>
    <label>Content:</label>
    <input type="text" name="content" required placeholder="Điền content">
    <br>
    <label>Img:</label>
    <input type="text" name="img" required placeholder="Điền URL img">
    <br>
    <label>PostedDate:</label>
    <input type="text" name="date" required>
    <br>
    <label>Author:</label>
    <input type="text" name="date" required>
    <br>
    <label>ViewCount:</label>
    <input type="text" name="date" required>
    <br>
    <label>CategoryId:</label>
    <input type="text" name="date" required>
    <br>
    <label>Home:</label>
    <input type="radio" name="date" required>
    <br>
    <button type="submit">Submit</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>
