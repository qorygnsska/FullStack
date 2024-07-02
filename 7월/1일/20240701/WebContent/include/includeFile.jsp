<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includeFile.jsp</title>
</head>
<body>
	<%
		// 자바코드 작성
		LocalDate today = LocalDate.now();
	
		LocalDateTime tom = LocalDateTime.now().plusDays(1);
		
		out.println(today + "<br>");
		out.println(tom + "<br>");
	%>
</body>
</html>