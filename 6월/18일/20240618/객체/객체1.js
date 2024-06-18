
// const name = "kyohoon";
// const age = 20;
// const hei = 170.1;
// const weight = 70.1;

function print(name, age){
    console.log(name);
    console.log(age);
}
/*
print("배교훈", 20);

// 자바스크립트에서 기본타입을 사용해서 여러개의 인자를
// 변수들을 추가하면 매개변수 길이 점점 늘어난다

// 1. 가변인자 ...변수명
// 2. 객체(Object)
//  여러 타입을 그룹으로 묶어서 저장하는 기능!

// {}
const obj1 = {};

// key:value
const dog = {
    name : '강아지',
    age : 2
};
// object 담긴 메모리는 따로 있고
// 변수 메모리 공간에 저장되긴 너무 큰 데이터라 dog, obj 변수의 메모리에는 주소 저장
// 자바 클래스랑 비슷하다!
console.log(dog);
console.log(dog.name);
console.log(dog.age);

function printA(animal){
    console.log(`동물의 이름 : ${animal.name} 나이 : ${animal.age}`);
}

// 함수실행
printA(dog);

// 위에 있는 object객체 안에 각각의 key를 이용해서 값을 변경
dog.name = "멍멍이";
dog.age = 3;
print(dog.name, dog.age);

const cat = {
    name : "냥냥이",
    age : 2
};

// dog = cat;

// print(dog.name);

// 위에서 각각의 key를 이용해서 데이터를 변경 가능하다!
// 그 각각의 key를 저장하고 있는 메모리 주소를 변경할 수 없다

// Object
//  자바스크립트의 타입
//  관련있는 데이터나 함수의 묶음이다.

// 만약 토끼에 대한 정보를 저장
const rabbit = {
    name : "토깽이",
    age : 1
};

// Object들 끼리 동일한 변수명이 중복돼서 생길 수 있음
// class문법이 생겼다
*/

const rabbit = {
    name : "토깽이",
    age : 1
};

// object 여러개의 key를 가지고 있다
// 그 안에 key가 존재하는 지 확인
// in
// key가 있으면 true, 없으면 false
console.log(rabbit);
// name이라는 key가 있니?
console.log('name' in rabbit);
console.log('age' in rabbit);
console.log('color' in rabbit);

console.log("--------------------------")

// 반복을 이용해서 하나씩 꺼낼 때
for(let key in rabbit){
    console.log(key + " : " + rabbit[key]);
}

// Object에서 keys() 메서드
//  key만 뽑아올 때 배열 형태
// Object.keys(key를 꺼내올 변수명)
const key = Object.keys(rabbit);
console.log(key);

// key, value를 쌍으로 한꺼번에 뽑아오고 싶을 경우
const en = Object.entries(rabbit);
console.log(en);

// 위에서 2차원 배열로 뽑아온다.
console.log(en[0]);
console.log(en[0][0]);

// key 삭제
delete rabbit.name;
print(rabbit);
