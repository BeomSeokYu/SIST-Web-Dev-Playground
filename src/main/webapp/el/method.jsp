<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jspz.bean.testBean"%>
<%@page import="jspz.basic.FindId"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>method.jsp</title>
</head>
<body>
	<h3>method call using EL</h3>
	<jsp:useBean id="fi" class="jspz.basic.FindId"></jsp:useBean>
	<br>
<%
	out.print(fi.findId(""));
%>
	<br> ${ fi.findId("123") }
	<br> ${ Math.random() }
	<br> ${ Math.max(1, 3) }
	
	<br> ${ result = (x, y) -> x > y ? true : false;'' }
	<br> ${ result(1, 2) }
	
	<hr>
	<h3>stream(), sum() using EL, lambda</h3>
	<br> ${ list = [1, 2, 3, 4, 5];'' }
	<br> ${ list.stream().sum() }
	<br> ${ map = {'a':5, 'b':10, 'c':15 };'' }
	<br> ${ map.entrySet().stream().map( e -> e.value ).toList().stream().sum() }
	
	<h3>stream() using EL, lambda</h3>
	<br> ${ list.stream().filter(n -> n%2==0).sum() }
	<br> ${ map.entrySet().stream().map( e -> e.value ).toList().stream().filter(n -> n%2==1).sum() }
	
	<hr>
<%
	testBean tb1 = new testBean("한국", "서울", "김씨");	
	testBean tb2 = new testBean("일본", "도쿄", "나카무라");	
	testBean tb3 = new testBean("중국", "베이징", "니하오");
	
	List<testBean> beanList = new ArrayList<>(Arrays.asList(tb1, tb2, tb3));
	request.setAttribute("beanList", beanList);
%>

	${ cities = beanList.stream().map( b -> b.city ).toList();'' }
	<br> ${ cities }
	${ cities = beanList.stream().map( b -> b.city ).filter( c -> c.equals("도쿄")).toList();'' }
	<br> ${ cities }
	${ cities = beanList.stream().filter( c -> c.getCity().equals("도쿄")).toList();'' }
	<br> ${ cities }
</body>
</html>