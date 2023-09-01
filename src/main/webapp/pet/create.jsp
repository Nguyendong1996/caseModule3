<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="">
    <title>Thêm mới</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../cssHome/Styles.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/regular.css">
    <style>
        input {
            margin: 20px 0;
        }
        label {
            color: red;

        }
    </style>
</head>
<body>
<div class="container">
    <!--    Bắt thanh menu-->

    <div class="item1 item">
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-top: 10px">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Logo</a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="pets">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giới thiệu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giống loài</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Dịch vụ
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Tiêm phòng vacxin</a></li>
                                <li><a class="dropdown-item" href="#">Phối giống cho thú cưng</a></li>
                                <li><a class="dropdown-item" href="#">Làm đẹp cho thú cưng</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Liên hệ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logins?action=login">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logins?action=register">Đăng ký</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="container " style="margin-top: 50px">
    <form class="row g-3" action="pets?action=create" method="post">

        <div class="row">
            <div class="col-md-4">
                <label for="namePet" class="form-label">* Tên thú cưng</label>
                <input type="text" class="form-control" id="namePet" name="namePet">
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">* Giá</label>
                <input type="number" class="form-control" id="price" name="price">
            </div>
            <div class="col-md-4">
                <label for="quantity" class="form-label">* Số lượng</label>
                <input type="number" class="form-control" id="quantity" name="quantity">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="price" class="form-label">* Giới tính</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="male" required value="Giống cái">
                   Giống cái
                </div>
                <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" name="male" required value="Giống Đực">
                  Giống đực<br/>
                </div>
            </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label class="form-label">* Màu sắc</label>

                    <select class="form-select"  aria-label="select example" name="color">
                        <option value="Màu Đen Tuyền">Màu Đen Tuyền</option>
                        <option value="Màu xám">Màu xám</option>
                        <option value="Màu vàng">Màu vàng</option>
                        <option value="Màu trắng">Màu trắng</option>
                        <option value="Màu trắng sữa">Màu trắng sữa</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-md-4">
                <div class="mb-3">
                    <label class="form-label">* Tiêm phòng vắc xin</label>

                    <select class="form-select" required aria-label="select example" name="vaccination">
                        <option value="1">1 mũi</option>
                        <option value="2">2 mũi</option>
                        <option value="3">3 mũi</option>
                    </select>
                    <div class="invalid-feedback">Example invalid select feedback</div>
                </div>
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">* Tẩy giun</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="deWorming" required value="Đã tẩy giun">
                    Đã tẩy giun
                </div>
                <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" name="deWorming" required value="Chưa tẩy giun">
                    Chưa tẩy giun<br/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <label for="price" class="form-label">* Sức khỏe</label>
                <input type="text" class="form-control" id="health" name="health">
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">* Trạng thái</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" name="status" required value="Còn Hàng">
                    Còn hàng
                </div>
                <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" name="status" required value="Hết Hàng">
                     Hết hàng<br/>
                </div>
        </div>
        <div class="col-md-4">
            <label for="source" class="form-label">* Nguồn gốc</label>
            <input type="text" class="form-control" id="source" name="source">
        </div>
            <div class="col-md-4">
                <div class="mb-3">
                    <label for="species" class="form-label">* Giống Loài</label>
                    <select name="idSpecies" class="form-select" id="species" aria-label="Default select example">
                        <c:forEach items="${species}" var="c">
                            <option value="<c:out value="${c.idSpecies}"/>">
                                <c:out value="${c.nameSpecies}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        <div class="col-md-4">
            <label>Ảnh</label>

            <input type="file" class="form-control" aria-label="file example" required>
            <div class="invalid-feedback">Example invalid form file feedback</div>
        </div>

</div>

<div class="mb-3" style="margin-top: 10px">
    <button class="btn btn-primary" type="submit" >Thêm mới</button>
</div>
</form>
</div>
</div>
</body>
</html>
