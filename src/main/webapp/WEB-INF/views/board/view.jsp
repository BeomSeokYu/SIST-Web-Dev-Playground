<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>
<body>
<jsp:include page="../include/navBar.jsp"/>
<body>
	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <h1 class="page-header">Board View</h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    Board View Page
	                </div>
	                <div class="panel-body">
                    	<div class="row">
							<span class="text-left col-lg-6">
							       <label>#No</label>
							</span>
							<span class="text-right col-lg-6">
						      	<span>작성일 : <fmt:formatDate value="${ bvo.regDate }" pattern="yyyy.MM.dd (E)"/></span>
							</span>
							<div class="col-lg-12">
						      	<input class="form-control" name="bno" value="${ bvo.bno }" readonly>
						    </div>
						</div>
						<div class="row">
							<div class="col-lg-12">
							    <label>Title</label>
							    <input class="form-control" name="title" value="${ bvo.title }" readonly>
						    </div>
						</div>
						<div class="row">
							<div class="col-lg-12">
							    <label>Content</label>
							    <textarea class="form-control" style="resize: none;" rows="5" name="content" readonly>${ bvo.content }</textarea>
						    </div>
						</div>
						<div class="row">
							<div class="col-lg-12">
							    <label>Writer</label>
							    <input class="form-control" name="writer" value="${ bvo.writer }" readonly>
						    </div>
						</div>
						<p></p>
						<form class="form-group" action="/board/modify">
							<input type="hidden" name="bno" value="${ bvo.bno }">
							<button class="btn btn-info" data-oper="modify">Modify</button>
							<button class="btn btn-primary" data-oper="list" formaction="/board/list">List</button>
							<input type="hidden" name="pageNum" value="${ criteria.pageNum }">
							<input type="hidden" name="amount" value="${ criteria.amount }">
							<input type="hidden" name="keyword" value="${ criteria.keyword }">
							<input type="hidden" name="type" value="${ criteria.type }">
						</form>
	                </div>
	                <!-- /.panel-body -->
	            </div>
	            <!-- /.panel -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	    <div class="chat-panel panel panel-default">
	        <div class="panel-heading">
	            <i class="fa fa-comments fa-fw"></i> Reply
	            <div class="chat-body clearfix">
            		<p>
            			<div class="row">
		            		<div class="col-md-4">
		            		<textarea class="form-control input-sm" rows="3" id="reply" name="reply" placeholder="reply" style="resize: none;"></textarea>
		            		</div>
		            		<div class="col-md-4">
				                <input id="replyer" name="replyer" type="text" class="form-control input-sm" placeholder="name" />
		            		</div>
		            		<div class="col-md-4 pull-right">
				            	<button class="btn btn-info btn-sm" id="replyRegBtn" type="button">register</button>
		            		</div>
	            		</div>
	            	</p>
	            </div>
	        </div>
	        <!-- /.panel-heading -->
	        <div class="panel-body">
	            <ul class="chat" id="replyList">
	                <li>
	                    <div class="chat-body clearfix">
	                        <div class="header">
	                            <strong class="primary-font">replyer</strong>
	                            <small class="pull-right text-muted">
	                                <i class="fa fa-clock-o fa-fw"></i> date
	                            </small>
	                        </div>
	                        <p>
	                            reply
	                        </p>
	                        <div class="footer">
	                        	<small class="pull-right text-muted">
	                                <button class="btn btn-warning btn-xs">수정</button>
	                                <button class="btn btn-danger btn-xs">삭제</button>
	                            </small>
	                        </div>
	                    </div>
	                </li>
	            </ul>
	        </div>
	        <!-- /.panel-body -->
	        <div class="panel-footer">
	        	<div class="row text-center">
					<ul class="pagination">
						<li class="page-item">
						<!-- previous -->
						<%-- <c:if test=""> --%>
							<a class="page-link" href="" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
							</a>
						<%-- </c:if> --%>
						</li>
						<!-- page -->
						<c:forEach  begin="1" end="3" var="i" varStatus="vs">
							<li class="page-item ">
								<a class="page-link" href="#">${ i }</a>
							</li>
						</c:forEach>
						<!-- next -->
						<%-- <c:if test=""> --%>
							<li class="page-item">
								<a class="page-link" href="" aria-label="Next">
									<span aria-hidden="true">&raquo;</span>
									<span class="sr-only">Next</span>
								</a>
							</li>
						<%-- </c:if> --%>
					</ul>
				</div>
	        </div>
	    </div>
	    <!-- /.panel .chat-panel -->
	</div>
	<!-- /#page-wrapper -->
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

<jsp:include page="../include/footer.jsp"/>
<script src="/resources/js/reply.js"></script>
<script>
	var bnoVal = '${ bvo.bno }'
	console.log(replyService);
	// 댓글 등록 테스트
	/* replyService.register(
		{
		  "bno": bnoVal,
		  "reply": "replyService.register",
		  "replyer": "tester",
		},
		function (result) {
			alert('댓글이 등록되었습니다.');
		}
	); */
	$('#replyRegBtn').on('click', function() {
		var reply = $('#reply');
		var replyer = $('#replyer');
		if (reply.val().trim() != '' && replyer.val().trim() != '') {
			replyService.register(
				{
				  bno : bnoVal,
				  reply : reply.val(),
				  replyer : replyer.val(),
				},
				function (result) {
					$('#modalBody').text('댓글이 등록되었습니다.');
					$("#myModal").modal('show');
					reply.val('');
					replyer.val('');
					list();
				}
			);
		} else {
			$('#modalBody').text('입력 항목을 모두 입력해 주세요.');
			$("#myModal").modal('show');
		}
	});
	
	list();
	// 댓글 목록 가져오기 테스트
	function list() {
	replyService.list(
		{
		  bno: bnoVal,
		  pageNum : 1
		},
		function (result) {
			$('#replyList').empty();
			for (var i = 0; i < result.length; i++) {
				console.log(result[i]);
				$('#replyList').append(
				'<li>'
				    +'<div class="chat-body clearfix">'
				    +'<div class="header">'
				        +'<strong class="primary-font">'+ result[i].replyer +'</strong>'
				        +'<small class="pull-right text-muted">'
				            +'<i class="fa fa-clock-o fa-fw"></i> '+ result[i].regDate
				        +'</small>'
				    +'</div>'
				    +'<p>'
				    	+ result[i].reply
				    +'</p>'
				    +'<div class="footer">'
				    	+'<small class="pull-right text-muted">'
				            +'<button class="btn btn-warning btn-xs">수정</button>'
				            +'<button class="btn btn-danger btn-xs">삭제</button>'
				        +'</small>'
				    +'</div>'
				+'</div>'
				+'</li>');
			}
		}
	);
	}
	// 댓글 수정 테스트
	/* replyService.modify(
		{
		  rno: 9,
		  reply: "replyService.modify"
		},
		function (result) {
			alert('댓글이 수정되었습니다.');
		}
	); */
	
	// 댓글 삭제 테스트
	/* replyService.remove(
		53,
		function (result) {
			alert('댓글이 삭제되었습니다.');
		}
	); */
	
	// 댓글 하나 테스트
	/* replyService.view(
		54,
		function (result) {
			alert('댓글 보기 : ' + result);
			console.log(result);
		}
	); */
	
	
</script>
</body>
</html>