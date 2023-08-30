<%--
  Created by IntelliJ IDEA.
  User: HNQA
  Date: 8/30/2023
  Time: 4:37 PM
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
    <div style="margin-top: 10px">
      <form action="products?action=search" method="post">
        <div class="row">
          <div class="col-md-9">
            <input class="form-control mr-sm-2" name="search" value="${search}" type="search"
                   placeholder="Search" aria-label="Search">
          </div>
          <div class="col-md-6">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
          </div>
        </div>
      </form>
    </div>
  </nav>
</div>
<form class="was-validated">
  <div class="col-md-4">
    <label for="validationServer1" class="form-label">Name</label>
    <input type="text" class="form-control is-valid" id="validationServer1" value="" required>
    <div class="valid-feedback"><br/>
    </div>
    <label for="validationServer1" class="form-label">Male</label><br/>

    <div class="form-check">

      <input type="radio" class="form-check-input" id="validationFormCheck2" name="radio-stacked" required>
      <label class="form-check-label" for="validationFormCheck2">M</label>
    </div>
    <div class="form-check mb-3">
      <input type="radio" class="form-check-input" id="validationFormCheck3" name="radio-stacked" required>
      <label class="form-check-label" for="validationFormCheck3">W</label><br/>
    </div>

    <label for="validationServer2" class="form-label">Price</label>
    <input type="text" class="form-control is-valid" id="validationServer2" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <div class="mb-3">
      <label for="validationServer2" class="form-label">Color</label>

      <select class="form-select" required aria-label="select example">
        <option value="">--Color--</option>
        <option value="1">Brown</option>
        <option value="2">Yellow</option>
        <option value="3">White</option>
        <option value="3">Black</option>
      </select>
      <div class="invalid-feedback">Example invalid select feedback</div>
    </div>


    <label for="validationServer3" class="form-label">Quantity</label>
    <input type="text" class="form-control is-valid" id="validationServer3" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <label for="validationServer4" class="form-label">Status</label>
    <input type="text" class="form-control is-valid" id="validationServer4" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <label for="validationServer5" class="form-label">Quantity</label>
    <input type="text" class="form-control is-valid" id="validationServer5" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <label for="validationServer6" class="form-label">Source</label>
    <input type="text" class="form-control is-valid" id="validationServer6" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <label for="validationServer7" class="form-label">Health</label>
    <input type="text" class="form-control is-valid" id="validationServer7" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <label for="validationServer8" class="form-label">De-Worming</label>
    <input type="text" class="form-control is-valid" id="validationServer8" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <label for="validationServer9" class="form-label">Vaccination</label>
    <input type="text" class="form-control is-valid" id="validationServer9" value="" required>
    <div class="valid-feedback"><br/>
    </div>

    <div class="mb-3">
      <label>IMG</label>

      <input type="file" class="form-control" aria-label="file example" required>
      <div class="invalid-feedback">Example invalid form file feedback</div>
    </div>

    <div class="mb-3">
      <button class="btn btn-primary" type="submit" disabled>Submit form</button>
    </div>
  </div>
</form>
</body>

</html>
