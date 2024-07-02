<%@page import="onLine.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pollRead.jsp</title>
</head>
<body>

	<%-- 투표 항목이 저장된 텍스트 파일을 읽어서 
 브라우저에 출력한다. 
 이클립스 프로젝트가 웹서버에 전체 복사되서
 실행한다. 
 
 프로젝트가 실행하면 실제(real)경로(path)
 를 얻어온다 
 --%>
	<%
		String filepath = application.getRealPath("/");

		filepath += "onLine\\poll.txt";
		out.println(filepath + "<br>");

		ArrayList<String> poll = PollRead.pollRead(filepath);

		out.println(poll);
	%>

	<form action="pollWrite.jsp" method="post">

		<table border="1" width="500" align="center">
			<tr>
				<!--  첫번째 줄은 제목 -->
				<th><%=poll.get(0)%></th>
			</tr>
			<%
				for (int i = 1; i <= 10; i++) {
			%>
			<tr>
				<td><input type="radio" name="poll" value="<%=poll.get(i)%>">
					<%=poll.get(i)%></td>
			</tr>

			<%
				}
			%>


			<tr>
				<td align="center"><input type="submit" value="투표하기"> <input
					type="button" value="결과보기" onclick="location.href='pollResult.jsp'">

				</td>
			</tr>

		</table>
	</form>
</body>
</html>