<%--
  Created by IntelliJ IDEA.
  User: kse93
  Date: 2025-06-20
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입 완료 | Uniplo</title>
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
  <div class="card" style="text-align: center">
    <h2>회원가입이 완료되었습니다!</h2>
    <p>Uniplo의 회원이 되신 것을 환영합니다 🎉</p>
    <a href="${pageContext.request.contextPath}/user/login"><button>로그인 하러 가기</button></a>
  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>