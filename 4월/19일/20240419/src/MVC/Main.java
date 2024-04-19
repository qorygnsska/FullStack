package MVC;

public class Main {

	public static void main(String[] args) {
		
		// 뷰페이지로 이동
		BookMenu menu = new BookMenu();
		menu.mainMenu();
		
		/*
		 * 웹 개발중에 사용되는 구조
		 * 각 개발 영역에 맞게 MVC로 구분하여
		 * 각 역할에 맞게 코드를 작성할 수 있는 개발 방식!
		 * 
		 * 클라이언트 : 데이터를 요청하는 컴퓨터
		 * 서버 : 데이터를 보내주는 컴퓨터
		 * 
		 * Model
		 *  - 클라이언트의 요청을 전달 받아서 요청사항을 처리하는 작업
		 *    예) DB로 들어가서 로그인 확인, 중복확인, 비밀번호 찾기, 회원가입... 등등
		 * 
		 * View
		 *  - 웹 브라우저(화면)
		 *  - 자바를 예) 키보드로 입력, 결과를 출력하는 println()
		 *  
		 * Controller
		 * - 요청이 들어오면 어떤 처리를 해야되는지 어떤 model로 보내야되는지 
		 *   model에서 결과를 컨트롤러가 받으면 어떤 화면(view)에 출력할 지 결정해주는 역할
		 *   
		 * 자바에서는 컨트롤러가 model포함
		 * 화면 menu(view) 클래스를 이용해서 구별
		 * 실제 처리를 하는 컨트롤러 클래스로 구별
		 */

	}

}
