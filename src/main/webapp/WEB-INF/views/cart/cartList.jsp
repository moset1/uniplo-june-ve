<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니 | Uniplo</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cart.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <script src="${pageContext.request.contextPath}/resources/js/common.js" defer></script>
</head>
<body>
<c:import url="/WEB-INF/views/includes/header.jsp" />
<h2>장바구니 목록</h2>
<c:if test="${empty cartList}">
    <p>장바구니가 비어 있습니다.</p>
</c:if>
<c:if test="${not empty cartList}">
    <table border="1">
        <tr>
            <th>상품 ID</th>
            <th>색상</th>
            <th>사이즈</th>
            <th>상품 가격</th>
            <th>수량</th>
            <th>삭제</th>
        </tr>
        <c:forEach var="item" items="${cartList}">
            <tr>
                <td>${item.item_id}</td>
                <td>${item.item_color_code}</td>
                <td>${item.item_size_code}</td>
                <td>${item.cart_item_price}</td>
                <td>
                    <table style="border-collapse: collapse;">
                        <tr>
                            <!-- [-] 버튼 -->
                            <td>
                                <form action="${pageContext.request.contextPath}/cart/update" method="post">
                                    <input type="hidden" name="item_id" value="${item.item_id}" />
                                    <input type="hidden" name="item_color_code" value="${item.item_color_code}" />
                                    <input type="hidden" name="item_size_code" value="${item.item_size_code}" />
                                    <input type="hidden" name="num" value="-1" />
                                    <button type="submit" style="width: 30px;">-</button>
                                </form>
                            </td>

                            <!-- 수량 -->
                            <td style="padding: 0 8px; text-align: center; min-width: 30px;">
                                    ${item.cart_item_cnt}
                            </td>

                            <!-- [+] 버튼 -->
                            <td>
                                <form action="${pageContext.request.contextPath}/cart/update" method="post">
                                    <input type="hidden" name="item_id" value="${item.item_id}" />
                                    <input type="hidden" name="item_color_code" value="${item.item_color_code}" />
                                    <input type="hidden" name="item_size_code" value="${item.item_size_code}" />
                                    <input type="hidden" name="num" value="1" />
                                    <button type="submit" style="width: 30px;">+</button>
                                </form>
                            </td>
                        </tr>
                    </table>
                </td>

                <td>
                    <form action="${pageContext.request.contextPath}/cart/delete" method="post">
                        <input type="hidden" name="item_id" value="${item.item_id}" />
                        <input type="hidden" name="item_color_code" value="${item.item_color_code}" />
                        <input type="hidden" name="item_size_code" value="${item.item_size_code}" />
                        <input type="submit" value="삭제" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div style="margin-top: 16px; text-align: right; font-weight: bold;">
        총 가격: <span style="color: red;">${TotalPrice}</span> 원
    </div>
    <div class="order-button">
        <form action="${pageContext.request.contextPath}/cart/order" method="post">
            <button type="submit" class="order-button">주문하기</button>
        </form>
    </div>
</c:if>
</body>
<c:import url="/WEB-INF/views/includes/footer.jsp" />
</html>