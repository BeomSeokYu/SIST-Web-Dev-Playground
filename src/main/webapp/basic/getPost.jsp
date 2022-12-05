<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getPost.jsp</title>
</head>
<body>
	<h3>get vs. post</h3>
	<form action="/jspz/Hello.do" method="get">
		<label for="na">이름</label>
		<input type="text" name="name" id="na"> <br>
		<label for="ag">나이</label>
		<input type="text" name="age" id="ag">
		<button type="submit" value="GET">전송</button>
	</form>
	<form action="/jspz/Hello.do" method="post">
		<label for="na">이름</label>
		<input type="text" name="name" id="na"> <br>
		<label for="ag">나이</label>
		<input type="text" name="age" id="ag">
		<button type="submit" value="POST">전송</button>
	</form>
</body>
</html>