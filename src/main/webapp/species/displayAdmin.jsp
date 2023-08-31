<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/26/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>STT</th>
            <th>Tên giống loài</th>
            <th style="width: 15%" colspan="2">Action</th>
        </tr>
        <c:forEach items="${species}" var="s" varStatus="index">
            <tr>
                <td><c:out value="${index.count}"/></td>
                <td><a href="species?action=display1&&idCategory=${s.idSpecies}"><c:out value="${s.nameSpecies}"/></a></td>
                <td><a class="btn btn-warning" href="species?action=update&&idCategory=${s.idSpecies()}">Cập nhật</a></td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-info" href="species?action=create">Thêm mới</a>
</div>
</body>
</html>
