<%--
  Created by IntelliJ IDEA.
  User: HNQA
  Date: 8/30/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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


</head>
<body>
<div class="container">
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
            <div style="margin-top: 20px">
                <form action="products?action=search" method="post">
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
    <c:if test="${message != null}">
        <script>
            alert("${message}")
        </script>
    </c:if>
    <div class="container mt-3">
        <form class="row g-3" action="products?action=create" method="post">
            <div class="row">
                <div class="col-md-3">
                    <label for="name" class="form-label">Name_Pet</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="col-md-6">
                    <label for="price" class="form-label">Price</label>
                    <input type="number" class="form-control" id="price" name="price">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="species" class="form-label">Species</label>
                    <input type="number" class="form-control" id="species" name="species">
                </div>
                <div class="col-md-6">
                    <label for="color" class="form-label">Color</label>
                    <input type="text" class="form-control" id="color" name="color">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="male" class="form-label">Male</label>
                    <input type="text" class="form-control" id="male" name="male">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="vaccination" class="form-label">Vaccination</label>
                    <input type="text" class="form-control" id="vaccination" name="vaccination">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="deWorming" class="form-label">De_Worming</label>
                    <input type="text" class="form-control" id="deWorming" name="deWorming">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="health" class="form-label">Health</label>
                    <input type="text" class="form-control" id="health" name="health">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="quantity" class="form-label">Quantity</label>
                    <input type="text" class="form-control" id="quantity" name="quantity">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="status" class="form-label">Status</label>
                    <input type="text" class="form-control" id="status" name="status">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="source" class="form-label">Source</label>
                    <input type="text" class="form-control" id="source" name="source">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="image" class="form-label">Image</label>
                    <input type="text" class="form-control" id="image" name="image">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <label for="category" class="form-label">Category</label>
                    <select name="idCategory" class="form-select" id="category" aria-label="Default select example">
                        <c:forEach items="${categories}" var="c">
                            <option value="<c:out value="${c.id}"/>">
                                <c:out value="${c.name}"/>
                            </option>
                        </c:forEach>
                    </select>

                </div>
            </div>
            <div>
                <button class="btn btn-info" type="submit">Create</button>
            </div>
        </form>
    </div>
</div>
</body>

</html>
