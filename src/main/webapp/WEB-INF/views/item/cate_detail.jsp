<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>제품 유형 상세 | Uniplo</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
  <style>
    .cate-detail-container {
      max-width: 900px;
      margin: 3rem auto;
      text-align: center;
    }

    .cate-detail-container img {
      width: 360px;
      border: 1px solid #ccc;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
      margin-bottom: 1rem;
    }

    .cate-detail-container h2 {
      font-size: 1.8rem;
      margin-bottom: 0.5rem;
    }

    .cate-detail-container p {
      font-size: 1rem;
      color: #444;
    }

    .cate-detail-container .btn {
      margin-top: 2rem;
      display: inline-block;
      padding: 0.6rem 1.2rem;
      background-color: #111;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
    }

    .cate-detail-container .btn:hover {
      background-color: #444;
    }
  </style>
</head>
<body>

<div class="cate-detail-container">
  <h2>${category.toUpperCase()} - ${type.toUpperCase()}</h2>

  <img src="${pageContext.request.contextPath}/resources/images/item_cate_${category.substring(0,1)}_${type}.jpg"
       alt="${type} 이미지" />

  <p>여기는 "${category}" 카테고리의 "${type}" 유형에 대한 설명이 들어갑니다.</p>

  <a href="${pageContext.request.contextPath}/item/list?category=${category}&type=${type}" class="btn">상품 보러가기</a>
</div>

</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>
