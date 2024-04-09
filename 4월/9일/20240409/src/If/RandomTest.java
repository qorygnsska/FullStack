package If;

import java.util.ArrayList;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		// 임의의 난수(랜덤값)
		// Scanner 처럼 이미 만들어진 기능을 포함해서 사용 : Random 클래스
		Random rand = new Random();		 
		
		  
		
		  
		 
		// 문제 1. 동전 던져서 1 이면  앞면 출력, 0 이면 뒷면을 출력, 랜덤 값을 뽑을 때  랜덤 개수 2
		int n0 = rand.nextInt(2);
		if(n0 == 1) {
			System.out.println(n0 + " 앞면");
		}else {
			System.out.println(n0 + " 뒷면");
		}
		
		
		// 문제 2. 로또 번호를 6개 출력, 1~45 사이의 숫자, 반복문,배열을 배웠다. 중복을 제거한다
		int n1 = rand.nextInt(45) + 1;
		int n2 = rand.nextInt(45) + 1;
		int n3 = rand.nextInt(45) + 1;
		int n4 = rand.nextInt(45) + 1;
		int n5 = rand.nextInt(45) + 1;
		int n6 = rand.nextInt(45) + 1;
		System.out.print(n1 + " " + n2 + " " + n3 + " " + n4 + " " + n5 + " " + n6);
		
		
		
//		// 정수 하나 뽑기
//		// int 범위 -21억 +21억 사이 숫자를 뽑는다
//		System.out.println(rand.nextInt());
//		
//		// 0, 1, 2 사이에서 정수 하나 뽑기
//		// nextInt(개수) : 0 ~ 개수만큼 뽑는다
//		System.out.println(rand.nextInt(3));
//		
//		// 로또 숫자 1~45 사이
//		// nextInt(개수) + 시작수
//		// 시작수 부터 개수 안에 하나를 뽑는다
//		System.out.println(rand.nextInt(45) + 1);
//		
//		// -6부터 6사이에 숫자를 하나 뽑는다
//		System.out.println(rand.nextInt(13) - 6);
		
		

	}

}
