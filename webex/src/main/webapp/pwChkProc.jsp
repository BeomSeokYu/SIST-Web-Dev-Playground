<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pw = request.getParameter("id");
    if (pw.equals("1111")){
        out.println("O");
    } else {
        out.println("X");
    }
%>