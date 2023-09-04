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
    <title>Title</title>
</head>
<body>
<h1>Hoa Don</h1>
<table>
  <tr>
    <th>idBill</th>
    <th>idUser</th>
    <th>totalPayment</th>
    <th>purchaseDate</th>
  </tr>

    <tr>
      <td>${bill.idBill}</td>
      <td>${bill.idUser}</td>
      <td>${bill.totalPayment}</td>
      <td>${bill.purchaseDate}</td>
    </tr>
</table>
</body>
</html>
