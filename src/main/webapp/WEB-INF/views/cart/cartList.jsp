<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니 | Uniplo</title>

    <!-- 버전 파라미터로 캐시 무효화 -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/cart.css?ver=${System.currentTimeMillis()}" />
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css?ver=${System.currentTimeMillis()}" />
</head>
<body>
<c:import url="/WEB-INF/views/includes/header.jsp" />

<h2>장바구니 목록</h2>

<c:choose>
    <c:when test="${empty cartList}">
        <p>장바구니가 비어 있습니다.</p>
    </c:when>

    <c:otherwise>
        <!-- ✅ 표 가운데 배치용 래퍼 -->
        <div class="cart-wrapper">
            <table class="cart-table">
                <tr>
                    <th>상품&nbsp;이미지</th>
                    <th>색상</th>
                    <th>사이즈</th>
                    <th>수량</th>
                    <th>단가</th>
                    <th>삭제</th>
                </tr>

                <c:forEach var="item" items="${cartList}">
                    <tr>
                        <!-- 상품 ID 대신 이미지 출력 -->
                        <td>
                            <img src="${pageContext.request.contextPath}${item.imageUrl}"
                                 alt="${item.item_id}" class="cart-item-img" width="80" height="80"/>
                        </td>
                        <td>${item.item_color_code}</td>
                        <td>${item.item_size_code}</td>

                        <!-- ▽ 수량 + 세로 버튼 ▽ -->
                        <td>
                            <div class="qty-wrapper">
                                <span class="qty-value">${item.cart_item_cnt}</span>

                                <div class="qty-btn-col">
                                    <!-- ▲ -->
                                    <form action="${pageContext.request.contextPath}/cart/update"
                                          method="post" class="qty-form">
                                        <input type="hidden" name="item_id" value="${item.item_id}" />
                                        <input type="hidden" name="item_color_code" value="${item.item_color_code}" />
                                        <input type="hidden" name="item_size_code" value="${item.item_size_code}" />
                                        <input type="hidden" name="num" value="1" />
                                        <button type="submit" class="qty-arrow-btn">&#9650;</button>
                                    </form>
                                    <!-- ▼ -->
                                    <form action="${pageContext.request.contextPath}/cart/update"
                                          method="post" class="qty-form">
                                        <input type="hidden" name="item_id" value="${item.item_id}" />
                                        <input type="hidden" name="item_color_code" value="${item.item_color_code}" />
                                        <input type="hidden" name="item_size_code" value="${item.item_size_code}" />
                                        <input type="hidden" name="num" value="-1" />
                                        <button type="submit" class="qty-arrow-btn">&#9660;</button>
                                    </form>
                                </div>
                            </div>
                        </td>

                        <td>${item.cart_item_price}</td>

                        <td>
                            <form action="${pageContext.request.contextPath}/cart/delete"
                                  method="post" class="cart-delete-form">
                                <input type="hidden" name="item_id" value="${item.item_id}" />
                                <input type="hidden" name="item_color_code" value="${item.item_color_code}" />
                                <input type="hidden" name="item_size_code" value="${item.item_size_code}" />
                                <input type="submit" value="삭제" class="cart-delete-btn" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <!-- 총 가격 & 주문 버튼 -->
        <div class="cart-total">
            총&nbsp;가격:&nbsp;<span class="cart-total-value">${TotalPrice}</span>&nbsp;원
        </div>

        <div class="order-btn-wrapper">
            <form action="${pageContext.request.contextPath}/cart/order" method="post">
                <button type="submit" class="order-btn">주문하기</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>

<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
