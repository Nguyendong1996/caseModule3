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
    <title>$Title$</title>
</head>
<body>
<h1>Gio Hang</h1>
<table>
    <tr>
        <th>IdCart</th>
        <th>NamePet</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>

    </tr>
    <c:forEach items="${carts}" var="carts">
        <tr>
            <td>${carts.idCart}</td>
            <td>${carts.getPet().getNamePet()}</td>
            <td>${carts.quantity}</td>
            <td>${carts.price}</td>
            <td>${carts.totalPrice}</td>
        </tr>
    </c:forEach>
</table>
<button><a href="bills?action=bill&&idUser=${idUser}">Thanh Toan</a></button>
<button><a href="pets?action=back">về trang chủ</a></button>
</body>
</html>
