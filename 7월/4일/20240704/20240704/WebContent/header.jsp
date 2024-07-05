<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
	<%
		// 아이디가 로그인이 되었다면 session
		// 데이터가 있다면 로그인 된 정보를 띄워주고
		// 만약 로그인이 되어있지 않다면 조건문으로
		// 로그인할 수있도록 아이디와 비밀번호를 
		// 입력 받는다. 
		
		String id = (String)session
					.getAttribute("id");
		
		if(id == null){
		
	%>
		<!--  로그인 페이지 만들기  -->
		<a href="list.jsp?book_kind=all">전체목록보기</a>
		<br>
		
		<form method="post" action="loginPro.jsp">
			아이디 : <input type="text" name="id" size="15" maxlength="50" autofocus>&nbsp;
			비밀번호 : <input type="password" name="passwd" size="15" maxlength="16" >
			<input type="submit" value="로그인">
		</form>
		<font color="red">* 반드시 로그인을 하셔야 쇼핑을 하실 수 있습니다. *</font>
	
	<%} else { %>
		<!--  ** 님 즐거운 쇼핑 시간이 되세요~
				전체목록 보기 버튼,장바구니버튼
				구매목록보기 버튼
		 -->
		 <a href="list.jsp?book_kind=all">전체목록보기</a>&nbsp;
		<a href="cartList.jsp?book_kind=all">장바구니 보기</a>&nbsp;
		<a href="buyList.jsp">구매목록보기</a>
		
		<br><br>
		<b><%= id %>님, 즐거운 쇼핑시간이 되세요.</b>
		<input type="button" value="로그아웃" onclick="window.location.href='logout.jsp'">
	<%} %>
	
</header>


