// html : 뼈, css : 피부, 근육
// html : 웹의 내용을 작성, CSS : 디자인
// 자바스크립트는 웹의 동작을 구하는 것!

// 자바스크립트 : html의 내용을 변경할 수 있다
// 속성, 스타일도 변경이 가능하다!

// 자바스크립트는 객체 기반의 스크립트 언어
// 타입을 명시할 필요가 없다!

// System.out.println()과 똑같은 역할!
console.log("Hello");

// 변수
// - 값 저장
// 변수 선언 시 타입 x
// var, let

// 변수 선언 x
// 선언하기도 전에 값이 할당 될 수 있다.
// undefinded
//  공간은 어딘가에서 만들었다.
//  근데 값이 없다!
// var를 사용해서 밑에 처럼 상황이 나오는 것을
// hoisting

// 변수는 항상 제일 위로 선언을 끌어 올려주는 것이 좋다!
// console.log(a);
// var a = 10;
// console.log(a);

// let은 var의 단점을 보완하기 위해서 나옴
// 변수를 만들고 초기화하지 않으면 undefinded 나옴!
// console.log(b);
let b = 100;
console.log(b);

// 전역변수
let global_name = "hee";

// 지역변수
{
    let name = "seo";
    console.log(global_name);
}
console.log(name);
console.log(global_name);

// 변수안에 값을 변경 못하게 막는 키워드!
const a = 10;
console.log(a);

// const 사용하면 좋은 점
// 1. 보안상 이유
// 2. 동시에 값을 변경하지 못하게 막기위함
// 3. 코드 변경 시 실수를 방지하기 위해서

// a = 1000; 에러 발생!

// 자바스크립트 타입
const num1 = 10;
const num2 = 17.1;

// typeof 변수명
console.log(typeof num1);
console.log(typeof num2);

// 숫자가 아닌것을 숫자로 나눌때 에러
const nan = 'not' / 5;
console.log(nan);

// 문자 string
const name2 = 'Hello';
const name3 = name2 + 'World';
console.log(name2);
console.log(typeof name2);
console.log(name3);
console.log(typeof name3);

// boolean
const result = true;
console.log(typeof result);

// null
const result2 = null;
console.log(typeof result2);

let text = 'hello';
console.log(text.charAt(0));

// 문자랑 숫자랑 + String으로 변환해서 연결한다
text = '7' + 5;
console.log(text);


