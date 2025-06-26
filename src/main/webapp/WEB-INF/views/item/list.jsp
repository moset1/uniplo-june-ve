<%-- 제품 목록 페이지 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>상품 목록 | Uniplone</title>
  <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="container">
  <h2>상품 목록</h2>
  <div class="product-grid">
    <c:forEach var="item" items="${items}">
      <a href="${pageContext.request.contextPath}/item/${item.id}">
        <div class="product-card">
          <img src="${item.imageUrl}" alt="${item.itemName}" />
          <div class="product-name">${item.itemName}</div>
          <div class="product-price">₩${item.itemPrice}</div>
        </div>
      </a>
    </c:forEach>
  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
