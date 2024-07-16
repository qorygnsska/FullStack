<%@page import="com.project.dto.MvcDTO"%>
<%@page import="com.project.service.MvcService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%
		ArrayList<MvcDTO> list = MvcService.getInstance().selectAll();

		request.setAttribute("list", list);
	%>

	<!-- 
 	아이바티스 , 마이바티스 둘 중 하나로
 	게시판 구현하기 
 	1. pageSize 5 , 10 , 15 , 20
 	2. 페이징 처리 
 	3. 데이터를 list.jsp에서 출력할 수있도록
 	4. 상세 페이지를 눌렀을 때 
      	조회수 증가 !
      	상세 글을 ajax() 데이터를 출력!
   		ajax()사용 x 컨트롤러를 이용해서 
      	데이터 출력하는 문장!
      
   	모두의 집 혹은 마켓컬리 문의 게시판 디자인
   	제목,작성자, 작성일 , 조회수 
   -->
	<div class="container">
		<h2 class="mt-4">리스트</h2>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>제목</th>
					<th>내용</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.idx}</td>
						<td>${item.name}</td>
						<td>${item.subject}</td>
						<td>${item.content}</td>
						<td>${item.hit}</td>
						<td>${item.writeDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>