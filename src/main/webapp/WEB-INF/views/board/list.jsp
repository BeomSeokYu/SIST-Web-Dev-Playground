<%@page import="edu.springz.domain.Criteria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../include/header.jsp"/>
<body>
<jsp:include page="../include/navBar.jsp"/>
	<div class="wrapper">
		<div id="page-wrapper">
			<div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List Page</h1>
                </div>
            </div>
			<div class="row">
		        <div class="col-lg-12">
		            <div class="panel panel-default">
		                <div class="panel-heading">
		                    Board List
		                    <a class="btn btn-xs pull-right btn-info" href="/board/register" id="regBtn">register new board</a>
		                </div>
		                <div class="panel-body">
		                	<div class="row">
								<span class="text-left col-lg-6">
								       Show
								       <select>
								       		<option value="5">5</option>
								       		<option value="10">10</option>
								       		<option value="20">20</option>
								       </select>
								       entries
								</span>
								<span class="text-right col-lg-6">
							      	Search:
							      	<input type="text" name="keyword">
								</span>
							</div>
							<p></p>
							<div class="row">
								<div class="col-lg-12">
									<table class="table table-striped table-bordered table-hover">
									    <thead>
									        <tr>
									            <th>no.</th>
									            <th>제목</th>
									            <th>내용</th>
									            <th>작성자</th>
									            <th>작성일</th>
									            <th>수정일</th>
									        </tr>
									    </thead>
									    <tbody>
											<c:forEach items="${ list }" var="bvo" varStatus="i">
												<tr onclick="location.href = '/board/view?bno=${ bvo.bno }'">
										            <td>${ bvo.bno }</td>
										            <td>${ bvo.title }</td>
										            <td>${ bvo.content }</td>
										            <td>${ bvo.writer }</td>
										            <td><fmt:formatDate value="${ bvo.regDate }" pattern="yyyy-MM-dd"/></td>
										            <td><fmt:formatDate value="${ bvo.updateDate }" pattern="yyyy-MM-dd"/></td>
										        </tr>
											</c:forEach>
								        </tbody>
									</table>
								</div>
							</div>
							<div class="row text-center">
								<ul class="pagination">
									<li class="page-item">
									<c:if test="${ pageDTO.previous }">
										<a class="page-link" href="/board/list?pageNum=${ criteria.pageNum - 1 }" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
										</a>
									</c:if>
									</li>
									<c:forEach  begin="${ pageDTO.start }" end="${ pageDTO.end }" var="i" varStatus="vs">
										<li class="page-item ${ criteria.pageNum == i ? 'active' : '' }"><a class="page-link" href="/board/list?pageNum=${ i }">${ i }</a></li>
									</c:forEach>
									<c:if test="${ pageDTO.next }">
										<li class="page-item">
											<a class="page-link" href="/board/list?pageNum=${ criteria.pageNum + 1 }" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
												<span class="sr-only">Next</span>
											</a>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                <h4 class="modal-title" id="myModalLabel"> 알림</h4>
			            </div>
			            <div class="modal-body" id="modalBody">
			                처리가 완료되었습니다.
			            </div>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			            </div>
			        </div>
			        <!-- /.modal-content -->
			   </div>
			   <!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
<jsp:include page="../include/footer.jsp"/>
<script>
	// 처리 결과 알림 모달창 ----------------------
	var result = '${ result }'
	checkModal(result);
	
	// 모달창 재출력 방지
	history.replaceState({}, null, null);
	
	// 모달창 표시
	function checkModal(result) {
		// result가 없으면 리턴
		if(result === '' || history.state) {
			return;
		}
		$("#myModal").modal('show');
	}
</script>
</body>
</html>