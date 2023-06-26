<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/sample/uploadEX.jsp</title>
</head>
<body>
	<h3>FILE UPLOAD in SPRING</h3>
	<form action="/sample/uploadEX" method="post" enctype="multipart/form-data">
		<p><input type="file" name="files"/></p>
		<p><input type="file" name="files"/></p>
		<p><input type="file" name="files"/></p>
		<p><button type="submit">전송</button></p>
	</form>
</body>
</html>