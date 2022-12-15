<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<% 
	String title = "상품 수정";
%>
<sql:setDataSource	var="dataSource"
						driver="oracle.jdbc.OracleDriver"
						url="jdbc:oracle:thin:@localhost:1521:xe"
						user="madang"
						password="1111" />
<sql:query var="rs" dataSource="${ dataSource }">
	SELECT * FROM product WHERE pid=?
	<sql:param value="${ param.pid }"></sql:param>
</sql:query>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>productModify.jsp</title>
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
    <!-- Section -->
    <section class="page-section" id="info">
        <div class="container mt-5">
        	<!-- <div class="form-group row mb-3 justify-content-end">
        		<div class="col-md-3">
        			<a href="?lang=en">English</a> / 
        			<a href="?lang=ko">한국어</a>
        		</div>
        	</div> -->
        	<c:forEach items="${ rs.rows }" var="pvo">
        	<form class="form-horizontal needs-validation" id="pModForm" action="productModifyProc.jsp" method="post" enctype="multipart/form-data" novalidate>
	        	<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="pid"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPid" type="text" name="pid" value="${ pvo.pid }" required>
						<input type="hidden" name="pid_old" value="${ pvo.pid }" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="pname"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPname" type="text" name="pname" value="${ pvo.pname }" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="price"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputPrice" type="number" name="price" value="${ pvo.price }" min="0" step="100" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="description"/></p>
					</div>
					<div class="col-md-4">
						<textarea class="form-control" name="description" required>${ pvo.description }</textarea>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="maker"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" name="maker" value="${ pvo.maker }" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="category"/></p>
					</div>
					<div class="col-md-4">
						<select id="category_select" class="form-select" name="category" required>
							<option value="Notebook" ${ pvo.category == 'Notebook' ? 'selected' : '' }><fmt:message key="category_notebook"/></option>
							<option value="Tablet" ${ pvo.category == 'Tablet' ? 'selected' : '' }><fmt:message key="category_tablet"/></option>
							<option value="Smart Phone" ${ pvo.category == 'Smart Phone' ? 'selected' : '' }><fmt:message key="category_smartPhone"/></option>
						</select>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="stock"/></p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="inputStock" type="number" value="${ pvo.stock }" min="0" name="stock" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="condition"/></p>
					</div>
					<div id="condition_radio" class="col-md-4">
						<input class="form-check-input" type="radio" name="condition" value="신규" id="r_new" ${ pvo.condition == '신규' ? 'checked' : '' }>
						<label class="form-check-label" for="r_new"><fmt:message key="condition_new"/></label>
						<input class="form-check-input" type="radio" name="condition" value="중고" id="r_old" ${ pvo.condition == '중고' ? 'checked' : '' }>
						<label class="form-check-label" for="r_old"><fmt:message key="condition_old"/></label>
						<input class="form-check-input" type="radio" name="condition" value="재생" id="r_rep" ${ pvo.condition == '재생' ? 'checked' : '' }>
						<label class="form-check-label" for="r_rep"><fmt:message key="condition_refurbish"/></label>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p><fmt:message key="image"/></p>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="file" name="pimage" id="pimage" onchange="chgImg('<%= application.getRealPath(application.getInitParameter("uploadPath")) %>')" >
						<input type="hidden" name="pimage2" value="${ pvo.pimage }">
					</div>
					<div class="col-md-1">
						<img class="w-100 border" id="pimg" alt="..." src="../resources/imgs/${ pvo.pimage }">
					</div>
				</div>
				<div class="row mb-3 justify-content-end">
					<div class="col-md-4">
						<span><button class="btn btn-success" id="modBtn" type="button">수정</button></span>
						<span><button class="btn btn-secondary backBtn"><fmt:message key="backBtn"/></button></span>
					</div>
				</div>
			</form>
			</c:forEach>
          </div>
    </section>
    </fmt:bundle>
<%@ include file="../includes/footer.jsp" %>
<script>
	//$('#pimage').change(function() {
	//	console.log($('#pimage').val());
	//	$('#pimg').attr("src", $('#pimage').val());
	//});
	function chgImg(path) {
		var s = $('#pimage').val().split("\\");
		console.log(path + s[s.length-1]);
		$('#pimg').attr('src', path + s[s.length-1]);
	}
</script>
</body>
</html>