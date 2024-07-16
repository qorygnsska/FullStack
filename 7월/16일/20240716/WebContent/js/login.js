/**
 * 파일명: login.js
 */

$(function() {
	console.log("찍힘?");
	
	// 이메일을 입력하고 이메일이 비었는지 확인
	// 비어있지 않다면 ajax()메서드를 이용해서
	// emailCheck.do  url 이 들어오면 
	// 데이터베이스로 가기 위해서 전처리를 한다.
	// Service 클래스  emailCheck()생성
	// 해서  Sqlsession객체 가져오고
	// DAO클래스의 emailCheck()메서드 실행
	// xml파일에서 sql 실행 
	// 결과를 ajax()로 보낸다.
	// 만약 성공시  이미지 참조!
	// 실패시  팝업! 
	
	 $('#checkEmailButton').click(function() {
	        var email = $('#email').val();
	        
	        if(email === ''){
	        	alert('이메일을 입력하세요');
	        	return;
	        }
	        $.ajax({
	        	
	        	type : 'POST',
	        	url  : 'emailCheck.do',
	        	data : { email : email},
	        	// 성공시 데이터를 받아주는 변수!
	        	// 변수명은 아무거나 작성해도 된다. 
	        	success : function(data) {
					console.log(data);
					
					if(data.result){
						alert('이메일을 사용할 수 있습니다.');
					}else{
						alert('이 이메일은 사용할 수 없습니다.')
					}				
					
				},error : function(e) {
					console.log("예외 발생!");
				}		        	
	        });     
	  });
	 
	 // 회원가입 버튼을 클릭했을 때 실행
	 // 이메일 확인,비밀번호,비밀번호 확인 입력
	 //           두 비밀번화 맞는지 확인
	 // 닉네임이 입력되었는지 길이가 2자 이상인지
	 // 확인 하고 ajax()로 데이터 보내기 
	 
	
});
	






