<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:useBean id="mdao" class="market.dao.MemberDAO"/>
 <jsp:setProperty property="con" name="mdao" value="${ con }"/>
 <jsp:useBean id="mvo" class="market.vo.MemberVO"/>
 <% 
 	mvo = mdao.select((String)session.getAttribute("sid")); 
 	request.setAttribute("mvo", mvo);
 %>
 
 <jsp:forward page="memberEdit.jsp"/>