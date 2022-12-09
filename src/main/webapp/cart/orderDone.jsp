<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String[] fname = {"rname", "deliDate", "zipNo", "addr", "phone"};
	String cartId = "";
	for(Cookie c : cookies) {
		if(c.getName().equals("cartId")) {
			cartId = URLDecoder.decode(c.getValue(), "UTF-8");
		}
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>orderDone.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5">주문 완료</h1>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section mt-5">
        <div class="container">
            <div class="container align-items-center text-center">
                <div class="row">
	                <div class="alert alert-success">
					  주문해 주셔서 감사합니다.
					</div>
                </div>
                <div class="row">
	                주문하신 상품은 2020-20-20에 배송될 예정입니다.
                </div>
                <div class="row">
	                주문번호 : <%= cartId %>
                </div>
            </div>
            <div class="container p-0 mt-3">
             <p><a href="../product/productList.jsp" class="btn btn-secondary">상품 목록</a><p>
            </div>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>
<%
Cookie c = null;
for (int i=0; i < fname.length; i++) {
	c = new Cookie(fname[i].trim(), "");
	c.setMaxAge(0);
	response.addCookie(c);
}
%>