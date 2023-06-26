<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application.jsp</title>
</head>
<body>
	<h3>내장 객체 application</h3>
	- init parameter codeOne : <%= config.getInitParameter("codeOne") %>
	<br>
	- context parameter adminEmail : <%= application.getInitParameter("adminEmail") %>
	
	<hr>
	server info : <%= application.getServerInfo() %> <br>
	context path : <%= application.getContextPath() %> <br>
	real path : <%= application.getRealPath(application.getContextPath()) %> <br>
</body>
</html>