<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("data", "<em>1234</em>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core.jsp</title>
</head>
<body>
	<h3>JSTL ; JSP Standard Tag Library</h3>
	<c:out value="Hello World~!"/>
	<hr>
	${ data } <br>
	<c:out value="${ data }" default="no data"/> <br>
	<c:out value="${ data }" escapeXml="true"/> <br>
	<c:out value="${ data }" escapeXml="false"/> <br>
	<hr>
	<h3>변수 설정 및 사용</h3>
	<c:set var="x" value="7"/>
	<c:set var="y" value="8"/>
	x = ${ x } <br>
	y = ${ y } <br>
	
	<jsp:useBean id="tb" class="jspz.bean.testBean"/>
	<jsp:setProperty property="country" name="tb" value="korea"/>
	
	<jsp:getProperty property="country" name="tb"/>
	<jsp:getProperty property="city" name="tb"/>
	<jsp:getProperty property="name" name="tb"/> <br>
	
	<c:set target="<%= tb %>" property="city" value="seoul"/>
	<c:set target="${ tb }" property="name" value="kim"/>
	<c:out value="${ tb.country }"/>
	<c:out value="${ tb.city }"/>
	<c:out value="${ tb.name }"/> <br>
	
	<hr>
	
	<h3>Map 사용</h3>
	<jsp:useBean id="map" class="java.util.HashMap"/>
	<c:set target="${ map }" property="key" value="HashMap Object"/>
	<c:out value="${ map.key }"/>
	
	<hr>
	
	<h3>Defered Expression</h3>
	<c:set var="m" value="${ map }"/>
	<c:set var="fontColor" value="${ m.fontColor }" />
	fontColor : <c:out value="${ fontColor }"/> <br>
	<c:set var="bgColor" value="#{ m.bgColor }" />
	bgColor : <c:out value="${ bgColor }"/> <br>
	
	<c:set target="${ m }" property="fontColor" value="yellow" />
	<c:set target="${ m }" property="bgColor" value="green" />
	fontColor : <c:out value="${ fontColor }"/> <br>
	bgColor : <c:out value="${ bgColor }"/> <br>
	<c:out value="${ map }"/>
	
	<hr>
	
	<h3>변수 제거</h3>
	x = ${ x } <br>
	y = ${ y } <br>
	제거 후 <br>
	<c:remove var="x"/>
	<c:remove var="y"/>
	x = ${ x } <br>
	y = ${ y } <br>
	
	<hr>
	<h3>if</h3>
	<c:set var="num1" value="5"/>
	<c:set var="num2" value="3"/>
	<c:out value="${ num1 == num2 ? true : false }"/> <br>
	
	<c:if test="${ num1 == num2 }">true</c:if>
	<c:if test="${ num1 != num2 }">false</c:if> <br>
	
	<c:if test="${ sid == null}">
		로그인 후 이용해 주세요.
	</c:if>
	
	<hr>
	<% session.setAttribute("sid", "admin"); %>
	<% session.invalidate(); %>
	<h3>choose - when - otherwise</h3>
	<c:choose>
		<c:when test="${ sid == null }">
			로그인 후 이용해 주세요.
		</c:when>
		<c:when test="${ sid == 'admin' }">
			관리자 로그인 중
		</c:when>
		<c:otherwise>
			회원 로그인 중
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<h3>forEach</h3>
	<c:forEach begin="1" end="5" var="i" step="2">
		${ i } : hello <br>
	</c:forEach>
	<%
		String[] colors = {"red", "green", "blue"}; 
		pageContext.setAttribute("colors", colors);
	%>
	<c:forEach items="${ colors }" var="i">
		${ i } <br>
	</c:forEach>
	<c:forEach items="${ colors }" var="i" varStatus="vs">
		${ vs.index } : ${ vs.count } : ${ i } <br>
	</c:forEach>
	
	<hr>
	
	<h3>forTokens</h3>
	<c:forTokens items="&&,||,!,==,!=,<;>;~;#;" var="op" delims=",">
		${ op } <br>
	</c:forTokens>
	<c:forTokens items="&&,||,!,==,!=,<;>;~;#;" var="op" delims=", ;">
		${ op } <br>
	</c:forTokens>
	
	<hr>
	
	<h3>import</h3>
	<%-- <c:import url="../basic/top.jsp"/>
	<c:import url="../basic/menu.jsp">
		<c:param name="newMenu" value="blue ocean"></c:param><!-- 파라미터 값 전송 -->
	</c:import> --%>
	
	<hr>
	
	<h3>url</h3>
	<%-- <c:url var="naver" value="https://search.naver.com/search.naver">
		<c:param name="where" value="nexearch"></c:param>
		<c:param name="query" value="bbb"></c:param>
	</c:url> --%>
	<%-- <a href="${ naver }" target="_blank">네이버에서 bbb 검색</a> --%>
	
	<hr>
	
	<h3>catch</h3>
	<c:catch var="e">
		<c:set var="num1" value="O"/>
		<c:out value="${ num1 / 3 }"></c:out>
	</c:catch>
	<c:out value="${ e }"></c:out> <br>
	<c:out value="${ e.message }"></c:out> <br>
	
	<br>
	
	<h3>redirect</h3>
	<c:redirect url="../basic/menu.jsp" >
		<c:param name="newMenu" value="red ocean"></c:param>
	</c:redirect>
	
</body>
</html>