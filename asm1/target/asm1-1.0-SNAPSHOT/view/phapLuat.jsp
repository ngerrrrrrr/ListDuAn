<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/09/2024
  Time: 3:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
        color: #333;
    }

    header, footer {
        background-color: #007BFF; /* Blue */
        color: white;
        text-align: center;
        padding: 15px 0;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    }

    nav {
        background-color: #FFC107; /* Yellow */
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

    }
    nav a:hover {
        background-color: #007BFF; /* Change background on hover */
        color: white; /* Change text color on hover */
    }

    .container {
        display: flex;
        margin: 20px;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    main {
        background-color: white;
        flex: 2;
        padding: 20px;
    }

    aside {
        flex: 1;
        padding: 20px;
        background-color: #f8f9fa; /* Light Gray */
        border-left: 2px solid #ddd;
    }

    aside section {
        margin-bottom: 20px;
        padding: 15px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    .top-news {
        background-color: #28a745; /* Green */
        color: white;
    }

    .latest-news {
        background-color: #d4edda; /* Light Green */
    }

    .viewed-news {
        background-color: #155724; /* Dark Green */
        color: white;
    }
    .newsletter{
        background-color: #6c757d;
        color: white;
    }
    /*.newsletter {*/
    /*    background-color: #6c757d; !* Gray *!*/
    /*    padding: 20px;*/
    /*    text-align: center;*/
    /*    color: white;*/
    /*    border-radius: 5px;*/
    /*    margin: 20px;*/
    /*}*/

    footer {
        clear: both;
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
    }
</style>
<head>
    <title>Pháp luật</title>
</head>
<body>
<header>
    <br>
    Long đẹp trai
</header>
<nav>
    <a href="/view/trangChu.jsp">Trang chủ</a>
    <a href="/view/vanHoa.jsp">Văn hóa</a>
    <a href="/view/phapLuat.jsp">Pháp Luật</a>
    <a href="/view/theThao.jsp">Thể thao</a>
</nav>
<div class="container">
    <img src="./long2.jpg" alt="">
</div>

<footer>
    Long siêu đẹp trai
</footer>

</body>
</html>
