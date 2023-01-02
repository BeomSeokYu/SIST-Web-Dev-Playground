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
	        <div class="col-lg-offset-3 col-lg-6">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    Board View Page
	                </div>
	                <div class="panel-body">
                    	<div class="row">
							<span class="text-left col-xs-6">
							       <label>#No</label>
							</span>
							<span class="text-right col-xs-6">
						      	<span>작성일 : <fmt:formatDate value="${ bvo.regDate }" pattern="yyyy.MM.dd (E)"/></span>
							</span>
						</div>
						<div class="">
					      	<input class="form-control" name="bno" value="${ bvo.bno }" readonly>
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
			    <div class="chat-panel panel panel-default">
			        <div class="panel-heading">
			            <i class="fa fa-comments fa-fw"></i> Reply <span class="badge bg-warning pull-right" id="replyCntBadge">총 댓글 수 : ${ bvo.replyCnt }</span>
			            <div class="chat-body clearfix">
		            		<div>
		            			<p></p>
			            		<textarea class="form-control input-sm" rows="3" id="reply" name="reply" placeholder="reply" style="resize: none;"></textarea>
					            <input id="replyer" name="replyer" type="text" class="form-control input-sm" placeholder="name" />
					            <div class="pull-right">
					            	<p></p>
					            	<button class="btn btn-info btn-sm" id="regBtn" type="button">register</button>
					            </div>
			            	</div>
			            </div>
			        </div>
			        <!-- /.panel-heading -->
			        <div class="panel-body">
			            <ul class="chat" id="replyList">
			                <li data-rno="11" id="list11">
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
							<ul class="pagination" id="pageUl">
								<li class="page-item">
								<!-- previous -->
								<%-- <c:if test=""> --%>
									<a class="page-link" onclick="" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previosus</span>
									</a>
								<%-- </c:if> --%>
								</li>
								<!-- page -->
								<c:forEach  begin="1" end="5" var="i" varStatus="vs">
									<li class="page-item ">
										<a class="page-link" onclick="">${ i }</a>
									</li>
								</c:forEach>
								<!-- next -->
								<%-- <c:if test=""> --%>
									<li class="page-item">
										<a class="page-link" onclick="" aria-label="Next">
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
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
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
	<!-- Modal -->
	<div class="modal fade" id="delModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel"> 삭제</h4>
	            </div>
	            <div class="modal-body" id="modalBody">
	                정말로 삭제하시겠습니까?.
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-danger" id="modalDelBtn">삭제</button>
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
	var bnoVal = '${ bvo.bno }';
	console.log(replyService);
	
	
	// 댓글 등록 처리
	$('#regBtn').on('click', function() {
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
					replyCount(bnoVal);
					makeList(-1);						
				}
			);
		} else {
			$('#modalBody').text('입력 항목을 모두 입력해 주세요.');
			$("#myModal").modal('show');
		}
	});
	
	makeList(1);
	// 댓글 목록 출력 함수
	function makeList(pageNumVal) {
		replyService.list(
			{
			  bno: bnoVal,
			  pageNum : pageNumVal
			},
			function (result) {
				// 페이징 처리
				if(pageNumVal > 0) {
					setPaginationObj(pageNumVal, result.totalReply);
					makePagination(pageNumVal, result.totalReply);
				}
				
				// 등록 마지막 페이지 이동 처리
				if(pageNumVal == -1) {
					makeList(Math.ceil(result.totalReply / 4));
					return;
				}
				
				// 삭제 페이지 이동 처리
				if(pageNumVal == -2) {
					var lastPage = Math.ceil(result.totalReply / 4);
					if(result.totalReply % 4 == 0 && lastPage < replyPageObj.page) {
						makeList(replyPageObj.page - 1);
					} else {
						makeList(replyPageObj.page);
					}
					return;
				}
				
				$('#replyList').empty();
				for (var i = 0; i < result.list.length; i++) {
					console.log(result.list[i]);
					$('#replyList').append(
					'<li data-rno="'+ result.list[i].rno +'" id="list'+ result.list[i].rno +'">'
					    +'<div class="chat-body clearfix">'
					    +'<div class="header">'
					        +'<strong class="primary-font">'+ result.list[i].replyer +'</strong>'
					        +'<small class="pull-right text-muted">'
					            +'<i class="fa fa-clock-o fa-fw"></i> '
					            + (result.list[i].updateDate == null 
					            		? getFormatDate(new Date(result.list[i].regDate)) 
					            		: getFormatDate(new Date(result.list[i].regDate)) + ' 수정됨')
					        +'</small>'
					    +'</div>'
					    +'<p>'
					    	+ result.list[i].reply
					    +'</p>'
					    +'<div class="footer">'
					    	+'<small class="pull-right text-muted btnGroup" id="btnGroup">'
					            +'<button class="btn btn-default btn-xs" onclick="modifyReplyFrm('+ result.list[i].rno +')">수정</button>'
					            +'<button class="btn btn-danger btn-xs" onclick="removeModal('+ result.list[i].rno +')">삭제</button>'
					        +'</small>'
					    +'</div>'
					+'</div>'
					+'</li>');
				}
			}
		);
	}
	
	// 댓글 page 객체
	var replyPageObj = {
		numPerPage : 5.0,
		start : 1,
		end : 1,
		page : 1,
		previous : false,
		next : false
	}
	// 이전 버튼 처리 함수
	function prePage() {
		replyPageObj.start = replyPageObj.start - 1;
		makeList(replyPageObj.start);
	}
	// 다음 버튼 처리 함수
	function nextPage() {
		replyPageObj.end = replyPageObj.end + 1;
		makeList(replyPageObj.end);
	}
	// pagination을 그리는 함수
	function makePagination(pageNumVal, totalReply) {
		console.log(replyPageObj);
		var ul = $('#pageUl');
		console.log(ul);
		var pre = replyPageObj.previous ?
			'<li class="page-item">'
				+'<a class="page-link" onclick="prePage()" aria-label="Previous">'
					+'<span aria-hidden="true">&laquo;</span>'
					+'<span class="sr-only">Previosus</span>'
				+'</a>'
			+'</li>'
			: '';
		var page = '';
		for (var i = replyPageObj.start; i <= replyPageObj.end; i++) {
			page = page
				+'<li class="page-item ' + (pageNumVal == i ? 'active' : '') + '">'
					+'<a class="page-link" onclick="makeList('+i+')">'+i+'</a>'
				+'</li>';
		}
		var next = replyPageObj.next ?
				'<li class="page-item">'
					+'<a class="page-link" onclick="nextPage()" aria-label="Next">'
						+'<span aria-hidden="true">&raquo;</span>'
						+'<span class="sr-only">Next</span>'
					+'</a>'
				+'</li>'
				: '';
		ul.empty()
		.append(pre + page + next);
	}
	// page 객체를 설정하는 함수
	function setPaginationObj(pageNumVal, totalReply) {
		var amount = 4;
		var pageNum = pageNumVal;
		
		replyPageObj.page = pageNumVal;			
		
		var pages = Math.ceil(totalReply / amount);
		
		replyPageObj.end = (Math.ceil(pageNum / replyPageObj.numPerPage) * replyPageObj.numPerPage);
		replyPageObj.start = (replyPageObj.end - (replyPageObj.numPerPage - 1));
		replyPageObj.end = replyPageObj.end >= pages ? pages : replyPageObj.end;	// 실제 끝 페이지 번호 확인

		replyPageObj.previous = replyPageObj.start > 1;
		replyPageObj.next = replyPageObj.end < pages;
	}
	// 댓글 날짜 포매팅 함수
	function getFormatDate(date){
	    var year = date.getFullYear();              
	    var month = (1 + date.getMonth());          
	    var day = date.getDate();                   
	    var h = date.getHours();
	    var m = date.getMinutes();
	    
	    var today = new Date();
	    var isToday = 	today.getFullYear() === year
	    				&& (1 + today.getMonth()) === month
	    				&& today.getDate() === day;
	    
	    month = month >= 10 ? month : '0' + month;  
	    day = day >= 10 ? day : '0' + day;          
	    h = h >= 10 ? h : '0' + h;
	    m = m >= 10 ? m : '0' + m;
	    
	    if(isToday) {
	    	return h + ':' + m;	    	
	    }
	    return  year + '-' + month + '-' + day;
	}
	// 댓글 수정 폼을 그리는 함수
	function modifyReplyFrm(rno) {
		var val = $('#list'+rno+' p').text();
		$('#list'+rno+' p')
			.empty()
			.append(
				'<textarea class="form-control input-sm" rows="3" id="reply'+rno+'" style="resize: none;">'+val+'</textarea>'
			)
		$('.btnGroup')
			.empty()
			.append (
				'<p>ㅤ</p>'
			);
		$('#list'+rno).find("small[id='btnGroup']")
			.empty()
			.append (
				'<button class="btn btn-info btn-xs" onclick="modifyReply('+ rno +')">수정</button>'
				+ '<button class="btn btn-default btn-xs" onclick="makeList(replyPageObj.page)">취소</button>'
			);
	}
	// 댓글 수정 처리
	function modifyReply(rnoVal) {
		var replyVal = $('#reply'+rnoVal).val();
		replyService.modify(
			{
			  rno: rnoVal,
			  reply: replyVal
			},
			function (result) {
				$('#modalBody').text('댓글이 수정되었습니다.');
				$("#myModal").modal('show');
				makeList(replyPageObj.page);
			}
		);
	}
	// 삭제 처리를 위한 모달 띄우기
	function removeModal(rno) {
		$("#delModal").modal('show');
		$("#modalDelBtn").on('click', function() {
			removeReply(rno);
		});
	}
	// 삭제 처리
	function removeReply(rno) {
		replyService.remove(
			rno,
			function (result) {
				$('#modalBody').text('댓글이 삭제되었습니다.');
				$("#delModal").modal('hide');
				$("#myModal").modal('show');
				replyCount(bnoVal);
				makeList(-2);
			}
		);
	}
	
	function replyCount(bno) {
		replyService.replyCount(
			bno,
			function (result) {
				$('#replyCntBadge').text('총 댓글 수 : ' + result.replyCnt)
			}
		);
	}
	
	// 댓글 목록 테스트
	/* replyService.list(
		{
		  bno: bnoVal,
		  pageNum : 1
		},
		function (result) {
			$('#replyList').empty();
			for (var i = 0; i < result.length; i++) {
				console.log(result[i]);
			}
		}
	); */
	
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