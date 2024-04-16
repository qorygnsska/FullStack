package Function;

import java.util.Scanner;

public class FunctionEx2 {
	// 국어등급 출력하는 함수
	public static void korScore() {
		Scanner sc = new Scanner(System.in);

		System.out.print("국어 점수를 입력하세요: ");
		int koreanScore = sc.nextInt();
		
		char grade;
		if (koreanScore >= 90) {
			grade = 'A';
		} else if (koreanScore >= 80) {
			grade = 'B';
		} else if (koreanScore >= 70) {
			grade = 'C';
		} else if (koreanScore >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("국어의 등급:" + grade);

	}
	
	public static void engScore() {
		Scanner sc = new Scanner(System.in);

		System.out.print("영어 점수를 입력하세요: ");
		int englishScore = sc.nextInt();
		
		char grade;
		if (englishScore >= 90) {
			grade = 'A';
		} else if (englishScore >= 80) {
			grade = 'B';
		} else if (englishScore >= 70) {
			grade = 'C';
		} else if (englishScore >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("영어의 등급:" + grade);

	}
	
	public static void mathScore() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수학 점수를 입력하세요: ");
		int mathScore = sc.nextInt();
		
		char grade;
		if (mathScore >= 90) {
			grade = 'A';
		} else if (mathScore >= 80) {
			grade = 'B';
		} else if (mathScore >= 70) {
			grade = 'C';
		} else if (mathScore >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("수학의 등급:" + grade);
	}

	public static void main(String[] args) {
		/*
		 * 함수를 사용하는 이유!
		 * 중복되는 코드들을 줄이기 위해서 사용!
		 * 
		 */
		
		// 국어 영어 수학 점수 받는다
		// 각각의 등급을 출력
		// 국어 등급 B 입니다.
		// 영어 등급 A 입니다.
		// 수학 등급 C 입니다.
		korScore();
		engScore();
		mathScore();
		
		// 국어등급 코드를 다시 실행
		korScore();
	}

}
