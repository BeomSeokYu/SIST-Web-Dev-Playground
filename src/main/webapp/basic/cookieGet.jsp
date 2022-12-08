<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieGet</title>
</head>
<body>
	<h3>get cookie</h3>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies) {
		out.print("name : " + c.getName() + " \t| value : " + c.getValue() + "<br>");
	}
%>
	쿠키 개수 : <%= cookies.length %> <br>
	<a href="cookieSet.jsp">cookieSet.jsp</a>
	<a href="cookieDel.jsp">cookieDel.jsp</a>
</body>
</html>