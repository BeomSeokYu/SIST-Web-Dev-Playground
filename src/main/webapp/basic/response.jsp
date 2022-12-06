<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.jsp</title>
</head>
<body>
	<h3>내장 객체 response</h3>
	- 클라이언트에게 응답을 제공 <br>
	- 응답 헤더 성정 : setHeader( ) <br>
	- 다른 페이지로 리다이렉트 : sendRedirect( ) <br>
	- 쿠키 생성 및 추가 : addCookie( ) <br>
	<hr>
	<!-- 요청 객체의  code 속성에 1234를 저장하고 respunseNew.jsp로 forwarding -->
	<%-- <% request.setAttribute("code", 1234); %>
	<jsp:forward page="responseNew.jsp"/> --%>
	
	<!-- 요청 객체의  code 속성에 1234를 저장하고 respunseNew.jsp로 redirect -->
	<% 
	/* request.setAttribute("code", 1234); 
	response.sendRedirect("responseNew.jsp?code=1234"); */
	// Redirect로는 값을 넘길 수 없음, 뒤로가기도 할 수 없음, 쿼리 스트링으로는 파라미터로 꺼낼 수 있음.
	
	String keyward = "JSP프로그래밍";
	String url = "https://search.naver.com/search.naver?where=nexearch&query=";
	//keyward = URLEncoder.encode(keyward, "EUC-KR");
	keyward = URLEncoder.encode(keyward, "UTF-8");
	response.sendRedirect(url + keyward);
	%>
	
	
</body>
</html>