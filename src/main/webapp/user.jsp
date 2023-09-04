<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 04/09/2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>form thoong tin</h1>
<form action="bills?action=createUser&&idAccount=${idAccount}" method="post">
<input type="text" name="fullName" placeholder="fullName">
<input type="date" name="dob" placeholder="dob">
<input type="text" name="sex" placeholder="sex">
<input type="text" name="phone" placeholder="phone">
<input type="text" name="email" placeholder="email">
<input type="text" name="address" placeholder="address">
<button>SAVE</button>
</form>
</body>
</html>
