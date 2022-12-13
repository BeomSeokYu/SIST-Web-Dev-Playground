<%@page import="jspz.basic.FindId"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>method.jsp</title>
</head>
<body>
	<h3>method call using EL</h3>
	<jsp:useBean id="fi" class="jspz.basic.FindId"></jsp:useBean>
	<br>
<%
	out.print(fi.findId(""));
%>
	<br> ${ fi.findId("123") }
	<br> ${ Math.random() }
	<br> ${ Math.max(1, 3) }
	
	<br> ${ result = (x, y) -> x > y ? true : false;'' }
	<br> ${ result(1, 2) }
	
</body>
</html>