<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<%@ include file="../includes/link.jsp" %>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
	<!-- Masthead -->
    <header class="masthead bg-secondary mt-5 text-white">
        <div class="container d-flex flex-column">
        	<div class="mt-5"></div>
            <h1 class="masthead-heading m-5">회원가입</h1>
        </div>
    </header>
    <!-- Section -->
	<section class="page-section mt-5" id="join">
        <div class="container mt-5">
            <form class="needs-validation" id="frm" action="joinProc.jsp" novalidate>
                <!-- Name input-->
                <div class="row justify-content-center text-truncate">
                    <div class="col-md-5 px-1 text-end">
                        <span class="badge bg-secondary">영문자+숫자 포함 5~15자</span>
                    </div>
                    <div class="col-md-1 px-1"></div>
                </div>
                <div class="row mb-4 justify-content-center text-truncate">
                    <div class="col-md-2 px-1">
                        <label for="join_id">아이디</label>
                    </div>
                    <div class="col-md-3 px-1">
                        <input type="text" class="form-control" id="userid" name="userid" placeholder="아이디를 입력하세요" required>
                        <div id="id-msg"></div>
                    </div>
                    <div class="col-md-1 px-1">
                        <button class="btn btn-primary" type="button" id="DupChkBtn">중복확인</button>
                    </div>
                </div>
                <!-- pw input-->
                <div class="row justify-content-center text-truncate">
                    <div class="col-md-5 px-1 text-end">
                        <span class="badge bg-secondary">영문자+숫자+특수문자 포함 8자 이상</span>
                    </div>
                    <div class="col-md-1 px-1"></div>
                </div>
                <div class="row justify-content-center text-truncate">
                    <div class="col-md-2 px-1">
                        <label for="join_pw">비밀번호</label>
                    </div>
                    <div class="col-md-3 px-1">
                        <input type="password" class="form-control" id="userpw" name="userpw" placeholder="비밀번호를 입력하세요" required>
                    </div>
                    <div class="col-md-1 px-1">
                    	<div id="pw-msg"></div>
                    </div>
                </div>
                <div class="row mb-4 justify-content-center">
                    <!-- pw chk input-->
                    <div class="col-md-2 px-1">
                        <label for="join_pw_chk">비밀번호 확인</label>
                    </div>
                    <div class="col-md-3 px-1">
                        <input type="password" class="form-control" id="userpw_chk" placeholder="비밀번호를 다시 입력하세요" required>
                        <div id="pw-chk-msg"></div>
                    </div>
                    <div class="col-md-1 px-1"></div>
                </div>
                <!-- Name input-->
                <!-- <div class="row justify-content-center text-truncate">
                    <div class="col-md-5 px-1 text-end">
                        <span class="badge bg-primary">영문자, 한글 1자 이상</span>
                    </div>
                    <div class="col-md-1 px-1"></div>
                </div> -->
                <div class="row mb-4 justify-content-center text-truncate">
                    <div class="col-md-2 px-1">
                        <label for="join_name">이름</label>
                    </div>
                    <div class="col-md-3 px-1">
                        <input class="form-control" id="usernm" type="text" name="usernm" placeholder="이름을 입력하세요." required>
                    </div>
                    <div class="col-md-1 px-1"></div>
                </div>
                <!-- Email address input-->
                <div class="row mb-4 justify-content-center text-truncate">
                    <div class="col-md-2 px-1">
                        <label for="join_email_f">이메일</label>
                        <input type="text" class="form-control" id="email1" placeholder="이메일을 입력하세요." required>
                    </div>
                    <div class="col-md-2 px-1">
                        <label for="autoSizingInputGroup"></label>
                        <div class="input-group">
                        <div class="input-group-text">@</div>
                            <input type="text" class="form-control" id="email2" required>
                        </div>
                    </div>
                    <div class="col-md-1 px-1">
                        <label for="autoSizingInputGroup"></label>
                        <select class="form-select" id="autoSizingSelect">
                            <option value="" selected>입력</option>
                            <option value="naver.com">naver.com</option>
                            <option value="gmail.com">gmail.com</option>
                            <option value="daum.net">daum.net</option>
                        </select>
                    </div>
                    <div class="col-md-1 px-1"></div>
                    <input type="hidden" id="email" name="email">
                </div>
                <!-- Photo input-->
                <div class="row mb-4 justify-content-center text-truncate">
                    <div class="col-md-1 px-1">
                        <label for="join_photo">사진</label>
                    </div>
                    <div class="col-md-3 px-1">
                        <!-- <input class="form-control" id="join_photo" type="file" accept="image/png, image/jpeg"> -->
                        <input type="hidden" name="photo" value="memberDefault.png">
                    </div>
                    <div class="col-md-2 px-1">
                        <img class="img" id="profile" src="../resources/imgs/memberDefault.png" alt="..." width="70px">
                    </div>
                </div>
                <!-- Gender input-->
                <div class="row justify-content-center text-truncate">
                    <div class="col-md-1 px-1">
                        <label>성별</label>
                    </div>
                    <div class="col-md-1 px-1">
                        <input class="form-check-input" type="radio" name="gender" id="join_gender_no" value="" checked>
                        <label class="form-check-label" for="join_gender_no">
                            미선택
                        </label>
                    </div>
                    <div class="col-md-1 px-1">
                        <input class="form-check-input" type="radio" name="gender" id="join_gender_m" value="M">
                        <label class="form-check-label" for="join_gender_m">
                            남성
                        </label>
                    </div>
                    <div class="col-md-1 px-1">
                        <input class="form-check-input" type="radio" name="gender" id="join_gender_f" value="F">
                        <label class="form-check-label" for="join_gender_f">
                            여성
                        </label>
                    </div>
                   	<div class="col-md-2 px-1">
                    <div class="invalid-feedback">성별을 선택해 주세요.</div>
                    <div class="col-md-3 px-1"></div>
                </div>
                <!-- Error Msg-->
                <div class="row justify-content-center text-truncate">
                    <div class="col-md-4 px-1 text-end">
                        <p class="text-danger" id="errMsg"></p>
                    </div>
                </div>
                <!-- Submit Button-->
                <div class="row justify-content-center text-truncate">
                    <div class="col-md-4 px-1 text-end">
                        <button class="btn btn-success" type="button" id="submitBtn">가입</button>
                    </div>
                </div>
            </form>
        </div>
    </section>
<%@ include file="../includes/footer.jsp" %>
<script>
	$('#submitBtn').click(function() {
		$('#email').val($('#email1').val()+'@'+$('#email2').val());
		checkJoinValidation();
	});
</script>
</body>
</html>