/**
 * 파일명: login.js 
 */

// 상태값을 저장할 수 있는 전역변수
let status = true;


$(function() {
	console.log("찍힘?");
	
	// 로그인 버튼을 클릭하면 자동으로 실행 
	// 입력한 아이디와 비밀번호를 갖고 loginPro.jsp
	// 페이지를 만들어서 실행 
	
	$("#login").click(function() {
		
		// 입력하는 폼에서 입력값의 유무를 확인
		// 아이디가 비었거나 비밀번호 비었는지 확인후
		// 입력하기!
		check(); 
		
		// 요소값에서 입력한 값을 가져오기 
		
		// ajax() 비동기 통신하기!
		// 요청방식 POST
		// url : loginPro.jsp
		// data: 객체타입
		// 성공시: index.jsp 
		// 실패시: 아이디,비밀번호 input 태그 
		//      모두 초기화 "" 
		
		if(status){
			// 두개 비어있지 않다면 통신을 시작
			let query = {
				id : $("#id").val(),
				passwd : $("#passwd").val()
			};
			
			//웹에서 서버로 접근하려면 ajax()를
			// 이용해서 통신 해야된다. 
			$.ajax({
				type : "POST",
				url  : "loginPro.jsp",
				data : query,
				
				success: function(data) {
					console.log(data);
					window.location.href=""
				
				},error: function(error) {
					console.log(error);
				}				
			});			
		}		
	});
	
	// 로그아웃버튼을 클릭하면 자동실행
	$("#logout").click(function() {		
		$.ajax({			
			type:"POST",
			url : "logout.jsp",
			success : function(data) {
				window.location.href=""
			}			
		});		
	});	
	
	
	
});

function check() {
	//  $.trim() 제이쿼리에서 제공하는 공백제거
	//           함수!
	let id = $.trim($("#id").val());
	let passwd = $.trim($("#passwd").val());
	
	
	if(!id){
		// 아이디가 비어있을 경우에는 아이디를 입력
		// 할 수 있도록! 경고 메시지 , 입력필드에
		// 포커스 맞추기
		return false;
	}else if(!passwd){
		return false;
	}
}









