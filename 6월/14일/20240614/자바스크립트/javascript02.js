// 자바스크립트에서 html의 요소들을 가지고 올 수 있는 함수들

// 함수를 만들어서 입력하는 텍스트가 버튼이 클릭되면 실행할 수 있는 함수를 만든다.
/* 
function 함수명(매개변수){
    실행할 문장!
} 
*/
function find(event){
    // 폼 태그의 제출 때문에 
    // 화면이 새로고침되서 함수안에
    // 콘솔 내용이 자꾸 지워진다.
    event.preventDefault();

    // 자바스크립트에서 html의 요소들을 가져올 때 사용하는 함수
    // 문서의 구조를 가지고있는 타입
    // getElementById() 아이디 속성이 괄호안에 이름으로 하나의 요소값을 찾아온다.

    const temp = document.getElementById("nameinput").value;
    console.log(temp);

    if(temp == "배교훈"){
        alert("맞다");
    }else{
        alert("아니다");
    }
}

// 위에 함수를 실행하고 싶으면 함수 호출
