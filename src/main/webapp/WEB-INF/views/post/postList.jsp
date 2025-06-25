<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>

<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<div class="post-list-container">
    <div class="post-list-header">
        <h2>게시판</h2>
        <a href="${pageContext.request.contextPath}/post/write" class="write-button">글쓰기</a>
    </div>

    <table class="post-table">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="postDto" items="${postList}">
            <tr>
                <td>${postDto.post_id}</td>
                <td>
                    <a class="post-title" href="${pageContext.request.contextPath}/post/${postDto.post_id}">
                            ${postDto.post_title}
                    </a>
                </td>
                <td>${postDto.user_id}</td>
                <td><fmt:formatDate value="${postDto.created_at}" pattern="yyyy-MM-dd" /></td>
                <td>${postDto.view_count}</td>
            </tr>
        </c:forEach>
        <c:if test="${empty postList}">
            <tr>
                <td colspan="5" style="text-align: center;">게시물이 없습니다.</td>
            </tr>
        </c:if>
        </tbody>
    </table>
    <div class="paging-container">
        <div class="paging">
            <c:if test="${totalCount!=null && totalCount!=0}">
                <c:if test="${ph.showPrev}">
                    <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
                </c:if>
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>
                </c:forEach>
                <c:if test="${ph.showNext}">
                    <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
                </c:if>
            </c:if>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/post/list" method="get" style="display: flex; justify-content: flex-end; align-items: center; gap: 0.5rem; margin-bottom: 1rem;">
        <select name="type" style="padding: 0.4rem;">
            <option value="title" ${ph.sc.option == 'T' ? 'selected' : ''}>제목</option>
            <option value="content" ${ph.sc.option == 'C' ? 'selected' : ''}>내용</option>
            <option value="writer" ${ph.sc.option == 'W' ? 'selected' : ''}>작성자</option>
        </select>
        <input type="text" name="keyword" value="${ph.sc.keyword}" placeholder="검색어 입력" style="padding: 0.4rem; width: 200px;" />
        <button type="submit" style="padding: 0.4rem 1rem; background-color: #b00020; color: white; border: none; border-radius: 4px;">검색</button>
    </form>
</div>

</body>
</html>
