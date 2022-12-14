<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error/noPidException.jsp"%>
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
        <% 	pvo = pdao.select(request.getParameter("pid")); %>
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
								<p><strong>상품명</strong></p>
							</div>
							<div class="col-md-9">
								<h3><%= pvo.getPname() %></h3>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>설명</strong></p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getDescription() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>분류</strong></p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getCategory() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>제조사</strong></p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getMaker() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>상품번호</strong></p>
							</div>
							<div class="col-md-9">
								<p class="badge bg-success"><%= pvo.getPid() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>상태</strong></p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getCondition() %></p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>재고</strong></p>
							</div>
							<div class="col-md-9">
								<p><%= pvo.getStock() %> 개</p>
							</div>
						</div>
						<div class="row">
			        		<div class="col-md-3">
								<p><strong>가격</strong></p>
							</div>
							<div class="col-md-9">
								<p><fmt:formatNumber value="<%= pvo.getPrice() %>"/> 원</p>
							</div>
						</div>
						<form action="../cart/cartAddProc.jsp" method="post" id="cartAddForm">
							<div class="container mt-3 p-0">
								<a href="#" class="btn btn-primary" id="cartAddBtn">장바구니 담기</a>
								<a href="../cart/cart.jsp" class="btn btn-dark">장바구니 보기</a>
								<a href="productList.jsp" class="btn btn-secondary">상품 목록</a>
								<input id="hiddenVal" type="hidden" name="pid" value="<%= pvo.getPid() %>">
							</div>
						</form>
		            </div>
	            </div>
            </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>