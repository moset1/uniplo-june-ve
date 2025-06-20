<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loginOutLink" value="${empty sessionScope.user ? contextPath.concat('/user/login') : contextPath.concat('/user/logout')}" />
<c:set var="loginOut" value="${empty sessionScope.user ? '로그인' : '로그아웃'}" />

<!DOCTYPE html>
<div class="header">
    <div class="logo">Uniplo</div>
    <nav>
        <a href="${contextPath}/">홈</a>
        <a href="${loginOutLink}">${loginOut}</a>
        <a href="${contextPath}/user/signup">회원가입</a>
    </nav>
</div>
