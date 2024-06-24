// 속성 선택자
// 태그와 태그에 지정된 속성 및 속성값으로 요소 찾기

// 태그이름[속성이름]
//  - 지정된 속성을 가지고 있는 모든 요소를 선택한다.
function attributeSelector(){
    // 이미지 태그 중에 id 속성을 가지는 요소값 찾기!
    // let img = $('img[id]');
    // img.css('opacity','0.2');

    // let img = $('img[title=img02]'); // 완전 일치하는 애만 가져옴

    // 태그이름[속성이름~=문자열] : 공백을 경계로 포함된 모든 요소를 선택
    // let img = $('img[title~=img02]'); // 포함되어 있는 애들 가져옴

    // img02로 시작하는 모든 요소 선택
    // ^=
    // let img = $('img[title^=image]');

    // 04로 끝나는 모든 요소 선택
    // $=
    let img = $('img[title$=04]');
}

// 속성값을 얻어오는 함수
// attr() : 선택된 요소 집합의 첫번째 요소로 지정된 속성 값을 리턴하거나
//          선택된 요소의 지정된 속성을 전달받은 값으로 설정한다.
function changeImg(){
    // 값이 있으면 값을 가져오고
    // 값이 없으면 undefined
    console.log($('img').eq(0).attr('id'));
    console.log($('img').eq(0).attr('title'));

    // attr('속성이름', '속성값')
    // 인수로 지정된 속성의 값을 변경한다
    $('img:eq(2)'.attr('src', '.images/img05.jpg'))

    // removeProp()
    //  - 지정된 프로퍼티를 제거한다
    // removeAttr()
    //  - 지정된 속성을 제거한다
}