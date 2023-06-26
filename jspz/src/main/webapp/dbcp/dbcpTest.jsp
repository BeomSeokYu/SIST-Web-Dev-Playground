<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbcpTest.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
	String query = "SELECT * FROM book";
	Connection con = (Connection) application.getAttribute("con");
	PreparedStatement pstmt = con.prepareStatement(query);
	ResultSet rs = pstmt.executeQuery();
%>
	<div class="container">
		<h3>DataBase Connection Pool Test</h3>
		<table class="table table-hover">
			<caption>Book Info</caption>
			<thead>
				<tr>
					<th>bookid</th>
					<th>bookname</th>
					<th>publisher</th>
					<th>price</th>
				</tr>
			</thead>
			<tbody>
				<% while(rs.next()) { %>
					<tr onclick="location.href = 'sqlUpdate.jsp?bookid='+<%= rs.getInt("bookid") %>">
							<td> <%= rs.getInt("bookid") %> </td>
							<td> <%= rs.getString("bookname") %> </td>
							<td> <%= rs.getString("publisher") %> </td>
							<td> <%= rs.getInt("price") %> </td>
					</tr>
				<% } 
				//con.close();
				//pstmt.close();
				%>
			</tbody>
		</table>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>