<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm.jsp</title>
</head>
<body>
	<h3>FILE UPLOAD with cos.jar</h3>
	
	<form action="uploadResult.jsp" method="post" enctype="multipart/form-data">
		<label for="usernm">이름</label>
		<input type="text" name="usernm" id="usernm"> <br>
		<input type="file" name="userfile" multiple> <br>
		<button type="submit">전송</button>
	</form>
</body>
</html>