<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
%>
<strong>TODAY's SPECIAL</strong><br>
- orange juice<br>
- apple coffee<br>
- white cocoa
<% 
	if(request.getParameter("newMenu") != null) {
		out.print("<br> - "+request.getParameter("newMenu"));
	}
%>
<hr>
<%
	Date date = new Date();
	out.print(date.toLocaleString());
%>