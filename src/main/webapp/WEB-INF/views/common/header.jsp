<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="isLoggedIn" value="${not empty sessionScope.authUser}" />
<c:set var="loginOutLink" value="${isLoggedIn ? contextPath.concat('/login/logout') : contextPath.concat('/login/login')}" />
<c:set var="loginOutLabel" value="${isLoggedIn ? 'LOGOUT' : 'LOGIN'}" />

<style>
  .header {
    background-color: #fff;
    border-bottom: 1px solid #ddd;
    padding: 1rem 2rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-family: 'Noto Sans KR', sans-serif;
  }
  .logo a {
    font-size: 1.5rem;
    font-weight: bold;
    color: #b00020;
    text-decoration: none;
  }
  nav {
    display: flex;
    gap: 1.5rem;
    align-items: center;
    position: relative;
  }
  nav a {
    color: #111;
    text-decoration: none;
    padding: 0.5rem;
    position: relative;
  }
  .dropdown {
    position: relative;
  }
  .dropdown-content {
    display: none;
    position: absolute;
    top: 2.5rem;
    background-color: #fff;
    border: 1px solid #ddd;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    min-width: 160px;
    z-index: 1;
  }
  .dropdown-content a {
    display: block;
    padding: 0.5rem 1rem;
    white-space: nowrap;
  }
  .dropdown.open .dropdown-content {
    display: block;
  }
</style>

<script>
  document.addEventListener("DOMContentLoaded", function () {
    const dropdowns = document.querySelectorAll(".dropdown");

    dropdowns.forEach((dropdown) => {
      let timeout;

      dropdown.addEventListener("mouseenter", () => {
        clearTimeout(timeout);
        dropdown.classList.add("open");
      });

      dropdown.addEventListener("mouseleave", () => {
        timeout = setTimeout(() => {
          dropdown.classList.remove("open");
        }, 200); // 200ms 여유 시간 줘서 사용자 경험 향상
      });
    });
  });
</script>

<div class="header">
  <div class="logo">
    <a href="${contextPath}/">Uniplo</a>
  </div>
  <nav>
    <a href="${contextPath}/">HOME</a>

    <div class="dropdown">
      <a href="#">SHOP</a>
      <div class="dropdown-content">
        <a href="${contextPath}/shop/men">MEN</a>
        <a href="${contextPath}/shop/women">WOMEN</a>
        <a href="${contextPath}/shop/kids">KIDS</a>
        <a href="${contextPath}/shop/baby">BABY</a>
      </div>
    </div>

    <div class="dropdown">
      <a href="#">BOARD</a>
      <div class="dropdown-content">
        <a href="${contextPath}/post/list?type=notice">NOTICE</a>
        <a href="${contextPath}/post/list?type=faq">FAQ</a>
        <a href="${contextPath}/post/list?type=qna">Q&A</a>
      </div>
    </div>

    <a href="<c:choose>
                    <c:when test='${isLoggedIn}'>
                        ${contextPath}/cart
                    </c:when>
                    <c:otherwise>
                        ${contextPath}/login/login
                    </c:otherwise>
                 </c:choose>">CART</a>

    <a href="${loginOutLink}">${loginOutLabel}</a>
  </nav>
</div>
