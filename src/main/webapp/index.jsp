<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String greetingUpper = "WELCOME to WEB SHOPPING MALL"; %>
<%	String greetingLower = "welcome TO web market!"; %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%@ include file="includes/link.jsp" %>
</head>
<body>
<%@ include file="includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white text-center">
        <div class="container d-flex align-items-center flex-column">
        	<div class="mt-5"></div>
            <!-- Masthead Heading-->
            <h1 class="masthead-heading m-5"><%= greetingUpper %></h1>
            <!-- Masthead Subheading-->
            <p class="masthead-subheading font-weight-light">
            </p>
        </div>
    </header>
    <!-- Info Section -->
    <section class="page-section" id="info">
        <div class="container">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Heading-->
                <h1 class="m-3"><%= greetingLower %></h1>
            </div>
        </div>
    </section>
<%@ include file="includes/footer.jsp" %>
</body>
</html>