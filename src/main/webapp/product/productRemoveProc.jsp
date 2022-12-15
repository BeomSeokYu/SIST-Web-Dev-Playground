<%@page import="market.dao.ProductDAO"%>
<%@page import="market.vo.ProductVO, java.lang.Integer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:setDataSource	var="dataSource"
					driver="oracle.jdbc.OracleDriver"
					url="jdbc:oracle:thin:@localhost:1521:xe"
					user="madang"
					password="1111" />
<sql:update var="rs" dataSource="${ dataSource }">
	DELETE FROM product WHERE pid=?
	<sql:param value="${ param.pid }"/>
</sql:update>

<c:choose>
	<c:when test="${ rs == 0 }">
		<c:redirect url="productEdit.jsp?edit=remove&msg=rmFail"/>
	</c:when>
	<c:otherwise>
		<c:redirect url="productEdit.jsp?edit=remove&msg=rmSuccess"/>
	</c:otherwise>
</c:choose>