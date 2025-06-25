<%--
  Created by IntelliJ IDEA.
  User: kse93
  Date: 2025-06-24
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- error.jsp -->
<c:import url="/WEB-INF/views/includes/header.jsp" />
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>에러 발생 | Uniplo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>
<div class="container">
    <div class="card" style="text-align: center;">
        <h2>⚠️ 에러가 발생했습니다</h2>
        <p>요청 처리 중 문제가 발생했습니다.<br>잠시 후 다시 시도해 주세요.</p>
        <p style="color: rgb(128,128,128)">${message}</p>
        <a href="${pageContext.request.contextPath }/"><button>홈으로 이동</button></a>
    </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>