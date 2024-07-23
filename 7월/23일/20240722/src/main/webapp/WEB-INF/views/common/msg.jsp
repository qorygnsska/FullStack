<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" 
	   value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		//알림메시지 띄움
		alert("${msg}")
		
		//페이지 이동 
		// 페이지를 리다이렉트 할 때 ,
		// jsp 페이지에서 위치를 조합해서
		// 전체 url을 구성하는 것!
		location.replace("${pageContext.request.contextPath}${location}");
	</script>

</body>
</html>