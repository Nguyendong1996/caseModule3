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

    <!--    Kết thúc thanh menu-->

    <!--    Bắt đầu slide-->
    <div class="item2 item">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100"
                         src="image/banner.jpg" height="300px"
                         alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="image/banner.jpg" height="300px"
                         alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="image/banner.jpg" height="300px"
                         alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <!--    Kết thúc slide-->

    <!--    Bắt đầu phần danh mục giống loài-->

    <div class="item3 item">
        <div class="list-group">
            <a href="#" class="list-group-item active">Danh mục thú cưng</a>
            <a href="#" class="list-group-item">Chó</a>
            <a href="#" class="list-group-item">Mèo</a>
        </div>
        <div class="dropdown">
            <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown"
                    aria-expanded="false" style="width:230px; text-align: left; margin: 3px 0" >
                Sắp xếp
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="#">Theo giá từ thấp đến cao</a></li>
                <li><a class="dropdown-item" href="#">Theo giá từ cao đến thấp</a></li>
            </ul>
        </div>
    </div>

    <!--    Kết thúc phần danh mục giống loài-->

    <div class="item4 item">Quảng cáo</div>

    <!--    Bắt đầu  phần danh sách sản phẩm-->
    <div class="item5 item">
<%--        <div class="row" style="text-align: center ; margin-left: 100px">--%>
            <c:forEach items="${pets}" var="p">
                <div class="abc">
<%--                <div class="col-12 col-sm-4 col-md-3" style="margin: 20px 20px ; border: solid 1px antiquewhite">--%>
                    <div class="product" style="margin-top: 3px"><img src="${p.image}" alt="image" width="300x" height="300px"></div>
                    <div class="product"><a href="pets?action=detail&&idPet=${p.idPet}"><c:out
                            value="${p.namePet}"/></a></div>
                    <div class="product" style="margin: 5px 50px "><c:out value="${p.price}"/> VNĐ</div>
                    <a class="btn btn-outline-success" href="pets?action=update&&idPet=${p.idPet}">Mua ngay</a>
                </div>
            </c:forEach>
<%--        </div>--%>
    </div>

    <!--    Kết thúc phần danh sách sản phẩm-->

    <div class="item6 item">Footer</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>