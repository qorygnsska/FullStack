// tab.js

// 첫번째 버튼을 누르면 orange 클래스명 해제
// 첫번째 content도 show 클래스명 해제

// 두번째 버튼을 누르면 orange 클래스명 부착
// 두번째 content도 show 클래스명 부착

// 세번째 버튼을 누르면 orange 클래스명 해제
// 세번째 content도 show 클래스명 해제

// 1. 요소값 
const tabButtons = document.querySelectorAll
                    ('.tab-button');
const tabContents = document.querySelectorAll
                    ('.tab-content');

// 2번째 탭을 눌렀을 때 실행
// tabButtons[1].addEventListener('click',
//         function(){
//             tabButtons[1].classList.add('orange'); 
//             tabButtons[0].classList.remove('orange'); 
//             tabButtons[2].classList.remove('orange'); 
            
//             tabContents[1].classList.add('show'); 
//             tabContents[0].classList.remove('show'); 
//             tabContents[2].classList.remove('show'); 
//         }
// );

// tabButtons[2].addEventListener('click',
//     function(){
//         tabButtons[2].classList.add('orange'); 
//         tabButtons[1].classList.remove('orange'); 
//         tabButtons[0].classList.remove('orange'); 
        
//         tabContents[2].classList.add('show'); 
//         tabContents[1].classList.remove('show'); 
//         tabContents[0].classList.remove('show'); 
//     }
// );

// tabButtons[0].addEventListener('click',
//     function(){
//         tabButtons[0].classList.add('orange'); 
//         tabButtons[1].classList.remove('orange'); 
//         tabButtons[2].classList.remove('orange'); 
        
//         tabContents[0].classList.add('show'); 
//         tabContents[1].classList.remove('show'); 
//         tabContents[2].classList.remove('show'); 
//     }
// );


// 반복문 사용
// 제이쿼리
//  자바스크립트 문법이 너무 길어서
//  간단하게 줄여주는 문법이 있다.
//  $(셀렉터).on();

// dataset
//  - html 안에 유저 몰래 정보를 숨기는 기능

for(let i = 0; i < tabButtons.length; i++){
    tabButtons[i].addEventListener('click', 
        function(){
            // 1. 모든 탭에 orange 클래스, show 클래스 제거
            for(let j = 0; j < tabButtons.length; j++){
                tabButtons[j].classList.remove('orange');
                tabContents[j].classList.remove('show');
            }
            // 2. 클릭된 탭 버튼에 orange, show 클래스 추가
            tabButtons[i].classList.add('orange');
            tabContents[i].classList.add('show');
        }
    );
}