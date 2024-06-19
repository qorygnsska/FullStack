// ele2.js
// 스크립트 태그가 무조건 한번을 실행된다.

function createImg(){
    // 라디오 버튼을 클릭하고 이미지 표시 버튼을
    // 클릭하면 이미지가 생성되서 div 태그 안쪽으로
    // 추가되야 한다.

    //1. 라디오버튼 가져오기
    let radios = document.
            getElementsByName('radioBtn');
    //img 태그를 추가할 요소값을 가져온다.
    let div = document
            .getElementById('imageView');
    
    // console.log(radios);
    //실제 경로를 가지고 있는 value저장
    let radioValue = '';

    for(let radio of radios){
        //console.log(radio.checked);
        if(radio.checked){
            radioValue = radio.value;
            console.log(radioValue);
        }
    }

    // 기존에 표시되던 img 태그를 제거하고
    // 새로 만든 img 태그를 넣어준다.

    // 삭제할 태그를 선택한다. 
    // 마지막 태그를 선택할 때 사용하는 명령문
    let removeImg = div.lastElementChild;

    // html 문서에서 삭제!
    div.removeChild(removeImg);


    // img이미지 태그 생성 
    let img = document
            .createElement('img');// <img>
    // 속성값 설정
    img.setAttribute('src',radioValue);

    

    // html 문서에 추가하기 
    div.appendChild(img);
}

function removeImg(){
    let div = document.getElementById('imageView');
    div.innerHTML = '';

}