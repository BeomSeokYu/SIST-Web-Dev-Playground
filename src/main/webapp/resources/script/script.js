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
    var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
    
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
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
var forms = document.querySelectorAll('.needs-validation')
Array.prototype.slice.call(forms)
	.forEach(function (form) {
	form.addEventListener('submit', function (event) {
		if (!form.checkValidity()) {
			event.preventDefault();
			event.stopPropagation();
    	}
        form.classList.add('was-validated')
 	}, false);
})