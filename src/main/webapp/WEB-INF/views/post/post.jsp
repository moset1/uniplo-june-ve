<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  pageContext.setAttribute("formatter", formatter);
%>
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
      작성자: ${postDto.user_id} | 작성일: ${postDto.created_at.format(formatter)} | 수정일: ${postDto.updated_at.format(formatter)}
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
</div>

</body>
</html>
