// 자바 스크립트 다운로드 되면 바로 실행! 한번만
$().ready(function(){
    
 

    $.ajax({
        url : "https://jsonplaceholder.typicode.com/users?_limit=2",
        method : 'GET',
        success: function(list){
            // 1. 성공했다면 배열을 테이블에 추가해야된다.
            //     요소값 가져오기
            console.log(list);
            let tableBody = $('#userTableBody');
            tableBody.empty();  // 기존내용 지우기
            for(let user of list){
                let row = `<tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.address.city}</td>
                <td>${user.phone}</td>
                </tr>`
                tableBody.append(row);
            }

        } ,
        error: function(){
            console.log('에러');
        }

    });
});

