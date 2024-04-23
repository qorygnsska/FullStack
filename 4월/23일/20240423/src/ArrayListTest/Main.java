package ArrayListTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// 저장을 위한 컨트롤러 객체를 생성
	public static ShoppingController sc = new ShoppingController();

	public static Scanner scan = new Scanner(System.in);
	
	// 로그인이 되었다면 null 값이 아니다!
	//  로그인되어있으면 이메일이 저장 되어있다.
	
	public static String loginEmail = null;
	
	public static void main(String[] args) {
		/*
		 * 회원의 정보를 저장하는 클래스 장바구니 기능을 추가하는 클래스
		 */

		while (true) {
			System.out.println("===쌍용쇼핑몰===");
			System.out.println("  1.로그인");
			System.out.println("  2.로그아웃");
			System.out.println("  3.회원가입");
			System.out.println("  4.조회");
			System.out.println("  0.종료");
			System.out.print("메뉴:");

			int sel = scan.nextInt();
			
			// 버퍼 비우기
			scan.nextLine();

			if (sel == 1) {
				
				System.out.println("이메일,비밀번호");
				String email = scan.nextLine();
				String pw = scan.nextLine();
				
				String result = sc.login(email,pw);
				if(result != null) {
					loginEmail = result;
					System.out.println("로그인 성공!");
				}else {
					System.out.println("로그인 실패!");
				}
				
				/*
				 *  로그인시 
				 *   쇼핑물건 구매할 수있는 메뉴
				 *    
				 *    == **님 로그인 중..==
				 *     1. 물품구매
				 *      > 옷,음식 ,그외 준비중...
				 *      
				 *     2. 장바구니
				 *      > 장바구니 안에 물건을 출력 
				 *      > 물품 삭제, 수량변경 
				 *      
				 *     0. 메뉴로 돌아가기 
				 */

			} else if (sel == 2) {
				/*
				 * 로그아웃 
				 *   만약 로그인이 되어있지 않다면 
				 *   로그인을 하세요!
				 * 
				 *  로그인이 되어있으면 로그아웃 되었습니다.
				 *   
				 */

			} else if (sel == 3) {
				
				System.out.println("이메일,비번,이름,폰:");
				String e = scan.nextLine();
				
				if(sc.checkEmail(e)) {
					System.out.println("중복이메일입니다.");
					continue;
				};
								
				String p = scan.nextLine();
				String n = scan.nextLine();
				String ph = scan.nextLine();
				
				//컨트롤러가 가지고 있는 list에 접근
				// sc.list.add(new Member(e,p,n,ph));
				//sc.setAdd(e, p, n, ph);
				boolean res = sc.setAdd(new Member(e,p,n,ph));
				
				if(res) {
					System.out.println("정상적으로 추가되었습니다.");
				}else {
					System.out.println("추가 안된다.!");
				}
				
			}else if(sel == 4) {
			
				// 컨트롤러에게 list를 받아오기
				ArrayList<Member> list =
							sc.getList();
				for(int i=0; i <list.size(); i++) {
					String r = list.get(i).toString();
					System.out.println(r);
				}
					
				
			}else if (sel == 0) {
				break;
			} else {
				System.out
				.println("메뉴를 다시 확인해주세요!");
			}
		}
	}
}