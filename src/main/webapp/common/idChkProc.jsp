<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <jsp:useBean id="mdao" class="market.dao.MemberDAO"/>
 <jsp:setProperty property="con" name="mdao" value="${ con }"/>
 <%
 	String id = request.getParameter("id");
 	boolean b = mdao.isId(id);
 	System.out.print(id);
 	if (mdao.isId(id)) {
 		out.print(false);
 	} else {
 		out.print(true);
 	}
 %>