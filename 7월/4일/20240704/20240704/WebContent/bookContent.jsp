<%@page import="bookstore.BookDTO"%>
<%@page import="bookstore.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookContent.jsp 상세페이지</title>
</head>
<body>
	<%
		// 1. url 요청으로 넘어온 book_id값 꺼내기
		// 2. 로그인 유무에 따라서 session영역 확인
		// 3. 책 한건의 정보를 가져오기 
		//    DAO 접근해서 메서드 호출해서 데이터
		//    가져오기 
		
		String book_id = request.getParameter("book_id");
		String id = (String)session.getAttribute("id");
		
		if(id == null){
			id = "not";
		}
		
		BookDAO dao = BookDAO.getInstance();
		BookDTO dto = dao.getBook(
					Integer.parseInt(book_id));
		
		
	%>
	<form action="cartInsert.jsp" method="post">
		<table border="1">
		<tr >
			<td rowspan="6" align="center">
				<img src="images/<%= dto
									.getBook_image()%>"
				 width="100" height="130">
			</td>
			
			<td width="250">
				<a href="bookContent.jsp?book_id=<%=dto.getBook_id()%>"><%= 
								dto.getBook_title() %></a>
			</td>
			
			<tr>	
				<td width="350">
					<%= dto.getPublishing_com() %>
					
				</td>
			</tr>
			<tr>
				<td width="350">
					<%= dto.getAuthor() %>
					
				</td>
			</tr>
			
			<tr>
				<td width="350">정가:
				<%= dto.getBook_price() %>
					
				</td>
			</tr>
			<tr>
				<td width="350">
					판매금액: 
					<%= dto.getDiscount_rate()%>			
					
				</td>
			</tr>
			<tr>
				<td>
					<!-- 수량 옆에 버튼을 생성  -->
					수량: <input type= text 
								name = "buy_count"
								value = "1"
								size="1">개
					<%
						if(!id.equals("not")){
					%>
										
					<input type="submit" 
						   value="장바구니에 담기">
						   
					<!--  기존에 저장되어있는 정보를 같이 넘기기 위해서 -->
					<input type="hidden" 
						   name="book_id" 
						   value="<%= book_id %>"> 
					<input type="hidden" 
						   name="book_image" 
						   value="<%= dto.getBook_image() %>"> 
					<input type="hidden" 
						   name="book_title" 
						   value="<%= dto.getBook_title() %>"> 
					<input type="hidden" 
						   name="book_price" 
						   value="<%= dto.getBook_price() %>"> 
							
					<%} %>
					<input type="button" 
						   value="목록으로"
						   onclick="window.location.href='list.jsp?book_kind=all'">
					
					<input type="button" 
						   value="메인으로"
						   onclick="window.location.href='shopMain.jsp'">		
					
				</td>
			</tr>
			
	</table>
	
</form>	
	
	
</body>
</html>