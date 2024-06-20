function addAppend(){
    // 기준이 되는 태그 가져오기
    let fieldset = document.querySelector("#addElement");
    
    let p = document.createElement('p');
    p.innerHTML = '<b>fieldset 내부의 div태그 뒤에 추가</b>';

    // html 문서에 추가하기
    fieldset.appendChild(p);
}

function addBefore(){
    let fieldset = document.querySelector("#addElement");

    let p = document.createElement('p');
    p.innerHTML = '<b>fieldset 내부의 div태그 앞에 추가</b>';

    // let div = document.getElementsByTagName('div')[0];
    let div = document.querySelectorAll('#addElement > div')[0];

    // 앞쪽에 추가하기
    // insertBefore(태그1, 태그2)
    // - 태그2 앞에 태그1을 삽입한다.
    fieldset.insertBefore(p, div);
}

function moveElement(){
    // 기준이 되는 필드셋 요소를 가지고 온다.
    // children[인덱스]: 선택된 태그의 인덱스 번째 해당 되는 자식 요소를 얻어옴
    let fieldset = document.querySelector("#addElement");
    console.log(fieldset.children[0]);
    console.log(fieldset.children[1]);

    // 특정 태그를 선택해서 다른 위치에 넣어주면
    // 기존 위치에 있는 태그는 제거됨 -> 이동됨
    let body = document.body;
    body.appendChild(fieldset.children[1]);
}