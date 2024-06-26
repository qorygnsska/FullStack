// Model.jsx

import React, { useState } from 'react'
import './App.css';

export default function Model() {

    let [글제목, 글제목변경] =
        useState(['여자 코트 추천',
            '강남 우동맛집',
            '파이썬 독학','역삼역 집밥 추천']);

    // 모달창을 처음에는 안보였다가 버튼,라벨
    // 따봉을클릭했을 때 실행하기
    // let [box1,setBox1] = useState('닫힘');
    let [box, setBox] = useState(false);

    // map()사용방법
    let 어레이 = [2,3,4];

    let newArray = 어레이.map(function(a){
        //console.log(1);
        return a * 10;        
    });
    console.log(newArray);

    return (
        <div>

         <div className='black-nav'>
                <div>ReactBlog</div>
            </div>
            {/*  계속 list가 반복되서 나올 경우
        반복문을 이용해서 줄일 수 있다.
        for 문은 JSX 중괄호 안에서 사용할 수
        없어요! 
        map() 

        
    */}

        {
            //글제목 배열의 개수만큼 요소를 
            // 생성한다. 
            // 배열의 값을 0번부터 하나씩 꺼내서
            // function(data){}에 하나씩
            // 저장한다. 

            // foreach()문은 단순히 데이터를
            // 가져와서 반복 데이터 변수 자체를
            // 수정하지 않는다!

            // map 반복을 하면서 데이터를 가져와
            // 서 조건이나 html 코드로 변경해서
            // 글제목이다 라는 데이터 배열 공간에
            // 저장한다. 
            
            글제목.map(function(data){
                return (
                <div className='list'>
                    <h4>{data}
                        <span onClick={() => { }}>👍</span> 0</h4>
                    <p>2월 17일 발행</p>
    
                </div>
                )
            })
        }


{/*            
            <div className='list'>
                <h4>{글제목[0]}
                    <span onClick={() => { }}>👍</span> 0</h4>
                <p>2월 17일 발행</p>

            </div>

            <div className='list'>
                <h4>{글제목[1]}
                    <span onClick={() => { }}>👍</span> 0</h4>
                <p>2월 17일 발행</p>


            </div>
            <div className='list'>
                <h4>{글제목[2]}
                    <span onClick={() => { }}>👍</span> 0</h4>
                <p>2월 17일 발행</p>

            </div>
 */}

            {/* box변수값이 true이면 <Box></Box>
        false 이면 아무것도 보여주지 않는다.

        JSX 안에서는 if ~  else문법을 바로
        사용할 수 없다!

         <button onClick={()=>{
        // 1.버튼을 클릭햇을 때 모달창!
        // 2. 버튼을 한번 더 누르면 모달창이
        //   안보임 (토글)
        // 현재 box는 false 안보임
        // false일 떄는 true 변경 
        setBox(!box);

      }}>{글제목[0]}</button>
      {
        //삼항연산자  ?
        // null 텅 비었다. 
        box == true ? <Box></Box> : null

        // 3 > 1 ? console.log("맞다") :
        //         console.log("다르다!")
      }


    */}
 {/* {
            // 게시글 서버에서 게시글의데이터를
            // 받아와서 배열에 저장 후 배열의
            // 개수만큼 자동으로 저장,사진데이터를
            // 장바구니 ...

            // 배열의 자료 개수만큼 
            // map내부 코드를 실행한다. 
            // 그 안에 return html 요소
            // [<div>안녕</div>,
            // <div>안녕</div>,<div>안녕</div>]
            [1,2,3].map(function(){
                return (<div>안녕</div>)
            })
           }    */}



            {/* <Box></Box>
      <Box />
      <Box></Box> */}


            {/* 위에 처럼 긴~ html을 한 단어로 
      깔끔하게 치환해서 넣을 수 있는 문법제공된다.
      하나의 단어로 만든것
      Component 컴포넌트 

      리액트에서 동적으로 요소값을 만들때 
      1. html, css 미리 디자인 해놓는다.
      2. 데이터를 저장하는 내용 state저장하기
      3. state에 따라서 어떻게 보일지 조건문을
       반복문 등을 이용해서 보이기 


      
      */}



        </div>
    )
}

// 새로운 함수를 만들 때는 현재 파일명과
// 동일한 함수 밖에 선언을 해야된다.
function Box() {
    return (
        <div className='model'>
            <h4> 제목 </h4>
            <p> 날짜 </p>
            <p> 상세내용 </p>

        </div>
    );
}