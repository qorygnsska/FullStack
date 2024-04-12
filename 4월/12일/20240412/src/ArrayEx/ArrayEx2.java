package ArrayEx;

import java.util.Arrays;

public class ArrayEx2 {

	public static void main(String[] args) {
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		// 문제) 1등학생의 학번과 성적 출력
		// 정답) 1004번(98점)
		
		// 가장 큰 값 구하기, 그 값이 들어있는 인덱스 번호!
		// 최고 성적을 저장하는 변수를 만들고 그 값이 저장되어 있는 인덱스(공간번호)
		int maxScore = scores[0];
		int maxIndex = 0;
		
		// 배열을 각각 접근해서 값 비교
		int i = 1;
		while(i < scores.length) {
			if(scores[i] > maxScore) {
				maxScore = scores[i];
				maxIndex = i;
			}
			i++;
		}
		System.out.print("1등학생 학번과 성적 : ");
		System.out.println(hakbuns[maxIndex] + "번(" + maxScore + "점)");
		
		

	}

}
