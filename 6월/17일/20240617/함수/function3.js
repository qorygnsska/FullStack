// 아이디버튼을 클릭했을 때 
// 토글 -> 기존에 내용이 있으면 반대로 적용!
//  창이 보이고 있는 상태에서 다시한번 버튼을 누르면
//  숨기는 기능
console.log("다");
function toggleInputMessage(){

    // 1. 요소값 검색
    const inputMessage = document
                .getElementById('input-message');
    console.log(inputMessage.style.display);

    if(inputMessage.style.display === 'none'
        || inputMessage.style.display ===''
    ){
        inputMessage.style.display = 'block';
    }else{
        inputMessage.style.display = 'none';
    }
}
// 비밀번호를 입력하세요~
// 버튼 클릭시 보이게 하는 토글 함수
function togglePasswordMessage(){

    // 1. 요소값 검색
    const passwordMessage = document
                .getElementById('password-message');
    console.log(passwordMessage.style.display);

    if(passwordMessage.style.display === 'none'
        || passwordMessage.style.display ===''
    ){
        passwordMessage.style.display = 'block';
    }else{
        passwordMessage.style.display = 'none';
    }
}

// 닫기 버튼을 클릭했을 때 모든 메시지 창을 숨긴다
function hideMessages(){
    document.getElementById('input-message').style.display ='none';
    document.getElementById('password-message').style.display ='none';
}