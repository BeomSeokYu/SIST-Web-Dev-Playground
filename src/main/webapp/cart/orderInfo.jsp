<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>orderInfo.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">주문 정보</h1>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section mt-5 mx-5">
        <div class="container border border-2 rounded-3 p-5">
        	<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>수령인</strong></p>
				</div>
				<div class="col-md-6">
					<p>kim</p>
				</div>
				<div class="col-md-2">
					<p><strong>배송희망일</strong></p>
				</div>
				<div class="col-md-2">
					<p>2022-12-30</p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>연락처</strong></p>
				</div>
				<div class="col-md-4">
					<p>010-1010-1010</p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>우편번호</strong></p>
				</div>
				<div class="col-md-4">
					<p>04001</p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>도로명 주소</strong></p>
				</div>
				<div class="col-md-4">
					<p>서울특별시 마포구 월드컵북로 21</p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>상세 주소</strong></p>
				</div>
				<div class="col-md-4">
					<p>풍성빌딩 3층 (서교동)</p>
				</div>
			</div>
			<div class="row mb-3 jus">
				<table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th scope="col">상품</th>
	                        <th scope="col">수량</th>
	                        <th scope="col">가격</th>
	                        <th scope="col">소계</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td>P1234 - asdf</td>
	                        <td>1</td>
	                        <td>150000</td>
	                        <td>150000</td>
	                    </tr>
	                    <tr>
	                        <td>P1234 - qwer</td>
	                        <td>1</td>
	                        <td>20000</td>
	                        <td>20000</td>
	                    </tr>
	                </tbody>
	                <tfoot>
	                	<tr>
	                        <td colspan="2"></td>
	                        <td>총액</td>
	                        <td>1520000</td>
	                    </tr>
	                </tfoot>
	            </table>
	            <div class="container my-3 p-0">
	            	<a href="orderCancle.jsp" class="btn btn-danger mx-1 float-end">취소</a>
					<a href="orderDone.jsp" class="btn btn-success mx-1 float-end">주문완료</a>
					<a href="#" class="btn btn-secondary float-end mx-1 backBtn">이전으로</a>
			</div>
			</div>
		</div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>