// 이전으로 버튼 이벤트 처리
$('.backBtn').on('click', function() {
	history.back();
});
 
// 버튼 이벤트 처리
$('#modBtn').on('click', function () {
	//checkProduct();
	$('#pModForm').submit();
});

$('#logoutBtn').on('click', function () {
	if(window.confirm('로그아웃 하시겠습니까?')) {
		location.href = 'logoutProc.jsp';
	}
});

$('#cartAddBtn').on('click', function () {
	if(window.confirm('장바구니에 추가하시겠습니까?')) {
		$('#cartAddForm').submit();
	}
});

/* ajax 방식
function cartAdd(pid) {
	if(window.confirm('장바구니에 추가하시겠습니까?')) {
		$.post(
	        '../cart/cartAddProc.jsp',
	        {"pid": pid},
	        function(result) {
	        	console.log(result.trim());
                if(result.trim() == 'false') {
                    alert('상품 담기를 실패하였습니다.');
                } else {
                    alert('상품이 장바구니에 담겼습니다.');
                }
	        }
	    );
    }
}
*/
$('#cartClearBtn').on('click', function () {
	if(window.confirm('정말로 비우시겠습니까?')) {
		location.href = 'cartClearProc.jsp';
	}
});

$('#searchBtn').click(function() {
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	
	/** 카카오 주소 API */
	/*new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipNo').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();*/

});
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	$('#addr1').val(roadAddrPart1);
	$('#addr2').val(addrDetail);
	$('#addr3').val(roadAddrPart2);
	$('#zipNo').val(zipNo);
	$('#addr').val(roadFullAddr);
}

// productAdd 유효성 검사 관련
	var pidPtn = /^P[0-9]{4,9}$/g;
	var pnamePtn = /^([a-zA-Z0-9][_ ]*){1,20}$/g;
	var pricePtn = /(^[0-9]+$)|(^[0-9]+.[0-9]{1,2}$)/g;
	var stockPtn = /^[0-9]+$/g;
	
	$('#inputPid').on('keyup', function () {
        $.post(
            'productChkProc.jsp',
            {"pid": $('#inputPid').val()},
            function(result) {
            	console.log(result.trim());
                if ($('#inputPid').val().trim().match(pidPtn)){
                    if(result.trim() == 'false') {
                        $('#pid-msg').text('이미 사용중인 상품번호 입니다.');
                        $('#pid-msg').attr('class','text-danger');
                    } else{
                        $('#pid-msg').text('사용 가능한 상품번호 입니다.');
                        $('#pid-msg').attr('class','text-primary');
                    }
                } else {
                	$('#pid-msg').text('P와 숫자를 조합하여 5~10자로 입력하세요.');
                	$('#pid-msg').attr('class','text-danger');
                }
            });
   });
   
   function checkProduct() {
		var inputPid = $('#inputPid');
		var inputPname = $('#inputPname');
		var inputPrice = $('#inputPrice');
		var inputStock = $('#inputStock');
		var result = true;
		
		if(!inputPid.val().trim().match(pidPtn)) {
			var result = false;
			inputPid.val('P');
		}
		if(!inputPname.val().trim().match(pnamePtn)) {
			var result = false;
			inputPname.val('');
		}
		if(!inputPrice.val().trim().match(pricePtn)) {
			var result = false;
			inputPrice.val('0');
		}
		if(!inputStock.val().trim().match(stockPtn)) {
			var result = false;
			inputStock.val('0');
		}
		if(!$('#inputMaker').val().trim() == '') {
			var result = false;
			$('#inputMaker').val('');
		}
		if(result) {
			$('#pAddForm').submit();
		} else {
			$('#pErrMsg').text('입력 양식에 맞지 않는 항목이 있습니다.');
		}
   }

