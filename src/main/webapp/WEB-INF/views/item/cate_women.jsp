<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>WOMEN 카테고리 | Uniplo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
  <h2>WOMEN 카테고리</h2>
  <div class="product-grid">

    <a href="${pageContext.request.contextPath}/item/women/tshirt">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_tshirt.jpg" alt="티셔츠" />
        <div class="product-name">티셔츠</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/blouse">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_shirt.jpg" alt="셔츠 & 블라우스" />
        <div class="product-name">셔츠 & 블라우스</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/cardigan">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_knit.jpg" alt="니트 & 가디건" />
        <div class="product-name">니트 & 가디건</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/pants">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_pants.jpg" alt="팬츠" />
        <div class="product-name">팬츠</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/dress">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_skirt.jpg" alt="원피스 & 스커트" />
        <div class="product-name">원피스 & 스커트</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/outer">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_outer.jpg" alt="아우터" />
        <div class="product-name">아우터</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/innerwear">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_inner.jpg" alt="이너웨어" />
        <div class="product-name">이너웨어</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/homewear">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_home.jpg" alt="홈웨어" />
        <div class="product-name">홈웨어</div>
      </div>
    </a>

    <a href="${pageContext.request.contextPath}/item/women/accessory">
      <div class="product-card">
        <img src="${pageContext.request.contextPath}/resources/images/item_cate_w_acc.jpg" alt="액세서리" />
        <div class="product-name">액세서리</div>
      </div>
    </a>

  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
