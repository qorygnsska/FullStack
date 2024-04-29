package inputoutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static MemoList memoList = new MemoList();
	public static void main(String[] args) {
		// 파일 입출력
		// 파일, 키보드, 모니터 메모리 사이를 연결하는 무언가가 필요하다.

		// 스트림
		// - 데이터를 운반하는데 사용되는 연결 통로

		// 입력 스트림
		// - 불러오기
		// 출력 스트림
		// - 저장

		// 이진 파일
		// - 동영상, 이미지, 엑셀, 기본 자료형
		// - 객체를 저장할 수 있는 형태

		// 텍스트 파일
		// - 오직 문자로만 저장하고 불러오기

		Scanner sc = new Scanner(System.in);

		int menu = 0;
		while (menu != 7) {
			while (true) {
				System.out.println("========================================");
				System.out.println("1. 입력, 2. 목록보기, 3. 수정, 4. 삭제 ");
				System.out.println("5. 파일로 저장, 6. 파일에서 읽기, 7. 종료");
				System.out.println("========================================");
				System.out.print("원하는 메뉴를 입력하고 enter키를 누르세요 : ");

				menu = sc.nextInt();
				// 정상적으로 입력했을 때는 while문을 나가기
				if (menu >= 1 && menu <= 7) {
					break;
				}
				// 잘못된 값이 들어오면
				System.out.println("1~7 사이의 값만 입력하세요!");
			}
			switch (menu) {
			case 1:
				insert();
				break;
			case 2:
				print();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				fileWrite();
				break;
			case 6:
				fileRead();
				break;
			case 7:
				break;

			}
		}
		System.out.println("프로그램 종료! 바이~");

	}
	// 키보드로 텍스트파일 이름을 입력 받아서 텍스트 파일에 저장된 데이터를 ArrayList에 저장하는 메서드
	private static void fileRead() {
		Scanner scan = new Scanner(System.in);
		System.out.println("읽어올 텍스트 파일 이름 : ");
		String fileName = scan.nextLine().trim();
		
		// 텍스트 파일에 저장된 데이터를 ArrayList에 저장하는 메서드 실행
		memoList.readMemo(fileName);
	}
	
	// 키보드로 텍스트 파일 이름을 입력받아 ArrayList에 저장된 데이터를 텍스트 파일로 저장하는 메서드
	private static void fileWrite() {
		Scanner scan = new Scanner(System.in);
		System.out.println("저장할 텍스트 파일 이름 : ");
		String fileName = scan.nextLine().trim();
		
		// ArrayList에 저장된 데이터를 텍스트 파일로 저장하는 메서드
		memoList.writeMemo(fileName);
	}
	// 글을 저장하는 메서드
	// 각각 스캐너를 이용해서 입력 받고 arrayList에 저장하는 내용을 작성하기
	private static void insert() {
		Scanner scan = new Scanner(System.in);
		System.out.println("게시글에 저장할 글 입력");
		System.out.print("이름 : ");
		String name = scan.nextLine().trim(); // 공백제거 중간의 공백은 제거 못하지만 양끝 공백은 제거한다
		System.out.print("비밀번호 : ");
		String password = scan.nextLine().trim(); // 공백제거
		System.out.print("메모 : ");
		String memo = scan.nextLine().trim(); // 공백제거
		
		Memo vo = new Memo(name, password, memo);
		// memoList로 다른 클래스로 보내야된다.
		memoList.addMemo(vo);
		System.out.println("저장완료");
	}
	
	// memoList에 있는 ArrayList를 반환 받아서 데이터를 출력하는 메서드
	private static void print() {
		// arrayList 전체 가져오기
		ArrayList<Memo> temp = memoList.getMemoList();
		if(temp.size() == 0) {
			System.out.println("데이터가 없습니다.");
		}else {
			for(int i = 0; i < temp.size(); i++) {
				System.out.println(temp.get(i));
			}
		}
	}
}
