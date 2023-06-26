<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="market.vo.ProductVO"%>
<%
// 세션에서 cartList 속성 지우기
// 장바구니 페이지로 이동
	session.removeAttribute("cartList");
	response.sendRedirect("cart.jsp");
%>