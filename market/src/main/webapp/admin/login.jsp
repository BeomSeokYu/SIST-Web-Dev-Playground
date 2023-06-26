<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>securityLogin.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Servay Section-->
	<section class="page-section" style="margin-top: 100px; margin-bottom: 200px;">
	    <div class="container">
	        <form action="j_security_check" id="adminLoginForm" class="needs-validation" method="post">
	            <div class="row mb-5 justify-content-center">
	            	<h3 class="col-md-6">관리자 로그인</h3>
	            </div>
	            <c:if test="${ param.msg != null && param.msg.equals('loginFail') }">
		            <div class="container align-items-center text-center">
						<div class="row justify-content-center">
							<div class="col-md-6 alert alert-danger">
						  		아이디 또는 비밀번호가 일치하지 않습니다.
							</div>
						</div>
					</div>
				</c:if>
	            <div class="row mb-3 justify-content-center">
	            	<div class="col-md-6">
		                <label class="form-label" for="id">아이디</label>
		                <input type="text" class="form-control" name="j_username" id="id" placeholder="아이디를 입력하세요" required>
	            	</div>
	            </div>
	            <!-- pw input-->
	            <div class="row mb-5 justify-content-center">
	            	<div class="col-md-6">
		                <label class="form-label" for="pw">비밀번호</label>
		                <input type="password" class="form-control" name="j_password" id="pw" placeholder="비밀번호를 입력하세요" required>
					</div>	                
	            </div>
	            <!-- Submit Button-->
	            <div class="row mb-3 justify-content-center">
	                <button class="btn btn-primary col-md-2 mx-3" type="button" onclick="setId()">로그인</button>
	                <button class="btn btn-secondary col-md-2 mx-3 backBtn" type="button">이전으로</button>
	            </div>
	        </form>
	    </div>
	</section>
<script>
	function setId() {
		document.querySelector('#adminLoginForm').submit();
	}
</script>
</body>
</html>