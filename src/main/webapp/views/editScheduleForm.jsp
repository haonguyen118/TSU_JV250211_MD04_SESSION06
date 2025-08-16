<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/16
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Schedule Form </title>
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
    button{
      width: 80%;
      height: 50px;
      background-color: blue;
      border-radius: 8px;
      margin-left: 10%;
      margin-top: 10px;
      color: white;
    }
    .select_option{
      width: 80%;
      height: 50px;
      margin-left: 10%;
    }
    h1{
      text-align: center;
    }

  </style>
</head>
<body>
<form action="/schedules/edit/${schedule.id}" method="post">
  <h1>Cập nhật lịch chiếu</h1>
  <label for="movieTitle">Tiêu đề phim</label><br>
  <input type="text" name="movieTitle" id="movieTitle" value="${schedule.movieTitle}"><br>
  <label>Thời gian</label><br>
  <input type="date" name="showTime" id="showTime" value="${schedule.showTime}" placeholder="dd/mm/yyyy"><br>
  <label for="screenRoomId">Phòng chiếu</label><br>
  <input type="text" name="screenRoomId" id="screenRoomId" value="${schedule.screenRoomId}"><br>
  <label for="availableSeat">Số ghế có sẵn</label><br>
  <input type="number" name="availableSeat" id="availableSeat" value="${schedule.availableSeat}"><br>
  <label for="format">Định dạng</label><br>
  <select class="select_option" name="format" id="format">
    <option value="2D" ${schedule.format == '2D'?'selected':''}>2D</option>
    <option value="2D" ${schedule.format == '3D'?'selected':''}>3D</option>
  </select><br>
  <button type="submit">Cập  nhật lịch chiếu</button>
</form>

</body>
</html>
