<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formAction.jsp</title>
</head>
<body>
	<h3> Files Upload </h3>
	<form action="/upload/formAction" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple>
		<hr>
		<button>upload</button>
	</form>
</body>
</html>