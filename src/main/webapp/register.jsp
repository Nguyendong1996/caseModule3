<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Đăng ký</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="login/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="login/css/util.css">
    <link rel="stylesheet" type="text/css" href="login/css/main.css">
    <!--===============================================================================================-->
    <style>
        .check {
            color: red;
            font-size: 18px;
            margin-left: 20px;
        }
    </style>
</head>
<body>

<div class="limiter">
    <div class="container-login100" style="background-image: url('login/images/bag-01.jpg');">
        <div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Đăng ký
				</span>
            <div class="check"><c:out value="${errorPass}"/></div>
            <div class="check"><c:out value="${errorUsername}"/></div>
            <div class="check"><c:out value="${errorUsernameFormat}"/></div>
            <div class="check"><c:out value="${errorUsernameLength}"/></div>
            <div class="check"><c:out value="${errorPasswordFormat}"/></div>
            <div class="check"><c:out value="${errorPasswordLength}"/></div>
            <form class="login100-form validate-form p-b-33 p-t-5" action="logins?action=register" method="post">
                <div class="wrap-input100 validate-input" data-validate="Enter username">
                    <input class="input100" type="text" name="username" placeholder="Tên tài khoản" required>

                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input class="input100" type="password" name="password" placeholder="Mật khẩu" required>

                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Enter password">
                    <input class="input100" type="password" name="re_password" placeholder="Nhập lại mật khẩu" required>
                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                </div>

                <div class="container-login100-form-btn m-t-32">
                    <button type="submit" class="login100-form-btn">
                        Đăng ký
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/bootstrap/js/popper.js"></script>
<script src="login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/daterangepicker/moment.min.js"></script>
<script src="login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="login/js/main.js"></script>

</body>
</html>