import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		 // 문제 1. 문자열을 입력받아 배열에 넣고 검색한 문자의 개수와 몇번째 인덱스에 존재하는 지 출력
//		System.out.print("문자열 입력:");
//		String str = sc.nextLine();
//		
//		// 문자열을 배열로 반환 
//		char[] charArr = str.toCharArray();
//		
//		
//		System.out.print("검색할 한 문 입력:");
//		char find = sc.nextLine().charAt(0);
//		
//		
//		//검색한 한 문자 개수 변수
//		int count = 0;
//		
//		for(int i = 0; i < charArr.length; i++) {
//			
//			if(charArr[i] == find) {
//				System.out.print(i +" ");
//				count++;
//			}			
//		}
//		System.out.println();//공백
//		System.out.println(find + " 개수:" + count);	
//		
//		
//		// charAt(index)
//		//  문자열로 입력받은 것 중에 
//		//  한 문자를 가져오기 
//		//	System.out.println(str.charAt(0));
//		//	System.out.println(str.charAt(1));
//		//	System.out.println(str.charAt(2));
//		//	System.out.println(str.charAt(3));
//
//		
//		
//		
//		
//		
//		// 문제 2. 3이상인 홀수 자연수를 입력받아 1부터 1씩 증가하여 오름차순으로 값을 넣고
//		// 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣고 출력, 조건에 안 맞을경우 다시 입력
//		while(true) {
//			System.out.println("3이상인 홀수 입력 : ");
//			int num = sc.nextInt();
//			if(num >= 3 && num % 2 == 1) {
//				for(int i = 1; i <= num / 2; i++) {
//					System.out.print(i + " ");
//				}
//				System.out.print((num / 2) + (num % 2) + " ");
//				for(int j = num / 2; j >= 1; j--) {
//					System.out.print(j + " ");
//				}
//				break;
//			}else {
//				System.out.println("3이상 홀수를 입력하세요!!!");
//			}
//		}
//		
//		System.out.println();
//		
//		
//		// 문제 3. 사용자가 입력한 값이 배열에 있는 지 검색하여 있으면 ~치킨 배달 가능, 없으면 없는 메뉴 출력
//		sc.nextLine();
//		String[] chi = {"뿌링클", "황올", "허니콤보", "슈프림", "골드킹"};
//		System.out.print("치킨 메뉴 입력 : ");
//		String schi = sc.nextLine();
//		boolean check = false;
//		for(int i = 0; i < chi.length; i++) {
//			if(schi.equals(chi[i])) {
//				System.out.println(schi + "치킨 배달 가능");
//				check = true;
//			}
//		}
//		if(check == false) {
//			System.out.println("없는 메뉴입니다.");
//		}
//		
//		
//		// 문제 4. 주민등록번호 성별자리 이후부터 *로 가리고 출력 원본 배열값은 원본으로 저장
//		while(true) {
//			System.out.print("주민번호 13자리 입력(-포함) : ");
//			String jumin = sc.nextLine();
//			String[] ju = jumin.split("", jumin.length());
//			if(ju.length == 14 && ju[6].equals("-")) {
//				for(int i = 0; i < ju.length; i++) {
//					if(ju[i] != "-" && i < 8) {
//						System.out.print(ju[i]);
//					}else if(ju[i] == "-") {
//						System.out.print(ju[i]);
//					}else{
//						System.out.print("*");
//					}
//					
//				}break;
//			}else {
//				System.out.println("주민번호 13자리와 '-'를 제대로 입력해주세요");
//			}
//			
//		}
//		System.out.println();
		
		//========================= 집 가서 완성한다 =================================
		
		// 문제 5. 사용자가 입력한 배열의 길이만큼 문자열 배열 선언 및 할당, 값도 사용자가 입력하여 초기화
		// 사용자에게 배열에 값을 더 넣을건 지, 몇개를 더 입력할 건지, 어떤 데이터를 넣을건 지 입력 받고
		// 더 이상 추가하지 않겠다고 하면 배열 전체 값 출력
		/*    예시
		 * 배열의 크기 입력 : 3
		 * 1번째 문자열 : ~~
		 * 2번째 문자열 : ~~
		 * 3번째 문자열 : ~~
		 * 더 값을 입력? : y
		 * 더 입력하고 싶은 개수 : 2
		 * 4번째 문자열 : 
		 * 5번째 문자열 : 
		 * 더 값을 입력? n
		 * 출력
		 */
		System.out.print("배열의 크기 입력 : ");
		int n = sc.nextInt();
		sc.nextLine();
		int x = n;
		String[] ary = new String[n];
		for(int i = 0; i < n; i++) {
			
			System.out.print((i+1) + "번째 문자열 : ");
			ary[i] = sc.nextLine();
		}
		
		int n2 = 0;
		while(true) {
			System.out.println(x);
			System.out.print("더 값을 입력?(y / n) : ");
			String answer = sc.nextLine();
			
			
			if(answer.equals("y")) {
				
				System.out.print("더 입력하고 싶은 개수 : ");
				n2 = sc.nextInt();
				String[] temp = ary;
				ary = new String[x + n2];
				for(int i = 0; i < x; i++) {
					ary[i] = temp[i];
				}
				sc.nextLine();
				
				for(int i = x; i < (x + n2); i++) {
					System.out.print((i + 1) + "번째 문자열 : ");
					ary[i] = sc.nextLine();
				}
				x += n2;
			}
		
			else {
				
				for(int i = 0; i < ary.length; i++) {
					System.out.print(ary[i] + " ");
					
				}
				break;
			}
		}
		
	}

}
