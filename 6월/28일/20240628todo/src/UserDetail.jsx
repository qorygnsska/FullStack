// UserDetail.jsx

import React from 'react'
import { useLocation, useNavigate } from 'react-router-dom';

export default function UserDetail() {

    // App.js 파일에서 테이블을 선택시 넘어온
    // 데이터를 꺼낼때 사용하는 기능(훅)
    // 현재 위치 정보를 담은 객체를 가져온다.

    const location = useLocation();
    const { user } = location.state || {};
    const navigate = useNavigate();
    // console.log(user);

  return (
    <div className='container mt-3'>
        <h1>{user.name}</h1>
        <p>{user.username}</p>
        <p>{user.email}</p>
        <p>{user.phone}</p>
        <p>{user.website}</p>
        <p>{user.address.city}</p>

        <button className='btn btn-primary mt-3' onClick={function(){
          navigate(-1);
        }}>뒤로가기</button>
    </div>
  )
}
