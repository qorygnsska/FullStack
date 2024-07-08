<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FormResult.jsp</title>
</head>
<body>
	<h2>폼 제출 결과</h2>
	<p>${member.name}</p>
	<p>${member.gender}</p>
	<p>${member.grade}</p>
	
	<p>${member.printArray()}</p>
</body>
</html>