import { useState } from 'react';
import './App.css';

function App() {

  // 변수를 선언시 함수 바로 밑에 지역변수개념
  let [글제목,글제목변경] = useState(['남자 코트 추천','강남 우동 맛집','자바 독학']);

  const user = {name:"배교훈", age:20};           
  
  function click(){
    alert("클릭됐니?");
  }
  return (
    
    <div>
      {/* 컴포넌트  
      props 이용을 해서 App컴포넌트가
      가지고 있는 변수값을 자식 컴포넌트
      인 Model 에게 전송할 수있다. 

      1. 자식 컴포넌트 사용하는 곳에
        가서 <자식컴포넌트 작명={state이름} />
      2. 자식컴포넌트를 만드는 function으로 가서
      () 안에 props라는 파라미터 등록후 
       props.작명 사용

        useState()
        몇 개든 무한히 전송 가능
       <Model 글제목={글제목}
              변수명={변수,함수}
              변수명="아무문자나 전송가능"

        <Model> 태그가 App 부모 컴포넌트한테 데이터를 보낼 수는 없다!

        같은 형제들 옆에 있는 컴포넌트들기리는 데이터 전송할 수 없음!
        <Model></Model>
        <Model></Model>

        함수에 매개변수를 사용하는 이유
        함수 하나로 다양한 기능을 사용하기 위해서 쓰는게 파라미터문법

      */}
        <Model 글제목={글제목} color='blue'></Model>
        {/* 자식 컴포넌트에서 user라는 변수명으로 데이터를 꺼내서 사용할 수 있다 */}
        <UserProfile user={user}/>

        {/* 함수를 넘길 땐 함수명만 작성하면 된다 */}
        <Funt onClick={click}/>
      </div>
    
  );
}

// 함수를 props로 넘길수도 있다.
function Funt(props){
  return(
    <div>
      <button onClick={props.onClick}>눌러봐!</button>
    </div>
  );
}

// 객체 타입으로 넘기기
function UserProfile(info){
  return(
    <div>
      <h2>{info.user.name}</h2>
      <p>Age: {info.user.age}</p>
    </div>
  );
}

//새로운 컴포넌트를 작성한다. 
function Model(props){
  // 글제목은 App() 컴포넌트 안에
  // 선언되어있고 Model하는 컴포넌트
  // 안에는 없다!
  let data = "안가는데";
  return (
    <div className='model' style={{background:props.color}}>
      <h4>{props.글제목[0]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}



export default App;