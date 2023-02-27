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
															<li id="${ list.uuid }" data-uuid="${ list.uuid }" data-upFolder="${ list.upFolder }" data-fileName ="${ list.fileName }" data-image ="${ list.image == 'Y' ? 'true' : 'false' }">
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
	//파일 종류(exe, sh, zip) 및 크기 (5MB) 제한
	var regex = new RegExp('(.*?)\.(exe|sh|zip|alz)$');
	var maxSize = 5242880;
	
	// 업로드 제한 확인
	function uploadCheck(fileName, fileSize) {
		if (regex.test(fileName)) {
			alert('해당 형식의 파일은 업로드 하실 수 없습니다.');
			return false;
		}
	
		if (fileSize >= maxSize) {
			alert('업로드 허용 크기 (5MB) 초과 - 업로드 불가');
			return false;
		}
		return true;
	}

	var DelObj = function(fileName, type, uuid){
		this.fileName = fileName;
		this.type = type;
		this.uuid = uuid;
	};
	
	var delObjs = new Array();

	$('#rmBtn').click(function () {
		if(window.confirm('정말로 삭제하시겠습니까?')) {
			$('#modifyForm').attr('action', '/board/remove');
			$('#pageNum').val('1');
			$('#modifyForm').submit();
		}
	});
	
	$('#modBtn').click(function () {
		
		var lis = $('.uploadResult ul li');
		for (let i = 0; i < lis.length; i++){
			// 전송할 데이터 담기
			var liTag = '<input type="hidden" name="attachList['+i+'].uuid" value="'+lis[i].getAttribute("data-uuid")+'">'
			+ '<input type="hidden" name="attachList['+i+'].upFolder" value="'+lis[i].getAttribute("data-upFolder").replaceAll("\\", "/")+'">'
			+ '<input type="hidden" name="attachList['+i+'].fileName" value="'+lis[i].getAttribute("data-fileName")+'">'
			+ '<input type="hidden" name="attachList['+i+'].image" value="'+ (lis[i].getAttribute("data-image") == "true" ? "Y" : "N") +'">'	
			lis[i].innerHTML += liTag;
		}
		
		for (var i = 0; i < delObjs.length; i++) {
			removeFile(delObjs[i].fileName, delObjs[i].type, delObjs[i].uuid);
		}
		$('#modifyForm').attr('action', '/board/modify')
						.submit();
	});
	
	// 제거될 파일 처리
	function checkRemoveFile(th, fileName, type, uuid) {
		delObjs.push(new DelObj(fileName, type, uuid));
		console.log(delObjs);
		$(th).hide();
		$('#'+uuid).remove();
	};
	
	// 업로드 처리
	document.querySelector('#upInput').addEventListener('change', function() {
		var formData = new FormData();	// form처럼 키/값으로 값 생성 가능
		var files = document.getElementsByName('files')[0].files;
		console.log(files);
		
		//formData 객체에 파일 추가
		for(var i = 0; i < files.length; i++) {
			if (uploadCheck(files[i].name, files[i].size)) {
				formData.append("files", files[i]);
			}
		}
		
		$.ajax({
			type : 'post',
			url : '/upload/ajaxAction',
			data : formData,
			dataType : "json",
			contentType : false,
			processData : false,
			success : function(result) {
				console.log('upload ok!');
				console.log(result);
				// 업로드 파일 선택 초기화
				document.querySelector('input[type="file"]').value = '';
				
				showUploadedFile(result);
			}
		});
	});
	
	// 업로드 결과 출력
	var resultUL = document.querySelector('.uploadResult ul');
	function showUploadedFile(result) {
		var lis = document.querySelectorAll('.uploadResult > ul > li')
		var liTag = '';
		for (let i = 0; i < result.length; i++) {
			liTag += '<li id='+ result[i].uuid
				+ '" data-uuid="'+result[i].uuid+'" data-upFolder="'+result[i].upFolder+'" data-fileName ="'+result[i].fileName+'" data-image ="'+result[i].image+'">'
			if(result[i].image) {
				/* liTag += '<li><img src="/resources/img/attach.png"><br>' + result[i].fileName + '</li>'; */
				var originImgFnm = result[i].upFolder + "/" + result[i].uuid + "_" + result[i].fileName;
				var imgFnm = result[i].upFolder + "/s_" + result[i].uuid + "_" + result[i].fileName;
				var originImg = encodeURIComponent(originImgFnm);
				//originImg = originImg.replaceAll('\\', '/');
				var thumbImg = encodeURIComponent(imgFnm);
					liTag += '<img src="/display?fileName=' + thumbImg
						+ '"><br>'
						+ result[i].fileName
						+ ' <button class="btn btn-info btn-xs" type="button" onclick="removeFile(\'' + thumbImg + '\', \'image\', \'' + result[i].uuid + '\')">X</button>'
			} else {
				var fileFnm = result[i].upFolder + "/" + result[i].uuid + "_" + result[i].fileName;
				var dlFile = encodeURIComponent(fileFnm);
					liTag += '<img src="/resources/img/attach.png"/><br>'+ result[i].fileName
						+ '<button class="btn btn-info btn-xs" type="button" onclick="removeFile(\'' + dlFile + '\', \'file\', \'' + result[i].uuid + '\')">X</button>'
			}
			// 전송할 이미지 데이터 담기
			liTag += '</li>';
			resultUL.innerHTML += liTag;
			liTag = '';
		}
	}
	
	function removeFile(fileName, type, uuid) {
		var formData = new FormData();	// form처럼 키/값으로 값 생성 가능
		formData.append("fileName", fileName);
		formData.append("type", type);
		formData.append("uuid", uuid);
		// 업로드 파일 삭제
		$.ajax({
			type : 'post',
			url : '/deleteFile',
			data : formData,
			dataType : "text",
			contentType : false,
			processData : false,
			success : function(result) {
				console.log(result);
				//document.getElementById(uuid).remove();
			}
		})
	}
</script>
</body>
</html>