// effectTest.js

$().ready(function(){

    /*
    만약 post 전송할  때는 
    $.post('url',전송할 데이터)
    .done(성공시 실행할 콜백함수)
    .fail(실패시 실행할 콜백함수);
    */
        
    //get 데이터를 가지고 올때만! 조회만 할때
    let products = [];
    $.get('productlist.json')
    // 성공시 실행하는 함수를 작성한다.
    // 성공을 하면 실행하기 때문에 콜백함수!
    // .then(function(){}); 둘 중 하나 사용하면 됨
     .done(function(data){
        
        products = data;
        appendProducts(products);
     }).fail(function(e){
        console.log(e);
     });  

     function appendProducts(products) {
        products.forEach(function (product) {

            var 템플릿 = '<div class="col-sm-4">'
                + '<div class="card">'
                + '<img src="열동그라미.png" class="card-img-top" alt="...">'
                + '<div class="card-body">'
                + '<h5 class="card-title">' + product.title + '</h5>'
                + '<p class="card-text"> 가격:' + product.price + '</p>'
                + '</div>'
                + '</div>'
                + '</div>';

            //템플릿을 추가할 요소를 가져오기 
            $('.row').append(템플릿);

        });
    } // appendProducts함수 끝
    appendProducts(products);


    // 최신순 버튼을 눌렀을 때 실행하는 함수
    // 버튼이벤트도 달기 

    $('#test1').click(function(){
        //최신순으로 정렬하는 함수를 만들기
        test1(products);
    });
    $('#test2').click(function(){
        //최신순으로 정렬하는 함수를 만들기
        test2(products);
    });

    //------------------------------------
    function test1(products){
        //최신 날짜 기준으로 sort()
        //배열 복사!
        let test = [...products];
        // console.log(new Date("2023-06-20"));
        
        test.sort(function(a,b){
           
            // 비교했을 때 음수값을 이용해서 
            // 내림차순으로 정렬했다!
            return new Date(b.date) - 
            new Date(a.date);
        });
        console.log(test);
        // 실제 데이터만 정렬이 된 것뿐
        // html 요소에 적용을 시킨다.
        // 기존 내용은 지우기
        $('.row').empty();
        appendProducts(test);
        
    }

    function test2(products){
        //배열 복사!
        let test2 = [...products];
        test2.sort(function(a,b){
            return a.ranking - b.ranking;
        });
      
        $('.row').empty();
        appendProducts(test2);
    }



});

/*
    // $.ajax({
    //     url:'productlist.json',
    //     dataType:'json',
    //     success: function(data){
    //         console.log(data);
    //     },
    //     error: function(){}
    // });

*/