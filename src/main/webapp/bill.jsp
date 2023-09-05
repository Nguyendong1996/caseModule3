<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/09/2023
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/regular.css">
</head>
<%--<body>--%>
<%--<h1>Gio Hang</h1>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>IdCart</th>--%>
<%--        <th>NamePet</th>--%>
<%--        <th>Price</th>--%>
<%--        <th>Quantity</th>--%>
<%--        <th>Total</th>--%>

<%--    </tr>--%>
<%--    <c:forEach items="${carts}" var="carts">--%>
<%--        <tr>--%>
<%--            <td>${carts.idCart}</td>--%>
<%--            <td>${carts.getPet().getNamePet()}</td>--%>
<%--            <td>${carts.quantity}</td>--%>
<%--            <td>${carts.price}</td>--%>
<%--            <td>${carts.totalPrice}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<button><a href="bills?action=bill&&idUser=${idUser}">Thanh Toan</a></button>--%>
<%--<button><a href="pets?action=back">về trang chủ</a></button>--%>
<%--</body>--%>
<body>
<div class="container">
    <!--    Bắt thanh menu-->

    <jsp:include page="header.jsp"/>

    <div class="body">

        <hr>
        <h1 style="text-align: center">Giỏ hàng của bạn</h1>
        <br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>Ảnh</th>
                <th>Tên thú cưng</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
                <th>Tổng tiền</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${carts}" var="carts" varStatus="index">

                <tr>
                    <div style="text-align: center">
                        <td>${index.count}</td>
                        <td><img src="${carts.getPet().getImage()}" alt="image" width="80px" height="80px"></td>
                        <td>${carts.getPet().getNamePet()}</td>
                        <td>${carts.quantity}</td>
                        <td>${carts.price}</td>
                        <td>${carts.totalPrice}</td>

                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>

       <a class="btn btn-info" href="bills?action=bill&&idUser=${idUser}">Thanh toán</a>
      <a class="btn btn-info" href="pets">Về trang chủ</a>
    </div>
    <jsp:include page="footer.jsp"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
