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
	<hr>
	<form action="/jspz/Hello.do" method="post">
		<label for="na">이름</label>
		<input type="text" name="name" id="na"> <br>
		<label for="ag">나이</label>
		<input type="text" name="age" id="ag">
		<button type="submit" value="POST">전송</button>
	</form>
	<hr>
	<form action="request.jsp" method="get">
		<label for="na">이름</label>
		<input type="text" name="name" id="na"> <br>
		<label for="ag">나이</label>
		<input type="text" name="age" id="ag"> <br>
		<label>성별</label>
		<input type="radio" name="gender" value="남" id="ma">
		<label for="ma">남</label>
		<input type="radio" name="gender" value="여" id="fe">
		<label for="fe">여</label> <br>
		<label>혈액형</label>
		<select name="type">
			<option value="O">O</option>
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="AB">AB</option>
		</select> <br>
		<input type="checkbox" name="season" value="봄" id="spr">
		<label for="spr">봄</label>
		<input type="checkbox" name="season" value="여름" id="sum">
		<label for="sum">여름</label>
		<input type="checkbox" name="season" value="가을" id="fal">
		<label for="fal">가을</label>
		<input type="checkbox" name="season" value="겨울" id="win">
		<label for="win">겨울</label> <br>
		<button type="submit" value="POST">전송</button>
	</form>
</body>
</html>