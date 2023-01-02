<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxAction.jsp</title>

</head>

<body>
	<h3> Files Upload With Ajax</h3>
	<div class="uploadDiv">
		<input type="file" name="files" multiple>
		<hr>
		<button id="uploadBtn">upload</button>
	</div>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script>
	document.querySelector('#uploadBtn').addEventListener('click', function() {
		var formData = new FormData();	// form처럼 키/값으로 값 생성 가능
		var files = document.getElementsByName('files')[0].files;
		console.log(files);
		
		//formData 객체에 파일 추가
		for(var i = 0; i < files.length; i++) {
			formData.append("files", files[i]);$
		}
		
		$.ajax({
			type : 'post',
			url : '/upload/ajaxAction',
			data : formData,
			contentType : false,
			processData : false,
			success : function() {
				console.log('upload ok!');
			}
		})
	})
	/* #('#uploadBtn').on('click', function() {
		var formData = new formData();	// form처럼 키/값으로 값 생성 가능
		var files = $('input[name="files"]')[0].files;
		
		console.log(files);
	}); */
</script>
</body>
</html>