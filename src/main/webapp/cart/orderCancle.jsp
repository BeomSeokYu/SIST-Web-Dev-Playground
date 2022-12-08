<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>orderCancle.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">주문 완료</h1>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section mt-5">
        <div class="container">
            <div class="container align-items-center text-center">
                <div class="row">
	                <div class="alert alert-danger">
					  주문이 취소 되었습니다.
					</div>
                </div>
            </div>
            <div class="container p-0 mt-3">
             <p><a href="../product/productList.jsp" class="btn btn-secondary">상품 목록</a><p>
            </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>