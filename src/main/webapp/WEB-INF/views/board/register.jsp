<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<body>
<jsp:include page="../include/navBar.jsp"/>
<body>
	<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register Page
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form action="/board/register" method="post">
                                        <div class="form-group">
                                            <label>Title</label>
                                            <input class="form-control" name="title">
                                        </div>
                                        <div class="form-group">
                                            <label>Content</label>
                                            <textarea class="form-control" rows="5" name="content"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label>Writer</label>
                                            <input class="form-control" name="writer">
                                        </div>
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
                                                    <ul></ul>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="reset" class="btn btn-default">Reset</button>
                                        <button type="button" class="btn btn-info backBtn">Cancel</button>
                                        <button type="submit" class="btn btn-primary">Submit</button>
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
	// 파일 종류(exe, sh, zip) 및 크기 (5MB) 제한
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
	})
	
	// 업로드 결과 출력
	var resultUL = document.querySelector('.uploadResult ul');
	function showUploadedFile(result) {
		var liTag = '';
		for (let i = 0; i < result.length; i++) {
			liTag += '<li id='+ result[i].uuid + '>'
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
			liTag += '<input type="hidden" name="attachList['+i+'].uuid" value="'+result[i].uuid+'">'
			+ '<input type="hidden" name="attachList['+i+'].upFolder" value="'+result[i].upFolder.replaceAll("\\", "/")+'">'
			+ '<input type="hidden" name="attachList['+i+'].fileName" value="'+result[i].fileName+'">'
			+ '<input type="hidden" name="attachList['+i+'].image" value="'+ (result[i].image ? "Y":"N") +'">'
			+'</li>';
			resultUL.innerHTML += liTag;
			liTag = '';
		}
	}

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