<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginTest.jsp</title>
</head>
<body>
	<h2>loginTest페이지입니다.</h2>
	<%--아이디랑 패스워드만 받아서 현재 페이지에서
		처리를 할 것!
		
		실제 로그인이 되어있지 않다면 로그인할 수있는
		화면을 보여주고 만약 로그인이 되었다면 
		로그인성공 혹은 ** 안녕하세요! 
	
	--%>
	<%
		//post방식은 한글 깨질 수 있다.
		request.setCharacterEncoding("UTF-8");

		// 로그인 버튼이 클릭되면 넘어오는 데이터를 받는다.
		// 단! null 예외가 발생할 수 있다. 

		String id = "";
		String pw = "";

		try {

			id = request.getParameter("id").trim();
			pw = request.getParameter("pw").trim();

		} catch (NullPointerException e) {
			// 알림창으로 알림!
			// 비워두면 무시한다!
		}

		// 입력한 데이터가 qwer , 1111
		// 데이터와 맞는지 확인 후 맞으면 세션에 저장하고
		// 맞지 않으면 alert() 


		if (id.length() != 0 && pw.length() != 0) {
			out.println("<script>");

			if (id.equals("qwer") && pw.equals("1111")) {
				// 로그인이 성공 
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				session.setAttribute("login", "yes");
				out.println("alert('" + session.getAttribute("id") + "님 어서오세요~')");

			} else {
				out.println("alert('아이디 또는 비밀번호가 올바르지 않습니다.')");
			}
			out.println("</script>");
		}
		
		//로그 아웃 버튼이 클릭되면 넘어오는 데이터
		// 를 logout 변수로 받는다.
		String logout = request.
				getParameter("logout");
		
		// 로그인이 되어있는 상태이 때문에 로그아웃을
		// 하면 된다. 세션에서 로그인 정보를 제거한다.
		if(logout != null && 
			logout.equals("yes")){
			
			session.removeAttribute("id");
			session.removeAttribute("pw");
			session.removeAttribute("login");
			
			// 자바 코드를 이용해서 html 코드를
			// 작성하는 것을 서블릿 
	
			out.println("<script>");
			out.println("alert('로그 아웃 되었습니다.')");
			out.println("</script>");
		}
		
		
		
		// 세션에서 로그인 정보를 읽어와서 로그인상태
		// true,false
		String login = (String)session
					  .getAttribute("login");
		
		if(login != null && 
		   login.equals("yes")){
	%>
	<!--  로그인 상태일 경우 브라우저에 표시 -->
	<h2>로그인 성공</h2>
	<p>** 님  안녕하세요!</p>
	<input type="button" 
		   value="로그아웃"
		   onclick="location.href='?logout=yes'"/> 

	<%} else { %>

	<form action="?" method="post">
		<table width="300" border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인">
				</td>
			</tr>

		</table>

	</form>
	<%} %>
</body>
</html>