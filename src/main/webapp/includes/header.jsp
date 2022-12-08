<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand text-white" href="/market">Home</a>
        <button class="navbar-toggler text-uppercase font-weight-bold bg-secondary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <em class="fas fa-bars"></em>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
        		<%
        			if (session.getAttribute("sid") == null) {
        				out.print("<li class=\"nav-item mx-0 mx-lg-1\"><a class=\"nav-link py-3 px-0 px-lg-3 text-white rounded\" href=\"/market/common/login.jsp\">로그인</a></li>");
        				out.print("<li class=\"nav-item mx-0 mx-lg-1\"><a class=\"nav-link py-3 px-0 px-lg-3 text-white rounded\" href=\"/market/common/join.jsp\">회원 가입</a></li>");
        			} else {
        				out.print("<li class=\"nav-item mx-0 mx-lg-1\"><a id=\"logoutBtn\" class=\"nav-link py-3 px-0 px-lg-3 text-white rounded\" href=\"/market/common/logoutProc.jsp\">로그 아웃</a></li>");
        			}
        		%>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 text-white rounded" href="/market/product/productList.jsp">상품 목록</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 text-white rounded" href="/market/product/productAdd.jsp">상품 등록</a></li>
            </ul>
        </div>
    </div>
</nav>