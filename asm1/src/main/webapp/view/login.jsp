<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/10/2024
  Time: 4:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập Admin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 50px;
        }
        .login-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #218838;
        }
        .alert {
            text-align: center;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
        }
        .alert-success {
            background-color: #d4edda;
            color: #155724;
        }
        .alert-error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Admin Login</h2>
    <form action="/Admin" method="post">
        <label>Tên đăng nhập</label>
        <input type="text" id="id" name="id" required>

        <label>Mật khẩu</label>
        <input type="password" id="pass" name="pass" required>

        <button type="submit">Đăng nhập</button>
    </form>
    <div id="alert" class="alert" style="display: none;"></div>
</div>
<script>
    window.onload = function() {
        const loginStatus = '<%= request.getAttribute("loginStatus") %>';
        const alertBox = document.getElementById("alert");

        if (loginStatus === "success") {
            alertBox.textContent = "Đăng nhập thành công!";
            alertBox.className += " alert-success";
            alertBox.style.display = "block";
        } else if (loginStatus === "failed") {
            alertBox.textContent = "Sai tài khoản hoặc mật khẩu!";
            alertBox.className += " alert-error";
            alertBox.style.display = "block";
        }
    };
</script>
</body>
</html>
