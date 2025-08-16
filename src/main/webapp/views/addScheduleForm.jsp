<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/16
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule add</title>
    <style>
        form{
            width: 40%;
            height: auto;
            box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
            padding: 20px;
        }
        input{
            width: 80%;
            height: 50px;
            margin-left: 10%;
        }
        label{
            margin-left: 10%;
        }
        .select_option{
            width: 80%;
            height: 50px;
            margin-left: 10%;
        }
        button{
            width: 80%;
            height: 50px;
            background-color: blue;
            border-radius: 8px;
            margin-left: 10%;
            margin-top: 10px;
            color: white;
        }
        a{
            text-decoration: none;
        }

    </style>
</head>
<body>
<form action="/schedules/add" method="post">
    <h1>Thêm mới lịch chiếu</h1>
    <label for="movieTitle">Tiêu đề phim</label><br>
    <select class="select_option" name="movieTitle" id="movieTitle">
        <option value="">Chọn phim</option>
        <c:forEach var="movie" items="${movieList}">
            <option value="${movie.movieTitle}">${movie.movieTitle}</option>
        </c:forEach>
    </select><br>
    <label>Thời gian</label><br>
    <input type="date" name="showTime" id="showTime" placeholder="dd/mm/yyyy"><br>
    <label for="screenRoomId">Phòng chiếu</label><br>
    <select class="select_option" name="screenRoomId" id="screenRoomId" required>
        <option value="">Chọn phòng chiếu</option>
        <c:forEach var="screenRoom" items="${screenRooms}">
            <option value="${screenRoom.id}">
                    ${screenRoom.screenRoomName}
            </option>
        </c:forEach>
    </select><br>
    <label for="availableSeat">Số ghế có sẵn</label><br>
    <input type="number" name="availableSeat" id="availableSeat"><br>
    <label for="format">Định dạng</label><br>
    <select class="select_option" name="format" id="format">
        <option value="2D">2D</option>
        <option value="3D">3D</option>
    </select><br>
    <button type="submit">Thêm lịch chiếu</button>
</form>
</body>
</html>
