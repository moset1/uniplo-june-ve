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
      <input type="email" id="user_email" name="user_email" placeholder="이메일" required />
      <button type="button" onclick="checkDuplicateEmail()">중복 확인</button>
      <span id="EmailCheckResult"></span>
      <input type="password" name="user_password" placeholder="비밀번호" required minlength="8" maxlength="20" />
      <input type="text" name="user_last_name" placeholder="성" required />
      <input type="text" name="user_first_name" placeholder="이름" required />
      <input type="tel" name="user_phone_number" placeholder="전화번호 (010-xxxx-xxxx)" required />
      <input type="date" name="user_birth_date" placeholder="생년월일" required />
      <label><input type="checkbox" name="is_agreed" value="Y" required /> 이용약관 동의</label>
      <button type="submit">회원가입</button>
    </form>

    <script>
      document.addEventListener("DOMContentLoaded", function () {
        const form = document.querySelector("form");
        form.addEventListener("submit", function (e) {
          const password = form.user_password.value.trim();

          if (password.length < 8 || password.length > 20) {
            alert("비밀번호는 8자 이상 20자 이하로 입력해주세요.");
            e.preventDefault();
            return;
          }

          const requiredFields = ["user_email", "user_last_name", "user_first_name", "user_phone_number", "user_birth_date"];
          for (const name of requiredFields) {
            if (!form[name].value.trim()) {
              alert("모든 항목을 입력해주세요.");
              e.preventDefault();
              return;
            }
          }
        });
      });

      function checkDuplicateEmail() {
        const user_email = document.getElementById('user_email').value;
        // 이메일 형식 검사
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(user_email)) {
          document.getElementById('EmailCheckResult').innerText = '올바른 이메일 형식을 입력해주세요.';
          return;
        }

        fetch('${pageContext.request.contextPath}/signup/check-email?user_email=' + encodeURIComponent(user_email))
                .then(response => response.text())
                .then(result => {
                  document.getElementById('EmailCheckResult').innerText =
                          result === 'OK' ? '사용 가능한 이메일입니다.' : '이미 사용 중인 이메일입니다.';
                });
      }
    </script>

  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>