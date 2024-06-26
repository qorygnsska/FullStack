// AppTest1.jsx

// 다른 js파일들을 import하거나
// 컴포넌트 타입으로 만들어서 
//  <div> 태그를 만들어서 추가해서 사용할 수있다.

import React, { useState } from 'react'

export default function AppTest1() {
    
    let arr = [1,2,3];
    //let arr2 = arr; // 하나의 데이터를 가지고
                    // 공유하는 것!
    let arr2 = [...arr];
    // ... 안에 괄호를 벗기고 새로운 배열에
    //   데이터를 담아 주세요! 

    console.log(arr == arr2);
    // ... 연산자
    //  array,object 자료형 왼쪽에 붙일 수
    // 있으며 괄호를 벗겨주세요!                  

    // 램이라는 가상공간에 몰래 저장이 된다.
    // 배열,객체 자료들은 하나로 만들어서 안에
    // 값을 변경 못하는 자바 String 클래스랑똑같다

    let [글제목,글제목변경] = 
    useState(['여자 코트 추천',
                '강남 우동맛집',
                '파이썬 독학' ]);

  
    return (
    <div>AppTest1
        <button onClick={()=>{
            // 배열의 모든 내용을 새로운 배열에
            // 복사한다. 
            let copy = [...글제목];
            copy.sort();
            글제목변경(copy);
        }}        
        > 정렬버튼 </button>

        <h3>글제목: {글제목[0]}</h3>
        <h3>글제목: {글제목[1]}</h3>
        <h3>글제목: {글제목[2]}</h3>


        <button onClick={()=>{
            // 배열의 모든 내용을 새로운 배열에
            // 복사한다. 
            // 내림차순 코드작성!
            let copy2 = [...글제목];
            copy2.sort(function (a,b){
                return b.localeCompare(a);
            });
                
            글제목변경(copy2);
           

        }}        
        > 내림차순 정렬 </button>
        
        <h3>글 내림정렬 제목: {글제목[0]}</h3>
        <h3>글 내림정렬 제목: {글제목[1]}</h3>
        <h3>글 내림정렬 제목: {글제목[2]}</h3>


    </div>
  )
}
/*

*/