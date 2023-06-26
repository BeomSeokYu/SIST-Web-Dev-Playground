<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body, div {margin: 0 auto; text-align: center;}
</style>
</head>
<body>
	<div>
		<h3>예외 발생</h3>
		<%
		String s = (String) request.getAttribute("e");
		String msg = "";
		if(s.contains("NumberFormatException")) {
			msg = "NumberFormatException이 발생했습니다.";
		} else if (s.contains("ArrayIndexOutOfBoundsException")) {

			msg = "ArrayIndexOutOfBoundsException이 발생했습니다.";
		} else {
			msg = "발생한 예외 : " + s;
		}
		%>
		<%= msg %>
		<img alt="..." src="https://www.pngkit.com/png/detail/264-2646979_java-exceptions-alert-sign-exceptions-transparent.png">
	</div>
</body>
</html>