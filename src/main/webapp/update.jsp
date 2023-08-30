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
  <title>Update</title>
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
<div class="container mt-5">
  <form class="row g-3" action="products?action=update&&id=${product.getId()}" method="post">
    <div class="row">
      <div class="col-md-6">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${product.getName()}">
      </div>
      <div class="col-md-6">
        <label for="price" class="form-label">Price</label>
        <input type="number" class="form-control" id="price" name="price" value="${product.getPrice()}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="quantity" class="form-label">Quantity</label>
        <input type="number" class="form-control" id="quantity" name="quantity" value="${product.getQuantity()}">
      </div>
      <div class="col-md-6">
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" id="description" name="description" value="${product.getDescription()}">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
        <label for="dateManufacture" class="form-label">DateManufacture</label>
        <input type="date" class="form-control" id="dateManufacture" name="dateManufacture" value="${product.getDateManufacture()}">
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
      <button class="btn btn-primary" type="submit">Update</button>
      <button class="btn btn-secondary" type="submit">Reset</button>
    </div>
  </form>
</div>
</body>

</html>
