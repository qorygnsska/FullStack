// JQuery_form1.js

function choice(){

    // 속성을 이용해서 type text인 
    // 요소를 모두 찾아오시오!
    // let inputs = $('input');전부
    // let inputs = $('input[type=text]');    
    let inputs = $('input:text');
    console.log(inputs);
    console.log(inputs.length);
    console.log(typeof inputs);

    // val() : 값을 저장할 때 사용!
    // let names = ['이익준','김준완'];
    // $('input:text:eq(0)')
    // .val(names[0]);
    // $('input:text:eq(1)')
    // .val(names[1]);

    // input 창에서 다른 요소들에서
    // 값을 꺼내올 때 
    let temp = $('input:text:eq(0)').val();
    console.log(temp);

}
// 라디오 버튼이 클릭되면 실행되는 함수
function choice2(){
    // 라디오버튼이 가지고 있는 value값을
    // 꺼내와서 div태그가 가지고 있는 
    // 안에 수강과정명 글씨를 보여주기!

    // 1. 라디오버튼 가져오기
    // let text1 = $('input:radio').val();
    let text1 = $('input:radio:eq(0)')
                .val();
    console.log(text1);

    // 자바스크립트
    //  요소 내부에 텍스트를 넣을 때 
    // innerHTML, innerText, textContent
    // innerHTML의 제이쿼리 -> html()  
    // innerText, textContent 제이쿼리->text()

    // html() 함수는 태그를 지원한다.
    $('#a').html('<h1>'+ text1 +'</h1>');

    // text() 함수는 태그를 지원하지 않는다
    //    모든 문자로 인식한다. 
    // $('#a').text('수강 과정명');
    $('#a').text('<h1>'+ text1 +'</h1>');
}

// 자바스크립트가 다운되는 시점에 바로 실행되는 함수
$().ready(function(){

    // 시작단계에서 이벤트를 연결할 객체를 찾아서
    //  이벤트 달아주기
    // click() , change()

    // let select = $('select');
    $('select:eq(0)').change(function(){
        // console.log("클릭됨");
        // 밑에 코드는 select 안에 option 전부
        // 가져온다. 
        // console.log($('select:eq(0) > option'));
        
        // 선택된 option태그가 온다.
        //console.log($('select:eq(0) > option:selected'));

        let select = $('select:eq(0) > option:selected')
                     .eq(0).val();
        console.log(select);

        //첫번째 input창에 select변수의 값을
        // 저장한다. 
        $('input:text:eq(0)')
        .val(select);

    });

    // 성별
    // document.getElementsByName('gender')[0]
    // .addEventListener('click',function(){});
    
    $('input[name=gender]').click(function(){
        let check = $('input[name=gender]:checked')
                    .eq(0).val();
        console.log(check);

        $('input:text:eq(1)')
        .val(check);

    });

    
});

// 화살표함수 
// $(()=>{});