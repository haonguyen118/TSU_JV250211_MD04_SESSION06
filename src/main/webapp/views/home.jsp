<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/14
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            margin-top: 50px;
            text-align: center;
            width: 50%;
            margin-left: 25%;

        }

        .item {
            width: 20%;
            background-color: aquamarine;
            border-radius: 10px;
            padding: 15px;
            box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
            text-align: center;
        }

        body {

        }
    </style>
</head>
<body>
    <h1>Danh sách phim đang chiếu</h1>
    <div class="container">
        <c:forEach var="m" items="${movieList}">
            <div class="item">
                <h3>${m.movieTitle}</h3>
                <p>Đạo diễn: ${m.director}</p>
                <p>Thể loại: ${m.genre}</p>
                <a href="/detail/${m.movieId}">Xem chi tiết</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
