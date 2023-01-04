<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxAction.jsp</title>
<style>
.uploadResult { width:100%; background:lightgray; }
.uploadResult ul { display:flex; flex-flow:row; justify-content:center; align-items:center; }
.uploadResult { width:100%; background:lightgray; }
.uploadResult ul { display:flex; flex-flow:row; justify-content:center; align-items:center; }
.uploadResult ul li { list-style: none; padding: 10px; text-align: center; }
.uploadResult ul li img { width:100px; }

.originImgDiv { position:absolute; display:none; justify-content: center; align-items: center;
				top:0%;	z-index:100; width:100%; height:100%; backgroud:gray; }
.originImg { position:relative; display:flex; justify-content: center; align-items: center; }
.originImg img { width:500px; }
</style>
</head>
<body>
	<h3> Files Upload With Ajax</h3>
	<div class="uploadDiv">
		<input type="file" name="files" multiple>
		<hr>
		<button id="uploadBtn">upload</button>
	</div>
	<hr>
	
	<!-- 업로드 결과 썸네일 표시 -->
	<div class="uploadResult">
		<ul></ul>
	</div>
	
	<!-- 썸네일 이미지 원본 표시 -->
	<div class="originImgDiv">
		<div class="originImg"></div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
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
	
	document.querySelector('#uploadBtn').addEventListener('click', function() {
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
		})
	})
	
	// 업로드 결과 출력
	var resultUL = document.querySelector('.uploadResult ul');
	function showUploadedFile(result) {
		var liTag = '';
		for (var i = 0; i < result.length; i++) {
			var fid = result[i].fileName.replace('.', '').replace(' ', '');
			if(result[i].image) {
				/* liTag += '<li><img src="/resources/img/attach.png"><br>' + result[i].fileName + '</li>'; */
				var originImgFnm = result[i].upFolder + "/" + result[i].uuid + "_" + result[i].fileName;
				var imgFnm = result[i].upFolder + "/s_" + result[i].uuid + "_" + result[i].fileName;
				var originImg = encodeURIComponent(originImgFnm);
				//originImg = originImg.replaceAll('\\', '/');
				var thumbImg = encodeURIComponent(imgFnm);
				liTag += '<li id='+ fid + '>' 
						+ '<img src="/display?fileName=' + thumbImg 
								+ '" onclick="showOriginal(\''+ originImg + '\')"><br>' 
								+ result[i].fileName 
								+ ' <button type="button" onclick="removeFile(\'' + thumbImg + '\', \'image\', \'' + fid + '\')">X</button>'
								+ '</li>';
			} else {
				var fileFnm = result[i].upFolder + "/" + result[i].uuid + "_" + result[i].fileName;
				var dlFile = encodeURIComponent(fileFnm);
				liTag += '<li id='+ fid + '>' 
						+ '<a href="/download?fileName='+ dlFile +'">'
						+'<img src="/resources/img/attach.png"/><br>'+ result[i].fileName
						+ '</a> <button type="button" onclick="removeFile(\'' + dlFile + '\', \'file\', \'' + fid + '\')">X</button>'
						+'</li>';
			}
			resultUL.innerHTML += liTag;
			liTag = '';
		}
	}
	
	function removeFile(fileName, type, fid) {
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
				document.getElementById(fid).remove();
			}
		})
	}
	
	function hideOriginal() {
		document.querySelector('.originImg').innerHTML = '';
		document.querySelector('.originImgDiv').style.setProperty('display', 'none');
	}
	
	// 썸네일 원본 이미지 표시
	function showOriginal(originImg) {
		document.querySelector('.originImg').innerHTML = '<img src="/display?fileName='
				+ originImg + '" onclick="hideOriginal()"/>';
		document.querySelector('.originImgDiv').style.setProperty('display', 'block');
	}
</script>
</body>
</html>