<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 8/26/2023
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="menu">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="pets">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="species">Species</a>
                    </li>
                </ul>
            </div>
            <div style="margin-top: 20px">
                <form action="pets?action=search" method="post">
                    <div class="row">
                        <div class="col-md-9">
                            <input class="form-control mr-sm-2" name="search" value="${search}" type="search"
                                   placeholder="Search" aria-label="Search">
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </nav>
    </div>
    <div class="body">

            <hr>
            <h1 style="text-align: center">List Pet</h1>
            <a class="btn btn-info" href="pets?action=create">Create</a>
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
                        <td>${p.source}</td>
                        <td>${p.species.nameSpecies}</td>
                        <td><a class="btn btn-warning" href="pets?action=update&&id=${p.idPet}">Update</a></td>
                        <td><button class="btn btn-danger" onclick="deleteS(${p.idPet})">Delete</button></td>
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
