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
    <jsp:include page="header.jsp"/>
    <!--    Kết thúc thanh menu-->

    <!--    Bắt đầu slide-->
    <%--    <div class="item2 item">--%>
    <div class="row" style="margin-bottom: 20px">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100"
                         src="image/banner.png" height="400px"
                         alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="image/banner.png" height="400px"
                         alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100"
                         src="image/banner.png" height="400px"
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
    <div class="row">
        <div class="col-3" >
            <div class="list-group">
                <a href="#" class="list-group-item active" style="background-color: #115b91">Danh mục thú cưng</a>
                <c:forEach items="${speciesList}" var="s">
                    <a href="pets?action=displayBySpecies&&idSpecies=${s.idSpecies}"
                       class="list-group-item"><c:out value="${s.nameSpecies}"/></a>
                </c:forEach>
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item active" style="background-color: #115b91">Sắp xếp theo giá</a>
                <a class="list-group-item" href="pets?action=sortByPriceAS">Theo giá từ thấp đến cao</a>
                <a class="list-group-item" href="pets?action=sortByPriceDESC">Theo giá từ cao đến thấp</a>
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item active" style="background-color: #115b91">Tìm kiếm theo giá</a>
                <a class="list-group-item" href="pets?action=searchByPrice&minPrice=1000000&maxPrice=5000000">1 triệu - 5 triệu</a>
                <a class="list-group-item" href="pets?action=searchByPrice&minPrice=5000000&maxPrice=10000000">5 triệu - 10 triệu</a>
                <a class="list-group-item" href="pets?action=searchByPrice&minPrice=10000000&maxPrice=15000000">10 triệu - 15 triệu</a>
                <a class="list-group-item" href="pets?action=searchByPrice&minPrice=15000000&maxPrice=20000000">15 triệu - 25 triệu</a>
            </div>
        </div>
        <c:forEach items="${pets}" var="p">
            <div class="col-3">
                <div class="pets">
                    <div class="image-container">
                        <img src="${p.image}" alt="image" width="270x" height="300px" style="margin-left: 7px"></div>
                    <div class="overlay"></div>
                    <div class="namePet1"><a style="text-decoration: none; color: brown"
                                             href="pets?action=detail&&idPet=${p.idPet}"><c:out
                            value="${p.namePet}"/></a></div>
                    <div class="pricePet1"><c:out value="${p.price}"/> VNĐ</div>

                    <a class="btn btn-info" href="javascript:void(0);" onclick="addToCart(${p.idPet})">Thêm vào giỏ hàng</a>

                </div>
            </div>
        </c:forEach>
    </div>
    <br>
    <div>
        <jsp:include page="footer.jsp"/>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>


<script>
    function addToCart(idPet) {
        if (${sessionScope.account == null}) {
            alert("Vui lòng đăng nhập để thêm vào giỏ hàng.");
        } else {
            window.location.href = "carts?action=create&idPet=" + idPet;
        }
    }
</script>
</body>
</html>