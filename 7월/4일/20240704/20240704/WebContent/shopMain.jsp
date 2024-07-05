<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shopMain.jsp</title>
</head>
<body>
	<table border = "1">
		<tr>
			<td width="150">
				<img src="images/logo.png">			
			</td>
			<td>
				<%-- 페이지를 포함하는 액션태그 --%>
				<jsp:include page="header.jsp" />
			</td>	
						
		</tr>
		
		<tr>
			<td width="150">
				<jsp:include page="left.jsp" />
			</td>
		
			<td>
				<jsp:include page="center.jsp" />
			</td>
		
		</tr>		
		
		<tr>
			<td colspan="2" 
				align="center">
				<jsp:include page="footer.jsp" />
			</td>	
		</tr>	
	</table>
</body>
</html>



