<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>MEN 카테고리 | Uniplone</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
  <h2>MEN 카테고리</h2>
  <div class="product-grid">
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_tshirt.jpg" alt="티셔츠">
      <div class="product-name">티셔츠</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_shirt.jpg" alt="셔츠 & 폴로셔츠">
      <div class="product-name">셔츠 & 폴로셔츠</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_knit.jpg" alt="니트 & 가디건">
      <div class="product-name">니트 & 가디건</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_pants.jpg" alt="팬츠">
      <div class="product-name">팬츠</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_outer.jpg" alt="아우터">
      <div class="product-name">아우터</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_inner.jpg" alt="이너웨어">
      <div class="product-name">이너웨어</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_home.jpg" alt="홈웨어">
      <div class="product-name">홈웨어</div>
    </div>
    <div class="product-card">
      <img src="${pageContext.request.contextPath}/resources/images/item_cate_m_acc.jpg" alt="액세서리">
      <div class="product-name">액세서리</div>
    </div>
  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
