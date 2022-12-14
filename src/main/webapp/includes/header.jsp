<%@page import="java.util.ArrayList"%>
<%@page import="market.vo.ProductVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<ProductVO> cList = (ArrayList<ProductVO>) session.getAttribute("cartList");
%>
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
            	<c:set var="liClass" value="nav-item mx-0 mx-lg-1"/>
            	<c:set var="aClass" value="nav-link py-3 px-0 px-lg-3 text-white rounded"/>
            	<c:choose>
            	<c:when test="${ sid == null }">
            		<li class="${ liClass }"><a class="${ aClass }" href="/market/common/login.jsp">로그인</a></li>
            		<li class="${ liClass }"><a class="${ aClass }" href="/market/common/join.jsp">회원 가입</a></li>
            	</c:when>
            	<c:otherwise>
            		<li class="${ liClass }"><a class="${ aClass }" href="/market/common/logoutProc.jsp">[${ sid }] 로그아웃</a></li>
            	</c:otherwise>
            	</c:choose>
        		<%-- <%
        			if (session.getAttribute("sid") == null) {
        				out.print("<li class=\"nav-item mx-0 mx-lg-1\"><a class=\"nav-link py-3 px-0 px-lg-3 text-white rounded\" href=\"/market/common/login.jsp\">로그인</a></li>");
        				out.print("<li class=\"nav-item mx-0 mx-lg-1\"><a class=\"nav-link py-3 px-0 px-lg-3 text-white rounded\" href=\"/market/common/join.jsp\">회원 가입</a></li>");
        			} else {
        				out.print("<li class=\"nav-item mx-0 mx-lg-1\"><a id=\"logoutBtn\" class=\"nav-link py-3 px-0 px-lg-3 text-white rounded\" href=\"/market/common/logoutProc.jsp\">로그 아웃</a></li>");
        			}
        		%> --%>
                    <li class="${ liClass }"><a class="${ aClass }" href="/market/product/productList.jsp">상품 목록</a></li>
                    <li class="${ liClass }"><a class="${ aClass }" href="/market/product/productAdd.jsp?lang=ko">상품 등록</a></li>
               	<% if (cList != null && cList.size() > 0) { %>
                    	<li class="${ liClass }"><a class="${ aClass }" href="/market/cart/cart.jsp">장바구니<span class="badge bg-danger"> <%= cList.size() %> </span></a></li>
            	<%	} else { %>
            			<li class="${ liClass }"><a class="${ aClass }" href="/market/cart/cart.jsp">장바구니</a></li>
            	<%	} %>
            	
            </ul>
        </div>
    </div>
</nav>