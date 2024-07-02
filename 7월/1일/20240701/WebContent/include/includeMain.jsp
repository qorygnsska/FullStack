<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! // 선언부를 이용한다.
	public int add(int a, int b){
		return a + b;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includeMain.jsp</title>
</head>
<body>

	<% 
		// 함수를 실행할 때는 스크립틀릿에안에서 실행
		// 함수를 정의할 수 없다.(함수 작성 안됨)
		int result = add(10, 20);
	%>
	<p> 덧셈 결과 : <%= result %></p>
	<p> 덧셈 결과2 : <%= add(20, 50) %></p>
	<%-- 
		includeFile 파일의 모든 내용을 복사해서
		Main으로 가지고 와서 하나의 파일에서 컴파일이
		진행된다.
		html에서 시멘틱태그를 이용해서 웹페이지 구분할 때
		많이 사용한다.
	 --%>
	<%@ include file = "includeFile.jsp" %>
</body>
</html>