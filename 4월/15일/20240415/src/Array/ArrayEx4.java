package Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx4 {

	public static void main(String[] args) {

		int[] arr = new int[3];
		
		// 1차원 배열
		// 한번 공간을 생성하면 고정이 돼서 삭제도 안되고 추가도 안된다.
		
		// 유동적(배열의 크기를 추가 / 삭제) 가능하도록 만들 수 있음
		String[] nameList = {"이익준", "김준완"};
		
		// 현재 배열의 갯수
		int valueCount = 2;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println();
			System.out.println("현재 데이터  개수 : " + valueCount);
			System.out.println("1. 이름 추가");
			System.out.println("2. 출력");
			System.out.println("3. 삭제");
			System.out.println("4. 정렬");
			System.out.println("5. 종료");
			
			// 메뉴 입력
			int sel = sc.nextInt();
			
			// 메뉴 선택
			switch(sel) {
			case 1:
				// 1. 기존 배열을 다른곳에 저장한다.
				String[] temp = nameList;
				
				// 2. nameList변수에 새로운 배열 만드려면 새로운 데이터를 추가할 공간을 만들어야함
				nameList = new String[valueCount + 1]; 
				
				// 3. 기존배열에서 데이터를 nameList로 복사한다.
				for(int i = 0; i < valueCount; i++) {
					nameList[i] = temp[i];
				}
				// 위에 기존 배열의 값을 복사해오면 새로 만든 공간이 비어있다.
				// valueCount 두 가지 역할을 함
				// 1. 데이터의 개수 저장
				// 2. 공간의 번호(index)
				sc.nextLine();
				System.out.println("추가할 이름 : ");
				nameList[valueCount] = sc.nextLine();
				
				// 새로운 데이터를 추가했기떄문에 데이터갯수 하나 증가
				valueCount++;
				System.out.println("추가 되었다.");
				
				break;
				
			case 2:
				System.out.println("조회 페이지");
				System.out.println("1. 전부 출력 / 2. 검색한 이름만 출력");
				
				sel = sc.nextInt();
				
				if(sel == 1) {
					// 전체 출력
					for(int i = 0; i < nameList.length; i++) {
						// 1번째 이름 : **
						System.out.println((i + 1) + "번 째 이름 : " + nameList[i]);
					}
				}else {
					// 검색
					sc.nextLine();
					System.out.println("검색할 이름 : ");
					String find = sc.nextLine();
					
					// 체크
					boolean check = false;
					for(int i = 0; i < valueCount; i++) {
						// 문자 여러개를 비교할 때는 .equals
						if(nameList[i].equals(find)) {
							System.out.println("찾았다");
							System.out.println("공간의 번호 : " + i);
							System.out.println(nameList[i]);
							check = true;
						}
					}
					if(check == false) {
						System.out.println("찾는 값이 없습니다.");
					}
				}
				
				break;
			case 3:
				System.out.println("삭제 페이지");
				//1. 기존 배열 복사
				String[] delete = nameList;
				
				//2. nameList에 새로운 배열 생성
				nameList = new String[valueCount - 1];
				
				sc.nextLine();
				//3. 삭제할 데이터 입력, 검색하기
				System.out.println("삭제할 이름 : ");
				String delFind = sc.nextLine();
				
				boolean check = false;
				
				// 값을 이용해서 값이 있으면 삭제할 값이 들어있는 공간의 번호를 기억
				int delIndex = -1;
				
				for(int i = 0; i < valueCount; i++) {
					if(delFind.equals(delete[i])) {
						delIndex = i;
						check = true;
					}
				}
				if(check == false) {
					System.out.println("찾는 값이 없습니다");
					break;
				}
				
				//4. 기존배열에 값을 복사해 올 때 
				//  삭제할 데이터는 빼고 나머지 복사하기
				// i 기존 배열에서 복사하기 위해서 i 값을 이용한다.
				// ArrayIndexOutOfBoundsException
				// 배열의 공간이 없다! 
				int j = 0; // 복사할 공간의 인덱스번호를 따로 만든다.
				for(int i = 0; i < valueCount; i++) {
					if(i != delIndex) {
						nameList[j] = delete[i];
						j++;
					}
				}
				//5. valueCount 값 감소 시키기
				valueCount--;
				
				break;
				
			case 4:
				System.out.println("정렬");
				// 오름차순으로 정렬하기
				// Arrays.sort(nameList);
				
				// 정렬 코드(버블정렬)
                for (int i = 0; i < valueCount - 1; i++) {
                    for (int j2 = 0; j2 < valueCount - i - 1; j2++) {
                        if (nameList[j2].compareTo(nameList[j2 + 1]) > 0) {
                            String temp2 = nameList[j2];
                            nameList[j2] = nameList[j2 + 1];
                            nameList[j2 + 1] = temp2;
                        }
                    }
                }
				break;
				
			case 5:
				System.out.println("종료");
				return;
			}
		}
		/*
		 * !주의사항!
		 * switch문이랑 while문이랑 같이 사용할 경우에는 switch문을 종료할 때 break를 사용
		 * 
		 * switch문 안에서 break를 하면
		 * switch문은 빠져나가지만 while문 안에 계속 반복을 함
		 * 
		 * return(함수의 종료) : main을  종료한다는 의미다!
		 * 종료를 한다는 것은 프로그램을 종료한다는 의미로 사용되기 때문에 무한반복중인 while을 끝낸다 
		 */

	}

}