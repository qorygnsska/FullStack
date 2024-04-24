package Music;

import java.util.Scanner;


public class MusicView {
	Scanner sc = new Scanner(System.in);
	
	MusicController mc = new MusicController();
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
		
			System.out.print("메뉴 번호 선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			if(sel == 1) {
				addList();
			}else if(sel == 2) {
				addAtZero();
			} else if (sel == 3) {
				printAll();
			} else if (sel == 4) {
				searchMusic();
			} else if (sel == 5) {
				removeMusic();
			} else if (sel == 6) {
				setMusic();
			} else if (sel == 7) {
				ascTitle();
			} else if (sel == 8) {
				descSinger();
			} else if (sel == 9) {
				System.out.println("종료");
				return;
			}else {
				System.out.println("없는 메뉴 번호입니다.");
			}
		}
	}
	
	public void addList() {
		System.out.println("***** 마지막 위치에 곡 추가 *****");
		System.out.print("곡 명 입력 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 입력 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title, singer);
		int check = mc.addList(music);
		if(check == 1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	
	public void addAtZero() {
		System.out.println("***** 첫 위치에 곡 추가 *****");
		System.out.print("곡 명 입력 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 입력 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title, singer);
		int check = mc.addAtZero(music);
		if(check == 1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	
	public void printAll() {
		System.out.println("***** 전체 곡 목록 출력 *****");
		System.out.println(mc.printAll());
	}
	
	public void searchMusic() {
		System.out.println("***** 특정 곡 검색 *****");
		System.out.print("곡 명 입력 : ");
		String title = sc.nextLine();
		if(mc.searchMusic(title) == null) {
			System.out.println("검색한 곡이 없습니다.");
		}else {
			System.out.println(mc.searchMusic(title));
		}
	}
	
	public void removeMusic() {
		System.out.println("***** 특정 곡 삭제 *****");
		System.out.print("삭제할 곡 명 입력 : ");
		String title = sc.nextLine();
		if(mc.searchMusic(title) == null) {
			System.out.println("삭제할 곡이 없습니다.");
		}else {
			System.out.println(mc.removeMusic(title) + "을 삭제 했습니다.");
		}
	}
	
	public void setMusic() {
		System.out.println("***** 특정 곡 정보 수정 *****");
		System.out.print("수정할 곡 명 입력 : ");
		String title = sc.nextLine();
		System.out.print("곡 명 수정 : ");
		String title2 = sc.nextLine();
		System.out.print("가수 명 수정 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title2, singer);
		if(mc.searchMusic(title) == null) {
			System.out.println("변경할 곡이 없습니다.");
		}else {
			System.out.println(mc.setMusic(title, music) + "의 값이 변경 되었습니다.");
		}
		
		
	}
	
	public void ascTitle() {
		
	}
	
	public void descSinger() {
		
	}
}
