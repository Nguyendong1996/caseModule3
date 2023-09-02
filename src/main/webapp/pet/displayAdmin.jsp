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

    <div class="body">

        <hr>
        <h1 style="text-align: center">Danh sách thú cưng </h1>
        <c:if test="${create != null}">
            <script>
                alert("${create}")
            </script>
        </c:if>
        <c:if test="${update != null}">
            <script>
                alert("${update}")
            </script>
        </c:if>
        <br>
        <a class="btn btn-info" href="pets?action=create">Thêm mới</a>
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
                            <a class="btn btn-danger" onclick="deletePet(${p.getIdPet()})" href="pets?action=delete&&idPet=${p.idPet}">Xóa</a>
                        </td>
                    </div>
                </tr>

            </c:forEach>
            </tbody>
        </table>


    </div>
    <jsp:include page="../footer.jsp"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script>
    function deletePet(id) {
        if (confirm("Bạn có muốn xóa không?")) {
            window.location.href = "pets?action=delete&&id=" + id
        }
    }
</script>
</body>
</html>
