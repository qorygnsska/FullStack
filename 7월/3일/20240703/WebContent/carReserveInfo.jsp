<%@page import="rentcar.RentcarDTO"%>
<%@page import="rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 파일명: carReserveInfo.jsp
	3개의 파일을 클릭하면 각각 상세 정보를 출력하는
	페이지를 구현해 보세요!
  -->
<div>
	<%
		RentcarDAO dao = RentcarDAO.getInstance();
		System.out.println(dao);

		// carReserveMain에서 상세페이지를 누르면
		// no가 넘어온다. 그거 하나를 url에서 꺼내기 
		int no = Integer.parseInt(request.getParameter("no"));
		RentcarDTO bean = dao.getSelectByNo(no);

		//out.println(bean);
		int category = bean.getCategory();

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
	%>

	<form action="carMain.jsp?center=11_carOptionSelect.jsp" method="post">

		<table>
			<tr height="100">
				<td align="center" colspan="3"><font size="6" color="gray">
						<%=bean.getName()%> 차량 선택
				</font></td>
			</tr>
			<tr>
				<td rowspan="6" width="500" align="center"><img alt=""
					src="img/<%=bean.getImg()%>" width="450"></td>
				<td width="250" align="center">차량이름</td>
				<td width="250" align="center"><%=bean.getName()%></td>
			</tr>
			<tr>
				<td width="250" align="center">차량수량</td>
				<td width="250" align="center"><select name="qty">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">차량분류</td>
				<td width="250" align="center"><%=temp%></td>
			</tr>
			<tr>
				<td width="250" align="center">대여가격</td>
				<td width="250" align="center"><%=bean.getPrice()%>원</td>
			</tr>
			<tr>
				<td width="250" align="center">제조회사</td>
				<td width="250" align="center"><%=bean.getCompany()%></td>
			</tr>
			<tr>
				<td width="250" align="center">
					<%-- 이전 차량에 관한 정보 --%> <input type="hidden" name="no"
					value="<%=bean.getNo()%>" /> <input type="hidden" name="img"
					value="<%=bean.getImg()%>" /> <input type="submit"
					value="옵션선택후 구매하기" />
				</td>
			</tr>
		</table>

		<br /> <br /> <br /> <font size="5" color="gray">차랑 정보 보기</font>
		<p>
			<%=bean.getInfo()%>
	</form>


</div>