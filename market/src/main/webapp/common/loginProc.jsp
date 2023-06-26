<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	입력받은 아이디와 비밀번호가 member 테이블의 값과 일치하면 
	세션의 sid 속성에 로그인 아이디를 저장하고 
	messages.jsp 페이지로 리다이렉트
	그렇지 않으면 로그인 화면으로 이동
 --%>
 <jsp:useBean id="mdao" class="market.dao.MemberDAO"/>
 <jsp:setProperty property="con" name="mdao" value="${ con }"/>
 <jsp:useBean id="mvo" class="market.vo.MemberVO"/>
 <jsp:setProperty property="userid" name="mvo"/>
 <jsp:setProperty property="userpw" name="mvo"/>
 <%
 	if (mdao.isMember(mvo)) {
 		session.setAttribute("sid", mvo.getUserid());
 		response.sendRedirect("messages.jsp?msg=login&title=Welcome");
 	} else {
 		response.sendRedirect("login.jsp?msg=loginFail");
 	}
 %>