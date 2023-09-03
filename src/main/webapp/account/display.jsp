<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/26/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="">
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/regular.css">
</head>
<body>
<div class="container">
    <!--    Bắt thanh menu-->

    <jsp:include page="../header.jsp"/>

    <div class="container" style="margin-top: 40px">
        <hr>
        <h1 style="text-align: center">Danh sách tài khoản </h1>
        <c:if test="${create != null}">
            <script>
                alert("${create}")
            </script>
        </c:if>
        <c:if test="${update != null}">
            <script>
                alert("${update}")
            </script>
        </c:if>
        <br>
        <table class="table table-hover">
            <tr>
                <th>STT</th>
                <th>Tên tài khoản</th>
                <th>Mật khẩu</th>
                <th>Vai trò</th>
                <th style="width: 15%" colspan="2">Action</th>
            </tr>
            <c:forEach items="${accounts}" var="a" varStatus="index">
                <tr>
                    <td><c:out value="${index.count}"/></td>
                    <td><c:out value="${a.username}"/></td>
                    <td><c:out value="${a.password}"/></td>
                    <td><c:if test="${a.isAdmin()}">Quản lý</c:if>
                    <c:if test="${a.isAdmin()== false}">Khách hàng</c:if></td>
                    <td><a class="btn btn-warning" href="accounts?action=update&&idAccount=${a.idAccount}">Cập nhật</a>
                    </td>
                    <td><a class="btn btn-danger" onclick="deleteAccount(${a.idAccount})" href="accounts?action=delete&&idAccount=${a.idAccount}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <jsp:include page="../footer.jsp"/>
</div>
<script>
    function deleteAccount(id) {
        if (confirm("Bạn có muốn xóa không?")) {
            window.location.href = "accounts?action=delete&&idAccount=" + id
        }
    }
</script>
</body>

</html>