// 전체 form의 submit이벤트에 대한 유효성 검사
/*var forms = document.querySelectorAll('.needs-validation')
Array.prototype.slice.call(forms)
	.forEach(function (form) {
	form.addEventListener('submit', function (event) {
		if (!form.checkValidity()) {
			event.preventDefault();
			event.stopPropagation();
    	}
        form.classList.add('was-validated')
 	}, false);
})*/

// 회원가입, 회원 수정 유효성 검사 관련
	var idPtn = /[a-zA-Z0-9]{5,15}$/g;
    var pwPtn = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*\W).{8,}$/g;
    var namePtn = /[a-zA-Z가-힣 ]{1,}$/g;
    var emailFrontPtn = /[a-zA-Z0-9._-]+/g;
    var emailRearPtn = /[a-zA-Z0-9._-]+[.][A-Za-z]{2,4}$/g;

    $('#userid').attr('pattern', idPtn);
    $('#userpw').attr('pattern', pwPtn);
    $('#usernm').attr('pattern', namePtn);
    $('#email1').attr('pattern', emailFrontPtn);
    $('#email2').attr('pattern', emailRearPtn);

    var forms = $('.needs-validation');
    Array.prototype.slice.call(forms)
    .forEach(function (form) {
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
        }, false);
    });
	
	$('#DupChkBtn').on('click', function () {
        $.post(
            'idChkProc.jsp',
            {"id": $('#userid').val()},
            function(result) {
            	console.log(result.trim());
                if ($('#userid').val().trim().match(idPtn)){
                    if(result.trim() == 'false') {
                        $('#id-msg').text('이미 사용중인 아이디 입니다.');
                        $('#id-msg').attr('class','text-danger')
                    } else{
                        $('#id-msg').text('사용 가능한 아이디 입니다.');
                        $('#id-msg').attr('class','text-primary')
                    }
                } else {
                	$('#id-msg').text('조건을 확인해 주세요.');
                	$('#id-msg').attr('class','text-danger')
                }
            }
        );
   });
	
	$('#userpw').on('keyup', function (event){
        if(!$('#userpw').val().trim().match(pwPtn)) {
        	$('#pw-msg').text('사용불가');
            $('#pw-msg').attr('class','text-danger')
            $('#pw-chk-msg').text('');
        } else {
        	$('#pw-msg').text('사용가능');
            $('#pw-msg').attr('class','text-primary')
        }
    });
	
	$('#userpw_chk').on('keyup', function (event){
		if($('#userpw').val().trim().match(pwPtn)) {
	        if($('#userpw').val() != $('#userpw_chk').val()) {
	        	$('#pw-chk-msg').text('일치하지 않습니다.');
	            $('#pw-chk-msg').attr('class','text-danger')
	        } else {
	        	$('#pw-chk-msg').text('일치합니다.');
	            $('#pw-chk-msg').attr('class','text-primary')
	        }
		}
    });
	
	$('#autoSizingSelect').on('change', function() {
        var selVal = $(this).val();
        var input = $('#email2');
        input.val(selVal);
        if (selVal == '') {
            input.focus();
            input.prop('readonly', false);
        } else {
            input.prop('readonly', true);
        }
    });

    function checkJoinValidation() {
    	var result = true;
    	if (!$('#userid').val().trim().match(idPtn)) {
    		result = false;
    	}
    	if (!$('#userpw').val().trim().match(pwPtn)) {
    		result = false;
    	}
    	if($('#userpw').val() != $('#userpw_chk').val()) {
    		result = false;
    	}
    	if (!$('#usernm').val().trim().match(namePtn)) {
    		result = false;
    	}
    	if (!$('#email1').val().trim().match(emailFrontPtn)) {
    		result = false;
    	}
    	if (!$('#email2').val().trim().match(emailRearPtn)) {
    		result = false;
    	}
    	if(result == true) {
			$('#frm').submit();
		} else {
			$('#errMsg').text('입력 양식에 맞지 않는 항목이 있습니다.');
		}
    }