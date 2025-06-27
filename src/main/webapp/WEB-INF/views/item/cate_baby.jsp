%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>BABY 카테고리 | Uniplo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>BABY 카테고리</h2>
    <div class="product-grid">

        <a href="${pageContext.request.contextPath}/item/baby/newborn">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_b_newborn.jpg" alt="신생아" />
                <div class="product-name">신생아</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/baby/infant">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_b_children.jpg" alt="영유아" />
                <div class="product-name">영유아</div>
            </div>
        </a>

    </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
