<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<a href="basic/session.jsp?code=1111">session.jsp</a>
	<%
	request.setAttribute("code", 2222);
	session.setAttribute("code", 3333);
	%>
	<jsp:forward page="basic/session.jsp">
		<jsp:param value="1111" name="code"/>
	</jsp:forward>
</body>
</html>