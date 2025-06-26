<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>KIDS 카테고리 | Uniplo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <h2>KIDS 카테고리</h2>
    <div class="product-grid">

        <a href="${pageContext.request.contextPath}/item/kids/tshirt">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_tshirt.jpg" alt="티셔츠" />
                <div class="product-name">티셔츠</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/kids/pants">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_pants.jpg" alt="팬츠" />
                <div class="product-name">팬츠</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/kids/dress">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_skirt.jpg" alt="원피스 & 스커트" />
                <div class="product-name">원피스 & 스커트</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/kids/innerwear">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_inner.jpg" alt="이너웨어" />
                <div class="product-name">이너웨어</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/kids/outer">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_outer.jpg" alt="아우터" />
                <div class="product-name">아우터</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/kids/knitshirt">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_knit.jpg" alt="니트 & 셔츠" />
                <div class="product-name">니트 & 셔츠</div>
            </div>
        </a>

        <a href="${pageContext.request.contextPath}/item/kids/suit">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}/resources/images/item_cate_k_suit.jpg" alt="정장" />
                <div class="product-name">정장</div>
            </div>
        </a>

    </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
