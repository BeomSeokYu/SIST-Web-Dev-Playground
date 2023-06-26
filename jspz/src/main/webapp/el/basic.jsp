<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basic.jsp</title>
</head>
<body>
	<h3>Expression Language</h3>
<%
	pageContext.setAttribute("msg", "Hello pageContext");
	request.setAttribute("msg", "Hello request");
	session.setAttribute("msg", "Hello session");
	application.setAttribute("msg", "Hello application");
	response.addCookie(new Cookie("msg", "HelloCookie"));
%>
	<!-- 이름만 명시하면 pageContext > request > session > application 순으로 찾음 -->
	<br> ${ msg }
	<br> ${ pageScope.msg }
	<br> ${ requestScope.msg }
	<br> ${ sessionScope.msg }
	<br> ${ applicationScope.msg }
	<br> ${ cookie.msg.value }
	<br> ${ param.msg }
	<br> ${ param["msg"] }
	<br> ${ param['msg'] }
	<hr>
	<br> type 파라미터의 값 : 
	<%for (String s : request.getParameterValues("type")) out.print("<br>" + s);%>
	<br> ${ paramValues.type[0] }
	<br> ${ paramValues.type[1] }
	<br> ${ paramValues.type[2] }
	<hr>
	<br> ${ header.host }
	<br> ${ header["User-Agent"] }
	<br> ${ headerValues.Accept }
	<hr>
	<br> ${ initParam.uploadPath }
	<br> ${ pageContext.request.requestURI }
	<hr>
	msg : <%= request.getAttribute("msg") %>
</body>
</html>