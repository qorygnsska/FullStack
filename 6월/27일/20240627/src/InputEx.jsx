// InputEx.jsx
import React, { useState } from 'react'
import './App.css';

export default function InputEx() {
  //변수명,setter함수 두 이름아무거나 작성
  let [입력값, 입력값변경] = useState('');
  let [array, setArray] = useState(['여자 코트 추천', '강남 우동맛집', '파이썬 독학']);
  return (
    <div>

      <div className='black-nav'>
        <div>ReactBlog</div>
      </div>

      {
        // array 배열의 개수만큼 반복을 하게된다
        // title은 array의 값을 저장하고
        // index는 말 그대로 공간의 번호를 가지고 온다
        array.map(function (title, index) {
          return (
            <div className='list' key={index}>
              <h4>{title}
                <span>👍</span> 0</h4>
              <p>2월 17일 발행</p>
            </div>
          );
        })
      }

      {/* state 변경 함수는 약간 늦게 처리가
        된다.  비동기적 처리! 
        자바스크립트 리액트 기본적으로 비동기적
        처리를 하기 때문에 늦게 처리되는 코드는
        잠깐 제쳐두고 바로 다음줄을 실행한다.*/}
      <input onChange={(e) => {
        // 입력값이 변경되면 입력값 변수를 수정
        입력값변경(e.target.value);
      }} />
      <button onClick={() => {
        // 배열에 추가하기(글 제목)
        // 배열을 가지고 와서 복사 후에 새로운 내용을 추가하는 방법
        let copy = [...array];
        copy.unshift(입력값);

        // setArray함수를 이용해서 추가
        setArray(copy);

        console.log(Array);
      }}>글발행</button>

      {/* 리액트는 내용이 없는 요소들도 
        무조건 닫는 태그를 사용해야된다.
        input 태그는 html과 똑같다!
        
        onClick 클릭했을 때 이벤트
        onChange 입력한 데이터가 변경시 이벤트
        onInput 입력을 할 때마다 이벤트
        
        onMouseOver
        onScroll 스크롤했을 때 안에 코드를
                 실행해라!
        
        <input type="text" 
            onChange={
            function(e){
               // 데이터가 변경시 안에있는
               // 내용을 가져오고 싶을 경우
               console.log(e.target.value);



               //단순출력 console.log("1");
            }
        }/>

        {/* 
            submit 타입은 서버로 데이터
            를 전송하는 역할 
            현재 발생한 이벤트 e.target
            기본동작을 막아주는 역할 
            e.preventDefault()

            버블링 
            자식을 클릭했으면 자식만 이벤트가
            실행하면 되는데 부모까지 같이 
            실행이 되는 버블링 현상을  막기
            e.stopPropagetion()

        
        <input type="range"/>
        <input type="date"/>
        <input type="number"/>
        <select>
            <option>사과</option>
            <option>바나나</option>
            <option>오렌지</option>
            
        </select>
        
    */}
    </div>
  )
}
