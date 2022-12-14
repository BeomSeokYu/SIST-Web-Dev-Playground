<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>messages.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">${ param.title }</h1>
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <!-- Info Section -->
    <section class="page-section" id="info">
		<div class="container mt-5 align-items-center text-center">
			<div class="row mb-5 justify-content-center">
				<div class="alert alert-danger">
					<c:if test="${ param.msg != null && param.msg.equals('login') }">
			  			${ sid } 님 어서오세요~
			  		</c:if>
			  		<c:if test="${ param.msg != null && param.msg.equals('logout') }">
			  			<p>로그아웃이 완료되었습니다.</p>
			  			<p>이용해 주셔서 감사합니다.</p>
			  		</c:if>
				</div>
				<p><a class="btn btn-primary mt-5" href="../index.jsp">메인으로</a></p>
			</div>
		</div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>