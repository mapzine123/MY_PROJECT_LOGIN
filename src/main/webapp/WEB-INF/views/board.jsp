<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<script>
    alert(${mode});
</script>

<%@ include file="jspf/nav.jspf"%>
<form id="form">
    <div class="form-group">
        <label class="col-form-label col-form-label-lg mt-4" for="inputLarge">Title</label>
        <input name="title" class="form-control form-control-lg" value="${mode == "new" ? "" : boardDto.title}" value="${mode == "read" ? "readonly" : ""}" type="text" placeholder="Input Your Title" id="inputLarge">
    </div>
    <div class="form-group">
        <label for="exampleTextarea" class="form-label mt-4">Content</label>
        <textarea name="content" class="form-control" id="exampleTextarea" rows="3" ${mode == "read" ? "readonly" : ""}>${mode == "new" ? "" : boardDto.content}</textarea>
    </div>

    <div>
        <c:if test="${mode == 'modify'}">
            <button type="button" id="modifyBtn" class="btn btn-info">수정</button>
        </c:if>
        <button type="button" id="${mode == "new" ? "writeBtn" : "listBtn"}" class="btn btn-info">${mode == "new" ? "등록" : "목록"}</button>
        <button type="button" id="cancelBtn" class="btn btn-danger">취소</button>
    </div>
</form>
<script>
    $(document).ready(function() {
        $("#writeBtn").on("click", function() {
             let form = $("#form");
             form.attr("method", "post");
             form.attr("action", "<c:url value="/board/write"/>");
             form.submit();
        });
        $("#listBtn").on("click", function() {
            location.href="<c:url value="/board/boardList?page=${page}&pageSize=${pageSize}"/>";
        });
        $("#cancelBtn").on("click", function() {
            location.href="<c:url value="/board/boardList?page=${page}&pageSize=${pageSize}"/>";
        });
        $("#modifyBtn").on("click", function() {
            let form=$("#form");
            form.attr("method", "POST");
            form.attr("action", "<c:url value='/board/modify'/>");
            form.submit();
        });
    });
</script>
</body>
</html>
