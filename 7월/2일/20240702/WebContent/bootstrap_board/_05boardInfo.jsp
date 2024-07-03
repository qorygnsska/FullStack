<%@page import="com.board.BoardDAO"%>
<%@page import="com.board.BoardDTO"%>
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
		// url을 타고 넘어온 num값을 꺼낸다.
		// a링크를 눌렀을 때 다른 페이지 주세요~
		// 요청이 들어왔기 때문에 request객체에
		// 자동으로 저장이 된다.

		// 문자로 저장된 값을 기본 자료형 int로 변환
		int num = Integer.parseInt(request.getParameter("num"));

		// 위에 num을 이용해서 boardDTO 한 건을 가지고 와서 출력
		BoardDTO board = BoardDAO.getInstance().getBoardByNum(num);
	%>
	<h2 align="center">
		"<%=num%>"상세 페이지
	</h2>

	<div align="center">
		<form method="post" action="_06boardUpdate.jsp">
			<table border="1">
				<tr>
					<td>번호</td>
					<td><%=board.getNum()%></td>
					<td>조회수</td>
					<td><%=board.getReadCount()%></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><%=board.getWriter()%></td>
					<td>이메일</td>
					<td><%=board.getEmail()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=board.getSubject()%></td>
					<td>작성일</td>
					<td><%=board.getRegDate()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3"><textarea rows="10" cols="20" readonly><%=board.getContent()%></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="hidden" name="num" value="<%=board.getNum()%>"> 
						<input type="submit" value="수정하기"> 
						<input type="button" value="삭제하기" onclick="window.location.href='_08boardDelete.jsp?num=<%=board.getNum()%>'">
						<input type="button" value="목록으로" onclick="window.location.href='_04boardList.jsp'">
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>