<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/11/2024
  Time: 2:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/sinhvien/update" method="post">
    <label>Id:</label>
    <input type="text" name="id" required value="${detail.id}">
    <br>
    <label>Mã:</label>
    <input type="text" name="ma" required value="${detail.ma}">
    <br>
    <label>Tên:</label>
    <input type="text" name="ten" required value="${detail.ten}">
    <br>
    <label>Tuổi:</label>
    <input type="number" name="tuoi" required value="${detail.tuoi}">
    <br>
    <label>Địa chỉ:</label>
    <input type="text" name="diaChi" required value="${detail.diaChi}">
    <br>
    <label>Giới tính:</label>
    <input type="radio" name="gioiTinh" value="true" ${detail.gioiTinh == true ? "checked" : ""}>Nam
    <input type="radio" name="gioiTinh" value="false" ${detail.gioiTinh == false ? "checked" : ""}>Nữ
    <br>
    <button type="submit">Update</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>
