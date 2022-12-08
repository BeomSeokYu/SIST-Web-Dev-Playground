<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error/noPidException.jsp"%>
<%@ page import="java.text.DecimalFormat" %>
<% String title = "상품 정보"; %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>productInfo.jsp</title>
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
    <section class="page-section" id="info">
        <jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
        <jsp:useBean id="pvo" class="market.vo.ProductVO"/>
        <% 	pvo = pdao.select(request.getParameter("pid")); 
        	DecimalFormat fmt = new DecimalFormat("###,###");%>
        <div class="container mt-5">
        	<div class="row">
        		<div class="col-md-6">
			        <div class="container d-flex flex-column">
			            <div class="row">
			                <div class="col-md-12">
								<img class="w-100" alt="" src="../resources/imgs/<%= pvo.getPimage() %>">
							</div>
						</div>
			        </div>
		        </div>
		        <div class="col-md-6">
			        <div class="container">
			        	<div class="row">
			        		<div class="col-md-3">
								<p>상품명</p>
							</div>
							<div class="col-md-9">
								<h3><%= pvo.getPname() %></h3>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>설명</p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getDescription() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>분류</p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getCategory() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>제조사</p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getMaker() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>상품번호</p>
							</div>
							<div class="col-md-9">
								<p class="badge bg-success"><%= pvo.getPid() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>상태</p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getCondition() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>재고</p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getStock() %> 개</p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p>가격</p>
							</div>
							<div class="col-md-9">
								<p><%= fmt.format(pvo.getPrice()) %> 원</p>
							</div>
						</div>
						<div class="container mt-3 p-0">
							<a href="#" class="btn btn-primary" id="inCartBtn">장바구니 담기</a>
							<a href="../cart/cart.jsp" class="btn btn-dark">장바구니 보기</a>
							<a href="productList.jsp" class="btn btn-secondary">상품 목록</a>
						</div>
		            </div>
	            </div>
            </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>