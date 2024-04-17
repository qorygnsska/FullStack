package Queue;

import java.util.Scanner;

public class QueueEx2 {
	
	// 여러 함수에도 들어간다(출력, 연산)
	// 함수들 밖에 변수를 만들 수 있다.
	// 전역변수
	// - 프로그램이 실행되고 변수가 만들어진다.
	// - 프로그램이 종료되면 변수가 삭제된다.
	
	// 지역변수
	// 장점 : 코드 분리 유지보수가 쉽다.
	// 단점 : 결과 값을 return
	
	// 전역변수
	// 장점 : 데이터를 유지
	// 단점 : 오류가 생기면 어디서 찾아야 될 지 모른다, 유지보수가 어렵다
	
	public static int[] arr = {1, 2, 0, 0, 0};
	public static int front = 0;
	public static int rear = arr.length - 1;
	public static int count = 2;
	
	public static void delete() {
		if(count == 0) {
			System.out.println("삭제할 데이터가 없습니다.");
			return;
		}
		// 현재 0~4까지만 있다.
		// front를 계속 증가시키면 4를 넘는다 = error
		
		front++;
		count--;
		
	}
	
	
	public static void push() {
		
		if(count <=5) {
			// 함수밖에 전역변수에 있는값을 그냥 사용하면 됨
			Scanner sc = new Scanner(System.in);
			// 새로운 데이터 추가
			System.out.print("추가 할 정수 입력 : ");
			arr[count] = sc.nextInt();
			
			// 데이터의 개수가 증가
			count++;
		}else {
			System.out.println("더 이상 추가 할 수 없습니다.");
		}
	}
	
	public static void show() {
		
		// 위에 고정된 배열을 사용하기 때문에
		// arr.lenght 무조건 5
		// 삭제된 결과를 볼 수가 없다!
		for(int i = 0; i < count; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void add() {
		
	}
	public static void main(String[] args) {
		for(int i = 1; i <= 5; i++) {
			//push();
			delete();
			show();
		}
	}
}
