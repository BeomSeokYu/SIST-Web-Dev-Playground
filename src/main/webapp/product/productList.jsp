<%@ page import="java.util.List, java.text.DecimalFormat"%>
<%@ page import="market.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = "상품 목록"; %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5"><%= title %></h1>
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section" id="list">
        <div class="container">
            <div class="container d-flex flex-column">
            	<div class="row mt-5">

<jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
<%
	List<ProductVO> list = pdao.selectAllProduct();
	if (list == null || list.isEmpty()) {
		// 목록이 없을 경우
		out.print("<div>등록된 상품이 없습니다.</div>");
	} else {

		// 목록 출력
		for (ProductVO pvo : list) { %>
				<div class="col-md-4 text-center">
					<!-- 이미지 -->
					<img class="img-fluid h-50" alt="" src="../resources/imgs/<%= pvo.getPimage() %>">
					<h3><%= pvo.getPname() %></h3>
					<p><%= pvo.getDescription() %></p>
					<p><fmt:formatNumber value="<%= pvo.getPrice() %>"/> 원</p>
					<p><a href="productInfo.jsp?pid=<%= pvo.getPid() %>" class="btn btn-secondary">상세 보기</a></p>
				</div>
		<% }
	}
%>
				</div>
            </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>