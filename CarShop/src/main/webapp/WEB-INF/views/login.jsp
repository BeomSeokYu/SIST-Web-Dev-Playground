<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="include/header.jsp" %>
</head>
<style>
html,
body {
  height: 100%;
}

body {
  align-items: center;
  padding-bottom: 40px;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}
</style>
<body>
<%@ include file="include/navbar.jsp" %>
<div class="container">
	<div class="form-signin text-center">
	
	  <form action="/login" method="post" id="loginFrm">
	    <h1 class="h3 py-5 fw-normal">로그인</h1>
	
	    <div class="form-floating">
	      <input type="text" class="form-control" id="username" name="username" placeholder="ID">
	      <label for="floatingInput">이메일</label>
	    </div>
	    <div class="form-floating">
	      <input type="password" class="form-control" id="password" name="password" placeholder="Password">
	      <label for="floatingPassword">비밀번호</label>
	    </div>

	    <button class="w-100 btn btn-lg btn-secondary mb-3" id="loginBtn">로그인</button>
	   <!--  <div>
	    	<p><a class="text-dark" href="/user/signup.jsp" class="">회원 가입</a></p>
	    </div>
	    <div>
	    	<p><a  class="text-dark" href="/user/pwfind.jsp" class="">비밀번호 찾기</a></p>
	    </div> -->
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	  </form>
	  
	</div>
</div>

<%@ include file="include/footer.jsp" %>
<script>

$('#password').on("keypress", function(){
	if(event.keyCode == 13) {
		$('#loginFrm').suvmit();
	}
})


</script>
</body>
</html>