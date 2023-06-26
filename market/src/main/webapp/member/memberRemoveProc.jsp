<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	액션태그를 이용하여 MemberDAO 및 MemberVO 객체 mdao, mvo 생성
	파라미터로 전달된 데이터를 mvo 에 저장한 후 
	회원 추가 메소드 호출하여 가입 처리를 하고
	messages.jsp 페이지로 이동
	단, 회원 등록에 성공한 경우 msg 파라미터에 joinOK를 저장
	실패한 경우 joinFail을 저장하여 messages.jsp에 적절한 메시지가 표시되도록 처리
 --%>
 <jsp:useBean id="mdao" class="market.dao.MemberDAO"/>
 <jsp:setProperty property="con" name="mdao" value="${ con }"/>
 <%
 	if (mdao.delete((String) session.getAttribute("sid"))) {
 		session.invalidate();
 		response.sendRedirect("../common/messages.jsp?msg=DelOK&title=Success");
 	} else {
 		response.sendRedirect("../common/messages.jsp?msg=DelFail&title=Failed");
 	}
 %>