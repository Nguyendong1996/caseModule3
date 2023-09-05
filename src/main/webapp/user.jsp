<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/09/2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/19/2023
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Creat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="cssHome/fontawesome-free-6.4.2-web/css/regular.css">


</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <h2>Thông tin khách hàng</h2>
    <div class="container mt-5">
        <form action="bills?action=createUser&&idAccount=${idAccount}" method="post">
            <div class="row">
                <div class="col-md-6">
                    <label class="form-label">Họ và tên </label>
                    <input type="text" class="form-control" name="fullName" placeholder="fullName">
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label class="form-label">Ngày sinh </label>
                        <input type="date" class="form-control" name="dob" placeholder="dob">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label class="form-label">Giới tính </label>
                        <input type="text" class="form-control" name="sex" placeholder="sex">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <label class="form-label">Số điện thoại </label>
                        <input type="text" class="form-control" name="phone" placeholder="phone">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <label class="form-label">Email</label>
                        <input type="text" class="form-control" name="email" placeholder="email">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <label class="form-label">Address</label>
                        <input type="text" class="form-control" name="address" placeholder="address">
                    </div>
                </div>
                <button>Hoàn tất</button>
<%--                                        <a class="btn btn-info" type="submit">Hoàn tất</a>--%>
                <a class="btn btn-info" href="pets">Về trang chủ</a>
            </div>
        </form>
    </div>
    <jsp:include page="footer.jsp"/>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

</html>

