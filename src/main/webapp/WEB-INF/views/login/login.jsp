<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 | Uniplo</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<div class="auth-container">
    <!-- 왼쪽: 로그인 폼 -->
    <div class="login-section">
        <h2>로그인</h2>
        <form action="${pageContext.request.contextPath}/login/login" method="post">
            <input type="email" name="user_email" placeholder="이메일(example@uniplo.com)" required />
            <input type="password" name="user_password" placeholder="비밀번호" required />
            <button type="submit">로그인</button>
        </form>
    </div>

    <!-- 오른쪽: 회원가입 안내 -->
    <div class="signup-section">
        <h2>회원가입</h2>
        <p>온라인 스토어를 이용하려면 회원가입이 필요합니다.</p>
        <button onclick="location.href='${pageContext.request.contextPath}/signup/signup'">회원가입</button>
    </div>
</div>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
