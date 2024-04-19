package MVC;

import java.util.Scanner;

// view를 담당하는 클래스(화면)
public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	
	// 프로그램의 처리를 하는 컨트롤러 클래스 생성
	private BookController bc = new BookController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 도서 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			if(menu == 1) {
				insertBook();
			}else if(menu == 2) {
				selectList();
			}else if(menu == 3) {
				searchBook();
			}else if(menu == 4) {
				deleteBook();
			}else if(menu == 5) {
				ascBook();
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				return;
			}else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}

	public void insertBook() {
		Book book = new Book("교훈의 자바", "배교훈", "it 개발", 30000);
		boolean result = bc.insert(book);
		if(result) {
			System.out.println("정상 저장되었습니다.");
			mainMenu();
		}else {
			System.out.println("공간이 꽉 찼다. 저장이 안 됐습니다.");
			mainMenu();
		}
		
	}

	public void selectList() {
		Book[] bookList = bc.selectList();
		if(bookList.length < 1) {
			System.out.println("존재하는 도서가 없습니다.");
			mainMenu();
		}else {
			for(int i = 0; i < bc.getCount(); i++) {
				bookList[i].show();
				System.out.println();
			}
			mainMenu();
		}
	}

	public void searchBook() {
		sc.nextLine();
		System.out.print("검색할 키워드 입력 : ");
		String keyword = sc.nextLine();
		Book[] searchList = bc.searchBook(keyword);
		if(searchList.length < 1) {
			System.out.println("검색 결과가 없습니다.");
			mainMenu();
		}else {
			for(int i = 0; i < searchList.length; i++) {
				System.out.println(searchList[i]);
			}
		}
	}

	public void deleteBook() {

	}

	public void ascBook() {

	}
}
