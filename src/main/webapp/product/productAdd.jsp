<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ page import="java.text.DecimalFormat" %>
<% 
	String title = "상품 등록";
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>productAdd.jsp</title>
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
        <% 	//pvo = pdao.select(request.getParameter("pid"));
        	DecimalFormat fmt = new DecimalFormat("###,###");%>
        <div class="container mt-5">
        	<form class="form-horizontal needs-validation" id="pAddForm" action="productAddProc.jsp" method="post" enctype="multipart/form-data" novalidate>
	        	<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>상품 코드</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPid" type="text" name="pid" value="P" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>상품명</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPname" type="text" name="pname" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>가격</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPrice" type="number" name="price" value="0" min="0" step="100" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>상세 정보</p>
					</div>
					<div class="col-md-4">
						<textarea class="form-control" name="description" required></textarea>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>제조사</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" name="maker" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>분류</p>
					</div>
					<div class="col-md-4">
						<select class="form-select" name="category" required>
							<option value="Notebook">Notebook</option>
							<option value="Tablet">Tablet</option>
							<option value="NoteSmart Phonebook">Smart Phone</option>
						</select>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>재고 수량</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputStock" type="number" value="0" min="0" name="stock" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>상태</p>
					</div>
					<div class="col-md-4">
						<input class="form-check-input" type="radio" name="condition" value="신규" id="r_new" checked>
						<label class="form-check-label" for="r_new">신규</label>
						<input class="form-check-input" type="radio" name="condition" value="중고" id="r_old">
						<label class="form-check-label" for="r_old">중고</label>
						<input class="form-check-input" type="radio" name="condition" value="재생" id="r_rep">
						<label class="form-check-label" for="r_rep">재생</label>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>이미지</p>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="file" name="pimage" id="pimage">
					</div>
					<div class="col-md-1">
						<img class="w-75" id="pimg" alt="..." src="../resources/imgs/default.png">
					</div>
				</div>
				<div class="row mb-3 justify-content-end">
					<div class="col-md-4">
						<span><button class="btn btn-success" id="regBtn" type="button">등록</button></span>
						<span><button class="btn btn-secondary backBtn">이전</button></span>
					</div>
				</div>
			</form>
          </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
<script>
	//$('#pimage').change(function() {
	//	console.log($('#pimage').val());
	//	$('#pimg').attr("src", $('#pimage').val());
	//});
</script>
</body>
</html>