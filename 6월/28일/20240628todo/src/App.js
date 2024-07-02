import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate, Routes, Route, Link } from 'react-router-dom';
import UserDetail from './UserDetail';

export default function App() {

  let [users, setUsers] = useState([]);
  let [search, setSearch] = useState('');
  // 전체조회,인덱스조회,이름조회
  let [filterUser, setFilterUser]
    = useState([]);

  // 사이트 경로를 기억하는 것!
  let navigate = useNavigate();

  // 버튼 클릭시 전제 내용을 조회하는 함수                      
  function fetchUsers() {

    axios.get('https://jsonplaceholder.typicode.com/users')
      .then(function (response) {
        //성공시 
        console.log(response);
        setUsers(response.data);
        setFilterUser(response.data);
      })
      .catch(function (error) {
        //실패시
        console.error(error);
      });
  }

  //입력창에 데이터가 변경될 때 마다
  // 저장하는 함수
  function searchChange(e) {
    setSearch(e.target.value);
  }

  // 이름으로 검색하는 함수
  function searchByName() {
    let findUser = users.filter(
      function (user) {
        return user.name === search;
      });
    setFilterUser(findUser);
  }
  // index로 검색하는 함수 
  function searchByIndex() {

    const index = parseInt(search, 10);

    if (!isNaN(index) && index >= 0
      && index < users.length) {
      setFilterUser([users[index]]);
    } else {
      setFilterUser([]);
    }
  }
  // 문자 검색 함수 
  function searchByChar() {
    const findChar = search.toLowerCase();
    const result = users.filter(function(user){
      return(
        user.name.toLowerCase().includes(findChar) && 
        user.email.toLowerCase().includes(findChar)
      )
    });

    setFilterUser(result);
  }
  //행을 클릭했을 때 상세페이지로 이동하는
  // 함수 
  function userClick(user){
    //console.log(user);
    // navigate()함수도 페이지 이동을 시킬수
    // 있다. 그리고 페이지 이동시 히스토리스택
    // 공간에 페이지가 저장된다. 
    navigate(`/user/${user.id}`,{state : {user}});

  }

  return (
    <div className='container mt-5'>

      <Routes>
        <Route path='/' element={
          <div>
            <button className='btn btn-primary mb-3'
              onClick={fetchUsers}>전제 조회</button>

            <input type="text"
              className='form-control'
              placeholder='name or index'
              onChange={searchChange}

            />

            <button className='btn btn-primary m-2'
              onClick={searchByName}>이름으로 검색</button>

            <button className='btn btn-primary m-2'
              onClick={searchByIndex}>인덱스로 검색</button>

            {/* 버튼을 하나 추가해서 버튼명:문자 검색
        테이블에 검색한 문자를 포함한 요소값을
        출력하기!
      */}
            <button className='btn btn-primary m-2'
              onClick={searchByChar}>문자 검색</button>

            {
              // 0일때는 아무것도 출력 안함!
              // 1이상일 때 데이터 테이블에 출력하기
              filterUser.length > 0 ? (
                <table className='table table-striped'>
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Email</th>
                      <th>Phone</th>
                    </tr>
                  </thead>
                  <tbody>
                    {
                      filterUser.map(function (user) {
                        return (
                          <tr key={user.id} 
                              onClick={()=>{
                                userClick(user);
                              }}
                              style={{cursor:'pointer'}}>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>{user.email}</td>
                            <td>{user.phone}</td>
                          </tr>
                        )
                      })
                    }
                  </tbody>
                </table>
              ) : (
                <h3>찾는 데이터가 없습니다!</h3>
              )}
          </div>
        } ></Route>

        <Route path='/user/:id' 
               element={<UserDetail />}/>
      </Routes>
    </div>
  )
}
