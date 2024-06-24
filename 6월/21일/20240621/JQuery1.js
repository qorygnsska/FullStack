// JQuery1.js

$().ready(function(){
    
    console.log("연결!");
});


// 요소의 표시와 숨김
// hide() : 선택한 요소의 css를 자동으로 조정해서
//          사라지게 한다.
// show() : 선택한 요소의 css를 자동으로 조정해서 표시되게 한다.
// toggle() : 선택한 요소의 css를 자동으로 조정해서  hide(), show()
//              메소드가 번갈아 적용된다.
// hide("slow","fast") 예약어를 전달해서
// 속도를 설정할 수 있다.

//  페이드 효과
//  fadeOut(): 선택한 요소의 css 중 opacity 속성의 값을 줄여가며 사리지게 한다.
//  fadeIn(): 선택한 요소의 css 중 opacity 속성의 값을 높여가며 나타나게 한다.
//  fadeToggle(): fadeIn(), fadeOut() 메소드가 번갈아 적용된다.
//  fadeIn(), fadeOut() 메소드의 인수로 시간(밀리초)을 설정하거나 "slow", "fast"와 같은 예약어를 전달해
//  속도를 설정할 수 있다.

//  슬라이드 효과
//  slideUp(): 선택한 요소의 css 중 height 속성의 값을 낮춰가며 사라지게 한다.
//  slideDown(): 선택한 요소의 css 중 height 속성의 값을 높여가며 나타나게 한다.
//  slideToggle(): slideUp(), slideDown() 메소드가 번갈아 적용된다.
//  slideUp(), slideDown() 메소드의 인수로 시간(밀리초)을 설정하거나 "slow", "fast"와 같은 예약어를 
//  전달해 속도를 설정할 수 있다.

function hideImg(){
    // $('img').hide('fast');
    // $('img').hide(5000);

    // $('img').fadeOut(5000);
    $('img').slideUp(2000);
}

function showImg(){
    $('img').show();
}

function toggleImg(){
    // $('img').toggle();
    $('img').fadeToggle();
    // $('img').slideToggle();

}