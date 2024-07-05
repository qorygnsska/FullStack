<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
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
		String book_kind = request
					.getParameter("book_kind");
		ArrayList<BookDTO> bookList = null;
		
		// 책의 모든 정보를 가져오기 
		BookDAO dao = BookDAO.getInstance();
		
		bookList = dao.getBookMore(book_kind);
		
		//out.println(bookList);	
		
		String book_kindName = "";
		
		switch(book_kind){
		case "100":
			book_kindName="문학";
			break;
		case "200":
			book_kindName="외국어";
			break;
		case "300":
			book_kindName="it서적";
			break;
		case "all":
			book_kindName="전체";
			break;
			
		}		
	%>
	<h2><%= book_kindName %>분류의 목록</h2>
	<a href="shopMain.jsp"> 메인으로 </a>
	
	<!--  밑에 전체 출력하기  -->
	
	<%
		BookDTO dto = null;
	 	for(int i = 0; i < bookList.size();
	 				   i++){
	 		
	 	dto = bookList.get(i);	 	
	%>
		<table border="1">
		<tr >
			<td rowspan="5" align="center">
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
			
	</table>
	<%} // 반복문의 끝을 알리는 중괄호 작성! %>
	
</body>
</html>