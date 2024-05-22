package Instagram;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Service service = new Service();

		Scanner sc = new Scanner(System.in);

		int menu = 0;
		try {
			while (true) {
				System.out.println("1) 사진을 게시한 유저는 모두 몇명 ?");
				System.out.println("2) 3번 댓글이 달린 사진은?");
				System.out.println("3) 사진1에 달린 모든 \"댓글 내용\",작성");
				System.out.println("4) 사진5에 파일명과 사진 게시자 닉네임");
				System.out.println("5) 사진2에 좋아요를 누른 닉네임, 파일명");
				System.out.println("0) 종료!");

				menu = sc.nextInt();

				switch (menu) {
				case 1:
					service.join1();
					break;
				case 2:
					service.join2();
					break;
				case 3:
					service.join3();
					break;
				case 4:
					service.join4();
					break;
				case 5:
					service.join5();
					break;

				case 0:
					System.out.println("프로그램 종료!");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
