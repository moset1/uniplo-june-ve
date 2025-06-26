<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>카테고리</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />

<h2>${gender_id} 카테고리</h2>

<ul>
    <c:forEach var="cate" items="${itemCates}">
        <li>
            <a href="${pageContext.request.contextPath}/item/${gender_id}/${cate.item_cate_id}">
                    ${cate.item_cate_name}
            </a>
        </li>
    </c:forEach>
</ul>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
