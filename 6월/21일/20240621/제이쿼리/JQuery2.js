function a4(){
    $('li > span').css('color','orange');

}

function a5(){
    $('li span').css('color','red');
    
}

// nth-child(), nth-last-child()
// 같은 부모 요소를 가지는 형제 요소중에
// 특정 순서에 있는 요소를 선택하는 선택자
function a6(){
    // $('li span').eq(0);
    // $('li:eq(0)');  위의 내용과 같은 의미이다.
    
    // 홀수의 요소만 선택하고 싶을 경우  odd 홀수  even 짝수 
    // $('li:nth-child(odd)').css('background','dodgerblue');

    // 3번째 인덱스부터 전부 선택해라
    // n은 자동으로 0부터 1씩 증가하고
    // 정수로 되어있다. 짝수 2n 
    $('li:nth-child(n+3)').css('background','dodgerblue');
}

function a7(){
    // 같은 부모 요소를 가지는
    // 형제들 중에서 첫번째
    $('li:first-child').css('background','tomato');
}