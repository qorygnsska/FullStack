
// 1. new
//  새 객체를 만들듯이 new 키워드를 이용
const arr1 = new Array();

// 2. []
const fruits = ['🥝','🍉','🍊','🍋','🍍'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[fruits.length-1]);

// 일반 for

// 향상 for
for(let fruit of fruits){
    console.log(fruit);
}

// forEach문
fruits.forEach(function(fruit, index, array){
    console.log(fruit, index, array);
});

// 배열에서 제공하는 함수
// 배열 뒤에서 부터 추가
fruits.push('🍕', '🍔');
console.log(fruits);

// 배열 뒤에서부터 삭제
fruits.pop();
console.log(fruits);

// 배열 앞에서부터 추가
fruits.unshift('🥖', '🍗');
console.log(fruits);

// 배열 앞에서부터 삭제
fruits.shift();
console.log(fruits);

// split()
// 구분자
const fruits2 = '🍏,🍐,🍑,🍒';
console.error(fruits2.split(','));

// slice(시작, 끝)
// 배열이나 문자를 자를 경우
// 시작은 데이터를 포함, 끝은 포함하지 않음
const result = fruits.slice(2, 5);
console.log(result);

// 배열연결
// concat(연결할 배열, 연결할 배열);
console.log(fruits.concat(fruits2));

// 검색
console.clear(); // 콘솔 지우기
console.log(fruits);

// 검색해서 인덱스를 반환
// 만약 중복되는 데이터가 있을 경우
// lastindexof() : 마지막부터 찾기
console.log(fruits.indexOf("🍉"));

// 문자가 포함 되어있는 지 검사
// 있으면 true, 없으면 false
// 비밀번호 검사할 때 사용!
console.log(fruits.includes("🍉"));

// 정렬
// 숫자, 영어, 한글 순으로 정렬됨
const arr2 = ['Abc', 1000, '한글'];
console.log(arr2.sort());
console.log(arr2.reverse());

console.clear();

// 정규식
//  /찾을문자/.test(변수명)
// 정규식은 결과를 true, false 반환
// a라는 문자가 있니?
const result2 = /a/.test('abcdefg');
console.log(result2);

// 알파벳 범위를 설정[]
// a부터 z까지 아무문자 하나가 있니?
const result3 = /[a-z]/.test('abcdefg');
console.log(result3);

// 대소문자 범위를 설정[]
const result5 = /[a-zA-Z]/.test('반a');
console.log(result5);

// 숫자 범위를 설정[]
// 0~9 사이 숫자가 하나가 있니?
const result4 = /[0-9]/.test('1');
console.log(result4);

// 한글 범위 설정[]
const result6 = /[ㄱ-ㅎ가-힣]/.test("방가루");
console.log(result6);

// 특수 문자 포함해서 아무 문자 1개 있니? 
// 대문자
const result7 = /\S/.test('ㅁㅇㄴ');
console.log(result7);

// 시작하는 문자를 검사
// ^문자
console.log(/^a/.test('abced'));

// 문자로 끝나는 검사
console.log(/a$/.test('abceda'));

// or
// e또는 f를 둘 중 하나를 포함하니?
// 공백 넣으면 안됨
console.log(/(e|f)/.test('abceda'));

// 중복적으로 찾을 때
// /찾을문자+/ /a+/ aaaa

// 이메일 qorygnsska@naver.com
const result8 = /\S+@\S+\.\S+/.test('qorygnsska@naver.com');
console.log(result8);

console.clear();