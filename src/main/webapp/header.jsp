<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-top: 30px">
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="background-color: rgba(176,116,116,0.84)">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">

                    <a class="nav-link active" aria-current="page" href="pets">
                        <img src="cssHome/logoWeb.png" alt="logo" style="width: 100px" height="60px"></a>

                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Giới thiệu</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Giống loài
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <c:forEach items="${speciesList}" var="s">
                            <li><a href="pets?action=displayBySpecies&&idSpecies=${s.idSpecies}"
                                   class="list-group-item"><c:out value="${s.nameSpecies}"/></a></li>
                        </c:forEach>
                    </ul>
                </li>
                <c:if test="${sessionScope.account.isAdmin()}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Quản lý
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="pets?action=displayAdmin">Danh sách thú cưng</a></li>
                            <li><a class="dropdown-item" href="species">Danh sách giống loài</a></li>
                            <li><a class="dropdown-item" href="accounts?action=display">Danh sách tài khoản</a></li>
                        </ul>
                    </li>
                </c:if>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dịch vụ
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Tiêm phòng vacxin</a></li>
                        <li><a class="dropdown-item" href="#">Kiểm tra sức khỏe</a></li>
                        <li><a class="dropdown-item" href="#">Làm đẹp cho thú cưng</a></li>
                        <li><a class="dropdown-item" href="#">Phối giống cho thú cưng</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Liên hệ</a>
                </li>

                <c:if test="${sessionScope.account.isAdmin()}">
                <li style="margin-left: 30px">
                    </c:if>
                    <c:if test="${sessionScope.account.isAdmin() == false || sessionScope.account == null}">
                <li style="margin-left: 80px">
                    </c:if>
                    <form class="d-flex" action="pets?action=searchByName" method="post">
                        <input style="height: 45px ; margin-top: 5px" class="form-control me-2" type="search"
                               placeholder="Tìm kiếm" aria-label="Search" name="search" value="${search}">
                        <button style="font-size: 20px; border: none; background-color: rgba(178,121,121,0.84); margin-right: 10px"
                                type="submit"><i
                                class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </li>


                <c:if test="${sessionScope.account == null}">

                    <li class="nav-item" style="margin-left: 80px">
                        <a class="nav-link" href="logins?action=login">
                            <i class="fa-solid fa-right-to-bracket" style="font-size: 18px"></i> Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logins?action=register">
                            <i class="fa-regular fa-registered " style="font-size: 18px"></i> Đăng ký</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.account != null}">
                    <li class="nav-item" style="margin: 0 5px 0 70px">
                        <a class="nav-link" href="accounts?action=detail&&idAccount=${account.idAccount}">
                            <i class="fa-solid fa-user" style="font-size: 18px"></i>
                            <strong> ${sessionScope.account.username}</strong></a>
                    </li>
                    <li class="nav-item" style="margin-left: 10px">
                        <a class="nav-link" href="logout">Đăng xuất</a>
                    </li>

                </c:if>


            </ul>
<%--<c:if test="${sessionScope.account.isAdmin() == false }">--%>
            <div style="margin-bottom: 33px">Giỏ hàng</div>
            <a class="nav-link" style="margin-bottom: 14px" href="#">
                <i class="fa-solid fa-cart-shopping"
                   style="width: 50px; font-size: 30px; margin-bottom: 13px; color: rgb(17,72,114)"></i>
            </a>
        </div>
<%--        </c:if>--%>
<%--        <c:if test="${sessionScope.account == null}">--%>
<%--            <div style="margin-bottom: 33px">Giỏ hàng</div>--%>
<%--            <a class="nav-link" style="margin-bottom: 14px" href="#">--%>
<%--                <i class="fa-solid fa-cart-shopping" style="width: 50px; font-size: 30px; margin-bottom: 13px"></i>--%>
<%--            </a>--%>
<%--            </div>--%>
<%--        </c:if>--%>

    </nav>


