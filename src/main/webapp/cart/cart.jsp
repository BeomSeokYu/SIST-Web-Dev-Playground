<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="market.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<% String title = "장바구니"; %>

<%
	List<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");
	int idx = 0;
	int sum = 0;
	if (cartList != null) {
		for (ProductVO pvo : cartList) { sum += pvo.getQuantity()*pvo. getPrice(); }
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>cart.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5"><%= title %></h1>
    </header>
    <section class="page-section mt-5">
<% if (cartList == null || cartList.size() < 1) { %>
		<div class="container align-items-center text-center">
			<div class="row">
				<div class="alert alert-danger">
			  		장바구니 목록이 비었습니다.
				</div>
			</div>
		</div>
<% } else { %>
        <div class="container">
	        <button class="btn btn-danger" id="cartClearBtn">장바구니 비우기</button>
	        <a class="btn btn-success float-end" href="deliveryInfo.jsp">주문하기</a>
        </div>
        <div class="container mt-5">
            <div class="container text-center text-truncate">
                <div class="row">
                    <div class="col">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">상품</th>
                                    <th scope="col">수량</th>
                                    <th scope="col">가격</th>
                                    <th scope="col">소계</th>
                                    <th scope="col">비고</th>
                                </tr>
                            </thead>
                            <tbody>
<%
	for (ProductVO pvo : cartList) {
		out.print("<tr>");
		out.print("<td>"+pvo.getPid() + " - " + pvo.getPname() +"</td>");
		out.print("<td>"+pvo.getQuantity()+"</td>");
		out.print("<td>"+pvo.getPrice()+"</td>");
		out.print("<td>"+pvo.getQuantity()*pvo. getPrice()+"</td>");
		out.print("<td><a class=\"badge bg-danger\" href=\"cartRemoveProc.jsp?pid="+pvo.getPid()+"\">삭제</a></td>");
		out.print("</tr>");
	}
%>
                            </tbody>
                            <tfoot>
                            	<tr>
                                    <td colspan="2"></td>
                                    <td><strong>총액</strong></td>
                                    <td><%= sum %></td>
                                    <td></td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        <div class="container">
        	<a class="btn btn-primary" href="../product/productList.jsp">계속 쇼핑</a>
        </div>
<% } %>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>