<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/sach/update" method="post">
    <input type="hidden" name="id" value="${detail.id}">
    <label>Mã Sách:</label>
    <input type="text" name="ma" required value="${detail.ma}">
    <br>
    <label>Tên Sách:</label>
    <input type="text" name="ten" required value="${detail.ten}">
    <br>
    <label>Năm Xuất Bản:</label>
    <input type="number" name="nam" required value="${detail.nam}">
    <br>
    <label>Thể Loại:</label>
    <input type="text" name="theLoai" required value="${detail.theLoai}">
    <br>
    <label>Id tác giả:</label>
    <input type="text" name="tacGiaId" required value="${detail.tg.id}">
    <br>
    <label>Mã:</label>
    <select name="tg.ma">
        <c:forEach items="${listTg}" var="tacGia">
            <option value="${tacGia.id}" <c:if test="${tacGia.id == detail.tg.id}">selected</c:if>>${tacGia.ma}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
