<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Img Upload</title>
</head>
<body>
	<h3>이미지 파일 업로드</h3>
	<form action="/img/upload?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name"/> <br>
		사진 : <input type="file" name="files" accept="image/*" multiple/> <br>
		<button>전송</button>
	</form>
</body>
</html>