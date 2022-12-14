// 이전으로 버튼 이벤트 처리
$('.backBtn').on('click', function() {
	history.back();
});
 
// 버튼 이벤트 처리
$('#regBtn').on('click', function () {
	checkProduct();
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

// submit 유효성 검사 (부트스트랩)
function checkProduct() {
	var pidPtn = /^P[0-9]{4,9}$/g
	var pnamePtn = /^([a-zA-Z0-9][_ ]*){1,20}$/g
	var pricePtn = /(^[0-9]+$)|(^[0-9]+.[0-9]{1,2}$)/g
	var stockPtn = /^[0-9]+$/g
	
	var inputPid = $('#inputPid');
	var inputPname = $('#inputPname');
	var inputPrice = $('#inputPrice');
	var inputStock = $('#inputStock');
	/*
	if(inputPid.val().trim().match(pidPtn) != null) {
		//alert('P와 숫자를 조합하여 5~10자로 입력하세요.');
		inputPid.val('P');
		inputPid.focus();
	} else if(!inputPname.val().trim().match(pnamePtn) == null) {
		alert('inputPname');
		inputPname.val('');
		inputPname.focus();
	} else if(!inputPrice.val().trim().match(pricePtn) == null) {
		alert('inputPname');
		inputPrice.val('');
		inputPrice.focus();
	} else if(!inputStock.val().trim().match(stockPtn) == null) {
		alert('inputStock');
		inputStock.val('');
		inputStock.focus();
	} */
	$('#pAddForm').submit();
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