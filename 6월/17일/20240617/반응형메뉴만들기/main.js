const toggleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.navbar_menu')
const icons = document.querySelector('.navbar_icons');

console.log(toggleBtn);
console.log(menu);
console.log(icons);

// classList.toggle(String)
// 1개의 인수만 있을 때
// 클래스 값 토글링을 한다. 클래스가 있으면 제거 false 반환
// 존재하지 않으면 클래스 추가하고 true를 반환
toggleBtn.addEventListener('click', function(){
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});