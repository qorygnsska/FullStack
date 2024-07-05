<%@page import="rentcar.RentcarDTO"%>
<%@page import="rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	// 1. 로그인이 되었는 지 안 되었는 지 확인
	// 2. 넘어온 CarReserveDTO 타입으로 저장
	// 3. 결과 창에 차량의 정보 얻어오기
	// 4. 차량 총 금액
	// 5. 옵션 선택 금액 계산 10000추가
%>
<jsp:useBean id="rbean" class="rentcar.CarReserveDTO">
	<jsp:setProperty name="rbean" property="*" />
</jsp:useBean>

<%
	//로그인 처리 
	// getParameter()
	//  - Http요청( get , post 요청)
	//  문자열 또는 폼 데이터에서 값을 가져올 때 사용된다.
	//  - 주로 클라이언트가 폼을 제출 할 때 사용
	//  - 클라이언트(브라우저)에서 서버로 전달된 데이터
	//    를 가져올 때 

	// set/getAttribute()
	//  - 서버 사이드에서 데이터를 공유할 때 주로 사용함
	//  - jsp 에서 jsp로 데이터를 전달할 때 사용
	//  - forward, include 
	String id = (String) session.getAttribute("id");

	if (id == null) {
%>
<script>
	alert("로그인 후 예약이 가능합니다!");
	location.href = "carMain.jsp?center=memberLogin.jsp";
</script>
<%
	}
	// 날짜 비교
	// Date클래스안에 compareTO() 메서드 비교
	// 예약 날짜가 현재 날짜보다 이전이라면 음수
	// 음수이면 alert()

	// 결과를 받아올 때 로그인도 날짜도 정상이면
	// 데이터 저장을 하고 결과 페이지를 보여주기
	// out.println(rbean);
	// 위에 출력을 했더니 id값이 null을 수정
	rbean.setId(id);

	// 위에 예약을 DAO로 보내서 저장(추가)
	RentcarDAO dao = RentcarDAO.getInstance();
	dao.setReserveCar(rbean);

	// 차량의 정보를 가져오는 메서드
	RentcarDTO cinfo = dao.getSelectByNo(rbean.getNo());

	// 차량 가격, 차량 수량, 대여일 수
	int totalCar = cinfo.getPrice() + rbean.getQty() + rbean.getDday();

	// 옵션 금액을 확인하고 총 금액에 추가하기
	int usein = (rbean.getUsein() == 1 ? 10000 : 0);
	int usewifi = (rbean.getUsewifi() == 1 ? 10000 : 0);
	int useseat = (rbean.getUseseat() == 1 ? 10000 : 0);

	// 선택하면 이벤트로 3일 내내 만원씩만 추가
	// 사용하는 일마다 추가

	int totalOption = (usein + usewifi + useseat) * rbean.getDday();
%>

<div align="center">
	<table>
		<tr height="100">
			<td align="center"><font size="6" color="gray"> 차량 예약 완료
					화면 </font></td>
		</tr>
		<tr height="100">
			<td align="center"><img src="img/<%=cinfo.getImg()%>"
				width="470" /></td>
		</tr>
		<tr height="50">
			<td align="center"><font size="5" color="red"> 차량 총예약 금액
					<%=totalCar%> 원
			</font></td>
		</tr>
		<tr height="50">
			<td align="center"><font size="5" color="red"> 차량 총옵션 금액
					<%=totalOption%> 원
			</font></td>
		</tr>
		<tr height="50">
			<td align="center"><font size="5" color="red"> 차량 총 금액 <%=totalOption + totalCar%>
					원
			</font></td>
		</tr>
	</table>
</div>