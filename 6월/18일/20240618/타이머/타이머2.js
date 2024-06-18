// 1초마다 안녕 출력
// let interval = setInterval(function(){
//     console.log("안녕");
// }, 1000);

// // 5초 후에 멈추기
// setTimeout(function(){
//     clearInterval(interval);
//     console.log("멈췄네?");
// }, 5000);

// html div태그의 숫자를 하나씩 감소하면서 0보다 작아지면 멈추기
// 초기값 카운 설정
let count = 10;

// DOM
// - 브라우저가 웹페이지를 js객체화 하는 방식
// document : 웹 페이지 문서 정보를 모두 지니고 있는 객체
let intervalId = setInterval(function(){
    // div태그요소 가져오기
    let divNum = document.querySelector("#num");
    // 하나씩 count 감소
    count -= 1;
    // 그걸 html에 적용한다
    // 그러다 마이너스가 되면 멈추기
    if(count >= 0){
        divNum.innerHTML = count;
    }else{
        clearInterval(intervalId);
    }
}, 1000);