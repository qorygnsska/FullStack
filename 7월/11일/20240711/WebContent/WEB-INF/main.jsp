<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<img alt="이미지" src="${pageContext.request.contextPath}/images/boardimage.png">

	<!-- 글쓰기 
 		1. 글쓰기 버튼을 입력하면 MainController로 가기
 		2. insert.nhn 서블릿 호출
 		3. insert.jsp 웹 페이지 보이기
 	-->
 	<div>	
 		<input type="button" value="글쓰기" onclick="location.href='insert.nhn'"/>	
 	</div>
 	
	
</body>
</html>