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
    <style>
        .body_container {
            position: relative;
        }
        .input_container {
            display: flex;
            align-items: center;
            justify-content: center;
            width : 100%;
            height: 80%;
        }

        .btn_container {
            margin-top : 20px;
            float: right;
        }
    </style>
</head>
<body>
<div class="body_container">
    <div class="input_container">
        <form id="form">
            <div class="form-group">
                <label for="exampleInputEmail1" class="form-label mt-4">Email address</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label class="col-form-label mt-4" for="inputDefault">Your Nickname</label>
                <input type="text" name="name" class="form-control" placeholder="input your name" id="inputDefault">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
                <input type="password" name="pwd" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="btn_container">
                <button type="button" class="btn btn-outline-primary" id="signBtn">Sign In</button>
                <button type="button" class="btn btn-outline-danger" id="cancelBtn">cancel</button>
            </div>
        </form>
    </div>
</div>

<script>
    $(document).ready(function() {
       $("#signBtn").on("click", function() {
           let form = $("#form");
           form.attr("method", "post");
           form.attr("action", "<c:url value='/login/signIn'/>");
           form.submit();
       });
        $("#cancelBtn").on("click", function() {
            location.href="<c:url value="/"/>";
        });
    });
</script>
</body>
</html>
