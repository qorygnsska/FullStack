// 버튼 2번이 눌렸을 때 실행
let slidebtn2 = document.getElementById("2");

let slidebtn3 = document.getElementById("3");

let slidebtn1 = document.getElementById("1");

slidebtn2.addEventListener('click', function(){
    document.querySelector('.slide-container').style.transform = 'translateX(-100vw)';
});

slidebtn3.addEventListener('click', function(){
    document.querySelector('.slide-container').style.transform = 'translateX(-200vw)';
});

slidebtn1.addEventListener('click', function(){
    document.querySelector('.slide-container').style.transform = 'translateX(0)';
}); 