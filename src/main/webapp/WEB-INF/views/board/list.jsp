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
								<form class="text-right col-lg-6">
							        Show
							        <select id="selectAmount">
							       		<option value="5" ${ pageDTO.criteria.amount == '5' ? 'selected' : '' }>5</option>
							       		<option value="10" ${ pageDTO.criteria.amount == '10' ? 'selected' : '' }>10</option>
							       		<option value="20" ${ pageDTO.criteria.amount == '20' ? 'selected' : '' }>20</option>
							        </select>
							        entries
								</form>
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
												<tr class="move" data="${ bvo.bno }">
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
							<div class="row text-right">
								<form class="col-lg-6" action="/board/list" id="searchFrm">
									<select name="type">
							       		<option value="T" ${ pageDTO.criteria.type == 'T' ? 'selected' : '' }>제목</option>
							       		<option value="C" ${ pageDTO.criteria.type == 'C' ? 'selected' : '' }>내용</option>
							       		<option value="W" ${ pageDTO.criteria.type == 'W' ? 'selected' : '' }>작성자</option>
							       		<option value="TC" ${ pageDTO.criteria.type == 'TC' ? 'selected' : '' }>제목/내용</option>
							       		<option value="TW" ${ pageDTO.criteria.type == 'TW' ? 'selected' : '' }>제목/작성자</option>
							       		<option value="TCW" ${ pageDTO.criteria.type == 'TCW' ? 'selected' : '' }>제목/내용/작성자</option>
							        </select>
							      	<input type="search" name="keyword" value="${ pageDTO.criteria.keyword }">
							      	<button class="btn btn-sm" id="searchBtn" type="button">검색</button>
							      	<input type="hidden" name="pageNum" value="1">
									<input type="hidden" name="amount" value="${ pageDTO.criteria.amount }">
								</form>
							</div>
							<div class="row text-center">
								<ul class="pagination">
									<li class="page-item">
									<!-- previous -->
									<c:if test="${ pageDTO.previous }">
										<a class="page-link" href="${ pageDTO.start - 1 }" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
										</a>
									</c:if>
									</li>
									<!-- page -->
									<c:forEach  begin="${ pageDTO.start }" end="${ pageDTO.end }" var="i" varStatus="vs">
										<li class="page-item ${ pageDTO.criteria.pageNum == i ? 'active' : '' }">
											<a class="page-link" href="${ i }">${ i }</a>
										</li>
									</c:forEach>
									<!-- next -->
									<c:if test="${ pageDTO.next }">
										<li class="page-item">
											<a class="page-link" href="${ pageDTO.end + 1 }" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
												<span class="sr-only">Next</span>
											</a>
										</li>
									</c:if>
								</ul>
							</div>
							<form id="actionFrm" action="/board/list">
								<input type="hidden" name="pageNum" value="${ pageDTO.criteria.pageNum }">
								<input type="hidden" name="amount" value="${ pageDTO.criteria.amount }">
								<input type="hidden" name="keyword" value="${ pageDTO.criteria.keyword }">
								<input type="hidden" name="type" value="${ pageDTO.criteria.type }">
							</form>
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
	// Pageing Event 처리
	var actionFrm = $('#actionFrm');
	$('.page-link').on('click', function(event) {
		event.preventDefault();
		
		actionFrm.find("input[name='pageNum']").val($(this).attr('href'));
		actionFrm.submit();
	});
	// view 페이지로 이동 처리
	$('.move').on('click', function (event) {
		event.preventDefault();
		
		actionFrm.append('<input type="hidden" name="bno" value="'+ $(this).attr('data') +'">');
		actionFrm.attr('action', '/board/view');
		actionFrm.submit();
	});
	
	// 페이지 표시 게시물 수 변경 이벤트 설정
	$('#selectAmount').on('change', function (event) {
		actionFrm.find("input[name='amount']").val($(this).val());
		actionFrm.submit();
	});
	
	// 검색 버튼 이벤트 처리
	var searchFrm = $('#searchFrm');
	$('#searchBtn').on('click', function () {
		if(searchFrm.find("input[name='keyword']").val() == '') {
			$('#modalBody').text('검색어를 입력해 주세요.');
			$("#myModal").modal('show');
		} else {
			searchFrm.submit();
		}
	});
	
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