// // 웹 문서에 출력하겠다!
// document.write(4*5);
// document.write("<br>");
// document.write("집에 가고 싶다!<br>");
// document.write("살려줘!~ 퇴근 10시!<br>");

console.log("나이 : " + 20);
console.log('1 + 1 = ' + (1*1));
console.log('1 + 1 =  + (1*1)');
console.log(`1 + 1 =  + ${1*1}`);

// -- 산술연산자 자바랑 똑같음 --
console.log("========================");

console.log('5' - 2);
// 문자 -> 숫자로 변경
console.log(parseInt('5') + 2);

// 올림함수 Math.ceil()
// 내림함수 Math.floor()
// 반올림함수 Math.round()
// 제곱함수 Math.pow()

// ++, -- 똑같음
let num = 2;
const num2 = num++;

// +=, -=. *= 똑같다
// 비교연산자도 똑같다
// == 데이터타입 구별X 값만 비교함
// === 데이터타입까지 구별함
console.log(`10 == 10 = ${10 == 10}`);
console.log(`10 == 10 = ${10 == '10'}`);
console.log(`10 == 10 = ${10 === '10'}`);

// 데이터 타입이 다르니까 true
console.log(`10 != 10 = ${10 !== '10'}`);

// 논리연산자 and &&, or ||, not !

// 자바스크립트도 0을 제외한 모든 숫자를 true로 인식
// 0은 모두 거짓으로 취급
console.log(`!1 = ${!1}`);
console.log(`!1 = ${!0}`);
console.log(`!1 = ${!3}`);

const name = 'seohee';
if(name === 'seohee'){
    console.log("맞다!");
    document.write("맞다!");
    alert("맞다!")
}else{
    console.log("아니다!");
    document.write("아니다!");
    alert("아니다!")
}