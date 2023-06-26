<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="market.vo.ProductVO"%>
<%
	List<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");
	for (int i=0; i<cartList.size(); i++) {
		if(cartList.get(i).getPid().equals(request.getParameter("pid"))) {
			cartList.remove(i);
		}
	}
	response.sendRedirect("cart.jsp");
%>