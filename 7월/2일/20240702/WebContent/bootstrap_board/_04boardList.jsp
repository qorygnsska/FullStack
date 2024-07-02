<%@page import="com.board.BoardDAO"%>
<%@page import="com.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		ArrayList<BoardDTO> boardList = BoardDAO.getInstance().getBoardList();

		int count = BoardDAO.getInstance().getAllCount();
	%>

	<div align="center">

		<h2>
			게시글 목록(<%=count%>개)
		</h2>
		<table border="1">
			<tr>
				<td colspan="5"><a href="_02boardWrite.jsp">글쓰기</a></td>
			</tr>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>조회 수</td>
			</tr>

			<% 
			//for(Board temp : boardList)
			
				for(int i = 0; i < boardList.size();
							i++){
			
				BoardDTO temp = boardList.get(i);			
		%>
			<tr>
				<td><%= temp.getNum() %></td>
				<td><%= temp.getWriter() %></td>
				<td><a href="#"><%= temp.getSubject() %></a></td>
				<td><%= temp.getRegDate() %></td>
				<td><%= temp.getReadCount() %></td>
			</tr>
			<%} %>
		</table>
		<%
			// BoardDAO에서 저장된 데이터를
			// 가져와야된다. 
			// ArrayList를 리턴 받아서 저장한다.

			// 테이블에 내가 작성한 글을 
			// 출력!
		%>
	</div>
</body>
</html>