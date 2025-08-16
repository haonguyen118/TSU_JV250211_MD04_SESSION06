<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/15
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
  <style>
    h2{
      text-align: center;
    }
    form{
      width: 60%;
      height: auto;
      box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
      margin-left: 20%;
    }
    input{
      width: 400px;
      height: 50px;
      margin-left: 6%;
    }
    button{
      width: 400px;
      height: 50px;
      margin-left: 6%;
      background-color: blue;
      margin-bottom: 20px;
      margin-top: 20px;
      color: white;
    }
    label{
      margin-left: 6%;
    }
  </style>
</head>
<body>
<h2>Thêm mới phim</h2>
<form action="/movies/add" method="post">
  <label for="movieTitle">Tiêu đề</label><br>
  <input type="text" name="movieTitle" id="movieTitle"><br>
  <label for="director">Đạo diễn</label><br>
  <input type="text" name="director" id="director"><br>
  <label for="genre">Thể loại</label><br>
  <input type="text" name="genre" id="genre"><br>
  <label for="description">Mô tả</label><br>
  <input type="text" name="description" id="description"><br>
  <label for="duration">Thời gian(phút)</label><br>
  <input type="number" name="duration" id="duration"><br>
  <label for="language">Ngôn ngữ</label><br>
  <input type="text" name="language" id="language"><br>
  <button type="submit">Thêm phim</button>
</form>
</body>
</html>
