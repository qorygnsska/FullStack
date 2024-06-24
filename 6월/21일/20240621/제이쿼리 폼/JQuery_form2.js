$().ready(function () {

    // 증복체크 버튼 클릭 이벤트
    $('#checkDuplicate').click(function () {

        // 1. input창에서 입력한 값을 가져오기
        let userId = $('#userId').val();

        // 2. 윈도우 창을 열기
        // open(); -> 새로운창 띄우기
        // open(url, windowName, 설정(스타일));
        // url : 새로운 창이 열릴 때 새 탭에서 
        //         불러올 페이지의 url을 지정한다.
        //         url 없을 시 비워두거나 빈 문자열을 저장한다.
        // windowName : 창 이름, 타겟 이름
        //              새 창의 이름을 지정한다.

        let popup = window.open("", "popup"
            , "width=300,height=200");   // 이때 스타일에 공백 절대 주지 않기

        // 3. 팝업창 안에 새로운 요소값을 추가하는 내용!



    });

    // 이메일 선택시 도메인 입력창에 선택한 이메일 도메인 넣기
    // 1. 요소값 선택하기
    // this는 위치에 따라서 다르게 동작할 수 있다.
    // 이벤트 안에 this이기 때문에 발생한 이벤트 요소를
    // 가지고 와서 그 안에 있는 val()를 이용해서 발생한
    // 값을 가져온다.
    $('#email-select').change(function () {
        let selectDomain = $(this).val();
        console.log(selectDomain);
        $('#email-domain').val(selectDomain);

    });

    // 취미요소들에 이벤트를 추가함
    // 값이 변경될 때 마다 이벤트 발생함
    // 실행문

    $('input[name="hobbies"]').change(function () {

        // 여러개의 취미가 클릭을 할 때마다 배열에 저장하기
        let selected = [];

        // 체크된 요소값 가져오기
        // console.log($('input[name="hobbies"]:checked'));
        // each() : 반복문
        //          선택된 요소들의 인덱스와 요소 자체를
        //          리턴하며 인수로 지정된 함수를 반복해서 실행한다.
        $('input[name="hobbies"]:checked').each(function(){
            selected.push();

            // join(',')
            // 배열의 요소를 구분자를 이용해서 하나의 문자로 리턴한다
            if(selected.length > 0){
                $('#hobby-message').text('선택된 취미는' + selected.join(',')+"입니다.");

            }
        });
    });




















})  