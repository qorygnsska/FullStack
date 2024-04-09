package If;

import java.util.Scanner;

public class If_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		// 문제 1. 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
		int a, b;
		System.out.print("A를 입력하세요 : ");
		a = sc.nextInt();
		System.out.print("B를 입력하세요 : ");
		b = sc.nextInt();
		
		if(a > b) {
			System.out.println(">");
		}else if(a < b) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}
		
		// 문제 2. 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 
		// 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
		int score;
		System.out.println("시험 점수 입력 : ");
		score = sc.nextInt();
		char result = ' ';
		
		if(score >= 90) {
			result = 'A';
		}else if(score >= 80) {
			result = 'B';
		}else if(score >= 70) {
			result = 'C';
		}else if(score >= 60) {
			result = 'D';
		}else {
			result = 'F';
		}
		System.out.println(result);
		
		
		// 문제 3. 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
		//		윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
		//		예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 
		//		1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 
		//		하지만, 2000년은 400의 배수이기 때문에 윤년이다.
		int year;
		System.out.print("연도 입력 : ");
		year = sc.nextInt();
		
		if(year % 400 == 0) {
			System.out.println("1");
		}else if(year % 4 == 0 && year % 100 != 0) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
		
		//삼항 연산자로 윤년 풀기
		boolean isYear = year % 4 == 0  && year % 100 != 0 || year % 400 == 0;
		String result1 = isYear ? "윤년" : "평년";
		System.out.println(result1);
		
		// 문제  4. 키, 몸무게를 double로 입력 받고 BMI지수 계산 후 저제충/정상체중/과체중/비만 출력
		//		BMI = 몸무게 / (키 * 키)
		//		BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
		//		BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
		//		BMI가 30이상일 경우 고도 비만
		System.out.print("키(m)를 입력하세요 : ");
		double h = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력하세요 : ");
		double w = sc.nextDouble();
		double bmi = w / (h * h);
		System.out.println("BMI 지수 : " + bmi);
		
		if(bmi >= 30) {
			System.out.println("고도비만");
		}else if(bmi >= 25) {
			System.out.println("비만");
		}else if(bmi >= 23) {
			System.out.println("과체중");
		}else if(bmi >= 18.5) {
			System.out.println("정상체중");
		}else {
			System.out.println("저체중");
		}
		
		
		// 문제 5. 키보드로 두 개의 정수와 연산 기호를 입력 받아 연산 결과 출력
		//		 두 개의 정수 모두 양수일 때만 작동
		// 		 없는 연산기호 입력 시 잘못 입력하셨습니다. 프로그램을 종료합니다. 출력
		System.out.print("피연산자1 입력 : ");
		int n1 = sc.nextInt();
		System.out.print("피연산자2 입력 : ");
		int n2 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		String x = sc.nextLine();
		
		if(n1 > 0 && n2 > 0) {
			if(x.equals("+")) {
				System.out.println(n1 + " " + x + " " + n2 + " = " + (n1 + n2));
			}else if(x.equals("-")) {
				System.out.println(n1 + " " + x + " " + n2 + " = " + (n1 - n2));
			}else if(x.equals("*")) {
				System.out.println(n1 + " " + x + " " + n2 + " = " + (n1 * n2));
			}else if(x.equals("/")) {
				System.out.println(n1 + " " + x + " " + n2 + " = " + (n1 / n2));
			}else if(x.equals("%")) {
				System.out.println(n1 + " " + x + " " + n2 + " = " + (n1 % n2));
			}else {
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
		}else {
			System.out.println("양수를 입력하세요.");
		}
		
		
		// 문제 6. 중간, 기말, 과제, 출석횟수 입력하고 Pass 또는 Fail 출력
		// 중간 20, 기말 30, 과제 30, 출석 20 으로 이루어짐
		// 출석 비율은 출석 횟수의 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산
		// 70 이상 pass, 70미만 or 전체 강의에 30이상 결석 시 fail
		
		System.out.print("중간 고사 점수 : ");
		double score1 = sc.nextDouble() * 0.2;
		System.out.print("기말 고사 점수 : ");
		double score2 = sc.nextDouble() * 0.3;
		System.out.print("과제 점수 : ");
		double score3 = sc.nextDouble() * 0.3;
		System.out.print("출석 횟수 : ");
		double score4 = sc.nextDouble();
		double sumsc = score1 + score2 + score3 + score4; 
		System.out.println("=========== 결과 ===========");
		System.out.println("중간 고사 점수(20) :  " + score1);
		System.out.println("기말 고사 점수(30) :  " + score2);
		System.out.println("과제 점수(30) :  " + score3);
		System.out.println("출석 점수(20) :  " + score4);
		System.out.println("총점 :  " + sumsc);
		
		if(sumsc >= 70 && score4 > 14) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail [점수미달]");
		}
			
		
	}

}
