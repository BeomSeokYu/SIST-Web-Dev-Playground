<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<% 
	String title = "게시글 보기";
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>boardView.jsp</title>
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
        	<form class="form-horizontal needs-validation" id="boardViewForm" action="/market/BoardModify.do" method="post">
	        	<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-1">
						<p>성명</p>
					</div>
					<div class="col-md-5">
						<input class="form-control" id="userid" type="text" name="userid" value="${ bvo.userid }" readonly>
						<div id="pid-msg"></div>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-1">
						<p>제목</p>
					</div>
					<div class="col-md-5">
						<input class="form-control" id="subject" type="text" name="subject" value="${ bvo.subject }" required>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-1">
						<p>내용</p>
					</div>
					<div class="col-md-5">
						<textarea class="form-control" id="content" name="content" rows="10" required>${ bvo.content }</textarea>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-1">
						<p>IP</p>
					</div>
					<div class="col-md-5">
						<input class="form-control" id="subject" type="text" name="subject" value="${ bvo.ip }" readonly>
					</div>
				</div>
				<div class="form-group row mb-3 justify-content-center">
	        		<div class="col-md-1">
						<p>조회수</p>
					</div>
					<div class="col-md-5">
						<input class="form-control" id="subject" type="text" name="subject" value="${ bvo.hit }" readonly>
					</div>
				</div>
				<div class="row mb-3 justify-content-end">
					<div class="col-md-1"></div>
					<div class="col-md-4">
						<input type="hidden" name="num" value="${ bvo.num }">
						<c:if test="${ sid == bvo.userid }">
							<span><button class="btn btn-success" id="boardModBtn" type="button" onclick="boardModify()">수정</button></span>
							<span><button class="btn btn-danger" id="boardDelBtn" type="button" onclick="boardRemove('${ bvo.num }')">삭제</button></span>
						</c:if>
						<span><a class="btn btn-secondary backBtn" href="/market/BoardList.do">목록</a></span>
					</div>
				</div>
			</form>
          </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
<script>
	function boardRemove(num) {
		if(window.confirm('정말로 삭제하시겠습니까?')) {
			location.href = '/market/BoardRemove.do?num='+num;
		}
	}
	function boardModify(num) {
		if(window.confirm('정말로 수정하시겠습니까?')) {
			$('#boardViewForm').submit();
		}
	}
	// $('#pimage').change(function() {
	//	console.log($('#pimage').val());
	//	$('#pimg').attr("src", $('#pimage').val());
	// });
</script>
</body>
</html>