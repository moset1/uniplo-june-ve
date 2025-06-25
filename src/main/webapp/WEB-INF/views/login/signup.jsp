<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입 | Uniplo</title>
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
  <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<div class="container">
  <h2>회원가입</h2>
  <div class="card">
    <form action="${pageContext.request.contextPath}/signup/signup" method="post" onsubmit="return formCheck(this)">
      <input type="email" name="user_email" placeholder="이메일" required />
      <input type="password" name="user_password" placeholder="비밀번호" required />
      <input type="text" name="user_last_name" placeholder="성" required />
      <input type="text" name="user_first_name" placeholder="이름" required />
      <input type="tel" name="user_phone_number" placeholder="전화번호 (010-xxxx-xxxx)" required />
      <input type="date" name="user_birth_date" placeholder="생년월일" required />
      <label><input type="checkbox" name="is_agreed" value="Y" required /> 이용약관 동의</label>
      <button type="submit">회원가입</button>
    </form>
  </div>
</div>
<script>
  function formCheck(form) {
    const email = form.user_email.value.trim();
    const password = form.user_password.value.trim();

    // 이메일 형식 검증
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
      alert("올바른 이메일 형식을 입력해주세요.");
      form.user_email.focus();
      return false;
    }

    // 비밀번호 길이 8~20자 검증
    if (password.length < 8 || password.length > 20) {
      alert("비밀번호는 8자 이상 20자 이하로 입력해주세요.");
      form.user_password.focus();
      return false;
    }

    return true;
  }
</script>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>