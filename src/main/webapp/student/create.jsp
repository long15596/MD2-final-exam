<%--
  Created by IntelliJ IDEA.
  User: lyngo
  Date: 11/12/2023
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="id">ID</span>
            </div>
            <input type="number" class="form-control" placeholder="Id" aria-label="Username" aria-describedby="addon-wrapping" name="id">
        </div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="name">Name</span>
            </div>
            <input type="text" class="form-control" placeholder="Name" aria-label="Username" aria-describedby="addon-wrapping" name="name">
        </div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="content">Age</span>
            </div>
            <input type="number" class="form-control" placeholder="Age" aria-label="Username" aria-describedby="addon-wrapping" name="age">
        </div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="bloggerName">Gender</span>
            </div>
            <input type="text" class="form-control" placeholder="Gender" aria-label="Username" aria-describedby="addon-wrapping" name="gender">
        </div>
        <div class="input-group flex-nowrap" style="width: 400px; margin-bottom: 10px">
            <div class="input-group-prepend">
                <span class="input-group-text" id="like">GPA</span>
            </div>
            <input type="number" class="form-control" placeholder="GPA" aria-label="Username" aria-describedby="addon-wrapping" name="gpa">
        </div>
        <button class="btn btn-primary" style="margin-top: 10px; color: white">ADD NEW</button>
    </div>
</form>
</body>
</html>
