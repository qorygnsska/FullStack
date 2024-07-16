<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일명: index.jsp</title>
</head>
<body>
	index페이지 
	
	<%-- index.jsp 페이지에서 
		새로운 요청을 실행한다. 
		메인 컨트롤러가 insertForm.do 받으면
		InsertForm.jsp페이지가 실행될 수 있도록
		컨트롤러 설정 !
	 --%>
	 <%
	 	response.sendRedirect("insertForm.do");	 
	 %>
	
</body>
</html>