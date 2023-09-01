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
    <link rel="stylesheet" href="cssHome/Styles.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/regular.css">
</head>
<body>
<div class="container">
    <!--    Bắt thanh menu-->

    <div class="item1 item">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-top: 10px">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Logo</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="pets">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giới thiệu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giống loài</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Dịch vụ
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Tiêm phòng vacxin</a></li>
                                <li><a class="dropdown-item" href="#">Phối giống cho thú cưng</a></li>
                                <li><a class="dropdown-item" href="#">Làm đẹp cho thú cưng</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Liên hệ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logins?action=login">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logins?action=register">Đăng ký</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input style="height: 45px ; margin-top: 5px" class="form-control me-2" type="search"
                               placeholder="Tìm kiếm" aria-label="Search">
                        <button class="btn " style="font-size: 27px; width: 40px" type="submit"><i
                                class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                    <a class="nav-link" href="#"><i class="fa-solid fa-cart-shopping"
                                                    style="width: 50px; font-size: 30px"></i></a>
                </div>
            </div>
        </nav>
    </div>

    <div class="container" style="margin-top: 40px">
        <table class="table table-hover">
            <tr>
                <th>STT</th>
                <th>Tên giống loài</th>
                <th style="width: 15%" colspan="2">Action</th>
            </tr>
            <c:forEach items="${species}" var="s" varStatus="index">
                <tr>
                    <td><c:out value="${index.count}"/></td>
                    <td><a href="species?action=display1&&idSpecies=${s.idSpecies}"><c:out
                            value="${s.nameSpecies}"/></a></td>
                    <td><a class="btn btn-warning" href="species?action=update&&idSpecies=${s.idSpecies}">Cập nhật</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-info" href="species?action=create">Thêm mới</a>
    </div>
</div>
</body>

</html>
