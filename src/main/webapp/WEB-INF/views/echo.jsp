<%--
  Created by IntelliJ IDEA.
  User: mapzi
  Date: 2022-03-27
  Time: 오전 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chatting</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <link rel="stylesheet" href="<c:url value='/css/echo.css' />">
</head>
<body>
<%@ include file="jspf/nav.jspf"%>

<div class="body_container">
    <div class="chatContainer">
        <form class="divForm">
            <div class="chatBox">

            </div>
            <div class="input-group mb-3 inputContainer">
                <input type="text" class="form-control messageBox" aria-label="Recipient's username" aria-describedby="button-addon2">
                <button class="btn btn-primary sendBtn" type="button" id="button-addon2">보내기</button>
            </div>
        </form>
    </div>
</div>
<script>
    sessionStorage.setItem("wsUri", "ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/websocket/echo.do");
    sessionStorage.setItem("name", "${name}");
</script>

<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script src="<c:url value='/js/echo.js' />"></script>
</body>
</html>
