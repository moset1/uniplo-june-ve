<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
  <title>${postDto.post_title}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<div class="post-container">
  <!-- 게시글 내용 -->
  <div class="post-header">
    <h2>${postDto.post_title}</h2>
    <div class="post-meta">
      작성자: ${postDto.user_id} | 작성일: <fmt:formatDate value="${postDto.created_at}" pattern="yyyy-MM-dd HH:mm"/>
    </div>
  </div>

  <div class="post-content">
    ${postDto.post_content}
  </div>

  <!-- 버튼 영역 -->
  <div class="post-buttons">
    <form action="${pageContext.request.contextPath}/post/list" method="get">
      <button type="submit">목록</button>
    </form>

    <c:if test="${sessionScope.authUser.user_id == postDto.user_id}">
      <form action="${pageContext.request.contextPath}/post/editForm" method="get">
        <input type="hidden" name="post_id" value="${postDto.post_id}">
        <button type="submit">수정</button>
      </form>
      <form action="${pageContext.request.contextPath}/post/delete" method="post"
            onsubmit="return confirm('정말 삭제하시겠습니까?');">
        <input type="hidden" name="post_id" value="${postDto.post_id}">
        <button type="submit">삭제</button>
      </form>
    </c:if>
  </div>

  <%--  <!-- 댓글 목록 -->--%>
  <%--  <div class="comment-section">--%>
  <%--    <h3>댓글</h3>--%>
  <%--    <c:forEach var="comment" items="${commentList}">--%>
  <%--      <div class="comment">--%>
  <%--        <div class="comment-meta">--%>
  <%--            ${comment.user_id} | <fmt:formatDate value="${comment.created_at}" pattern="yyyy-MM-dd HH:mm"/>--%>
  <%--        </div>--%>
  <%--        <div class="comment-content">${comment.comment_content}</div>--%>
  <%--      </div>--%>
  <%--    </c:forEach>--%>

  <%--    <!-- 댓글 작성 -->--%>
  <%--    <c:if test="${not empty sessionScope.user}">--%>
  <%--      <form class="comment-form" action="${pageContext.request.contextPath}/comment/write" method="post">--%>
  <%--        <input type="hidden" name="post_id" value="${post.post_id}">--%>
  <%--        <textarea name="c omment_content" placeholder="댓글을 입력하세요..." required></textarea>--%>
  <%--        <button type="submit">댓글 등록</button>--%>
  <%--      </form>--%>
  <%--    </c:if>--%>
  <%--    <c:if test="${empty sessionScope.user}">--%>
  <%--      <p>댓글을 작성하려면 <a href="${pageContext.request.contextPath}/user/login">로그인</a> 해주세요.</p>--%>
  <%--    </c:if>--%>
  <%--  </div>--%>
  <%--</div>--%>

</body>
</html>
