<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차 등록</title>
</head>
<%@ include file="../include/header.jsp" %>
<body>
<%@ include file="../include/navbar.jsp" %>
	<div class="alert alert-dark">
		<div class="container">
			<h1>차량 등록</h1>
		</div>
	</div>


	<div class="container">
		<form:form modelAttribute="car" method="POST" class="form-horizontal">
		<fieldset>
		<legend>${ addTitle }</legend>
			<p>차량 ID : <form:input path="cid" class="form-control"/></p>
			<p>차량 이름 : <form:input path="cname" class="form-control"/></p>
			<p>차량 가격 : <form:input path="cprice" class="form-control"/></p>
			<p>차량 카테고리 : <form:input path="ccate" class="form-control"/></p>
			<p>차량 소개 : <form:textarea path="cdesc" cols="50" rows="2" class="form-control"/></p>
		
			<button class="btn btn-sm btn-secondary">등록</button>
		</fieldset>
		</form:form>
	</div>
<%@ include file="../include/footer.jsp" %>
</body>
</html>