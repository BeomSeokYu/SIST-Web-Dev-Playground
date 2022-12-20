<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
 
 <%
 	String pid = request.getParameter("pid");
 	boolean b = pdao.select(pid) == null ? false : true;
 	System.out.print(pid);
 	if (b) {
 		out.print(false);
 	} else {
 		out.print(true);
 	}
 %>