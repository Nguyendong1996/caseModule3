<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="">
    <title>Thông tin chi tiết</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.min.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/all.css">
    <link rel="stylesheet" href="../cssHome/fontawesome-free-6.4.2-web/css/regular.css">
    <link rel="stylesheet" href="../cssHome/detail.css">
</head>
<body>
<div class="container">
    <!--    Bắt thanh menu-->
    <jsp:include page="../header.jsp"/>
    <hr>
    <div class="body">


        <h1 style="text-align: center; color: #d93c3c">Thông tin về thú cưng</h1>
        <br>
        <div class="row">
            <div class="col-sm-6">
                <div class="image-container">
                    <img class="anh" src="${pet.image}" alt="image" width="450px" height="500px"/>
                </div>
            </div>
            <div class="col-sm-6">
                <table>
                    <tr>
                        <th colspan="3"><span class="namePet">${pet.namePet}</span></th>
                    </tr>
                    <tr>
                        <th colspan="3"><span class="price">${pet.price} VNĐ</span></th>
                    </tr>
                    <tr>
                        <th>Màu:</th>
                        <td colspan="2">${pet.color}</td>
                    </tr>
                    <tr>
                        <th>Giới tính:</th>
                        <td colspan="2">${pet.male}</td>
                    </tr>
                    <tr>
                        <th>Tiêm vacxin:</th>
                        <td colspan="2">${pet.vaccination}</td>
                    </tr>
                    <tr>
                        <th>Tẩy giun:</th>
                        <td colspan="2">${pet.deWorming}</td>
                    </tr>
                    <tr>
                        <th>Sức khỏe:</th>
                        <td colspan="2">${pet.health}</td>
                    </tr>
                    <tr>
                        <th>Nguồn gốc:</th>
                        <td colspan="2">${pet.source}</td>
                    </tr>
                    <tr>
                        <th>Trạng thái:</th>
                        <td colspan="2">${pet.status} </td>
                    </tr>
                    <tr>
                        <th>Giống loài:</th>
                        >
                        <td colspan="2">${pet.species.nameSpecies}</td>
                    </tr>
                    <tr style="margin-top: 10px">
                        <td colspan="3"><a class="btn btn-danger" style="font-size: 22px; font-weight: bold"
                                           href="pets?action=cart&&idPet=${pet.idPet}&&idUser=${account.idAccount}">Thêm vào giỏ hàng</a></td>
                    </tr>

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
    </div>
</div>
</body>
</html>