<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>deliveryInfo.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">배송 정보</h1>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section mt-5">
        <div class="container">
        	<div class="row mb-3">
        		<div class="col-md-2">
					<p>수령인</p>
				</div>
				<div class="col-md-4">
					<input class="form-control" type="text" value="Kim">
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p>배송희망일</p>
				</div>
				<div class="col-md-4">
					<input class="form-control" type="date" value="2022-12-30">
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p>우편번호</p>
				</div>
				<div class="col-md-4">
					<input class="form-control" type="text" value="04001" readonly>
				</div>
				<div class="col-md-2">
					<button class="btn btn-light" type="button">검색</button>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p>도로명 주소</p>
				</div>
				<div class="col-md-4">
					<input class="form-control" type="text" value="서울시 마포구 월드컵북로 21">
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p>상세 주소</p>
				</div>
				<div class="col-md-3">
					<input class="form-control" type="text" value="풍성빌딩 3층">
				</div>
				<div class="col-md-3">
					<input class="form-control" type="text" value="(서교동)">
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p>연락처</p>
				</div>
				<div class="col-md-2">
					<select class="form-select">
						<option value="010" selected>010</option>
						<option value="02">02</option>
						<option value="032">032</option>
						<option value="031">031</option>
					</select>
				</div>
				<div class="col-md-2">
					<input class="form-control" type="text">
				</div>
				<div class="col-md-2">
					<input class="form-control" type="text">
				</div>
			</div>
			<div class="container my-3 p-0">
				<a href="orderInfo.jsp" class="btn btn-success float-end">등록</a>
				<a href="productList.jsp" class="btn btn-secondary float-end mx-1">이전으로</a>
			</div>
		</div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>