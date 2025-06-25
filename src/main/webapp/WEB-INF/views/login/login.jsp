<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/common/header.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 | Uniplo</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <h2>로그인</h2>
    <div class="card">
        <form action="${pageContext.request.contextPath}/login/login" method="post">
            <input type="text" name="user_email" placeholder="이메일(example@uniqlo.com)" required />
            <input type="password" name="user_password" placeholder="비밀번호" required />
            <button type="submit">로그인</button>
        </form>
    </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>