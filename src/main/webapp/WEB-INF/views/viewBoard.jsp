<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>

<%@ include file="jspf/nav.jspf"%>
<form id="form">
    <div class="form-group">
        <label class="col-form-label col-form-label-lg mt-4" for="inputLarge">Title</label>
        <input name="title" class="form-control form-control-lg" value="${boardDto.title}"  type="text" id="inputLarge" readonly>
    </div>
    <div class="form-group">
        <label for="exampleTextarea" class="form-label mt-4">Content</label>
        <textarea name="content" class="form-control" id="exampleTextarea" rows="3" readonly>${boardDto.content}</textarea>
    </div>

    <div>
        <c:if test="${mode == 'modify'}">
            <button type="button" id="modifyBtn" class="btn btn-info">수정</button>
        </c:if>
        <button type="button" id="listBtn" class="btn btn-info">목록</button>
        <input type="hidden" id="mode" name="mode">
        <input type="text" id="bno" name="bno" value="${boardDto.bno}">
    </div>
</form>
<script>
    $(document).ready(function() {
        $("#listBtn").on("click", function() {
            location.href="<c:url value="/board/boardList?page=${page}&pageSize=${pageSize}"/>";
        });
        $("#modifyBtn").on("click", function() {
            let form = $("#form");
            form.attr("method",  "POST");
            form.attr("action", "<c:url value="/board/goModify"/>");

            let mode = $("#mode");
            mode.attr("value", "modify");
            form.submit();
        });
    });
</script>
</body>
</html>
