<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date, java.util.Calendar"
    trimDirectiveWhitespaces="false"
%>
<% 
	Date date = new Date(); 
	Calendar cal = Calendar.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageDirective.jsp</title>
</head>
<body>
	<div>[Date] 오늘은 <%= date.toLocaleString() %></div>
	<div>[Calendar] 오늘은 <%= cal.get(cal.YEAR) %>년 <%= cal.get(cal.MONTH)+1 %>월 <%= cal.get(cal.DATE) %>일</div>
</body>
</html>