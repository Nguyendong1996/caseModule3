<%--
  Created by IntelliJ IDEA.
  User: HNQA
  Date: 8/30/2023
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        input {
            margin: 18px 0;
        }

        label {
            color: red;
        }

        .container1 {
            margin: 60px auto;
            width: 85%;
            height: 470px;
            padding: 30px 30px;
            border-radius: 20px;
            border: 3px solid rgba(175, 16, 16, 0.8);
            background: #eee7e9;
        }
    </style>
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/regular.css">
</head>
<body>


<div class="container " style="margin-top: 50px">

    <jsp:include page="../header.jsp"/>
    <!--    Kết thúc thanh menu-->
    <h2 style="color: rgba(175,16,16,0.8); text-align: center">Thông tin thú cưng</h2>

    <div class="container1 ">
        <table>
            <form class="row g-3" action="pets?action=update&&idPet=${pet.getIdPet()}" method="post">

                <div class="row">
                    <div class="col-md-4">
                        <label for="namePet" class="form-label">* Tên thú cưng</label>
                        <input type="text" class="form-control" id="namePet" name="namePet" value="${pet.getNamePet()}">
                    </div>
                    <div class="col-md-4">
                        <label for="price" class="form-label">* Giá</label>
                        <input type="number" class="form-control" id="price" name="price" value="${pet.getPrice()}">
                    </div>
                    <div class="col-md-4">
                        <label for="quantity" class="form-label">* Số lượng</label>
                        <input type="number" class="form-control" id="quantity" name="quantity"
                               value="${pet.getQuantity()}">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label for="price" class="form-label">* Giới tính</label>
                        <div class="form-check">
                            <input type="radio" class="form-check-input" name="male" required value="Giống đực"
                            ${pet.getMale().equals("Giống đực") ? 'checked' : ''}>
                            Giống cái
                        </div>
                        <div class="form-check mb-3">
                            <input type="radio" class="form-check-input" name="male" required value="Giống cái"
                            ${pet.getMale().equals("Giống cái") ? 'checked' : ''}>
                            Giống đực<br/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">* Màu sắc</label>

                            <select class="form-select" aria-label="select example" name="color">
                                <option value="Màu đen trắng">Màu đen trắng</option>
                                <option value="Màu kem">Màu kem</option>
                                <option value="Màu nâu">Màu nâu</option>
                                <option value="Màu nâu đỏ">Màu nâu đỏ</option>
                                <option value="Màu xám">Màu xám</option>
                                <option value="Màu vàng">Màu vàng</option>
                                <option value="Màu trắng">Màu trắng</option>
                                <option value="Màu trắng sữa">Màu trắng sữa</option>
                            </select>
                        </div>
                    </div>
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
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label for="price" class="form-label">* Tẩy giun</label>
                        <div class="form-check">
                            <input type="radio" class="form-check-input" name="deWorming" required value="Đã tẩy giun"
                            ${pet.getDeWorming().equals("Đã tẩy giun") ? 'checked' : ''}>
                            Đã tẩy giun
                        </div>
                        <div class="form-check mb-3">
                            <input type="radio" class="form-check-input" name="deWorming" required value="Chưa tẩy giun"
                            ${pet.getDeWorming().equals("Chưa tẩy giun") ? 'checked' : ''}>
                            Chưa tẩy giun<br/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="price" class="form-label">* Sức khỏe</label>
                        <input type="text" class="form-control" id="health" name="health" value="${pet.getHealth()}">
                    </div>
                    <div class="col-md-4">
                        <label for="source" class="form-label">* Nguồn gốc</label>
                        <input type="text" class="form-control" id="source" name="source" value="${pet.getSource()}">
                    </div>
                </div>
                <div class="row">

                    <div class="col-md-4">
                        <label for="price" class="form-label">* Trạng thái</label>
                        <div class="form-check">
                            <input type="radio" class="form-check-input" name="status" required value="Còn Hàng"
                            ${pet.getStatus().equals("Còn Hàng") ? 'checked' : ''}>
                            Còn hàng
                        </div>
                        <div class="form-check mb-3">
                            <input type="radio" class="form-check-input" name="status" required value="Hết Hàng"
                            ${pet.getStatus().equals("Hết Hàng") ? 'checked' : ''}>
                            Hết hàng<br/>
                        </div>
                    </div>

                    <div class="col-md-4" style="margin-top: 20px">
                        <div class="mb-3">
                            <label for="species" class="form-label">* Giống Loài</label>
                            <select name="idSpecies" class="form-select" id="species"
                                    aria-label="Default select example">
                                <c:forEach items="${speciesList}" var="s">
                                    <option value="<c:out value="${s.idSpecies}"/>">
                                        <c:out value="${s.nameSpecies}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label for="image" class="form-label">* Ảnh</label>
                        <input type="text" class="form-control" id="image" name="image" value="${pet.getImage()}">
                    </div>
                </div>
                <br>
                <div class="mb-3" style="margin-top: 10px">
                    <button class="btn btn-primary" type="submit">Cập nhật</button>
                    <button class="btn btn-danger" type="reset">Làm mới</button>
                </div>
            </form>
            <jsp:include page="../footer.jsp"/>
    </div>

</body>
</html>
