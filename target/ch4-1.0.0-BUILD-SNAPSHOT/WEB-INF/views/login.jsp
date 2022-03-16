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
<div class="form-group">
    <form id="form">
        <label class="form-label mt-4">Floating labels</label>
        <div class="form-floating mb-3">
            <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" name="pwd" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>
    </form>
</div>
<button type="button" class="btn btn-outline-primary" id="signBtn">Sign In</button>
<button type="button" class="btn btn-outline-primary" id="loginBtn">Login</button>
<script>
    $(document).ready(function() {
        $("#signBtn").on("click", function() {
            let form = $("#form");
            form.attr("method", "get");
            form.attr("action", "<c:url value='/login/signIn'/>");
            form.submit();
        });
        $("#loginBtn").on("click", function() {
            let form = $("#form");
            form.attr("method", "post");
            form.attr("action", "<c:url value='/login/login'/>");
            form.submit();
        });
    });
</script>
</body>
</html>
