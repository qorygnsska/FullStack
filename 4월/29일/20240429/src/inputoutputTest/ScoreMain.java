package inputoutputTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreMain {
	private static ScoreList scoreList = new ScoreList();

	public static void main(String[] args) {
		/*
		 * Score 클래스 생성 그 안에 1번 2번 학생 순서번호 : 1 이름 : 박신우 국어 : 100 영어 : 80 수학 : 90
		 * 
		 * 학생 순서번호 : 2 ~~ ~~ ~~ 저장할 수 있는 scoreList를 만들어서 memoList와 똑같이 파일 저장하고 파일읽기 하기
		 * 파일명 : scoreList.txt
		 */
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 성적 저장");
			System.out.println("2. 성적 출력");
			System.out.println("3. 파일 저장");
			System.out.println("9. 끝내기");
			System.out.print("입력 : ");
			int sel = sc.nextInt();
			if (sel == 1) {
				saveScore();
			} else if (sel == 2) {
				readScore();
			} else if (sel == 3) {
				writeFile();
			} else if (sel == 9) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("번호를 다시 입력");
			}
		}

	}

	private static void saveScore() {
		int num = 0; // 학생 숫자 변수
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = scan.nextLine().trim(); // 공백제거 중간의 공백은 제거 못하지만 양끝 공백은 제거한다
		System.out.print("국어 점수 : ");
		int kor = scan.nextInt();
		System.out.print("영어 점수 : ");
		int eng = scan.nextInt();
		System.out.print("수학 점수 : ");
		int math = scan.nextInt();
		Score score = new Score(name, kor, eng, math);

		scoreList.addScore(score);

		System.out.println("저장완료");
	}

	private static void readScore() {
		ArrayList<Score> temp = scoreList.getScoreList();
		if (temp.size() == 0) {
			System.out.println("데이터가 없는데용??");
		} else {
			for (int i = 0; i < temp.size(); i++) {
				System.out.println(temp.get(i));
			}
		}

	}

	private static void writeFile() {
		Scanner scan = new Scanner(System.in);
		System.out.print("파일명 입력 : ");
		String fileName = scan.nextLine();
		scoreList.save(fileName);
	}

}
