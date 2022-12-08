<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup.jsp</title>
<script>
	console.log(document.cookie);
	function setCookie() {
		document.cookie = "popup=pop; path=/; domain=localhost; max-age=60";
		window.close();
	}
</script>
</head>
<body>
	<h3>popup</h3>
	<input type="checkbox" id="pop" onclick="setCookie()" style="margin-top: 150px">
	<label for="pop">1분 동안 보지 않기</label>
	<input type="button" onclick="window.close()" value="[닫기]">
</body>
</html>