<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <% request.setCharacterEncoding("UTF-8"); %>
 <fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt.jsp</title>
</head>
<body>
	<h3>jstl formatting</h3>
	<% Locale locale = request.getLocale(); %>
	country : <%= locale.getCountry() %> <br>
	display country : <%= locale.getDisplayCountry() %> <br>
	language : <%= locale.getLanguage() %> <br>
	display language : <%= locale.getDisplayLanguage() %> <br>
	<hr>
	change locale UK <% locale = Locale.UK; %> <br>
	country : <%= locale.getCountry() %> <br>
	display country : <%= locale.getDisplayCountry() %> <br>
	language : <%= locale.getLanguage() %> <br>
	display language : <%= locale.getDisplayLanguage() %> <br>
	<hr>
	change locale JP <% locale = Locale.JAPAN; %> <br>
	country : <%= locale.getCountry() %> <br>
	display country : <%= locale.getDisplayCountry() %> <br>
	language : <%= locale.getLanguage() %> <br>
	display language : <%= locale.getDisplayLanguage() %> <br>
	
	<hr>
	<% 
		response.setHeader("Content-Language", "en"); 
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	%>
	<%= sdf.format(date) %> <br>
	
	<hr>
	<h2>문자열 - 날짜</h2>
	<c:set var="d" value="<%= new Date() %>"/>
	<h3>fmt</h3>
	<fmt:formatDate value="${ d }"/> <br>
	<fmt:formatDate value="${ d }" type="date"/> <br>
	<fmt:formatDate value="${ d }" type="time"/> <br>
	<fmt:formatDate value="${ d }" type="both"/> <br>
	
	<hr>
	<h3>dateStyle</h3>
	<h5>date</h5>
	<fmt:formatDate value="${ d }" type="date" dateStyle="short"/> <br>
	<fmt:formatDate value="${ d }" type="date" dateStyle="medium"/> <br>
	<fmt:formatDate value="${ d }" type="date" dateStyle="long"/> <br>
	<fmt:formatDate value="${ d }" type="date" dateStyle="full"/> <br>
	<hr>
	<h5>time</h5>
	<fmt:formatDate value="${ d }" type="time" timeStyle="short"/> <br>
	<fmt:formatDate value="${ d }" type="time" timeStyle="medium"/> <br>
	<fmt:formatDate value="${ d }" type="time" timeStyle="long"/> <br>
	<fmt:formatDate value="${ d }" type="time" timeStyle="full"/> <br>
	<hr>
	<h5>both</h5>
	<fmt:formatDate value="${ d }" type="both" dateStyle="short" timeStyle="short"/> <br>
	<fmt:formatDate value="${ d }" type="both" dateStyle="medium" timeStyle="medium"/> <br>
	<fmt:formatDate value="${ d }" type="both" dateStyle="long" timeStyle="long"/> <br>
	<fmt:formatDate value="${ d }" type="both" dateStyle="full" timeStyle="full"/> <br>
	<hr>
	<h3>pattern</h3>
	<fmt:formatDate value="${ d }" type="date" pattern="yyyy/MM/dd"/> <br>
	<fmt:formatDate value="${ d }" type="date" pattern="yyyy/MM/dd (E)"/> <br>
	<fmt:formatDate value="${ d }" type="time" pattern="hh:mm:ss"/> <br>
	<fmt:formatDate value="${ d }" type="time" pattern="(a) hh:mm:ss"/> <br>
	
	<hr>
	<h3>parseDate</h3>
	<%-- <c:set var="str" value="20221213001122"/>
	<fmt:parseDate value="${ str }" pattern="yyyyMMddhhmmss"/> --%>
	
	<hr>
	<h3>timezone</h3>
	<fmt:timeZone value="Europe/London">
		<fmt:formatDate value="${ d }" type="both" dateStyle="full" timeStyle="full"/> <br>
	</fmt:timeZone>
	<fmt:setTimeZone value="America/New_York"/>
	<fmt:formatDate value="${ d }" type="both" dateStyle="full" timeStyle="full"/> <br>
	
	<h2>문자열 - 숫자</h2>
	<c:set var="num" value="123456789.09876"/> 
	<fmt:formatNumber value="${ num }"/> <br>
	<fmt:formatNumber value="${ num }" type="number"/> <br>
	<fmt:formatNumber value="0.1" type="percent"/> <br>
	<fmt:formatNumber value="${ num }" type="currency"/> <br> <!-- 엣지에서 원 표시 안됨 -->
	<fmt:formatNumber value="${ num }" type="currency" currencySymbol="$"/> <br>
	<fmt:formatNumber value="${ num }" pattern="#,###.##"/> <br>
	<fmt:formatNumber value="${ num }" pattern="#,###.##"/> <br>
	<fmt:formatNumber value="${ num }" pattern="0,000.00"/> <br>
	
	<fmt:parseNumber var="f" value="123.456"/>
	<fmt:parseNumber var="i" value="123.456" integerOnly="true"/>
	
	<hr>
	
	msg 파라미터의 값 : <%= request.getParameter("msg") %>
</body>
</html>