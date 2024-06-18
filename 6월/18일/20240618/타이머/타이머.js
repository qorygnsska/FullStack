// 자바스크립트 함수 중에서 타이머 기능!
// 콜백함수 : 함수를 바로 실행하는 것이 아니라 몇초 후에 실행해라

// setTimeout(function(){실행할 코드~~~}, 기다릴 시간);
// 첫번째 인자 -> 몇초 후에 function(){실행할 코드}
// 두번째 인자 -> ms 1s -> 1000ms
// setTimeout(function(){
//     console.log("안녕");
// }, 3000);

// div를 5초 뒤에 안 보이게 할 것!
function hide(){
    // 5초가 지나면 hide 실행
    // div태그를 안 보이게 숨김
    let alerts = document.querySelector("#a");
    console.log(alerts);
    
}
// 타이머 함수
setTimeout(hide, 5000);

// 몇 초마다 코드를 실행하고 싶으면
// setTimeout() 코드를 연달아서 여러개 쓰면 된다

// setInterval(function(){실행할 코드~~}, 기다릴 시간);
setInterval(function(){
    console.log("안녕!");
}, 1000);