<%@page import="java.net.URLEncoder"%>
<%@page import="market.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 배송 정보를 쿠키에 저장하고
	// 쿠키의 유효기간은 1년으로 설정한 후
	// orderInfo.jsp로 이동
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	String[] fname = {"rname", "deliDate", "zipNo", "addr", "addr1", "addr2", "addr3", "phone"};
	Cookie c = null;
	
	c = new Cookie("cartId", session.getId());
	c.setMaxAge(31536000);
	response.addCookie(c);
	
	for (int i=0; i < fname.length; i++) {
		c = new Cookie(fname[i].trim(), URLEncoder.encode(request.getParameter(fname[i]).trim(), "UTF-8"));
		c.setMaxAge(31536000);
		response.addCookie(c);
	}
	pageContext.forward("orderInfo.jsp");
%>