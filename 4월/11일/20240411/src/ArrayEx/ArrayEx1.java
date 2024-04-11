package ArrayEx;

public class ArrayEx1 {

	public static void main(String[] args) {
		// 변수 : 하나의 값만 저장
		// 배열(Array) 
		// - 여러개의 값을 저장한다.
		// - 같은 종류(자료형)의 데이터를 여러개 저장
		// - 같은 이름으로 여러 개의 기억장소를 만든다.
		// - 기억장소 구분은 인덱스(공간번호)를 이용
		
		//  정수 3개를 저장하는 배열
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		// 실수 3개를 저장하는 배열
		double[] arr2 = new double[3];
		arr2[0] = 1.1;
		arr2[1] = 2.2;
		arr2[2] = 3.3;
		
		// 문자 여러개 저장하는 배열
		String[] arr3 = new String[3];
		arr3[0] = "이익준";
		arr3[1] = "양석형";
		arr3[2] = "김준완";
		// 공간 만들고 저장할 때는 공간의 번호를 이용한다! 공간의 번호는 0부터 시작함
		
		int[] arr4 = {1, 2, 3, 4, 5};
		String[] arr5 = {"익준", "준완"};
		
		// arr4 각각의 공간의 번호를 이용해서 출력
		System.out.println(arr4[0]);
		System.out.println(arr4[1]);
		System.out.println(arr4[2]);
		System.out.println(arr4[3]);
		System.out.println(arr4[4]);
		
		System.out.println(arr5[0]);
		System.out.println(arr5[1]);
		
		// 자격증 시험의 점수 배열 생성 87, 11, 30, 20, 59
		int[] scores = {87, 11, 30, 20, 59};
		
		// 총점
		int total = scores[0] + scores[1] + scores[2] + scores[3] + scores[4];
		System.out.println("총점 : " + total);
		
		// 평균
		// 배열의 길이를 확인하는 키워드  : 배열명.length 
		// - ()를 쓰지 않는다
		System.out.println("배열의 길이 : " + scores.length);
		
		System.out.println("평균 : " + total / scores.length);

		
		int[] arr1 = {10, 20, 30, 40, 50};

		
		// 문제1) 4의 배수만 출력
		// 정답1) 20 40
		int i = 0;
		
		// while문 사용
		while(i < arr1.length) {
			if(arr1[i] % 4 == 0) {
				System.out.print(arr1[i] + " ");
			
			}
			i++;
		}
		
		System.out.println();
		
		// for문 사용
		for(i = 0; i < arr1.length; i++) {
			if(arr1[i] % 4 == 0) {
				System.out.print(arr1[i] + " ");
			}
		}
		
		System.out.println();

		
		// 문제2) 4의 배수의 합 출력
		// 정답2) 60
		int total2 = 0;
		
		//배열에서 하나씩 꺼내온다
		// 하나씩 꺼내 오다가 더 이상 꺼낼 데이터가 없으면 반복을 종료!
		// 밑에 for문은 조건 줄 필요가 없다
		// 배열이름만 쓰면 자바가 배열의 개수를 자동으로 계산해서 계산된 개수만큼 자동으로 반복을 실행한다.
		// 단 값만 가져오기 때문에 인덱스번호를 사용할 수 없음
		for(int num : arr1) {
			if(num % 4 ==0) {
				total2 += num;
			}
		}
		System.out.println("합  : " + total2);
		
		
		// 문제3) 4의 배수의 개수 출력
		// 정답3) 2
		int count = 0;
		int start = 0;
		
		while(start < 5) {
			if(arr1[start] % 4 == 0) {
				count++;
			}
			start++;
		}
		System.out.println(count);
		
	}
	
}


