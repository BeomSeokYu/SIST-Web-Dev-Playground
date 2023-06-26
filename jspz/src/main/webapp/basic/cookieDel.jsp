<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName().equals("level")) {
			c.setMaxAge(0);
			response.addCookie(c);
		}
		out.print("name : " + c.getName() + " \t| value : " + c.getValue() + "<br>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieDel.jsp</title>
</head>
<body>
	<h3>delete cookie</h3>
<%
	boolean popupChk = false;
	for(Cookie c : cookies) {
		if (c.getName().equals("popup")) {
			popupChk = true;
			break;
		}
	}
	if (!popupChk) {
		out.print("<script>window.open('popup.jsp', 'popup', 'top=300, left=900, width=300, height=250');</script>");
	}
%>
	쿠키 개수 : <%= cookies.length %> <br>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</body>
</html>