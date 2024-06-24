$().ready(function(){

    // 중복체크 버튼 클릭 이벤트
    $('#checkDuplicate').click(function(){

        // 1. input창에서 입력한 값을 가져오기
        let userId = $('#userId').val();

        // 2. 윈도우 창 열기
        // open(); 새로운 창 띄우기!
        // open(url, windowName, "설정(스타일)")
        // url : 새로운 창이 열릴 때 새 탭에서 불러올 페이지의 url을 지정한다.
        //       url 앖을 시 비워두거나 빈 문자열을 지정
        // windowName : 새 창의 이름을 지정한다
        let popup = window.open("", "popup", "widtg=300,height=200");
        
        // 팝업창 안에 새로운 요소값을 추가하는 내용

    });

    // 이메일 선택 시 도메인 입력창에 선택한 이메일 도메인에 넣기
    // 1. 요소값 선택하기

    // this는 위치에 따라서 다르게 동작할 수 있다.
    // 이벤트 안에 this이기 때문에 발생한 이벤트 요소를
    // 가지고와서 그 안에 있는 val()을 이용해서 발생한 값을 가져온다.
    $('#email-select').change(function(){
        let selectDomain = $(this).val();

        $('#email-domain').val();
    });
});
