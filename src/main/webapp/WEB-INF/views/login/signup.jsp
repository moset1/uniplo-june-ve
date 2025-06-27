<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입 | Uniplo</title>
  <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
  <h2>회원가입</h2>
  <div class="card">
    <form action="${pageContext.request.contextPath}/signup/signup" method="post">
      <div class="email-check-row">
        <input type="email" id="user_email" name="user_email" placeholder="이메일" required />
        <c:if test="${not empty errors.getFieldError('user_email')}">
          <span class="error">${errors.getFieldError('user_email').defaultMessage}</span>
        </c:if>
        <button type="button" id="emailCheckBtn" onclick="checkDuplicateEmail()">중복 확인</button>
        <button type="button" id="sendAuthCodeBtn" onclick="sendAuthCode()">인증코드 발송</button>
      </div>
      <span id="EmailCheckResult"></span><br/>

      <div class="auth-code-row">
        <input type="text" id="auth_code" name="auth_code" placeholder="인증코드 입력" />
        <button type="button" onclick="verifyAuthCode()">인증코드 확인</button>
      </div>
      <span id="authCodeResult"></span>

      <input type="password" name="user_password" placeholder="비밀번호" required minlength="8" maxlength="20" />
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
  const contextPath = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/resources/js/signup.js"></script>

</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>