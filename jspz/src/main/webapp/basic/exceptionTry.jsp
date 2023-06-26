<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	try {
		//Integer.parseInt("일");
		int[] a = {1, 2, 3, 4}; a[4] = 5;
	} catch(Exception e) {
		request.setAttribute("e", e.getClass().getName());
		pageContext.forward("../error/exceptionCatch.jsp");
	}
%>
</body>
</html>