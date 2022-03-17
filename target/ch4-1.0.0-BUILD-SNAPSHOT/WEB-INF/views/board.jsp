<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        div {
            margin: 10px;
        }
        .btnContainer {
            float: right;
        }
    </style>
</head>
<body>
<%@ include file="jspf/nav.jspf"%>
<form id="form">
    <div class="form-group">
        <label class="col-form-label col-form-label-lg mt-4" for="inputLarge">Title</label>
        <input name="title" class="form-control form-control-lg" type="text" placeholder=".form-control-lg" id="inputLarge" value="${mode == "new" ? "" : boardDto.title}" ${mode == "new" ? "" : 'readonly'}>
    </div>
    <div class="form-group">
        <label for="exampleTextarea" class="form-label mt-4">Content</label>
        <textarea name="content" class="form-control" id="exampleTextarea" rows="10" ${mode == "new" ? "" : 'readonly'}>${mode == "new" ? "" : boardDto.content}</textarea>
    </div>
    <div class="btnContainer">
        <button type="button" id="${mode == "new" ? "writeBtn" : "listBtn"}" class="btn btn-info">${mode == "new" ? "등록" : "목록"}</button>
        <button type=${mode == "new" ? "button" : "hidden"} id="cancelBtn" class="btn btn-danger">취소</button>
    </div>
</form>
<script>
    $("document").ready(function() {
        $("#writeBtn").on("click", function() {
            let form = $("#form");
            form.attr("method", "post");
            form.attr("action", "<c:url value='/board/write' />");
            form.submit();
        });
        $("#listBtn").on("click", function() {
            location.href="<c:url value='/board/boardList?page=${page}&pageSize=${pageSize}'/>";
        });
    });
</script>
</body>
</html>
