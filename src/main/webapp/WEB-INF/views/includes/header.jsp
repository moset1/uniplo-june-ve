<!-- header.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="isLoggedIn" value="${not empty sessionScope.authUser}" />
<c:set var="loginOutLink" value="${isLoggedIn ? contextPath.concat('/login/logout') : contextPath.concat('/login/login')}" />
<c:set var="loginOutLabel" value="${isLoggedIn ? 'LOGOUT' : 'LOGIN'}" />

<div class="header">
    <div class="logo">
        <a class="logo" href="${contextPath}/">Uniplo</a>
    </div>
    <nav>
        <a href="${contextPath}/">HOME</a>
        <div class="dropdown">
            <a href="#">SHOP</a>
            <div class="dropdown-content">
                <a href="${contextPath}/item?gender=man">MEN</a>
                <a href="${contextPath}/item?gender=women">WOMEN</a>
                <a href="${contextPath}/item?gender=kids">KIDS</a>
                <a href="${contextPath}/item?gender=baby">BABY</a>
            </div>
        </div>
        <div class="dropdown">
            <a href="${contextPath}/post/list">BOARD</a>
            <div class="dropdown-content">
                <a href="${contextPath}/post/list?type=notice">NOTICE</a>
                <a href="${contextPath}/post/list?type=faq">FAQ</a>
                <a href="${contextPath}/post/list?type=qna">Q&A</a>
            </div>
        </div>
        <a href="<c:choose>
                <c:when test='${isLoggedIn}'>${contextPath}/cart</c:when>
                <c:otherwise>${contextPath}/login/login</c:otherwise>
             </c:choose>">CART</a>
        <a href="${loginOutLink}">${loginOutLabel}</a>
    </nav>
</div>
