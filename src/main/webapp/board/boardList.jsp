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

	int pg = 1;
	int totalPage = ((boardList.size()-1)/10)+1;
	pageContext.setAttribute("totalPage", totalPage);
	int start = (pg - 1) * 10;
	int end = 0;
	if (pg < totalPage) {
	   	end = start + 10;
	} else if (pg==totalPage) {
		end = ((boardList.size()-1) % 10);
	}
	pageContext.setAttribute("start", start);
	pageContext.setAttribute("end", end);
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
	<c:if test="${ msg != null }">
		<script>
			alert('${ msg }');
		</script>
	</c:if>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5"><%= title %></h1>
    </header>
    <section class="page-section mt-5">
   	<c:choose>
   		<c:when test="${ boardList == null || boardList.size() < 1 }">
   			<c:if test="${ param.searchText == null}">
   			<div class="container align-items-center text-center">
				<div class="row">
					<div class="alert alert-danger">
				  		게시판 목록이 비었습니다.
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${ param.searchText != null}">
   			<div class="container align-items-center text-center">
				<div class="row">
					<div class="alert alert-danger">
				  		검색 결과가 없습니다.
					</div>
				</div>
				<button type="button" class="btn btn-primary backBtn">뒤로</button>
			</div>
			</c:if>
   		</c:when>
   		<c:otherwise>
        <div class="container align-items-center">
	        <span class="badge bg-success float-end">전체 게시글 ${ total } 개</span>
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
							<%-- <c:forEach items="${ boardList }" var="bvo"> --%>
							<c:forEach begin="${ start }" end="${ end-1 }" var="i">
								<tr onclick="location.href = '/market/BoardView.do?num=${ boardList[i].num }'">
						            <td scope="col">${ boardList[i].num }</td>
						            <td scope="col">${ boardList[i].subject }</td>
						            <td scope="col"><fmt:formatNumber value="${ boardList[i].hit }"/></td>
						            <td scope="col">${ boardList[i].userid }</td>
						        </tr>
							</c:forEach>
                            </tbody>
                        </table>
                    </div>
					<div class="row">
						<div class="col">
		                    <nav aria-label="Page navigation">
							  <ul class="pagination justify-content-center">
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
							    <c:forEach begin="1" end="${ totalPage }" var="i">
							    	<li class="page-item"><a class="page-link" href="/market/board/boardList.jsp?page=${ boardList[i].num }">${ i }</a></li>
							    </c:forEach>
							    <li class="page-item">
							      <a class="page-link" href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							  </ul>
							</nav>
						</div>
					</div>
                </div>
            </div>
        <div class="container mb-5">
        	<form class="float-start" id="searchForm" action="#" method="post">
                <select class="" name="select" id="boardSearchSelect">
                    <option value="Subject" ${ param.select != null && param.select == 'Subject' ? 'selected' : '' }>제목</option>
                    <option value="Content" ${ param.select != null && param.select == 'Content' ? 'selected' : '' }>내용</option>
                    <option value="Userid" ${ param.select != null && param.select == 'Userid' ? 'selected' : '' }>작성자</option>
                </select>
                <input class="" id="searchText" name="searchText" type="text" value="${ param.search != null ? param.search : '' }">
                <button type="button" id="boardSearchBtn" class="btn btn-primary">검색</button>
            </form>
            <c:if test="${ sid != null }">
	        	<a class="btn btn-primary float-end" href="/market/BoardWriteForm.do">글쓰기</a>
            </c:if>
        </div>
		</c:otherwise>
   	</c:choose>
    </section>
<%@ include file="../includes/footer.jsp" %>
<script>
	$('#boardSearchBtn').click(function() {
		console.log('action', '/market/BoardSearch'+ $('#boardSearchSelect').val() +'.do');
		if($('#searchText').val().trim() != "") {
			$('#searchForm').attr('action', '/market/BoardSearch'+ $('#boardSearchSelect').val() +'.do')
				.submit();
		} else {
			alert('검색어를 입력하세요.')
		}
	})
</script>
</body>
</html>