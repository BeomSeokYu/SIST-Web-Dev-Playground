<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
	입력받은 아이디와 비밀번호가 member 테이블의 값과 일치하면 
	세션의 sid 속성에 로그인 아이디를 저장하고 
	messages.jsp 페이지로 리다이렉트
	그렇지 않으면 로그인 화면으로 이동
 --%>
<sql:setDataSource		var="dataSource"
						driver="oracle.jdbc.OracleDriver"
						url="jdbc:oracle:thin:@localhost:1521:xe"
						user="madang"
						password="1111" />
<sql:query var="rs" dataSource="${ dataSource }">
	SELECT userid, userpw FROM member WHERE userid=? AND userpw=?
	<sql:param value="${ param.userid }"/>
	<sql:param value="${ param.userpw }"/>
</sql:query>
<c:forEach items="${ rs.rows }" var="bvo" varStatus="i">
	<c:choose>
		<c:when test="${ bvo.userid != null }">
			<c:redirect url="../member/member.jsp?msg=loginFail"/>
		</c:when>
		<c:otherwise>
			<c:redirect url="login.jsp?msg=loginFail"/>
		</c:otherwise>
	</c:choose>
</c:forEach>