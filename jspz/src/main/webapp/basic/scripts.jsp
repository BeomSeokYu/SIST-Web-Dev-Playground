<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scripts.jsp</title>
</head>
<body>
	<h3>JSP 스크립트 요소</h3>
	<ul>
		<li>선언문 declaration &lt;%! ... %&gt;<br></li>
		<li>스크립트릿 scriptlet &lt;% ... %&gt;<br></li>
		<li>표현식 expression &lt;%= ... %&gt;<br></li>
		<li>주석 &lt;%-- ... --%&gt;<br></li>
	</ul>
<%!	String name = "Kim"; %>
<%	String userid = "aaa"; %>
<%= name %>
<%-- == --%>
<% out.println(name); %>
<%-- 주석 --%>
</body>
</html>