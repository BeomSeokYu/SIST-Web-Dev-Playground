<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">해당 상품이 존재하지 않습니다.</h1>
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <!-- Info Section -->
    <section class="page-section" id="info">
        <div class="container">
            <div class="container d-flex flex-column mt-3">
                <!-- Masthead Heading-->
                <%= request.getRequestURL() %>?<%= request.getQueryString() %>
            </div>
            <div class="container d-flex flex-column mt-3">
            	<div class="row">
                	<a class="col-md-1 btn btn-primary" href="../product/productList.jsp">목록으로</a>
            	</div>
            </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>