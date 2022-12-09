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
        	<form action="deliveryInfoProc.jsp" id="deliveryForm" method="post">
	        	<div class="row mb-3">
	        		<div class="col-md-2">
						<p>수령인</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" name="rname" value="" required>
					</div>
				</div>
				<div class="row mb-3">
	        		<div class="col-md-2">
						<p>배송희망일</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="date" name="deliDate" value="">
					</div>
				</div>
				<div class="row mb-3">
	        		<div class="col-md-2">
						<p>우편번호</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" name="zipNo" id="zipNo" value="" readonly required>
					</div>
					<div class="col-md-2">
						<button class="btn btn-light border" type="button" id="searchBtn">검색</button>
					</div>
				</div>
				<div class="row mb-3">
	        		<div class="col-md-2">
						<p>도로명 주소</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" name="addr1" id="addr1" value="" required>
					</div>
				</div>
				<div class="row mb-3">
	        		<div class="col-md-2">
						<p>상세 주소</p>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="addr2" id="addr2" value="" required>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="addr3" id="addr3" value="" required>
					</div>
				</div>
				<div class="row mb-3">
	        		<div class="col-md-2">
						<p>연락처</p>
					</div>
					<div class="col-md-2">
						<select class="form-select" name="phone1" id="phone1">
							<option value="010" selected>010</option>
							<option value="02">02</option>
							<option value="032">032</option>
							<option value="031">031</option>
						</select>
					</div>
					<div class="col-md-2">
						<input class="form-control" name="phone2" id="phone2" type="text" required>
					</div>
					<div class="col-md-2">
						<input class="form-control" name="phone3" id="phone3" type="text" required>
					</div>
					<input type="hidden" name="addr" id="addr" value="">
					<input type="hidden" name="phone" id="phone" value="">
				</div>
				<div class="container my-3 p-0">
					<button class="btn btn-success float-end" id="orderBtn" type="button">주문</button>
					<a href="productList.jsp" class="btn btn-secondary float-end mx-1">이전으로</a>
				</div>
			</form>
		</div>
    </section>
<%@ include file="../includes/footer.jsp" %>
<!-- <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$('#searchBtn').click(function() {
		new daum.Postcode({
		    oncomplete: function(data) {
		        $('#zipNo').val(data.zonecode);
		        $('#addr1').val(data.address);
		        $('#addr2').focus();
		    }
		}).open();
	});
</script> -->
<script>
	$('#phone1').change(function () {
		$('#phone2').focus();
	});
	$('#phone2').keyup(function () {
		if($('#phone2').val().length > 3) {
			$('#phone3').focus();
		}
	});
	$('#phone3').keyup(function () {
		if($('#phone3').val().length > 3) {
			$('#phone3').blur();
		}
	});
	$('#orderBtn').click(function() {
		$('#phone').val($('#phone1').val() +'-'+ $('#phone2').val() +'-'+ $('#phone3').val());
		$('#deliveryForm').submit();
	});
</script>
</body>
</html>