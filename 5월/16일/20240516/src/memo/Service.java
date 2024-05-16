package memo;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
	private static Scanner sc = new Scanner(System.in);

	// 저장된 글 전체를 얻어오는 메서드
	public static void select() {
		// 얻어온 글을 출력하는 메서드
		System.out.println("service클래스의 select() 메서드 실행!!");

		ArrayList<MemoVO> list = Dao.select();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	public static void insert() {
		System.out.println("Service의 insert 실행");
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String password = sc.nextLine();
		System.out.print("메모 입력 : ");
		String memo = sc.nextLine();
		Dao.insert(name, password, memo);
	}

	// 아이디를 기준으로 할 때 혹은 idx번호로 수정해야되는 데이터가 있는 지 먼저 찾은다음에
	// 수정하는 메서드를 실행
	public static void update() {
		System.out.println("Service의 update 실행");
		MemoVO vo = search();

		if (vo != null) {
			System.out.print("비밀번호 : ");
			String pass = sc.nextLine();

			if (vo.getPassword().equals(pass)) {
				System.out.println("수정할 데이터를 입력");
				System.out.print("수정할 글 제목 : ");
				String name = sc.nextLine();

				System.out.print("수정할 글 비밀번호 : ");
				String password = sc.nextLine();

				System.out.print("수정할 글 내용 : ");
				String memo = sc.nextLine();

				// 기존에 데이터를 가지고 있는 vo변수안에 수정후 넘겨주기
				vo.setName(name);
				vo.setPassword(password);
				vo.setMemo(memo);

				if (Dao.update(vo) > 0) {
					System.out.println("정상적으로 수정하였습니다.");
				} else {
					System.out.println("제대로 수정되지 않았습니다.");
					System.out.println("내용을 확인해주세요");
				}
			} else {
				System.out.println("비밀번호가 다릅니다.");
				System.out.println("메뉴로 돌아갑니다..");
				return;
			}
		}
		// 찾는 아이디가 없을 시
		System.out.println("찾는 아이디가 없습니다.");
	}

	public static void delete() {
		MemoVO vo = search();

		if (vo != null) {
			if (Dao.delete(vo) > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패!");
			}
		} else {
			System.out.println("찾는 아이디가 없습니다!!");
		}

	}

	public static MemoVO search() {
		System.out.println("Service의 search 실행");
		System.out.print("아이디 : ");
		String name = sc.nextLine();

		// 실제 데이터베이스에서 검색하기
		MemoVO vo = Dao.search(name);
		System.out.println("확인 : " + vo);

		return vo;
	}
}
