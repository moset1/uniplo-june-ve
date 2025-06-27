<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>${item.item_name} | Uniplo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>
<div class="container">
  <div class="product-detail">
    <img src="${pageContext.request.contextPath}/resources/images/${item.image_url}" alt="${item.item_name}" />
    <h2>${item.item_name}</h2>
    <p>가격: ₩${item.item_price}</p>
    <p>소재: ${item.item_material}</p>
    <p>제조일: ${item.item_manufacturing_year_month}</p>
    <p>카테고리: ${item.item_cate_code} / ${item.item_cate_detail_code}</p>
    <p>성별: ${item.gender_code}</p>
  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
