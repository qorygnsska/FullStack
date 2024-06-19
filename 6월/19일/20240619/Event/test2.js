// test2.js
function allCheck(){

    // name 속성이 all 체크박스에 의해서
    // 체크가 되면 전부 체크한다 true
    //  false가 되면 전부 해제 시킨다.
    console.clear();
    
    let check =  document
                .getElementsByName('all')[0]
                .checked;
    
    const checkBoxs = document
            .getElementsByName('chk');
    
    for(let checkbox of checkBoxs){
        checkbox.checked = check;
    }
    
    /*
     // 태그객체.classList: 태그 객체의 클래스 값들을 
        //                    담고 있는 배열 
        // 태그객체.classList.add('클래스명')
        //      - 태그객체에 클래스를 추가 
        // 태그객체.classList.remove('클래스명')
        //      - 태그객체에 클래스를 제거   
    */

}

function chkSelect(){

    const checkBoxs = document
            .getElementsByName('chk');

    let flag = true;
    
    // console.log(checkBoxs);
    for(let checkbox  of checkBoxs){
        // 체크박스안에 속성 checked
        // 이용해서 구별해서 적용!
        // console.log(checkbox.checked);

        // 파란색,빨간,노랑 체크 박스중에
        // 하나라도 false는 체크 풀렸다는 소리
        // 전체 선택하는 버튼도 체크가 풀릴 수
        // 있도록 flag값을 false로 변경해서
        // 저장한다. 

        if(!checkbox.checked){
           flag = false; 
        }
    }

    // 만약 위에서 전부 true이면 전체선택
    // 버튼을 체크로 보여주기
    document.getElementsByName('all')[0]
            .checked = flag;


}

function selectColor(){
    // 선택 버튼을 클릭했을 때 
    const checkBoxs = document
            .getElementsByName('chk');
    // 체크박스의 버튼들 중에서 checked
    // 가 true이면 각각의 색상으로 변경하기

    for(let checkbox of checkBoxs){
        console.log(checkbox.value);
        console.log(typeof checkbox.value);

        if(checkbox.checked){
            document
            .getElementById(checkbox.value)
            .style.backgroundColor=checkbox.value;
        }else{
            document
            .getElementById(checkbox.value)
            .style.backgroundColor='white';
        }
    }


    // 만약 체크가 풀리거나 체크가 안된
    // 체크버튼들은 하얀색 배경을 한다.
}
function clearColor(){

    // let div = document
    //         .getElementById('colorBox');

    let divs = document
        .querySelectorAll('#colorBox div');
    //console.log(divs);

    for(let div of divs){
        div.style.backgroundColor='white';
    }

    // 전체 선택 체크박스를 요소를 가져온다.
    let all = document.querySelectorAll('input');
    //console.log(all[0]);
    all[0].checked = false;

    allCheck();
}