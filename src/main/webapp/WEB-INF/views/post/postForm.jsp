<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  String contextPath = request.getContextPath();
  pageContext.setAttribute("contextPath", contextPath);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>게시글 작성</title>
  <link rel="stylesheet" href="${contextPath}/resources/css/style.css" />
  <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>

<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<c:set var="postActionUrl" value="${contextPath}/post/${not empty postDto.post_id ? 'modify' : 'write'}" />

<div class="form-container">
  <h2>
    <c:choose>
      <c:when test="${not empty postDto.post_id}">게시글 수정</c:when>
      <c:otherwise>게시글 작성</c:otherwise>
    </c:choose>
  </h2>

  <form action="${postActionUrl}" method="post">
    <c:if test="${not empty postDto}">
      <input type="hidden" name="post_id" value="${postDto.post_id}" />
    </c:if>

    <label>제목</label>
    <input type="text" name="post_title" value="${postDto.post_title}" required />


    <label for="post_type">게시판종류</label>
    <select name="post_type" id="post_type" required>
      <option value="">-- 선택하세요 --</option>
      <option value="NOTICE" ${postDto.post_type == 'NOTICE' ? 'selected' : ''}>공지사항</option>
      <option value="FAQ" ${postDto.post_type == 'FAQ' ? 'selected' : ''}>FAQ</option>
      <option value="QNA" ${postDto.post_type == 'QNA' ? 'selected' : ''}>Q&A</option>
    </select>

    <label for="category_main">대분류</label>
    <select name="category_main" id="category_main" required>
      <option value="">-- 선택하세요 --</option>
      <option value="배송" ${postDto.category_main == '배송' ? 'selected' : ''}>배송</option>
      <option value="상품" ${postDto.category_main == '상품' ? 'selected' : ''}>상품</option>
      <option value="회원" ${postDto.category_main == '회원' ? 'selected' : ''}>회원</option>
      <option value="결제" ${postDto.category_main == '결제' ? 'selected' : ''}>결제</option>
      <option value="환불" ${postDto.category_main == '환불' ? 'selected' : ''}>환불</option>
      <option value="이벤트" ${postDto.category_main == '이벤트' ? 'selected' : ''}>이벤트</option>
      <option value="기타" ${postDto.category_main == '기타' ? 'selected' : ''}>기타</option>
    </select>

    <label for="category_sub">소분류</label>
    <select name="category_sub" id="category_sub" required>
      <option value="">-- 소분류 선택 --</option>
    </select>


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

</body>
<script>
  const subCategoryMap = {
    "배송": ["배송지연", "배송조회", "주소변경"],
    "상품": ["재고문의", "상품정보", "사이즈문의"],
    "회원": ["비밀번호", "회원가입", "탈퇴문의"],
    "결제": ["카드결제", "무통장입금", "결제실패"],
    "환불": ["환불요청", "진행상황문의", "반품"],
    "이벤트": ["이벤트참여", "쿠폰문의"],
    "기타": ["기타문의"]
  };

  document.addEventListener("DOMContentLoaded", function () {
    const mainSelect = document.getElementById("category_main");
    const subSelect = document.getElementById("category_sub");
    const selectedMain = '${postDto.category_main}';
    const selectedSub = '${postDto.category_sub}';

    function updateSubOptions(selectedMainCategory) {
      const options = subCategoryMap[selectedMainCategory] || [];
      subSelect.innerHTML = '<option value="">-- 소분류 선택 --</option>';
      options.forEach(option => {
        const opt = document.createElement("option");
        opt.value = option;
        opt.text = option;
        if (option === selectedSub) {
          opt.selected = true;
        }
        subSelect.appendChild(opt);
      });
    }

    // 초기 로드 시에도 반영 (수정 시 필요)
    if (selectedMain) {
      updateSubOptions(selectedMain);
    }

    // 메인 카테고리 변경 시
    mainSelect.addEventListener("change", function () {
      updateSubOptions(this.value);
    });
  });
</script>

</html>
