<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataType.jsp</title>
</head>
<body>
	<hr>
	<h3>El data type</h3>
	<br> ${ 12345 }
	<br> ${ 123.45 }
	<br> ${ true }
	<br> ${ "Hello" }
	<br> ${ 'Hello' }
	<br> ${ null }
	<hr>
	<h3>El operator</h3>
	<br> ${ 1 + 2 }
	<br> ${ "1" + 2 }
	<br> ${ "1" + '2' }
	<br> ${ "1" += '2' } <!-- 문자열로 결합 -->
	<br> ${ "1" += 2 }
	<br> ${ 5 / 2 }
	<%-- <br> ${ 5 div 2 } --%>
	<br> ${ 5 % 2 }
	<br> ${ 5 mod 2 }
	<br> ${ 5 == 2 }
	<br> ${ 5 eq 2 }
	<br> ${ 5 != 2 }
	<br> ${ 5 == 2 ? '같다' : '다르다' }
	<br> data is null : ${ data == null ? 'O' : 'X' }
	<br> data is empty : ${ empty data ? 'O' : 'X' }
	<br> ${ empty sessionScope.sid ? '로그인' : '로그아웃' }
	<br> ${ a=1; b=2; c=a+b }
	<br> ${ c }

	<hr>
	
<%
	String[] starArr = {"Sun", "Moon", "Earth"};
	List<String> starList = new ArrayList<>();
	starList.add("해");
	starList.add("달");
	starList.add("별");
	Map<String, String> starMap = new HashMap<>();
	starMap.put("one", "화성");
	starMap.put("two", "목성");
	starMap.put("sam", "토성");
	request.setAttribute("starArr", starArr);
	request.setAttribute("starList", starList);
	request.setAttribute("starMap", starMap);
%>
	<jsp:useBean id="tb" class="jspz.bean.testBean"/>
	<jsp:setProperty property="country" name="tb" value="korea"/>
	<jsp:setProperty property="city" name="tb" value="seoul"/>
	<jsp:setProperty property="name" name="tb" value="lee"/>
	
	<br> ${ starArr[0] }
	<br> ${ starArr[1] }
	<br> ${ starArr[2] }
	<br> ${ starList }
	<br> ${ starList[0] }
	<br> ${ starList[1] }
	<br> ${ starList[2] }
	<br> ${ starMap }
	<br> ${ starMap["one"] }
	<br> ${ starMap["two"] }
	<br> ${ starMap.sam }
	<br> ${ tb }
	<br> ${ tb["country"] }
	<br> ${ tb["city"] }
	<br> ${ tb.name }
	
	<hr>
	
	<h3>List 및 Map 객체 생성</h3>
	
	<br> ${ list = [3, 6, 9] } 		${ list[0] } 
	<br> ${ list = [3, 6, 9];'' } 	${ list[2] }
	
	<br> ${ map = {'a':'apple', 'b':'banana', 'c':'carrot'} }
	${ map['b'] } 
	<br> ${ map = {'a':'apple', 'b':'banana', 'c':'carrot'};'' }
	${ map.a }
</body>
</html>