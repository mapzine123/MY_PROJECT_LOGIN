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
<%@ include file="jspf/nav.jspf"%>
<div class="body_container">
    <div class="input_container">
        <form id="form">
            <div class="form-group">
                <label for="exampleInputEmail1" class="form-label mt-4">Email address</label>
                <input type="email" name="email" id="input_email" class="input_email form-control " id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                <div class="invalid-feedback notice_email">Your Email is Shorts. Try Again.</div>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
<%--            <div class="form-group has-danger">--%>
<%--                <label class="form-label mt-4" for="inputInvalid">Invalid input</label>--%>
<%--                <input type="text" value="" class="form-control is-invalid" id="inputInvalid">--%>
<%--                <div class="invalid-feedback">Sorry, that username's taken. Try another?</div>--%>
<%--            </div>--%>
            <div class="form-group">
                <label class="col-form-label mt-4" for="inputDefault">Your Nickname</label>
                <input type="text" name="name" class="form-control input_name" placeholder="input your name" id="inputDefault">
                <div class="invalid-feedback notice_name">Your Name is Shorts. Try Again.</div>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
                <input type="password" name="pwd" class="form-control input_pwd" id="exampleInputPassword1" placeholder="Password">
                <div class="invalid-feedback notice_pwd">Your Password is Shorts. Try Again.</div>
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

           let email = document.querySelector(".input_email");
           let notice_email = document.querySelector(".notice_email");

           let name = document.querySelector(".input_name");
           let notice_name = document.querySelector(".notice_name");

           let pwd = document.querySelector(".input_pwd");
           let notice_pwd = document.querySelector(".notice_pwd");

           if(validate(email, notice_email, email.value.length < 5)){
                return;
           }
           if(validate(name, notice_name, name.value.length < 2 || name.value.length > 15)) {
                return;
           }
           if(validate(pwd, notice_pwd, pwd.value.length < 1)) {
                return;
           }

           form.attr("method", "post");
           form.attr("action", "<c:url value='/login/signIn'/>");
           form.submit();
       });
        $("#cancelBtn").on("click", function() {
            location.href="<c:url value="/"/>";
        });

        function validate(element, notice_element, condition) {
            if(condition) {
                element.classList.add('is-invalid');
                notice_element.style.display = 'block';
                return true;
            } else {
                element.classList.remove('is-invalid');
                notice_element.style.display = 'none';
            }
        }
    });
</script>
</body>
</html>
