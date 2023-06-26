<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBeanInput.jsp</title>
</head>
<body>
	<form action="useBeanProc.jsp" method="get">
	<div>
		<label for="co">국가</label>
		<input type="text" name="country" id="co">
	</div>
	<div>
		<label for="ci">도시</label>
		<input type="text" name="city" id="ci">
	</div>
	<div>
		<label for="na">이름</label>
		<input type="text" name="name" id="na">
	</div>
	<hr>
	<input type="submit" value="전송">
	</form>
</body>
</html>