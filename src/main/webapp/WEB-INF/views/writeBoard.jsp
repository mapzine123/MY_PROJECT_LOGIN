<%--
  Created by IntelliJ IDEA.
  User: mapzi
  Date: 2022-03-19
  Time: 오전 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${boardDto.title} : view Board</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        #margin_h3 {
            margin-top : 20px;
        }
        .btn_container {
            float: right;
            margin-right: 20px;
        }
    </style>
</head>
<body>
    <%-- navi --%>
    <%@ include file="jspf/nav.jspf"%>
    <h3 id="margin_h3">Write Your Opinion</h3>
    <hr>
    <form id="form">
        <div class="form-group">
            <label class="col-form-label col-form-label-lg mt-4" for="inputLarge"></label>
            <input class="form-control form-control-lg" value="${boardDto.title}" type="text" name="title" placeholder="Input your title" id="inputLarge">
        </div>
        <div class="form-group">
            <label for="exampleTextarea" class="form-label mt-4"></label>
            <textarea class="form-control" id="exampleTextarea" name="content" rows="10" placeholder="Input your Content">${boardDto.content}</textarea>
        </div>
        <div class="btn_container">
            <button type="button" class="btn btn-info" id=${mode == "accessable" ? "modifyBtn" : "writeBtn"}>등록</button>
            <button type="button" class="btn btn-warning" id="cancelBtn">취소</button>
            <c:if test="${mode == 'accessable'}">
                <input type="hidden" id="bno" name="bno" value="${boardDto.bno}">
            </c:if>
        </div>
    </form>
    <script>
        $(document).ready(function() {
            $("#writeBtn").on("click", function() {
                 let form = $("#form");
                 form.attr("action", "<c:url value='/board/write'/>");
                 form.attr("method", "POST");
                 form.submit();
            });

            $("#cancelBtn").on("click", function() {
                location.href="<c:url value="/board/boardList?page=${page}&pageSize=${pageSize}"/>";
            });

            $("#modifyBtn").on("click", function() {
                let form = $("#form");
                form.attr("action", "<c:url value='/board/modify'/>");
                form.attr("method", "POST");
                form.submit();
            });
        });
    </script>
</body>
</html>
