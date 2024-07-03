<%@page import="rentcar.RentcarDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선택한 차 페이지!</h1>
	
	<%
		// url에서 넘겨주는 값을 꺼내올 때는 밑에 메서드 사용
		int category = Integer.parseInt(request.getParameter("category"));
		
		String temp = "";
		
		switch (category) {
		case 1:
			temp = "소형";
			break;
		case 2:
			temp = "중형";
			break;

		case 3:
			temp = "대형";
			break;
		}
		
		// 소형 선택 시 자동차 정보 가져오기
		RentcarDAO dao = RentcarDAO.getInstance();
		
		// 여러개의 데이터를 저장하는 ArrayList
		ArrayList<RentcarDTO> list = dao.getCategoryCar(category);
	
	%>
	<!-- 
		1. 카테고리를 이용해서 데이터베이스에서
		   카테고리의 번호로 데이터 전부 가져오기
		   DAO 안에서 getCategory(temp)
		   반환 타입은 DTO
		   
		2. 가져온 데이터를 화면에 출력
	 -->
	 <table>
	 	<tr>
	 		<td>
	 			<h1><%= temp %> 자동차</h1>
	 		</td>
	 	</tr>
	 	
	 	<%
	 		for(int i = 0; i < list.size(); i++){
	 			RentcarDTO bean = list.get(i);
	 	%>
	 	<tr>
	 		<td>
	 			<a href="carMain.jsp?center=carReserveInfo.jsp?no=<%=bean.getNo()%>">
	 				<img src="img/<%=bean.getImg() %>" width="300" height="200">
	 			</a>
	 			<p>차랑명 : <%= bean.getName() %></p>
	 		</td>
	 	</tr>
	 	<%} %>
	 </table>
</body>
</html>