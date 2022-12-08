<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = "장바구니"; %>
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
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <section class="page-section mt-5">
		<div class="container align-items-center text-center">
			<div class="row">
				<div class="alert alert-danger">
			  		장바구니 목록이 비었습니다.
				</div>
			</div>
		</div>
        <div class="container">
	        <a class="btn btn-danger" href="#">장바구니 비우기</a>
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
                                <tr>
                                    <td>P1234 - asdf</td>
                                    <td>1</td>
                                    <td>150000</td>
                                    <td>150000</td>
                                    <td><div class="badge bg-danger">삭제</div></td>
                                </tr>
                                <tr>
                                    <td>P1235 - qwer</td>
                                    <td>1</td>
                                    <td>20000</td>
                                    <td>20000</td>
                                    <td><div class="badge bg-danger">삭제</div></td>
                                </tr>
                            </tbody>
                            <tfoot>
                            	<tr>
                                    <td colspan="2"></td>
                                    <td>총액</td>
                                    <td>1520000</td>
                                    <td></td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        <%-- <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="Page navigation">
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div> --%>
        <div class="container">
        	<a class="btn btn-primary" href="../product/productList.jsp">계속 쇼핑</a>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>