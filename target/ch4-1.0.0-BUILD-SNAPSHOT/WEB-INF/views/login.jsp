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
        .login_container {
            display : flex;
            width : 100%;
            height: 80%;
            align-items: center;
            justify-content: center;
        }
        .login_container_bottom {
            margin-top : 15px;
        }

        .input_box {
            width : 480px;
        }
        .btn_container {
            float : right;
        }
    </style>
</head>
<body>
<%@ include file="jspf/nav.jspf"%>
<div class="body_container">
    <div class="form-group login_container">
        <div>
            <form id="form">
                <label class="form-label mt-4">Login</label>
                <div class="form-floating mb-3">
                    <input type="email" name="email" class="form-control input_box" id="floatingInput" value="${cookie.email.value}" placeholder="name@example.com">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="pwd" class="form-control input_box" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-check login_container_bottom">
                    <input class="form-check-input" type="checkbox" name="rememberId" value="true" id="flexCheckDefault" ${empty cookie.email.value ? "" : "checked"}>
                    <label class="form-check-label" for="flexCheckDefault">
                        Auto login
                    </label>
                    <div class="btn_container">
                        <button type="button" class="btn btn-outline-primary" id="loginBtn">Login</button>
                        <button type="button" class="btn btn-outline-primary" id="signBtn">Sign In</button>
                    </div>
                </div>
            </form>
        </div>


    </div>

</div>
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
