// 이벤트 발생시 처리 3단계
// 1. 감시할 대상을 지정한다. 
// 2. 특정 이벤트를 지속적으로 발생하는지 감시!
// 3. 이벤트 발생하면 동작을 수행!

// 1. 메뉴를 저장하는 배열을 선언한다.
const menuCart = [];

// 2. 결과를 출력하는 요소값을 가져온다.
const resultDiv = document
            .querySelector('#order-list');
// 버튼들의 요소를 가져오기
const menuButtons = document
            .querySelectorAll('#practice-3 button');
console.log(menuButtons);
// 3. 각각의 버튼에 리스너(감시자)
for(let i=0; i < menuButtons.length; i++){
    // 감시를 시작한다.
    menuButtons[i].addEventListener(
        'click',function(event){
            // 4. 처리를 수행 

            // 클릭된 버튼을 가져옴
            const btn = event.target;
            // console.log(btn);

            //버튼이 가지고 있는 텍스트를 가져오기
            // innerText 요소 안에 text만 가져온다.
            const menuName = btn.innerText;
            //console.log(menuName);

            // 장바구니 배열에 담기 
            menuCart.push(menuName);

            // 장바구니 배열을 html 문서에
            // 적용!

            resultDiv.innerText =
                `>>[${menuCart}]이 주문되었습니다.`;



        }
    );

}