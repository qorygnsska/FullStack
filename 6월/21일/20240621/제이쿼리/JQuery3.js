// 속성 선택자
// 태그와 태그에 지정된 속성 및 속성값으로 요소찾기
// 태그이름[속성이름]
//  - 지정된 솏ㅇ을 가지고 있는 모든 요소를 선택한다.

function attributeSelector(){
    // 이미지 태그 중에 id속성을
    // 가지는 요소 값 찾기
    // let img = $('img[id]');
    // console.log(img);

    // img.css('opacity','0.2');

    // 속성이 img02인 요소만 가져옴
    // 완전 일치되는 문자의 요소만!
    // 지정된 문자열
    // 태그이름[속성이름~ = 문자열]
    // 지정된 문자열이 공백을 경계로 포함된
    // 모든 요소를 선택한다.

    // 전부 찾는다
    // *=
    // let img = $('img[title*= img02]');

    // img02로 시작하는 모든 요소를 선택해라!
    // ^=
    // let img = $('img[title^= img02]');

    // 02로 끝나는 모든 요소를 선택해라!
    // $=
    let img = $('img[title$= img02]');
    console.log(img);


}

// 속성값을 얻어오는 함수
// attr() : 선택된 요소 집합의 첫번째 요소로 
//          지정된 속성 값을 리턴하거나
//          선택된 요소의 지정된 속성을
//          전달받은 값으로 설정한다.

function changeImg(){
    console.log($('img').eq(4).attr('id'));

    console.log($('img:eq(4)').attr('title'));

    console.log($('img:eq(3)').attr('src'));

    // attr('속성이름','속성값')
    // 인수로 지정된 속성의 값을 변경한다.
    $('img:eq(4)').attr('src','./images/img05.jpg')

    // removeProp()
    //  - 지정된 프로퍼티를 제거한다.
    // removeAttr()
    //  - 지정된 속성을 제거한다.

}
















































