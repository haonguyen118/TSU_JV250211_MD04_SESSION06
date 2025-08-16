<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/15
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Movies</title>
    <style>
        .detail {
            background-color: aquamarine;
            padding: 20px;
            border-radius: 10px;
            box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
            max-height: 600px;
            transition: box-shadow 0.3s;
        }

        .detail:hover {
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<div style="width: 50%; margin-left: 25%; text-align: center">
    <div class="detail">
        <h1>Chi tiết Phim: ${movie.movieTitle}</h1>
        <p>Đạo diễn: ${movie.director}</p>
        <p>Thể loại: ${movie.genre}</p>
        <p>Mô tả: ${movie.description}</p>
        <p>Thời gian: ${movie.duration}</p>
        <p>Ngôn ngữ: ${movie.language}</p>
        <h2>Lịch chiếu</h2>
        <div>
            <c:forEach var="s" items="${schedules}">
                <button>
                    <a>${s.showTime}</a>
                </button>
            </c:forEach>

        </div>
        <a href="/home">Quay lại danh sách Phim</a>
    </div>
</div>
</body>
</html>
