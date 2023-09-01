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
    <jsp:include page="../footer.jsp"/>
</div>

</body>

</html>
