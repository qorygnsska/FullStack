
public class VariableEx {

	public static void main(String[] args) {
		
		// 변수 : 값 저장하는 공간
				// 변수선언 방법
				// 자료형 변수명;
				
				// 변수의 종류
				// 일반 변수 : 값
				// 참조 변수 : 메모리의 주소
				int num;
				num = 1000;
				
				System.out.println(num);
				System.out.println(num);
				System.out.println(num);
				System.out.println(num);
				System.out.println(num);
				System.out.println(num);
				System.out.println(num);
				
		// 각 각 타입 공간
		// 4byte 공간에 정수 하나 저장
		int number;
		number = 100;
		System.out.println(number);
		
		// 본인의 키를 저장하는 변수
		// 8byte 공간에 실수 하나 저장
		double hei = 174.15;
		System.out.println(hei);

		// 국어 10, 수학 95, 영어87
		// 여러개의 변수를 생성할 때 ,를 사용하여 구분
		int kor = 11, math = 95, eng = 87;
		
		// 총점 평균
		// 프로그래밍 언어에서 계산을 할 때는 타입을 계산
		// 정수 + 정수 = 정수
		// 정수 / 정수 = 정수
		// 정수 + 실수 = 실수
		int total = kor + math + eng;
		double avg = total / 3.0;

		
		// 왼쪽 타입에 맞춰서 자동으로 변경된다.
		// Casting (형변환)
		// 자동으로 형변환하는 것(묵시적 형변환) double avg = total / 3.0;
		// 프로그래머가 강제적으로 형변환하는 것(명시적 형변환) double avg = (double)total / 3;
		// - 계산하는 순간만 형태를 변경하고 실행
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		
		// 실수의 자리를 원하는 대로 출력 printf("%f", 변수명)
		// printf는 줄바꿈이 포함되어있지 않음 \n 사용해야 줄바꿈 가능
		System.out.printf("%f \n", avg);
		System.out.printf("%.5f \n", avg);
		System.out.printf("%.4f \n", avg);
		System.out.printf("%.3f \n", avg);
		System.out.printf("%.2f \n", avg);
		System.out.printf("%.1f \n", avg);
		
		/*
		 * 자바가 제공해주는 기능(라이브러리)
		 * 
		 * 수학과 관련된 기능을 제공하는 폴더
		 * Math  round()
		 * 
		 * */
	}

}
