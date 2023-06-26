<%@page import="jspz.bean.testBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBeanOutput.jsp</title>
</head>
<body>
	<h3>useBean action tag</h3>
	<!-- 스크립트릿으로 요청 객체의 tb1 속성 값 받아오기 -->
	<%	testBean tb1 =  (testBean) request.getAttribute("tb1"); %>
	출신 국가 : <%out.print(tb1.getCountry()); %> <br>
	출신 국가 : <%out.print(tb1.getCity()); %> <br>
	이름 : <%out.print(tb1.getName()); %>
	<hr>
	<!-- 액션 태그를 이용하여 testBean 클래스의 객체 tb2 생성 -->
	<jsp:useBean id="tb2" class="jspz.bean.testBean" scope="request"/>
	출신 국가 : <jsp:getProperty property="country" name="tb2"/> <br>
	출신 국가 : <jsp:getProperty property="city" name="tb2"/> <br>
	이름 : <jsp:getProperty property="name" name="tb2"/>
</body>
</html>