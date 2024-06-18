function openWin(){
    // 새로운 페이지를 열기 위해서 window 현재 페이지 객체를 사용한다.(새창)

    // window.open(); 새로운 탭으로 전체 페이지가 생긴다.
}

function registerForm(){
    // 감춰 놓은 id 속성이 register로 지정된 div 태그를 화면에 보이게 한다.
    document.getElementById('register').style.display = 'block';
    document.body.style.backgroundColor = 'gray';

    // 배경에 있는 로그인 버튼을 비활성화 하기
    const namelist = document.getElementsByName('btn')[1];
    namelist.disabled = 'disabled';

    // 공통되는 내용이 없을 경우에는 TagName(input)
}