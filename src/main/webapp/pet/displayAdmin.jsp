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
                        <input style="height: 45px ; margin-top: 5px" class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
                        <button class="btn " style="font-size: 27px; width: 40px"  type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                    <a class="nav-link" href="#"><i class="fa-solid fa-cart-shopping" style="width: 50px; font-size: 30px"></i></a>
                </div>
            </div>
        </nav>
    </div>

    <div class="body">

        <hr>
        <h1 style="text-align: center">Danh sách thú cưng </h1>
        <a class="btn btn-info" href="pets?action=create">Thêm mới</a>
        <c:if test="${message != null}">
            <script>
                alert("${message}")
            </script>
            <c:out value="${message}"/>
        </c:if>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>Ảnh</th>
                <th>Tên</th>
                <th>Giá</th>
                <th>Màu</th>
                <th>Giới tính</th>
                <th>Tiêm vacxin</th>
                <th>Tẩy giun</th>
                <th>Sức khỏe</th>
                <th>Số lượng</th>
                <th>Trạng thái</th>
                <th>Nguồn gốc</th>
                <th>Giống loài</th>
                <th style="width: 15%" colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pets}" var="p" varStatus="index">

                <tr>
                    <div style="text-align: center">
                        <td>${index.count}</td>
                        <td><img src="${p.image}" alt="image" width="80px" height="80px"></td>
                        <td>${p.namePet}</td>
                        <td>${p.price} VNĐ</td>
                        <td>${p.color}</td>
                        <td>${p.male}</td>
                        <td>${p.vaccination}</td>
                        <td>${p.deWorming}</td>
                        <td>${p.health}</td>
                        <td>${p.quantity}</td>
                        <td>${p.status}</td>
                        <td>${p.source}</td>
                        <td>${p.species.nameSpecies}</td>
                        <td><a class="btn btn-warning" href="pets?action=update&&idPet=${p.idPet}">Cập nhật</a></td>
                        <td>
                            <a class="btn btn-danger" href="pets?action=delete&&idPet=${p.idPet}">Xóa</a>
                        </td>
                    </div>
                </tr>

            </c:forEach>
            </tbody>
        </table>


    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script>
    function deleteProduct(id) {
        if (confirm("Are you sure?")) {
            window.location.href = "pets?action=delete&&id=" + id
        }
    }
</script>
</body>
</html>
