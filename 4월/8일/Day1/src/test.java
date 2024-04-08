import java.util.Scanner;

public class test {

	public static void main(String[] args) {
//		/*
//		 * 산술 연산자
//		 * 더하기 +, 빼기 -, 곱하기 *
//		 * 나눗셈 몫 : /
//		 * 나눗셈 나머지 : %
//		 */
//		
//		// 예) 현금이 1000원있다. 200원짜리 과자 구입 후, 잔돈 출력
//				int 현금 = 1000;
//				int 과자 = 200;
//				int 잔돈 = 현금 - 과자;
//				System.out.println("잔돈 = " + 잔돈 + "원");
//
//				// 문제1) 월급이 100원이다. 연봉은? (조건 : 세금 10% 제외)
//				int 월급 = 100;
//				double 연봉 = 월급 * 12 - (12 * (월급 * 0.1));
//				System.out.println("연봉 : " + 연봉);
//
//				// 문제3) 가로가 3이고 세로가 6인 삼각형 넓이 출력
//				int 가로 = 3, 세로  = 6;
//				int 넓이 = 가로 * 세로 / 2;
//				System.out.println("넓이 : " + 넓이);
//				
//				// 문제4) 100초를 1분 40초로 출력
//				int a = 100;
//				int b = a / 60;
//				int c = a % 60;
//				System.out.println("100초는 : " + b + "분" + c + "초");
//				
//				// 문제5) 800원에서 500원짜리 개수 , 100원짜리 개수
//				// 정답5) 500원(1개), 100원(3개)s
//				int a2 = 500;
//				int b2 = 800 / a2;
//				int c2 = 100;
//				int d2 = 800 % a2 / c2;
//				System.out.println("500짜리 : "+ b2 + "개, 100원짜리 : " + d2 + "개");
//				
//				// 추가문제 275 가운데 숫자만 출력
//				int num = 275;
//				int num2 = (num % 100)/10;
//				System.out.println("가운데 숫자 : " + num2);
//				
//				/*
//				#문제 1) 8 과 12 의 최소 공배수를 구하시요
//				 최소 공배수란 각 수의 배수를 나열한다음 처음으로 같은숫자를 말한다.
//				 예) 8 16 24... 
//				 예) 12 24....
//				 여기서 24가 최소공배수이다.
//				 */
//				
//				
//
//				/*
//				# 문제2) 수인이는 4일 마다 수영장을 가고 형주는 6일마다 수영장에간다
//				# 두사람이  4월 3일에 만났다면 다음에 만날날은 언제인가?
//				*/
//
//				/*
//				# 문제3) 가로가 12 이고 세로가 8인 직사각형모양의 종이를 늘어놓아
//				# 만들수있는 가장작은 정사각형을 만들려고한다. 직사각형은몇장이 필요한가?
//				*/
//				
//				// 문제 1) 과락
//				// 3과목의 평균이 60점 이상이면, true
//				// 단, 어느 한 과목이라도 50점 미만이면, false
//				int kor = 100;
//				int eng = 87;
//				int math = 41;
//				double avg = (kor + eng + math) / 3;
//				boolean isResult1 = avg >= 60 && kor >= 50 && eng >= 50 && math >= 50 ? true : false;
//				System.out.println("평균 : " + avg);
//				System.out.println(isResult1);
//
//				        
//				// 문제 2) 키가 200cm이상이거나 몸무게가 200kg 이상이면, 입장(true)
//				int height1 = 199;
//				int weight1 = 199;
//				String result = height1 >= 200 || weight1 >= 200 ? "입장" : "나가";
//				System.out.println(result);
				
				
				//백준문제 2. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
				Scanner sc = new Scanner(System.in);
				System.out.print("A 입력 : ");
				int a3 = sc.nextInt();
				System.out.print("B 입력 : ");
				int b3 = sc.nextInt();
				int sum = a3 + b3;
				System.out.println("합 : " + sum);
				
				
				//백준문제 3. 두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.
				System.out.print("A 입력 : ");
				int a4 = sc.nextInt();
				System.out.print("B 입력 : ");
				int b4 = sc.nextInt();
				int sub = a4 - b4;
				System.out.println("차 : " + sub);
				
				
				//백준문제 4. 두 정수 A와 B를 입력받은 다음, A×B를 출력하는 프로그램을 작성하시오.
				System.out.print("A 입력 : ");
				int a5 = sc.nextInt();
				System.out.print("B 입력 : ");
				int b5 = sc.nextInt();
				int mul = a5 * b5;
				System.out.println("곱 : " + mul);
				
				
				//백준문제 5. 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
				System.out.print("A 입력 : ");
				int a6 = sc.nextInt();
				System.out.print("B 입력 : ");
				int b6 = sc.nextInt();
				int div = a5 / b5;
				System.out.println("몫 : " + div);
				
				
				//백준문제 6. 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
				System.out.print("A 입력 : ");
				int a7 = sc.nextInt();
				System.out.print("B 입력 : ");
				int b7 = sc.nextInt();
				int sum1 = a7 + b7, sub1 = a7 - b7, mul1 = a7 * b7, div1 = a7 / b7, na1 = a7 % b7;
				System.out.println("합 : " + sum1 + ", 차 : " + sub1 + ", 곱 : " + mul1 + ", 몫 : " + div1 + ", 나머지 : " + na1);
	}
	
				
}
