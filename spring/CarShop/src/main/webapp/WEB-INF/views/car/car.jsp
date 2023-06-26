<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차 상세보기</title>
</head>
<%@ include file="../include/header.jsp" %>
<body>
<%@ include file="../include/navbar.jsp" %>
	<div class="alert alert-dark">
		<div class="container">
			<h1>차량 상세보기</h1>
		</div>
	</div>
	<div class="container">
		<h3>${car.cid}</h3>
		<p>${car.cname}</p>
		<p>${car.cprice} 만원</p>
		<p>${car.ccate}</p>
		<p>${car.cdesc}</p>
		<p><a href="<c:url value="/cars/list" />" class="btn btn-secondary btn-sm">목록으로</a></p>
	</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>