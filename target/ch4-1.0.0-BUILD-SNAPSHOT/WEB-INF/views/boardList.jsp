<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        #body_container {
            position: relative;
        }

        #search_container {
            position: relative;
            margin-top : 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .search_form {
            display : flex;
        }
        .search_box {
            width: 130px;
            margin-left: 10px;
        }
        .search_input {
            width : 400px;
            margin-left: 10px;
        }
        .write_btn {
            margin-left : 10px;
        }

        .center_align_container {
            position: relative;
            display : flex;
            align-items: center;
            justify-content: center;
        }

        .table_container {
            width : 60%;
        }
        .table_data_container > th, td {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="body_container">
    <script>
        let message;
        if(${msg == "MOD_OK"}) {
            message = "성공적으로 수정하였습니다."
        } else if($msg == "DEL_OK") {
            message = "성공적으로 삭제되었습니다."
        }
        alert(message);
    </script>

    <%-- navi --%>
    <%@ include file="jspf/nav.jspf"%>

    <%--게시판 검색--%>
    <div id="search_container">
        <form class="search_form" action="<c:url value="/board/boardList"/>" method="get">
            <div class="form-group">
                <select class="form-select search_box" id="exampleSelect1">
                    <option value="A" ${ph.sc.option=='A' || ph.sc.option == '' ? "selected" : ""}>제목 + 내용</option>
                    <option value="T" ${ph.sc.option == 'T' ? "selected" : ""}>제목만</option>
                    <option value="W" ${ph.sc.option == 'W' ? "selected" : ""}>작성자</option>
                </select>
            </div>
            <input class="form-control me-sm-2 search_input" name="keyword" value="${ph.sc.keyword}" type="text" placeholder="Search">
            <button class="btn btn-secondary my-2 my-sm-0 search_btn" type="submit">Search</button>
            <button type="button" class="btn btn-outline-primary write_btn" id="writeBtn">글 쓰기</button>
        </form>
    </div>
    <%-- 게시판 --%>
    <div class="center_align_container">
        <div class="table_container">
            <table class="table table-hover">
                <thead>
                <tr class="table_data_container">
                    <th scope="col">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">내용</th>
                    <th scope="col">작성자</th>
                    <th scope="col">등록일</th>
                    <th scope="col">조회수</th>
                </tr>
                </thead>
                <tbody class="table_data_container">
                <c:forEach var="boardDto" items="${list}">
                    <tr class="table-light">
                        <td>${boardDto.bno}</td>
                        <td>${boardDto.title}</td>
                        <td><a href="<c:url value="/board/read${ph.sc.queryString}&bno=${boardDto.bno}"/>"><c:out value="${boardDto.content}"/></a></td>
                        <td>${boardDto.name}</td>
                        <td>${boardDto.reg_date}}</td>
                        <td>${boardDto.viewCnt}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <%-- 게시판 밑 인덱스 --%>
            <div class="center_align_container">
                <ul class="pagination pagination-lg">
                    <c:if test="${ph.showPrev}">
                        <li class="page-item">
                            <a class="page-link" href="<c:url value="/board/boardList${ph.sc.getQueryString(ph.beginPage - 1)}" />">&laquo;</a>
                        </li>
                    </c:if>
                    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                        <li class="page-item active">
                            <a class="page-link" href="<c:url value='/board/boardList${ph.sc.getQueryString(i)}'/>">${i}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${ph.showNext}">
                        <li class="page-item">
                            <a class="page-link" href="<c:url value='/board/boardList${ph.sc.getQueryString(ph.endPage + 1)}'/>">&raquo;</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $("#writeBtn").on("click", function() {
                location.href="<c:url value='/board/write' />";
            });
        });
    </script>
</div>
</body>
</html>
