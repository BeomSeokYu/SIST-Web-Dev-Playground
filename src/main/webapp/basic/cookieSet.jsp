<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieSet.jsp</title>
</head>
<body>
<%
	Cookie code = new Cookie("code", "5678");
	Cookie level = new Cookie("level", "A");
	
	
	code.setMaxAge(60);
	level.setMaxAge(180);
	level.setValue("B");
	
	response.addCookie(code);
	response.addCookie(level);
	response.sendRedirect("cookieGet.jsp");
%>
</body>
</html>