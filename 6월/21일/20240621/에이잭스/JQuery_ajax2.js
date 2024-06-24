$().ready(function(){
    // 이벤트 추가
    $('#loadPosts').click(function(){
        // console.log("실행?");
        $.ajax({
            url:"https://jsonplaceholder.typicode.com/posts/1",
            method:'GET',
            // 성공시
            // 데이터를 보내준다. 그 데이터를 받을 수 있는 
            // 매개변수를 하나 만든다.
            // ajax() 메소드 자체에서 데이터를 
            // 주고 받을 때 자동으로 변환해준다.
            // obj -> JSON타입
            // JSON -> obj 타입으로 변환
            success : function(data){
                // console.log(data);
                console.log(typeof data);
                $('#data').append(
                    '<p>ID: '+ data.id + ',Title: ' + data.title + 
                    ',body: ' + data.body + '</p>'
                );
            },
            // 실패시
            error : function(){
                console.log("에런데?");
            }
        });

    })




    $('#loadComments').click(function(){
        // 클릭이 되면 실행하는 함수
        $.ajax({
            url:"https://jsonplaceholder.typicode.com/comments/1",
            method:'GET',
            success:function(d){
                // console.log(d);
                $('#data').append(
                    '<p>ID: '+ d.id + ',Name: ' + d.name + 
                    ',Email: ' + d.email + ',body: ' + d.body + '</p>'
                );
            }, 
            error: function(e){
                console.log(e);
            }
            
        });
    });




    $('#loadAlbums').click(function(){
        // 클릭이 되면 실행하는 함수
        $.ajax({
            url:"https://jsonplaceholder.typicode.com/albums/1",
            method:'GET',
            success:function(d){
                // console.log(d);
                // 기존에 있는 내용 지우기
                $('#data').empty();
                // 내용 추가하기
                $('#data').append(
                    '<p>ID: '+ d.id + ',Title: ' + d.title + '</p>'
                );
            }, 
            error: function(e){
                console.log(e);
            }
            
        });
    });

    // 여러개의 데이터를 가져오는 함수
    $('#loadPhotos').click(function(){
     // 클릭이 되면 실행하는 함수
     $.ajax({
        url:"https://jsonplaceholder.typicode.com/photos?_limit=6",
        method:'GET',
        success:function(data){

            // 기존에 있는 내용 지우기
            $('#data').empty();
            // 내용 추가하기
            // 위에서 받아온 데이터가 여러개라서
            // 배열형태로 넘어온다.  --> 반복문 사용
            for(let obj1 of data){
                // console.log(obj1);
                $('#data').append(
                    '<p>ID: '+ obj1.id + '<br>,Title: ' + obj1.title + 
                    '<br>,Url: ' + obj1.title +'</p>'
                );
            }
            
        }, 
        error: function(e){
            console.log(e);
        }
        
    });
});
});