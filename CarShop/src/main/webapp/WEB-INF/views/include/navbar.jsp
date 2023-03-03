<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!-- Navigation -->
<nav class="navbar navbar-expand navbar-dark bg-dark"
	aria-label="Second navbar example">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">CarShop</a>
		<button class="navbar-toggler" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarsExample02"
			aria-controls="navbarsExample02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample02">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/">홈</a></li>
				<li class="nav-item"><a class="nav-link" href="/cars/list">차량 보기</a></li>
				<li class="nav-item"><a class="nav-link" href="/cars/add">차량 등록</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/list">게시판</a></li>
				<li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		             	회원관리
		          </a>
		          <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="#">로그인</a></li>
		            <li><form action="/logout" method="post">
						<button>로그아웃</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form></li>
		          </ul>
		        </li>
			</ul>
			<div>
			<c:choose>
				<c:when test="${ isLogOn == true }">
					<form action="/logout">
						<button>로그아웃</button>
					</form>
				</c:when>
				<c:otherwise>
					<a href="/cars/login">로그인</a>
				</c:otherwise>
			</c:choose>
				
			</div>
		</div>
	</div>
</nav>