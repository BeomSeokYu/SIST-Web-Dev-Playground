<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="market.vo.ProductVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	List<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");
	int idx = 0;
	int sum = 0;
	if (cartList != null) {
		for (ProductVO pvo : cartList) { sum += pvo.getQuantity()*pvo. getPrice(); }
	}
	
	Cookie[] cookies = request.getCookies();
	String[] fname = {"rname", "deliDate", "zipNo", "addr", "phone"};
	String rname = "";
	String deliDate = "";
	String zipNo = "";
	String addr = "";
	String addr1 = "";
	String addr2 = "";
	String addr3 = "";
	String phone = "";
	for(Cookie c : cookies) {
		switch(c.getName()) {
		case "rname": rname = URLDecoder.decode(c.getValue(), "UTF-8"); break;
		case "deliDate": deliDate = c.getValue() == null ? "없음" : c.getValue(); break;
		case "zipNo": zipNo = URLDecoder.decode(c.getValue(), "UTF-8"); break;
		case "addr": addr = URLDecoder.decode(c.getValue(), "UTF-8"); break;
		case "addr1": addr1 = URLDecoder.decode(c.getValue(), "UTF-8"); break;
		case "addr2": addr2 = URLDecoder.decode(c.getValue(), "UTF-8"); break;
		case "addr3": addr3 = URLDecoder.decode(c.getValue(), "UTF-8"); break;
		case "phone": phone = c.getValue(); break;
		}
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>orderInfo.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">주문 정보</h1>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section mt-5 mx-5">
        <div class="container border border-2 rounded-3 p-5">
        	<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>수령인</strong></p>
				</div>
				<div class="col-md-6">
					<p><%= rname %></p>
				</div>
				<div class="col-md-2">
					<p><strong>배송희망일</strong></p>
				</div>
				<div class="col-md-2">
					<p><%= deliDate %></p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>연락처</strong></p>
				</div>
				<div class="col-md-4">
					<p><%= phone %></p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>우편번호</strong></p>
				</div>
				<div class="col-md-4">
					<p><%= zipNo %></p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>도로명 주소</strong></p>
				</div>
				<div class="col-md-4">
					<p><%= addr1 %></p>
				</div>
			</div>
			<div class="row mb-3">
        		<div class="col-md-2">
					<p><strong>상세 주소</strong></p>
				</div>
				<div class="col-md-4">
					<p><%= addr2+" "+addr3 %></p>
				</div>
			</div>
			<div class="row mb-3 jus">
				<table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th scope="col">상품</th>
	                        <th scope="col">수량</th>
	                        <th scope="col">가격</th>
	                        <th scope="col">소계</th>
	                    </tr>
	                </thead>
	                <tbody>
<%-- <%
	if(cartList != null) {
		for (ProductVO pvo : cartList) {
			out.print("<tr>");
			out.print("<td>"+pvo.getPid() + " - " + pvo.getPname() +"</td>");
			out.print("<td>"+pvo.getQuantity()+"</td>");
			out.print("<td>"+pvo.getPrice()+"</td>");
			out.print("<td>"+pvo.getQuantity()*pvo. getPrice()+"</td>");
			out.print("</tr>");
		}
	}
%> --%>
					<c:forEach items="${ cartList }" var="pvo">
						<tr>
				            <td scope="col">${ pvo.pid } - ${ pvo.pname }</td>
				            <td scope="col">${ pvo.quantity }</td>
				            <td scope="col"><fmt:formatNumber value="${ pvo.price }"/> 원</td>
				            <td scope="col"><fmt:formatNumber value="${ pvo.quantity * pvo.price }"/> 원</td>
				        </tr>
					</c:forEach>
	                </tbody>
	                <tfoot>
	                	<tr>
	                        <td colspan="2"></td>
                            <td><strong>총액</strong></td>
                            <td><fmt:formatNumber value="<%= sum %>"/> 원</td>
	                    </tr>
	                </tfoot>
	            </table>
	            <div class="container my-3 p-0">
	            	<a href="orderCancle.jsp" class="btn btn-danger mx-1 float-end">취소</a>
					<a href="orderDone.jsp" class="btn btn-success mx-1 float-end">주문완료</a>
					<a href="#" class="btn btn-secondary float-end mx-1 backBtn">이전으로</a>
			</div>
			</div>
		</div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>