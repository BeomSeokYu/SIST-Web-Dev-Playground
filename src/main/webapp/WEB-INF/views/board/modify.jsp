<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp"/>
<body>
<jsp:include page="../include/navBar.jsp"/>
<body>
	<div id="page-wrapper">
	    <div class="row">
	        <div class="col-lg-12">
	            <h1 class="page-header">Board Modify</h1>
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	    <div class="row">
	        <div class="col-lg-12">
	            <div class="panel panel-default">
	                <div class="panel-heading">
	                    Board Modify Page
	                </div>
	                <div class="panel-body">
	                    <div class="row">
	                        <div class="col-lg-12">
	                            <form id="modifyForm" method="post">
	                            	<div class="row">
	                            		<span class="text-left col-lg-6">
	                                     <label>#No</label>
	                            		</span>
	                            		<span class="text-right col-lg-6">
	                            			<label>작성일 :</label>
	                                    	<span><fmt:formatDate value="${ bvo.regDate }" pattern="yyyy.MM.dd (E)"/></span>
	                            		</span>
	                            		<div class="col-lg-12">
	                                    	<input class="form-control" name="bno" value="${ bvo.bno }" readonly>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                	<div class="col-lg-12">
		                                    <label>Title</label>
		                                    <input class="form-control" name="title" value="${ bvo.title }">
	                                    </div>
	                                </div>
	                                <div class="row">
	                                	<div class="col-lg-12">
		                                    <label>Content</label>
		                                    <textarea class="form-control" rows="5" name="content">${ bvo.content }</textarea>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                	<div class="col-lg-12">
		                                    <label>Writer</label>
		                                    <input class="form-control" name="writer" value="${ bvo.writer }" readonly>
	                                    </div>
	                                </div>
	                                <p></p>
	                                <div class="row">
	                                	<div class="col-lg-12">
			                                <div class="panel panel-default">
	                                            <div class="panel-heading">
	                                                <strong>Attach File</strong>
	                                            </div>
	                                            <div class="panel-body">
	                                                <div class="uploadDiv">
	                                                    <input class="form-control" id="upInput" type="file" name="files" multiple>
	                                                </div>
	                                                <hr>
	                                                <!-- 업로드 결과 썸네일 표시 -->
	                                                <div class="uploadResult">
	                                                    <ul>
														<c:forEach var="list" items="${ bvo.attachList }" varStatus="vs">
															<li id="${ list.uuid }">
																<c:if test="${ list.image == 'Y' }">
																	<img src="/display?fileName=${ list.upFolder }/s_${ list.uuid }_${ list.fileName }"
																		 onclick="showOriginal('${ list.upFolder }/${ list.uuid }_${ list.fileName }')">
																	<br>${ list.fileName } 
																	<button class="btn btn-info btn-xs" type="button" onclick="checkRemoveFile(this, '${ list.upFolder }/s_${ list.uuid }_${ list.fileName }', 'image', '${ list.uuid }')">X</button>
																</c:if>
																<c:if test="${ list.image == 'N' }">
																	<a href="/download?fileName=${ list.upFolder }/${ list.uuid }_${ list.fileName }">
																		<img src="/resources/img/attach.png"/>
																		<br>${ list.fileName } 
																	</a>
																	<button class="btn btn-info btn-xs" type="button" onclick="checkRemoveFile(this, '${ list.upFolder }/${ list.uuid }_${ list.fileName }', 'file', '${ list.uuid }')">X</button>
																</c:if>
															</li>
														</c:forEach>
														</ul>
	                                                </div>
	                                            </div>
	                                        </div>
                                		</div>
                                	</div>
	                                <p></p>
	                                <div class="row">
	                                	<div class="col-lg-12">
			                                <button class="btn btn-danger" id="rmBtn" type="button">Remove</button>
			                                <button class="btn btn-info" data-oper="modify" id="modBtn" type="button">Modify</button>
											<button class="btn btn-primary" data-oper="list" formaction="/board/list" formmethod="get">List</button>
											<input type="hidden" name="pageNum" id="pageNum" value="${ criteria.pageNum }">
											<input type="hidden" name="amount" value="${ criteria.amount }">
											<input type="hidden" name="keyword" value="${ criteria.keyword }">
											<input type="hidden" name="type" value="${ criteria.type }">
		                                </div>
	                                </div>
	                            </form>
	                        </div>
	                        <!-- /.col-lg-6 (nested) -->
	                    </div>
	                    <!-- /.row (nested) -->
	                </div>
	                <!-- /.panel-body -->
	            </div>
	            <!-- /.panel -->
	        </div>
	        <!-- /.col-lg-12 -->
	    </div>
	    <!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

<jsp:include page="../include/footer.jsp"/>
<script>
	$('#rmBtn').click(function () {
		if(window.confirm('정말로 삭제하시겠습니까?')) {
			$('#modifyForm').attr('action', '/board/remove');
			$('#pageNum').val('1');
			$('#modifyForm').submit();
		}
	});
	
	$('#modBtn').click(function () {
		for (var i = 0; i < delObjs.length; i++) {
			removeFile(delObjs[i].fileName, delObjs[i].type, delObjs[i].uuid);
		}
		$('#modifyForm').attr('action', '/board/modify')
						.submit();
	});
	
	var DelObj = function(fileName, type, uuid){
		this.fileName = fileName;
		this.type = type;
		this.uuid = uuid;
	}
	var delObjs = new Array();
	
	function checkRemoveFile(th, fileName, type, uuid) {
		delObjs.push(new DelObj(fileName, type));
		console.log(delObjs);
		$(th).hide();
		$('#'+uuid+' *').css({opacity: '0.3'});
	};
	
	function removeFile(fileName, type, uuid) {
		var formData = new FormData();	// form처럼 키/값으로 값 생성 가능
		formData.append("fileName", fileName);
		formData.append("type", type);
		$.ajax({
			type : 'post',
			url : '/deleteFile',
			data : formData,
			dataType : "text",
			contentType : false,
			processData : false,
			success : function(result) {
				console.log(result);
				document.getElementById(uuid).remove();
			}
		})
	}
</script>
</body>
</html>