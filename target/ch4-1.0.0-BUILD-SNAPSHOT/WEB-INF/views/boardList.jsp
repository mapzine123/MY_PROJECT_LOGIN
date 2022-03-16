<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">내용</th>
        <th scope="col">작성자</th>
        <th scope="col">등록일</th>
        <th scope="col">조회수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="boardDto" items="${list}">
    <tr class="table-light">
        <td>${boardDto.bno}</td>
        <td>${boardDto.title}</td>
        <td><a href="<c:url value="/board/board?bno=${boardDto.bno}&page=${page}&pageSize=${pageSize}"/>">${boardDto.content}</a></td>
        <td>${boardDto.name}</td>
        <td>${boardDto.reg_date}}</td>
        <td>${boardDto.viewCnt}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>


<div>
    <ul class="pagination pagination-lg">
        <c:if test="${ph.showPrev}">
            <li class="page-item">
                <a class="page-link" href="<c:url value="/board/boardList?page=${ph.beginPage - 1}&pageSize=${ph.pageSize}" />">&laquo;</a>
            </li>
        </c:if>
        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <li class="page-item active">
                <a class="page-link" href="<c:url value='/board/boardList?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
            </li>
        </c:forEach>
        <c:if test="${ph.showNext}">
            <li class="page-item">
                <a class="page-link" href="<c:url value='/board/boardList?page=${ph.endPage + 1}&pageSize=${ph.pageSize}'/>">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>
<div style="float:right">
    <button type="button" class="btn btn-outline-primary" id="writeBtn">글 쓰기</button>
</div>
<script>
    $(document).ready(function() {
        $("#writeBtn").on("click", function() {
            location.href="<c:url value='/board/write' />";
        });
    });
</script>
</body>
</html>
