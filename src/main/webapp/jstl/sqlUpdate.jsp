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
	<sql:setDataSource	var="dataSource"
						driver="oracle.jdbc.OracleDriver"
						url="jdbc:oracle:thin:@localhost:1521:xe"
						user="madang"
						password="1111" />
	<sql:query var="rs" dataSource="${ dataSource }">
		SELECT * FROM book WHERE bookid=?
		<sql:param value="${ param.bookid }"></sql:param>
	</sql:query>
	<h3>JSTL SQL - UPDATE</h3>
	<div class="container">
		<c:forEach items="${ rs.rows }" var="bvo">
		<form action="sqlUpdateProc.jsp">
			책ID : <input class="form-control" type="text" name="bookid" value="${ bvo.bookid }" readonly/> <br>
			책이름 : <input class="form-control" type="text" name="bookname" value="${ bvo.bookname }"/> <br>
			출판사 : <input class="form-control" type="text" name="publisher" value="${ bvo.publisher }"/> <br>
			가격 : <input class="form-control" type="text" name="price" value="${ bvo.price }"/> <br>
			<input class="btn btn-success" type="submit" value="수정"/>
			<input class="btn btn-danger" type="button" value="삭제" onclick="confDel(${ bvo.bookid })"/>
		</form>
		</c:forEach>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
	function confDel(bookid) {
		if(confirm("정말로 삭제하시겠습니까?")) {
			location.href = 'sqlDeleteProc.jsp?bookid=' + bookid
		}
	}
</script>
</body>
</html>