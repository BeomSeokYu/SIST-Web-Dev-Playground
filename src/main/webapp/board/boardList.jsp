<%@page import="market.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!-- boardList.
	세션에 msg속성이 있는 경우 경고창 표시
 -->
<% 
	String title = "게시판"; 

	List<BoardVO> boardList =  (ArrayList) request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
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
<% if (boardList == null || boardList.size() < 1) { %>
		<div class="container align-items-center text-center">
			<div class="row">
				<div class="alert alert-danger">
			  		게시판 목록이 비었습니다.
				</div>
			</div>
		</div>
<% } else { %>
        <div class="container">
	        <button class="badge bg-success float-end">전체 게시글 ${ total } 개</button>
        </div>
        <div class="container my-5">
            <div class="container text-center text-truncate">
                <div class="row">
                    <div class="col">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">글 번호</th>
                                    <th scope="col">제목</th>
                                    <th scope="col">조회수</th>
                                    <th scope="col">작성자</th>
                                </tr>
                            </thead>
                            <tbody>
							<c:forEach items="${ boardList }" var="bvo">
								<tr onclick="location.href = '/market/BoardView.do?num='+${ bvo.num }">
						            <td scope="col">${ bvo.num }</td>
						            <td scope="col">${ bvo.subject }</td>
						            <td scope="col"><fmt:formatNumber value="${ bvo.hit }"/></td>
						            <td scope="col">${ bvo.userid }</td>
						        </tr>
							</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        <div class="container mb-5">
        	<form class="float-start" action="">
                <select name="" id="">
                    <option value="title">제목에서</option>
                    <option value="item">작성자에서</option>
                </select>
                <input type="text">
                <button type="button" class="btn btn-primary">검색</button>
            </form>
            <c:if test="${ sid != null }">
	        	<a class="btn btn-primary float-end" href="/market/BoardWriteForm.do">글쓰기</a>
            </c:if>
        </div>
<% } %>
    </section>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>