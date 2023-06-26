<%@ page import="jspz.bean.testBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 스크립트릿 이용
	testBean tb1 = new testBean();
	tb1.setCountry(request.getParameter("country"));
	tb1.setCity(request.getParameter("city"));
	tb1.setName(request.getParameter("name"));
	request.setAttribute("tb1", tb1); // 요청객체의 tb1 속성에 tb1 객체 저장
	
	System.out.println(tb1);
	
%>
<!-- 2. 액션 태그 이용 -->
<jsp:useBean id="tb2" class="jspz.bean.testBean" scope="request"/>
<jsp:setProperty property="country" name="tb2"/>
<jsp:setProperty property="city" name="tb2"/>
<jsp:setProperty property="name" name="tb2"/>

<jsp:useBean id="tb3" class="jspz.bean.testBean"/>
<jsp:setProperty property="*" name="tb3"/>

<% System.out.println(tb2); %>
<% System.out.println(tb3); %>

<jsp:forward page="useBeanOutput.jsp"></jsp:forward>