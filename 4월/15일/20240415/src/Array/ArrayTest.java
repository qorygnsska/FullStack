package Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 추가
		// 2. 삭제
		// 3. 정렬
		// 4. 출력
		// 0. 종료
		// 정말 종료하시겠습니까? y/n, y 입력 시 진짜 종료, n을 누르면 메뉴로 돌아가기
		// 최대 가입 인원 5명
		String[] idList = {"abcd", "aaaa"};
		String[] pwList = {"1111", "2222"};
		int count = 2;
		
		while(true) {
			System.out.println("현재 계정 갯수 : " + count);
			System.out.println("1. 추가");
			System.out.println("2. 삭제");
			System.out.println("3. 정렬");
			System.out.println("4. 출력");
			System.out.println("0. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println("추가 페이지");
				String[] arr = idList;
				String[] arr2 = pwList;
				idList = new String[count + 1];
				pwList = new String[count + 1];
				for(int i = 0; i < count; i++) {
					idList[i] = arr[i];
					pwList[i] = arr2[i];
				}
				sc.nextLine();
				System.out.println("id와 pw 입력 : ");
				idList[count] = sc.nextLine();
				pwList[count] = sc.nextLine();
				count++;
				
				break;
				
			case 2:
				System.out.println("삭제 페이지");
				sc.nextLine();
				boolean check = false;
				
				String[] delete = idList;
				String[] delete2 = pwList;
				idList = new String[count - 1];
				pwList = new String[count - 1];
				
				System.out.print("삭제할 ID 입력 : ");
				String del = sc.nextLine();
				int delnum = -1; // 삭제할 인덱스 번호 저장
				 
				for(int i = 0; i < count; i++) {
					if(del.equals(delete[i])) {
						delnum = i;
						check = true;
					}
				}
				if(check == false) {
					System.out.println("찾으시는 ID가 없습니다.");
					break;
				}
				
				int j = 0;
				for(int i = 0; i < count; i++) {
					if(delnum != i) {
						idList[j] = delete[i];
						pwList[j] = delete2[i];
						j++;
					}
				}
				count--;
				
				break;
				
			case 3:
				System.out.println("정렬");
				Arrays.sort(idList);
				break;
				
			case 4:
				System.out.println("출력 페이지");
				check = false;
				System.out.println("1. 전부 다 출력 / 2. ID로 검색 후 출력");
				num = sc.nextInt();
				if(num == 1) {
					for(int i = 0; i < count; i++) {
						System.out.println((i + 1) + "번의 ID : " + idList[i] + ", " + (i + 1) + "번의 PW : " + pwList[i]);
					}
				}else {
					sc.nextLine();
					System.out.print("찾으실 ID 입력 : ");
					String id = sc.nextLine();
					for(int i = 0; i < count; i++) {
						if(id.equals(idList[i])) {
							System.out.println("ID : " + idList[i] + " PW : " + pwList[i]);
							check = true;
						}
					}
					if(check == false) {
						System.out.println("찾으시는 ID가 없습니다.");
					}
				}
				
				break;
				
			case 0:
				System.out.println("종료 페이지");
				sc.nextLine();
				System.out.print("정말 종료하시겠습니까?(y/n)");
				String an = sc.nextLine();
				
				if(an.equals("y")) {
					System.out.println("종료합니다.");
					return;
				}else if(an.equals("n")) {
					break;
				}else {
					System.out.println("다시 입력하세요");
				}
				
			}
			
		}
	}

}
