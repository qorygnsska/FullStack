package JDBC_Test;

import java.util.Scanner;

// 데이터를 테이블에 저장, 수정, 삭제 및 조회 작업을 실행하기 전 필요한 전처리 작업을 실행하는 클래스
public class MemoService {
	// 데이터를 입력 받아서 전송만 담당하는 DAO 클래스에 넘겨준다.
	private static Scanner sc = new Scanner(System.in);
	public static void insert() {
		// 실행한 메서드를 확인하는 것!
		System.out.println("MemoService클래스의 insert() 메서드 실행");
		
		// 전처리
		// 키보드로 memo에 대한 데이터 입력받기
		System.out.print("메모를 입력 하세요!");
		System.out.print("글 제목 : ");
		String title = sc.nextLine();
		System.out.print("글 내용 : ");
		String content = sc.nextLine();
		
		// 입력받은 데이터를 객체화 시켜서
		MemoVO vo = new MemoVO(title, content);
		System.out.println(vo);
		
		// DAO 클래스로 넘겨준다
		if(MemoDAO.insert(vo)) {
			System.out.println("저장 성공!!");
		}else {
			System.out.println("저장 실패!!");
		}
		
		// 저장이 잘 되면 그 결과를 반환받아서 출력
		// 성공 시 땡땡님의 글이 저장 완료
		
		// 실패 시 글이 제대로 저장되지 않았습니다.
	}
	
	public static void print() {
		System.out.println("MemoService클래스의 print() 메서드 실행");
		MemoDAO.print();
	}
	
	// 수정할 글 번호를 입력 받아서 DAO로 넘겨주는 글을 수정하는 메서드
	public static void update() {
		System.out.println("MemoService클래스의 update() 메서드 실행");
		
		System.out.print("수정할 글 번호 : ");
		int idx = sc.nextInt();
		sc.nextLine();
		
		// update, delete를 할때 꼭 검색을 먼저하고 검색한 내용이 있으면 수정, 삭제를 해야한다
		MemoVO vo = MemoDAO.selectById(idx);
		if(vo != null) {
			System.out.println("수정할 메모가 있다.");
			// 수정할 내용을 입력 받기
			// 제목, 내용 두개만 받기
			System.out.print("수정할 제목 : ");
			String title = sc.nextLine();
			System.out.print("수정할 내용 : ");
			String content = sc.nextLine();
			
			// 진짜 수정하는 update 메서드 만들기
			MemoDAO.update(idx, title, content);
		}
	}

	public static void delete() {
		// 키보드로 삭제할 글 번호 입력 후 삭제
		System.out.println("MemoService클래스의 delete() 메서드 실행");
		System.out.print("삭제할 글 번호 입력 : ");
		int idx = sc.nextInt();
		
		// 먼저 글 번호가 있는지 확인
		MemoVO vo = MemoDAO.selectById(idx);
		if(vo != null) {
			MemoDAO.delete(idx);
			System.out.println(idx + "번 글 삭제완료!");
		}else {
			System.out.println(idx + "번 글은 없습니다.");
		}
	}
}
