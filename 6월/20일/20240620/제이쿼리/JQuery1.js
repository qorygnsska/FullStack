
// 제이쿼리 작성법
// 제이쿼리의 시작은 $로 시작
// $('css 셀렉터').메서드();
// 위에 $('css 셀렉터') 하나만 가져오는것이 아니라 여러개를 찾아온다
// 그래서 배열형태(object)로 데이터를 받아서

// 무조건 한번 실행해야되는 문장들은 아래 있는 함수처럼 작성
// $().ready(function(){
//     console.log("연결");
// });

// 저장을 하면 브라우저는 새로고침 된다

function highLight(){
    // ul 리스트 배경색을 원하는 색으로 변경
    $('#list').css('backgroundColor', 'pink');

    // ul 요소중에 첫번째 요소에 css를 변경할 때 사용하는 메서드
    // 첫번째 요소들을 접근할 때 사용한다.

    // 필터링 함수
    // first()
    $('#list li').first().css('background', 'skyblue');
    // last()
    $('#list li').last().css('background', 'blue');
    // 내가 원하는 요소에 접근하는 함수
    // eq(index)
    $('#list li').eq(2).css('background', 'red');

    // slice(시작, 끝+1)
    // 모든 배열에서 슬라이싱
    // 문자를 자르거나 범위값을 지정할 때는
    // 끝나는 번호는 데이터를 포함하지 않는다.
    $('#list li').slice(2, 6).css('background', 'chocolate');


}

function imgSize(){
    // $('img').css('width', '100px');
    // $('img').css('height', '200px');

    // 한줄로 변경
    // $('img').css('width', '100px').css('hidth', '200px');

    $('img').css({'width': '100px', 'height': '200px'}).css('opacity', '0.5');
}

// 버튼을 클릭했을 때 실행하는 함수
// 이미지를 추가하는 함수
function addImg(){

    // 요소값을 선택된 div의 내부로 추가
    // .append() : 선택된 요소의 마지막에 추가
    // .prepend() : 선택된 요소의 앞에 추가
    
     // 선택된 요소값 외부에 추가
    // .before(): 선택된 요소의 앞에 추가된다.
    // .after() : 선택된 요소의 뒤에 추가한다.

    $('div').append('<img src="./img/img03.jpg">');

    $('div').prepend('<img src="./img/img01.jpg">');
    
}

// 버튼을 누르면 이미지를 숨기는 함수
function hideImg(){
    // .hide() : 선택한 요소를 css 자동으로 조정해서 사라지게 한다.
    // $('img').hide();

    // 필터 함수를 이용해서 원하는 인덱스 요소만 숨기기 할 수 있다.
    // first()
    // last(), eq(index)

    // 특별한 기능
    // 천천히 사라지는 기능
    $('img').hide(2000);

}
