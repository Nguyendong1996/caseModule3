<%--
  Created by IntelliJ IDEA.
  User: HNQA
  Date: 8/30/2023
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <style>
        .was-validated {
            width: 900px;
            margin-left: 40%;
            margin-right: auto;
        }
    </style>

</head>
<body>

<div class="menu">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="products">Home</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="categories">Category</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<div class="container " style="margin-top: 50px">
    <form class="row g-3" action="pets?action=create" method="post">

        <div class="row">
            <div class="col-md-4">
                <label for="namePet" class="form-label">Tên thú cưng</label>
                <input type="text" class="form-control" id="namePet" name="namePet">
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">Giá</label>
                <input type="number" class="form-control" id="price" name="price">
            </div>
            <div class="col-md-4">
                <label for="quantity" class="form-label">Số lượng</label>
                <input type="number" class="form-control" id="quantity" name="quantity">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="price" class="form-label">Giới tính</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="male" required>
                    <label class="form-check-label">Giống cái</label>
                </div>
                <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" name="male" required>
                    <label class="form-check-label">Giống đực</label><br/>
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label class="form-label">Màu sắc</label>

                    <select class="form-select" required aria-label="select example" name="color">
                        <option value="">Màu đen tuyền</option>
                        <option value="1">Màu xám</option>
                        <option value="2">Màu vàng</option>
                        <option value="3">Màu trắng</option>
                        <option value="3">Màu trắng sữa</option>
                    </select>
                    <div class="invalid-feedback">Example invalid select feedback</div>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-md-4">
                <div class="mb-3">
                    <label class="form-label">Tiêm phòng vắc xin</label>

                    <select class="form-select" required aria-label="select example" name="vaccination">
                        <option value="">1 mũi</option>
                        <option value="">2 mũi</option>
                        <option value="">3 mũi</option>
                    </select>
                    <div class="invalid-feedback">Example invalid select feedback</div>
                </div>
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">Tẩy giun</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="deWorming" required>
                    <label class="form-check-label">Đã tẩy giun</label>
                </div>
                <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" name="deWorming" required>
                    <label class="form-check-label">Chưa tẩy giun</label><br/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="price" class="form-label">Sức khỏe</label>
                <input type="text" class="form-control" id="health" name="health">
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">Trạng thái</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="status" required>
                    <label class="form-check-label">Còn hàng</label>
                </div>
                <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" name="status" required>
                    <label class="form-check-label">Hết hàng</label><br/>
                </div>
        </div>
        <div class="col-md-4">
            <label for="source" class="form-label">Nguồn gốc</label>
            <input type="text" class="form-control" id="source" name="source">
        </div>

        <div class="col-md-4">
            <label>Ảnh</label>

            <input type="file" class="form-control" aria-label="file example" required>
            <div class="invalid-feedback">Example invalid form file feedback</div>
        </div>

</div>

<div class="mb-3" style="margin-top: 10px">
    <button class="btn btn-primary" type="submit" disabled>Thêm mới</button>
</div>
</form>
</div>
</body>
</html>
