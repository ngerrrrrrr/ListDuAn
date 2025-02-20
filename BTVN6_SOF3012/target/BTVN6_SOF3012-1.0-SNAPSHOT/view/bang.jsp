<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/11/2024
  Time: 2:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<form action="/sinhvien/add" method="post">
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
<%--    <select name="diaChi">--%>
<%--        <option value="${detail.id}" ${detail.id == detail.id ? "selected" : ""}>${detail.diaChi}</option>--%>
<%--    </select>--%>
    <br>
    <label>Giới tính:</label>
    <input type="radio" name="gioiTinh" value="true" ${detail.gioiTinh == true ? "checked" : ""}>Nam
    <input type="radio" name="gioiTinh" value="false" ${detail.gioiTinh == false ? "checked" : ""}>Nữ
    <br>
    <button type="submit">ADD</button>
    <button type="reset">Reset</button>
</form>
<body>
<a href="/sinhvien/hienthi">Load</a>
<c:if test="${list!=null}">
    <table border="1" style="border-collapse: collapse">
        <thead>
        <th>STT</th>
        <th>ID</th>
        <th>Mã Sinh Viên</th>
        <th>Tên Sinh Viên</th>
        <th>Tuổi</th>
        <th>Địa Chỉ</th>
        <th>Giới tính</th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="s" varStatus="i">
            <tr>
                <td>${i.index}</td>
                <td>${s.id}</td>
                <td>${s.ma}</td>
                <td>${s.ten}</td>
                <td>${s.tuoi}</td>
                <td>${s.diaChi}</td>
                <td>${s.gioiTinh ? "Nam" : "Nữ"}</td>
                <td>
                    <a href="/sinhvien/detail?id=${s.id}"><button>Detail</button></a>
                    <a href="/sinhvien/delete?id=${s.id}"><button>Delete</button></a>
                    <a href="/sinhvien/view-update?id=${s.id}"><button>Update</button></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
