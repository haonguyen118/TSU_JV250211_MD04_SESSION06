<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/15
  Time: 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule List</title>
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
            text-decoration: none;
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
<h1>Danh sách lịch chiếu phim</h1>
<a href="/schedules/add">Thêm mới lịch chiếu</a>
<table>
    <thead>
    <tr>
        <th>Tiêu đề phim</th>
        <th>Thời gian</th>
        <th>Phòng chiếu</th>
        <th>Số ghế có sẵn</th>
        <th>Định dạng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${schedules}">
    <tr>
        <td>${s.movieTitle}</td>
        <td>${s.showTime}</td>
        <td>${s.screenRoomId}</td>
        <td>${s.availableSeat}</td>
        <td>${s.format}</td>
        <td> <a href="/schedules/delete/${s.id}" onclick="return confirm('Bạn có chắc chăn muốn xóa phim này không?')" ><i class="fa-solid fa-trash-can"></i></a>
            <a href="/schedules/edit/${s.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
