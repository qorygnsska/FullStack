<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
		<%
			request.setCharacterEncoding("UTF-8");
		%>
		
		<jsp:useBean id ="boardDTO" 
		       class="com.board.BoardDTO">
		      <jsp:setProperty name="boardDTO"
		      				  property="*" />
		</jsp:useBean>

		<%
			// 위에서 저장한 객체를 BoardDAO로 
			// 전송! 
			// 게시글 목록이다 _04boardList.jsp이동
			BoardDAO.getInstance()
					.boardWrite(boardDTO);
		
			// 게시글 목록으로 페이지 이동만!
			response.sendRedirect("_04boardList.jsp");
			
		%>

</body>
</html>