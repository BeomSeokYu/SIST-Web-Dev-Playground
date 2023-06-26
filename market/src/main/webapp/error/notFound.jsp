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
            <h1 class="masthead-heading m-5">요청하신 페이지가 없습니다.</h1>
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <!-- Info Section -->
    <section class="page-section" id="info">
        <div class="container mt-5">
	        <div class="row jusify-content-center text-center">
	        	<h1>404</h1>
				<h1>PAGE NOT FOUND</h1>
				<p><a class="btn btn-primary mt-5" href="../index.jsp">메인으로</a></p>
	        </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>