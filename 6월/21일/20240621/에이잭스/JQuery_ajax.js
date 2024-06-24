// 서버
//  유저가 데이터를 달라고 요청하면
//  데이터를 보내주는 간단한 프로그램일 뿐


// 서버에 데이터를 요청할 때는
// 1. 어떤 데이터인지 url로 잘 기재해야한다.
// 2. 어떤 방법으로 요청할지 결정
//        get / post 데이터를 보내준다.  


// get 요청 
//  - 서버에 있던 데이터를 읽고 싶을 때

// post 요청
//  - 내가 서버에 데이터를 보내고 싶을 때
// get/post요청을 보내면 계속 새로고침 함

// put / delete 요청
//   - 동일한 url로 전송할 때 고정해서 보낼 수 있다.
//   - spring boot에서 자세히! spring배울 때
// + 동일한 url로 전송할 때 이게 get요청인지 post요청인지 
//   수정하는 코드인지 delete하는 요청인지


// 자바스크립트 object 타입
// json 타입과 유사하다.
// 모바일이나 파일시스템 혹은 여러가지
// 다양한 프로그램 언어와 호환성이 좋다.
// key와 value가 모두 문자타입
// 그냥 이렇게 쓰면 자바의 object와 같다, 해서 변경을 해줘야함 json타입으로
let test = {
    "name": "hee",
    "age" : 26,
    "address" : "서울시"

};


// 자바스크립트 object 객체를 Json타입으로 변경
// 직렬화
let json = JSON.stringify(test);
console.log(json);
console.log(typeof json);

let json2 = JSON.stringify(true);
console.log(json2);
console.log(typeof json2);
console.log(typeof true);


// 역직렬화
// JSON 타입으로 서버와 통신해서
// 데이터를 텍스트 기반으로 받아왔다.
// JSON 타입을 Object타입으로 변환

let obj1 = JSON.parse(json);
console.log(obj1);
console.log(typeof obj1);
console.log(obj1.address);

// Ajax 동작 방식
// 1. request (요청)
//    - 브라우저가 서버에 정보를 요청한다.
// 2. 서버의 동작 
//    - 서버는 JSON, XML 등의 형식으로 데이터를 전달한다.
// 3. response (응답)
//    - 브라우저에서 이벤트가 발생하여 내용을 처리한다

// 시작은 이렇게
/* 

$.ajax(
    type : "전송방식 get/post",
    url : "url주소를 작성",
    contentType : "json/ xml/ text 
            json : JSON형식의 데이터로 배열, 객체를 포함하는 문자열
            xml : 태그 형식으로 데이터를 주고받음
            text : 일반적인 문자열 String"
            html : HTML을 포함한 문자열
            기본적으로 MIME 유형

    data : 서버로 보낼 데이터 test변수명

    // success : 성공시 실해아는 함수, 
    // error : 실패시 실행하는 함수
    // complete : 요청 완료시 실행하는 함수 
    //             성공 여부 관계없이 무조건 실행! (자바의 finally와 비슷)



)
    
*/

$ajax({
    type : "전송방식 get/post",
    url : "url주소를 작성",
    contentType : "json/ xml"

});

