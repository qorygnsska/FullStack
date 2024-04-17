package Sort;

import java.util.Scanner;
// 총 금액 입력 받고 원가와 세금 출력
public class SelectionSortTest2 {
	public static double Price(int totalPrice) {
		double productPrice = totalPrice / 1.1;
		return productPrice;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("소비자가 입력(원) : ");
		int totalPrice = sc.nextInt();
		double tax = Price(totalPrice) * 0.1;
		
		System.out.println("제품 가격은 " + Math.round(Price(totalPrice)) + "원, 부가가치세는 " + Math.round(tax) + "원 입니다.");
		
	}

}
