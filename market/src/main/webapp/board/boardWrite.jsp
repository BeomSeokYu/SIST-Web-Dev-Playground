<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<% 
	String title = "게시판 글 작성";
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>boardWrite.jsp</title>
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
        <div class="container mt-5">
        	<form class="form-horizontal needs-validation" id="boardWriteForm" action="/market/BoardWrite.do" method="post" novalidate>
	        	<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>성명</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="userid" type="text" name="userid" value="${ sid }" readonly>
						<div id="pid-msg"></div>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>제목</p>
					</div>
					<div class="col-md-4">
						<input class="form-control" id="subject" type="text" name="subject" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-2">
						<p>내용</p>
					</div>
					<div class="col-md-4">
						<textarea class="form-control" id="content" name="content" rows="10" required></textarea>
					</div>
				</div>
				<div class="row mb-3 justify-content-end">
					<div class="col-md-4">
						<span><button class="btn btn-success" id="regBtn" type="button">등록</button></span>
						<span><button class="btn btn-danger backBtn">취소</button></span>
					</div>
				</div>
			</form>
          </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
<script>
	$('#regBtn').on('click', function () {
		$('#boardWriteForm').submit();
	});
	//$('#pimage').change(function() {
	//	console.log($('#pimage').val());
	//	$('#pimg').attr("src", $('#pimage').val());
	//});
</script>
</body>
</html>