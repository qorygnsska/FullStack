<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carMain.jsp</title>

<!--  원하는 라이브러리 가져오기  -->
 
 <!--  내가 만든 css,자바스크립트 파일 포함 -->
 
</head>
<body>
	<%
		// 클라이언트가 버튼을 클릭해서 원하는 사이트를 요청할 때마다
		// 페이지가 변경할 수 있도록 url에 center 변수를 이용해서
		// 페이지명을 입력 받는다.
		String center = request.getParameter("center");
		// 처음 페이지를 요청하면 페이지가 없다!
		if(center == null){
			center = "center.jsp";
		}
	%>

	<div align="center">
	<!-- header.jsp -->
	<%-- <%@ include file="header.jsp" %> --%>
	<jsp:include page="header.jsp"/>
	
	<!-- center 부분만 페이지 변경하면서 보임 -->
	<jsp:include page="<%= center%>"></jsp:include>
	
	<!-- footer.jsp -->
	<%-- <%@ include file="footer.jsp" %> --%>
	<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>

<%--
	<%@ include>
	jsp파일 안에 있는 모든 코드르
--%>