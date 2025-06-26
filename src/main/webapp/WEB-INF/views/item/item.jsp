<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>${item.itemName} | Uniplone</title>
  <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="container">
  <div class="product-detail">
    <img src="${item.imageUrl}" alt="${item.itemName}" />
    <h2>${item.itemName}</h2>
    <p>가격: ₩${item.itemPrice}</p>
    <p>소재: ${item.itemMaterial}</p>
    <p>제조일: ${item.itemManufacturingYearMonth}</p>
    <p>카테고리: ${item.itemCateCode} / ${item.itemCateDetailCode}</p>
    <p>성별: ${item.genderCode}</p>
  </div>
</div>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
