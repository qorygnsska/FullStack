// 이미지를 변경하기 위해서는
// 버튼을 눌렀을 때 이동할 수 있는 요소들을 가져와야한다
let a = document.querySelectorAll('a');
let img = document.querySelectorAll('img')[0];

// 이미지 사진의 기준을 잡는다.
let count = 3;

// 이벤트 생성
a[0].addEventListener('click', function(){
    // 이미지를 이전으로
    count = --count < 1 ? 5 : count;
    // 요소 값 안에 속성을 수정할 때는
    // setAttribute('속성key' : '속성 value');
    img.setAttribute('src', './img/img0' + count + '.jpg');
    stopAutoSlide();
});

a[1].addEventListener('click', function(){
    // 이미지를 이후로
    count = ++count > 5 ? 1 : count;
    // 요소 값 안에 속성을 수정할 때는
    // setAttribute('속성key' : '속성 value');
    img.setAttribute('src', `./img/img0${count}.jpg`);
    stopAutoSlide();
});

// 타이머 기능 중에서 방향만!
// setInterval("몇초마다 실행", "3초");
function autoSlid(){
    count = ++count > 5 ? 1 : count;
    // 요소 값 안에 속성을 수정할 때는
    // setAttribute('속성key' : '속성 value');
    img.setAttribute('src', `./img/img0${count}.jpg`);
}

let autoSlideInt = setInterval(autoSlid, 500);

function stopAutoSlide(){
    clearInterval(autoSlideInt);
}

// 만약 몇초동안 버튼을 클릭하지 않으면 다시 움직이기
