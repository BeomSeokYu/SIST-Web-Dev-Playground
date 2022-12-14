<%@page import="jspz.bean.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sqlSelect.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- 
driver = oracle.jdbc.OracleDriver
url = jdbc:oracle:thin:@localhost:1521:xe
username = madang
password = 1111 
-->
	<h3>JSTL SQL - SELECT</h3>
	<sql:setDataSource	var="dataSource"
						driver="oracle.jdbc.OracleDriver"
						url="jdbc:oracle:thin:@localhost:1521:xe"
						user="madang"
						password="1111" />
	<sql:query var="rs" dataSource="${ dataSource }">
		SELECT * FROM book
	</sql:query>
	<div class="container">
		<c:if test="${ msg != null}">
			<script> alert('${ msg }');</script>
			<% session.removeAttribute("msg"); %>
		</c:if>
		<a class="row justify-content-end" href="sqlInsert.jsp">등록</a>
	</div>
	<div class="container">
		<h5>rowsByIndex</h5>
		<table class="table table-hover">
			<caption>Book Info</caption>
			<thead>
				<tr>
					<c:forEach items="${ rs.columnNames }" var="colNm">
						<th> <c:out value="${ colNm }"/>  </th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ rs.rowsByIndex }" var="row">
					<tr onclick="location.href = 'sqlUpdate.jsp?bookid='+${ row[0] }">
						<c:forEach items="${ row }" var="colVal">
							<td> <c:out value="${ colVal }"/> </td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<h5>rows</h5>
		<table class="table table-hover">
			<caption>Book Info</caption>
			<thead>
				<tr>
					<th> No. </th>
					<th> book id </th>
					<th> book name </th>
					<th> publisher </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ rs.rows }" var="bvo" varStatus="i">
					<tr onclick="location.href = 'sqlUpdate.jsp?bookid='+${ bvo.bookid }">
						<td> <c:out value="${ i.count }"/> </td>
						<td> <c:out value="${ bvo.bookid }"/> </td>
						<td> <c:out value="${ bvo.bookname }"/> </td>
						<td> <c:out value="${ bvo.publisher }"/> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>