<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/common/header.jsp" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="postActionUrl" value="${contextPath}/post/${not empty postDto.post_id ? 'modify' : 'write'}" />
<style>
  .form-container {
    max-width: 800px;
    margin: 2rem auto;
    padding: 2rem;
    border: 1px solid #ddd;
    border-radius: 0.5rem;
    background-color: #fafafa;
    font-family: 'Noto Sans KR', sans-serif;
  }

  .form-container h2 {
    text-align: center;
    margin-bottom: 2rem;
  }

  .form-container input[type="text"],
  .form-container textarea,
  .form-container select {
    width: 100%;
    padding: 0.75rem;
    margin-bottom: 1.2rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1rem;
  }

  .form-container textarea {
    height: 200px;
    resize: vertical;
  }

  .form-buttons {
    text-align: right;
  }

  .form-buttons button {
    padding: 0.5rem 1.5rem;
    font-size: 1rem;
    margin-left: 0.5rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  .btn-submit {
    background-color: #b00020;
    color: white;
  }

  .btn-cancel {
    background-color: #999;
    color: white;
  }
</style>

<div class="form-container">
  <h2><c:choose>
    <c:when test="${not empty postDto.post_id}">게시글 수정</c:when>
    <c:otherwise>게시글 작성</c:otherwise>
  </c:choose></h2>

  <form action="${postActionUrl}" method="post">
    <c:if test="${not empty postDto}">
      <input type="hidden" name="post_id" value="${postDto.post_id}" />
    </c:if>

    <label>제목</label>
    <input type="text" name="post_title" value="${postDto.post_title}" required />

    <label>카테고리</label>
    <select name="category_main" required>
      <option value="">-- 선택하세요 --</option>
      <option value="NOTICE" ${postDto.category_main == 'NOTICE' ? 'selected' : ''}>공지사항</option>
      <option value="FAQ" ${postDto.category_main == 'FAQ' ? 'selected' : ''}>FAQ</option>
      <option value="QNA" ${postDto.category_main == 'QNA' ? 'selected' : ''}>Q&A</option>
    </select>

    <label>서브 카테고리</label>
    <input type="text" name="category_sub" placeholder="예: 배송문의, 회원정보" value="${postDto.category_sub}" />

    <label>내용</label>
    <textarea name="post_content" required>${postDto.post_content}</textarea>

    <label>비공개 여부</label>
    <select name="is_private">
      <option value="N" ${postDto.is_private == 'N' ? 'selected' : ''}>공개</option>
      <option value="Y" ${postDto.is_private == 'Y' ? 'selected' : ''}>비공개</option>
    </select>

    <div class="form-buttons">
      <button type="submit" class="btn-submit">저장</button>
      <button type="button" class="btn-cancel" onclick="location.href='${contextPath}/post/list'">취소</button>
    </div>
  </form>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
