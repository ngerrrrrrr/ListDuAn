<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/11/2024
  Time: 2:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<form action="/sach/search" method="get">
    <label>Nhập tên:</label>
    <input type="text" name="ten">
    <button type="submit">Search</button>
</form>
<br>
<form action="/sach/add" method="post">
    <label>Mã:</label>
    <input type="text" name="ma" required value="${detail.ma}">
    <br>
    <label>Tên:</label>
    <input type="text" name="ten" required value="${detail.ten}">
    <br>
    <label>Năm xuất bản:</label>
    <input type="number" name="nam" required value="${detail.nam}">
    <br>
    <label>Thể loại:</label>
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
    <button type="submit">ADD</button>
    <button type="reset">Reset</button>
</form>
<body>
<a href="/sach/hienthi">
    <button>Load</button>
</a>
<table border="1" style="border-collapse: collapse">
    <thead>
    <th>STT</th>
    <th>ID</th>
    <th>MÃ</th>
    <th>TÊN</th>
    <th>NĂM XUẤT BẢN</th>
    <th>THỂ LOẠI</th>
    <th>ID TÁC GIẢ</th>
    <th>MÃ TÁC GIẢ</th>
    <th>ACTION</th>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="s" varStatus="i">
        <tr>
            <td>${i.index +1}</td>
            <td>${s.id}</td>
            <td>${s.ma}</td>
            <td>${s.ten}</td>
            <td>${s.nam}</td>
            <td>${s.theLoai}</td>
            <td>${s.tg.id}</td>
            <td>${s.tg.ma}</td>
            <td>
                <a href="/sach/detail?id=${s.id}">
                    <button>Detail</button>
                </a>
                <a href="/sach/delete?id=${s.id}">
                    <button>Delete</button>
                </a>
                <a href="/sach/view-update?id=${s.id}">
                    <button>Update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <c:if test="${pageHienTai > 0}">
        <a href="/sach/hienthi?pageNo=${pageHienTai -1}&pageSize=5">
            <button>Previous</button>
        </a>
    </c:if>

    <c:if test="${pageHienTai < tongPage - 1}">
        <a href="/sach/hienthi?pageNo=${pageHienTai + 1}&pageSize=5">
            <button>Next</button>
        </a>
    </c:if>
</div>
</body>
</html>
