<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 성공 | Uniplo</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cart.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>
<c:import url="/WEB-INF/views/includes/header.jsp" />
<h2>주문 완료</h2>
<p>주문이 접수됐습니다.</p>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>