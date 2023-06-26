<%@page import="jspz.bean.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!-- 
driver = oracle.jdbc.OracleDriver
url = jdbc:oracle:thin:@localhost:1521:xe
username = madang
password = 1111 
-->
<jsp:useBean id="bvo" class="jspz.bean.BookVO"/>
<jsp:setProperty property="*" name="bvo"/>
<sql:setDataSource	var="dataSource"
					driver="oracle.jdbc.OracleDriver"
					url="jdbc:oracle:thin:@localhost:1521:xe"
					user="madang"
					password="1111" />
<sql:update var="rs" dataSource="${ dataSource }">
	INSERT INTO book VALUES(?, ?, ?, ?)
	<sql:param value="${ bvo.bookid }"></sql:param>
	<sql:param value="${ bvo.bookname }"></sql:param>
	<sql:param value="${ bvo.publisher }"></sql:param>
	<sql:param value="${ bvo.price }"></sql:param>
</sql:update>
<% session.setAttribute("msg", "책 등록 성공"); %>
<c:redirect url="sqlSelect.jsp"/>