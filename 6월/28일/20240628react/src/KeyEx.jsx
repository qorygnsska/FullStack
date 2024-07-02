import React, { useState } from 'react'

export default function KeyEx() {

    const items = ['Apple','Banana','Cherry'];

    // input에서 입력받은 데이터를 저장
    let [search, setSearch] = useState('');
    // 배열에서 찾은 결과값 저장
    let [result, setResult] = useState(null);

  return (
    <div>
        {/* 
            map을 사용해서 여러개의 요소값을 생성하다 보면 
            요소의 들어가는 항목 변경, 추가, 삭제를 하기 위해서
            요소를 구별하는 사용법으로 key 사용한다.
         */}

        <ul>
            {
                items.map(function(item, index){
                    return(
                        <li key={index}>{item}</li>
                    )
                })
            }
        </ul>

        <input type='text' onChange={function(e){
            setSearch(e.target.value);
        }}/>
        <button className='btn btn-primary' onClick={function(){
            // let findItem = items.find(function(item){
            //     return item === search;
            // });
            // console.log(typeof search);

            // 입력한 검색창에 문자를 숫자로 변경
            // parseInt(값, 10진수);
            let num = parseInt(search, 10);

            // 인덱스로 검색해서 있으면 실제 값을 저장
            let findItem = null;

            items.map(function(item, index){
                if(index === num){
                    findItem = item;
                }
                // map함수는 return이 꼭 있어야된다.
                // 뭔가를 항상 반환을 해야된다.
                return null;
            })

            setResult(findItem);
        }}>검색</button>
        {
            // 찾는 데이터가 있으면 값을 보여주고
            // 없으면 찾는 데이터가 없습니다.
            result ? (
                <div>
                    <h3>검색한 결과 : {result}</h3>
                </div>
            ) : (
                <p>검색한 결과가 없습니다.</p>
            )
        }
    </div>
  )
}
