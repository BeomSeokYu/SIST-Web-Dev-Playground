<%@page import="jspz.bean.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sqlSelect.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- 
driver = oracle.jdbc.OracleDriver
url = jdbc:oracle:thin:@localhost:1521:xe
username = madang
password = 1111 
-->
	<h3>JSTL SQL - INSERT</h3>
	<div class="container">
		<form action="sqlInsertProc.jsp">
			책ID : <input class="form-control" type="text" name="bookid" /> <br>
			책이름 : <input class="form-control" type="text" name="bookname" /> <br>
			출판사 : <input class="form-control" type="text" name="publisher" /> <br>
			가격 : <input class="form-control" type="text" name="price" /> <br>
			<input class="btn btn-success" type="submit" value="등록">
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>