import { useState } from 'react';
import './App.css';

// ajax통신을 할 때 외부라이브러리 
import axios from 'axios';
// 부트스트랩 테이블 포함
import Table from 'react-bootstrap/Table';
function App() {

  // 버튼 클릭시 가져온 데이터 저장
  // 현재 서버가 열려있는 상태! 
  // 데이터를 이미 가져옴 
  // 클릭을 하면 계속 ajax통신을 한다!
  let [click, setClick] = useState([]);

  return (
    <div className="App">

      <button onClick={function () {
        // 1. url  axios.get(url)
        axios.get('https://jsonplaceholder.typicode.com/users')
          .then(function (결과) {
            //성공시 사용하는 then(동작하는 콜백함수)
            console.log(결과.data);
            setClick(결과.data);

          }).catch(function (실패) {
            //실패시에 사용하는 catch(동작하는 콜백함수)
            console.log('실패함!');
          })
      }}>버튼클릭</button>

      {/* 검색창을 만들어서 인덱스를 입력
      버튼 클릭 시 검색된 요소 하나만 테이블에 보여주기

      2. 이름으로 검색
      
      만약 없으면 검색한 번호가 없습니다 alert() */}

      <Table striped bordered hover>
        <thead>
          <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            
          </tr>
        </thead>
        <tbody>
          {
            click.map(function(user){
              return(
                <tr>
                  <td>{user.name}</td>
                  <td>{user.phone}</td>
                  <td>{user.email}</td>
                  
                </tr>
              )
            })
          }
        </tbody>
      </Table>

     
    </div>
  );
}

export default App;



{/* 
1. XMLHttpRequest
2. fetch()
3. axios 같은 외부라이브러리를 사용!
터미널 열고 npm install axios
*/}

// {
  //   click.map(function (post) {
    //     return (
      //       <h4>{post.title}</h4>
      //     )
      //   })
      // }