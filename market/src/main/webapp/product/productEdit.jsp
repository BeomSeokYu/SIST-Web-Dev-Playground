<%@ page import="java.util.List, java.text.DecimalFormat"%>
<%@ page import="market.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = "상품 편집"; %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>productEdit.jsp</title>
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
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <!-- Section -->
    <section class="page-section" id="list">
        <div class="container">
            <div class="container d-flex flex-column">
            	<div class="row mt-5">

<jsp:useBean id="pdao" class="market.dao.ProductDAO"/>
<%
	DecimalFormat fmt = new DecimalFormat("###,###");
	List<ProductVO> list = pdao.selectAllProduct();
	if (list == null || list.isEmpty()) {
		// 목록이 없을 경우
		out.print("<div>등록된 상품이 없습니다.</div>");
	} else {

		// 목록 출력
		for (ProductVO pvo : list) { %>
				<div class="col-md-4 text-center">
					<!-- 이미지 -->
					<img class="img-fluid h-50" alt="" src="../resources/imgs/<%= pvo.getPimage() %>">
					<h3><%= pvo.getPname() %></h3>
					<p><%= pvo.getDescription() %></p>
					<p><fmt:formatNumber value="<%= pvo.getPrice() %>"/> 원</p>
					<c:if test="${ param.edit == 'modify' }">
						<p><a href="productModify.jsp?pid=<%= pvo.getPid() %>&lang=ko" class="btn btn-primary">수정</a></p>
					</c:if>
					<c:if test="${ param.edit == 'remove' }">
						<p><button class="btn btn-danger" onclick="productRm('<%= pvo.getPid() %>')">삭제</button></p>
					</c:if>
				</div>
		<% }
	}
%>
				</div>
            </div>
        </div>
    </section>
    <c:if test="${ param.msg == 'rmSuccess' }"><script>alert('삭제되었습니다.');</script></c:if>
    <c:if test="${ param.msg == 'rmFail' }"><script>alert('존재하지 않는 상품입니다.');</script></c:if>
    <c:if test="${ param.msg == 'modSuccess' }"><script>alert('수정되었습니다.');</script></c:if>
    <c:if test="${ param.msg == 'modFail' }"><script>alert('수정에 실패하였습니다.');</script></c:if>
<%@ include file="../includes/footer.jsp" %>
<script>
	function productRm(pid) {
		if(window.confirm('정말로 삭제하시겠습니까?')) {
			location.href = 'productRemoveProc.jsp?pid='+pid;
		}
	};
</script>
</body>
</html>