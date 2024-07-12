<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>

<style>
	a{
		text-decoration: none;
	}


	a:hover{
		color:red;
		text-decoration: none;
		font-weight: bold;
	}
</style>

</head>
<body>


	<table border="1" align="center" width="1000">
		<tr>
			<th colspan="5">게시판 보기</th>
		</tr>
		<tr>
			<td colspan="5" align="right">1/1</td>
		</tr>
		<tr>
			<th width="70">글번호</th>
			<th width="620">제목</th>
			<th width="120">이름</th>
			<th width="120">작성일</th>
			<th width="70">조회수</th>
		</tr>


		<c:set var="list" value="${boardList}" />
		<!--  만약 데이터가 없으면 ! 어떤 내용 출력 -->
		<c:if test="${ list == null }">
			<td colspan="5"><marquee>테이블에 저장된 글이 없습니다.</marquee></td>
		</c:if>

		<c:if test="${ list != null }">
			<!--  for(타입 변수명: 배열,map,list> 같은 문법 -->
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.idx}</td>
					<td><a href="contentView.nhn?idx=${dto.idx}">${dto.subject}</a></td>
					<td>${dto.name}</td>

					<!--  jstl에서 제공하는 태그 라이브러리 중
 							날짜 시간 형식을 지정할 수 있는 태그  fmt -->
					<td align="center"><fmt:formatDate value="${dto.writeDate }" pattern="yyyy.MM.dd(E)" /></td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
		</c:if>
		
		<tr>
		<td colspan="5">페이징 처리할 공간</td>
		</tr>
		
		
		<tr>
		<td colspan="5" align="right"><input type="button" value="글쓰기" 
		onclick="location.href='insert.nhn'"/></td>
		</tr>
	
		<!-- 
			클릭했을 때 onclick 실행할 때
			자바스크립트 코드를 지정
			
		  **현재 브라우저의 URL을 변경할 때 사용하는 코드
			location.href
			location은 브라우저의 위치(주소) 정보를 제공한다.
			href는 현재 페이지의 URL을 나타낸다.
		 -->

	</table>

</body>
</html>