<%@page import="java.util.ArrayList"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="bookstore.BookDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>
<%
	// 1. 책의 정보를 가져온다.
	BookDAO dao = BookDAO.getInstance();
	

	// 2. 2차원 반복문을 이용해서 
	//   외부 반복은 분류의 신간목록의 개수만큼 
	
	//   내부 반복에 책의 3개의 정보를 가져와서
	//   출력 
	

	ArrayList<BookDTO> bookLists =null;
	int number = 0;
	String book_kindName = "";
	
	for(int i = 1; i<=3; i++){
	
		bookLists = dao
				.getBooks(i + "00");
		
		//새로운 데이터를 가져올 때 항상 첫번째 0번째
		// 공간에 데이터를 가져와서 분류를 한다.
		if(bookLists != null){
			switch(bookLists
					.get(0)
					.getBook_kind()){
			case "100":
				book_kindName = "문학";
				break;
				
			case "200":
				book_kindName = "외국어";
				break;
				
			case "300":
				book_kindName = "컴퓨터";
				break;
			}
			
		}
	
	//out.println(bookLists);
	
	// 2. BookDAO 접근 하기 
	// 3. 각각의 분류 book_kind 문학(100),외국어(200)
	//   ,it서적(300)
	// 4. 책의 정보를 3개씩만 가져와서 반복하면서 
	//    출력한다. 

%>	
	<h2> 신간 소개 </h2>
	<br><br>
	<h5><%= book_kindName %> 분류의 신간 목록:
	
		<a href="list.jsp?book_kind=<%= bookLists
									.get(0)
									.getBook_kind()%>">더보기</a>
	</h5>
	
	<%
	 for(int j = 0; j < bookLists.size();
			 		j++){
	%>
	<table border="1">
		<tr >
			<td rowspan="5" align="center">
				<img src="images/<%= bookLists
									.get(j)
									.getBook_image()%>"
				 width="100" height="130">
			</td>
			
			<td width="250">
				<a href="bookContent.jsp?book_id=<%= bookLists
								.get(j).getBook_id()%>"><%= bookLists
								.get(j).getBook_title() %></a>
			</td>
			
			<tr>	
				<td width="350">
					<%= bookLists
						.get(j).getPublishing_com() %>
					
				</td>
			</tr>
			<tr>
				<td width="350">
					<%= bookLists
						.get(j).getAuthor() %>
					
				</td>
			</tr>
			
			<tr>
				<td width="350">정가:
				<%= bookLists
						.get(j).getBook_price() %>
					
				</td>
			</tr>
			<tr>
				<td width="350">
					판매금액: 
					<%= bookLists
						.get(j).getDiscount_rate()%>			
					
				</td>
			</tr>
			
	</table>	
	<%}} %>

</div>

