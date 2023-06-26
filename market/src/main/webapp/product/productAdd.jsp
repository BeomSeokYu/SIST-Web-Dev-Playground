<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
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
<fmt:setLocale value="${ param.lang }"/>
<fmt:bundle basename="market.bundle.message">
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5"><fmt:message key="title"/></h1>
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
    <jsp:useBean id="pvo" class="market.vo.ProductVO"/>
    <!-- Section -->
    <section class="page-section" id="info">
        <div class="container mt-5">
        	<div class="form-group row mb-3 justify-content-end">
        		<div class="col-md-3">
        			<a href="?lang=en">English</a> / 
        			<a href="?lang=ko">한국어</a>
        		</div>
        	</div>
        	<form class="form-horizontal needs-validation" id="pAddForm" action="productAddProc.jsp" method="post" enctype="multipart/form-data" novalidate>
	        	<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="pid"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPid" type="text" name="pid" value="P" required>
						<div id="pid-msg"></div>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="pname"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPname" type="text" name="pname" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="price"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPrice" type="number" name="price" value="0" min="0" step="100" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="description"/></p>
					</div>
					<div class="col-md-4">
						<textarea class="form-control" name="description" required></textarea>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="maker"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" id="inputMaker" name="maker" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="category"/></p>
					</div>
					<div class="col-md-4">
						<select class="form-select" name="category" required>
							<option value="Notebook"><fmt:message key="category_notebook"/></option>
							<option value="Tablet"><fmt:message key="category_tablet"/></option>
							<option value="Smart Phone"><fmt:message key="category_smartPhone"/></option>
						</select>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="stock"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputStock" type="number" value="0" min="0" name="stock" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="condition"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-check-input" type="radio" name="condition" value="신규" id="r_new" checked>
						<label class="form-check-label" for="r_new"><fmt:message key="condition_new"/></label>
						<input class="form-check-input" type="radio" name="condition" value="중고" id="r_old">
						<label class="form-check-label" for="r_old"><fmt:message key="condition_old"/></label>
						<input class="form-check-input" type="radio" name="condition" value="재생" id="r_rep">
						<label class="form-check-label" for="r_rep"><fmt:message key="condition_refurbish"/></label>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="image"/></p>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="file" name="pimage" id="pimage">
					</div>
					<div class="col-md-1">
						<img class="w-75" id="pimg" alt="..." src="../resources/imgs/default.png">
					</div>
				</div>
				<div class="row justify-content-center text-truncate">
                    <div class="col-md-4 px-1 text-end">
                        <p class="text-danger" id="pErrMsg"></p>
                    </div>
                </div>
				<div class="row mb-3 justify-content-end">
					<div class="col-md-4">
						<span><button class="btn btn-success" id="regBtn" type="button"><fmt:message key="addBtn"/></button></span>
						<span><button class="btn btn-secondary backBtn"><fmt:message key="backBtn"/></button></span>
					</div>
				</div>
			</form>
          </div>
    </section>
    </fmt:bundle>
<%@ include file="../includes/footer.jsp" %>
<script>
	$('#regBtn').on('click', function () {
		checkProduct();
	});
	//$('#pimage').change(function() {
	//	console.log($('#pimage').val());
	//	$('#pimg').attr("src", $('#pimage').val());
	//});
</script>
</body>
</html>