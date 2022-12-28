/**
 * 	자바 스크립트를 하나의 모듈처럼 구성

 	모듈 패턴
 	관련 함수들을 하나의 모듈처럼 묶음으로 구성
 	자바스크립트의 즉시 실행 함수와 {}을 이용하여 객체 구성
 	- 	() 안에 함수를 선언하고
 		바깥 쪽에서 실행
 		>> 실행 결과가 바깥 쪽에 선언된 변수에 할당 됨.
*/

console.log('reply.js...........');

// 외부에서는 replyService.register(객체, 콜백함수) 형태로 호출

var replyService = ( function(){

	function register(reply, callback) {
		console.log('reply register()');
		$.ajax({
			type : 'POST',
			url : '/replies/register',
			data : JSON.stringify(reply),
			contentType : 'application/json; charset=UTF8',
			success : function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (err) {
				if(error) {
					error(err)
				}
			}
		});// end ajax
	}// end register

	function list(param, callback, error) {
		console.log('reply list()');
		$.getJSON("/replies/list/" + param.bno + '/' + param.pageNum + '.json',
			function (result) {
				if(callback) {
					callback(result);
				}
			}
		).fail( function(){
			if(error) {
				error(err);
			}
		}); // end getAjax
	}// end list

	function view(rno, callback, error) {
		console.log('reply view()');
		$.getJSON("/replies/" + rno + '.json',
			function (result) {
				if(callback) {
					callback(result);
				}
			}
		).fail( function(){
			if(error) {
				error(err);
			}
		}); // end getAjax
	}// end view

	function modify(modReply, callback) {
		console.log('reply modify()');
		$.ajax({
			type : 'PUT',
			url : '/replies/' + modReply.rno,
			data : JSON.stringify(modReply),
			contentType : 'application/json; charset=UTF8',
			success : function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (err) {
				if(error) {
					error(err)
				}
			}
		});// end ajax
	}// end modify

	function remove(rno, callback, error) {
		console.log('reply remove()');
		$.json
		$.ajax({
			type : 'DELETE',
			url : '/replies/' + rno,
			data : JSON.stringify(rno),
			contentType : 'application/json; charset=UTF8',
			success : function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (err) {
				if(error) {
					error(err)
				}
			}
		});// end ajax
	}// end remove

	return  {
				register : register,
				list : list,
				view : view,
				modify : modify,
				remove : remove
			};
})();