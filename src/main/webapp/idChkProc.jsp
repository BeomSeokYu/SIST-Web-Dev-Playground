<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    if (id.equals("admin")){
        out.println("X");
    } else {
        out.println("O");
    }
%>