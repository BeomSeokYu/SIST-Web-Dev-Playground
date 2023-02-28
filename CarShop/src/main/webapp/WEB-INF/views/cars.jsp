<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@ include file="./include/header.jsp" %>
<body>
<%@ include file="./include/navbar.jsp" %>
	<div class="alert alert-dark">
		<div class="container">
			<h1>차량 보기</h1>
		</div>
	</div>


	<div class="container">
		<div class="row" align="center">
		
		<c:forEach items="${carList}" var="car">
			<div class = "col-md-4">
				<h3>${car.cid}</h3>
				<p>${car.cname}
				<p>${car.cprice} 만원
			</div>

		</c:forEach>
		
		</div>
	</div>
<%@ include file="./include/footer.jsp" %>
</body>
</html>