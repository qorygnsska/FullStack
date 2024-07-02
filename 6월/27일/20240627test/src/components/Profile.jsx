import React from 'react';
import '../App.css';

// 이미지 포함할 때도 똑같이 파일명 작성
import pika from '../image/img02.jpg';
import Avartar from './Avartar';

export default function Profile({image, name, title, isNew}) {
  return (
    <div className='profile'>
        <Avartar image={image} isNew={isNew}/>
        <h1>{name}</h1>
        <p>{title}</p>
    </div>
  )
}
