// App이라는 자바스크립트 파일로
// 경로가 지정되어있기 때문에
// css도 기본적으로 App.css 
// 밑에 있는 useState 꼭 포함해야 사용가능
// 하다  이거는 자동완성으로 가능하다!
import { useState } from 'react';
import './App.css';

function App() {

  let [글제목,글제목변경] = useState(['여자 코트 추천',
                '강남 우동맛집',
                '파이썬 독학' ]);
  
  return (
    
    <div className="App">
      <button onClick={()=>{
              
        //글제목[0] = '남자코드 추천';
        let copy = [...글제목];
        copy[0] = '남자코트 추천';
        // 수정버튼을 클릭했을 때 
        // 남자 코트 추천 이면 여자 코트 추천 변경
        // 여자 코트 추천이면 남자 코트추천 변경
        
        글제목변경(copy);
        console.log(글제목[0]);

      }}>
        수정버튼      
      </button>  

      <h1>{글제목[0]}</h1>
    
    </div>
  );
}

export default App;
/*
  
  // 변수 생성 
  // 변수를 html에 꽂아넣는 작업을 
  // 데이터 바인딩 {}
  // let data = 'red';
  // let post = '신분당선 강남역 맛집';

  let array = ['여자 코트 추천',
                '강남 우동맛집',
                '파이썬 독학'       
  ];

  let array2 = ['kim',20];
  
  //let name = array2[0];
  //let age = array2[1];

  let [name,age] = ['lee',20];
  
  // 따봉을 누르면 숫자를 기억해서 
  // 따봉수를 표현하고 싶다.
  // let like = 0;

  // 변수의 값은 변경 되지만 실제 리액트가
  // 변수가 변경된 값을 html 코드에 적용을
  // 시켜야된다. 그 적용을 못시킨다. 
  //  useState('보관할 자료'); 이 함수를 이용해서 값을 
  //   저장하고 수정할 때 리액트가 감지할 수있다.
  
  //  let [변수명,변수를 수정하는 함수명]

  // 일반변수는 데이터 값은 변경 되지만 html에 
  //  적용이 안된다. 고정된 값을 저장할 때
  // const num = 10;

  // 데이터를 변경해서 html 에 보여줘야될 경우
  // useState() 
  let [likes,setLike] = useState([0,0,0]);

 

  // 일반함수를 작성해서 사용할 수있다.
  // 클릭을 했을 때 공간의 번호를 받아온다.
  function increment(index){
    console.log(index);
    // useState() 함수는 변경을 하면 안 에있는
    // 모든 내용을 수정을 해버려서 기존에 있던
    // 배열이 사라진다. 

    // 기존에 있는 배열을 새로운 공간에 복사해서
    // 복사한 다음에 수정하는 값을 저장하고
    // 수정된 값 전체를 useState() 수정하는곳에
    // 저장한다. 
    let newLikes = [...likes];
    newLikes[index] += 1;
    setLike(newLikes);

  }
    <div className='black-nav'>
        <div>ReactBlog</div>
      </div>

      <div className='list'>
        <h4>{array[0]} 
          <span onClick={()=>{
              increment(0);
          }}>👍</span>  {likes[0]}</h4>
        <p>2월 17일 발행</p>
        <p>{name}</p>
      </div>

      <div className='list'>
        <h4>{array[1]} 
          <span onClick={()=>{
            increment(1);
            }}>👍</span> {likes[1]} </h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4>{array[2]}
           <span onClick={()=>{
              increment(2);
          }}>👍</span> {likes[2]}</h4>
        <p>2월 17일 발행</p>
      </div>

      

       react snippets 
        새로운 파일 만들 때 rfc 단축키 누르면
        자동으로 함수를 만들어준다. 
      



*/