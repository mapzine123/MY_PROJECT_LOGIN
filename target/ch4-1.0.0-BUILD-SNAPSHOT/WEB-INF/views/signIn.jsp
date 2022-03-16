<%--
  Created by IntelliJ IDEA.
  User: mapzi
  Date: 2022-03-16
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<form id="form">
    <div class="form-group">
        <label for="exampleInputEmail1" class="form-label mt-4">Email address</label>
        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label class="col-form-label mt-4" for="inputDefault">Default input</label>
        <input type="text" name="name" class="form-control" placeholder="input your name" id="inputDefault">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
        <input type="password" name="pwd" class="form-control" id="exampleInputPassword1" placeholder="Password">
    </div>
    <button type="button" class="btn btn-outline-primary" id="signBtn">Sign In</button>
</form>
<script>
    $(document).ready(function() {
       $("#signBtn").on("click", function() {
           let form = $("#form");
           form.attr("method", "post");
           form.attr("action", "<c:url value='/login/signIn'/>");
           form.submit();
       });
    });
</script>
</body>
</html>
