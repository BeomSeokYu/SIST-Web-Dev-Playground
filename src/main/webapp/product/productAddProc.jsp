<%@page import="market.dao.ProductDAO"%>
<%@page import="market.vo.ProductVO, java.lang.Integer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	ProductVO p = new ProductVO();
	p.setPid(request.getParameter("pid"));
	p.setCategory(request.getParameter("category"));
	p.setCondition(request.getParameter("condition"));
	p.setDescription(request.getParameter("description"));
	p.setMaker(request.getParameter("maker"));
	p.setPname(request.getParameter("pname"));
	p.setPrice(Integer.parseInt(request.getParameter("price")));
	p.setStock(Integer.parseInt(request.getParameter("stock")));
	p.setPimage(request.getParameter("pimage"));
%>


<jsp:useBean id="pvo" class="market.vo.ProductVO" scope="request"/>
<jsp:setProperty property="*" name="pvo"/>

<jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
<%
	if(pdao.insert(pvo)) { 
		response.sendRedirect("productList.jsp");
	} else {
%>
	<script>
		alert("이미 존재하는 상품코드입니다."); // unique constraint 위반인 경우
		history.back();
	</script>
<%
	}
%>