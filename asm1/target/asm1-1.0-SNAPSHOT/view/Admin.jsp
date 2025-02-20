<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/09/2024
  Time: 12:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
        color: #333;
        line-height: 1.6;
    }

    header, footer {
        background-color: #007BFF;
        color: white;
        text-align: center;
        padding: 15px 0;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    }

    header img {
        max-width: 100px;
        margin-bottom: 10px;
    }

    nav {
        background-color: #FFC107;
        display: flex;
        justify-content: center;
        padding: 10px 0;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    nav a {
        margin: 0 15px;
        text-decoration: none;
        color: #333;
        font-weight: bold;
        padding: 10px 20px;
        transition: background-color 0.3s, color 0.3s;
    }

    nav a:hover {
        background-color: #007BFF;
        color: white;
        border-radius: 5px;
    }

    /* Container */
    .container {
        display: flex;
        justify-content: space-between;
        margin: 20px;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        background-color: white;
    }

    main {
        width: 70%; /* Main chiếm 70% chiều rộng */
        padding: 20px;
    }

    .news-item {
        display: flex;
        flex-direction: row;
        margin-bottom: 20px;
        width: 100%;
        border-bottom: 1px solid #ddd;
        padding-bottom: 20px;
    }

    .news-image {
        flex: 0 0 30%; /* Ảnh chiếm 30% chiều rộng */
        padding-right: 20px;
    }

    .news-image img {
        width: 100%;
        height: auto;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    .news-content {
        flex: 1; /* Nội dung chiếm phần còn lại */
    }

    .news-content h2 {
        margin: 0;
        font-size: 1.5em;
        margin-bottom: 10px;
    }

    .news-content p {
        margin: 0;
        line-height: 1.6;
    }

    /* Sidebar */
    aside {
        width: 28%; /* Sidebar chiếm 28% chiều rộng */
        padding: 20px;
        background-color: #f8f9fa;
        border-left: 2px solid #ddd;
    }

    aside section {
        margin-bottom: 20px;
        padding: 15px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .top-news {
        background-color: #ffc107;
        color: black;
    }

    .latest-news {
        background-color: #d3d3d3;
        color: black;
    }

    .viewed-news {
        background-color: #28a745;
        color: white;
    }

    .newsletter {
        background-color: #6c757d;
        color: white;
    }

    /* Footer */
    footer {
        margin-top: 20px;
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .container {
            flex-direction: column;
        }

        aside {
            border-left: none;
        }

        .news-item {
            flex-direction: column;
        }

        .news-image {
            flex: 0 0 100%;
            padding-right: 0;
        }

        .news-content {
            flex: 1;
        }
    }
    .auth-buttons {
        margin-top: 10px;
    }

    .auth-buttons button {
        background-color: #007BFF;
        color: white;
        border: none;
        padding: 10px 15px;
        margin: 0 5px;
        cursor: pointer;
        font-size: 1em;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .auth-buttons button:hover {
        background-color: #0056b3;
    }

    .auth-buttons .register-btn {
        background-color: #28a745; /* Màu cho nút Đăng ký */
    }

    .auth-buttons .register-btn:hover {
        background-color: #218838;
    }
    .auth-buttons .login-btn {
        background-color: #dc3545; /* Màu đỏ cho nút Đăng nhập */
    }
</style>
</head>
<body>
<header>
    <img src="/view/logo.jpg" alt="Logo">
    <br>
    Long đẹp trai

</header>

<nav>
    <a href="/SVadmin">Trang chủ</a>
    <a href="/view/vanHoa.jsp">Văn hóa</a>
    <a href="/view/phapLuat.jsp">Pháp Luật</a>
    <a href="/view/theThao.jsp">Thể thao</a>
</nav>

<div class="container">
    <main>
        <!-- Lặp qua danh sách bản tin để hiển thị -->
        <c:forEach var="n" items="${listN}">

            <div class="news-item">
                <!-- Ảnh bên trái -->
                <div class="news-image">
                    <img src="${n.img}" alt="Ảnh tin tức">
                </div>

                <!-- Nội dung và tiêu đề bên phải -->
                <div class="news-content">
                    <h2>${n.getTitle()}</h2>
                    <p>${n.getContent()}</p>
                    <button type="button" onclick="update('${n.id}')">UPDATE</button>
                    <button type="button" onclick="xoa('${n.id}')">DELETE</button>
                </div>
            </div>
        </c:forEach>
    </main>

    <aside>
        <section class="top-news">
            <h3>5 bản tin được xem nhiều</h3>
            <!-- Add content here -->
        </section>

        <section class="latest-news">
            <h3>5 bản tin mới nhất</h3>
            <!-- Add content here -->
        </section>

        <section class="viewed-news">
            <h3>5 bản tin đã được xem</h3>
            <!-- Add content here -->
        </section>

        <section class="newsletter">
            <h3>Newsletter</h3>
            <!-- Add content here -->
        </section>
    </aside>
</div>

<footer>
    Long siêu đẹp trai
</footer>
<script>
    function xoa(id){
        cf = confirm("Bạn chắc chắn muốn xóa tin này?");
        location.href = "/Delete?id="+id;
    }
    function update(id){
        cf = confirm("Bạn chắc chắn chỉnh sửa tin này?");
        location.href = "/Edit?id="+id;
    }
    function add(id){
        cf = confirm("Bạn chắc chắn muốn tạo thêm tin?");
        location.href = "/Add?id="+id;
    }
</script>
</body>
</html>
