<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/09/2023
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hóa đơn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/regular.css">
</head>
<body>
<div class="container">
    <!--    Bắt thanh menu-->

    <jsp:include page="header.jsp"/>

    <div class="body">

        <hr>
        <h1 style="text-align: center">Hóa đơn mua hàng</h1>
        <br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>IdUser</th>
                <th>Tên Khách Hàng</th>
                <th>Địa chỉ</th>
                <th>Tổng Tiền</th>
                <th>Ngày Mua Hàng</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <div style="text-align: center">
                    <tr>
                        <td>${bill.idUser}</td>
                        <td>${user.fullName}</td>
                        <td>${user.address}</td>
                        <td>${bill.totalPayment}</td>
                        <td>${bill.purchaseDate}</td>
                    </tr>

                </div>
            </tr>
            </tbody>
        </table>
        <a class="btn-warning" href="pets">Về trang chủ</a>
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
