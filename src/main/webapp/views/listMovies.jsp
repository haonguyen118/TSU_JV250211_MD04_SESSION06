<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/15
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Movies</title>
    <style>
        table {
            width: 60%;
            height: auto;
            box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
            margin-left: 20%;
            text-align: center;
        }

        thead {
            background-color: blue;
            color: white;
        }

        th, td {
            border: 1px solid black;
            height: 50px;
        }

        a {

        }
        h1{
            text-align: center;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.0/css/all.min.css"
          integrity="sha512-DxV+EoADOkOygM4IR9yXP8Sb2qwgidEmeqAEmDKIOfPRQZOWbXCzLC6vjbZyy0vPisbH2SyW27+ddLVCN+OMzQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<h1>Danh sách phim</h1>
<a style="text-decoration: none;
            background-color: blue;
            color: white;
            margin-left: 20%;"
   href="/movies/add">Thêm phim mới</a>
<br>
<br>
<table>
    <thead>
    <tr>
        <th>MÃ PHIM</th>
        <th>TIÊU ĐỀ</th>
        <th>ĐẠO DIỄN</th>
        <th>THỂ LOẠI</th>
        <th>THỜI LƯỢNG</th>
        <th>NGÔN NGỮ</th>
        <th>HÀNH ĐỘNG</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="m" items="${movieList}">
        <tr>
            <td>${m.movieId}</td>
            <td>${m.movieTitle}</td>
            <td>${m.director}</td>
            <td>${m.genre}</td>
            <td>${m.duration} phút</td>
            <td>${m.language}</td>
            <td>
                <a href="/movies/delete/${m.movieId}" onclick="return confirm('Bạn có chắc chăn muốn xóa phim này không?')" ><i class="fa-solid fa-trash-can"></i></a>
                <a href="/movies/edit/${m.movieId}"><i class="fa-solid fa-pen-to-square"></i></a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
