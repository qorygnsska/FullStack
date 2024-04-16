package Stack;

public class StackEx {

	public static void show(int[] arr,int top) {
		// 데이터 출력
		for (int i = top; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
				
	}
	// 데이터 추가 하는 함수
	public static void push(int[] arr,int value
							,int count,int top) {
		System.out.println("top:" + top);
		arr[top+1] = value;
		top++;
		count++;
		System.out.println("top:" + top);
		System.out.println("count:" + count);
	}
	

	public static void main(String[] args) {

		// 스택 구조를 만들기 위해서는 두 가지 변수가
		// 필요하다

		// 배열로 구현을 하는 것이기 때문에 인덱스(공간의번호)
		// 를 이용해서 사용한다.

		int top = -1;// 아직 스택에 데이터가 쌓이지 않았다.
		int count = 0; // 스택 데이터 개수!

		int[] arr = new int[5];

		// 데이터 추가
		push(arr,10,count,top);
		push(arr,20,count,top);
		push(arr,30,count,top);
		
		System.out.println("arr[0]:" + arr[0]);
		System.out.println("arr[1]:" + arr[1]);
		System.out.println("arr[2]:" + arr[2]);
		
		System.out.println("main top:" + top);
		System.out.println("main count:" + count);

		// 데이터 출력 
		//show(arr,top);
		
		
		
		
		// 데이터 삭제
		int del = arr[top];
		arr[top] = 0;
		top = top - 1;
		count -= 1;

		// 데이터 출력
		//show(arr,top);

		// 최상위 데이터를 조회
		System.out.println(arr[top]);

		// 스택
		// - 사전적으로 쌓다, 더미
		// - 접시를 쌓아올린다.
		// - 어딘가에 데이터를 쌓는 자료구조

		// ex) 쓰레기통,스링글스 과자통 ,
		// 인터넷 뒤로가기

		// 하나의 입구 들어가기 때문에 가장 먼저
		// 들어간 데이터가 가장 나중에 나온다.
		// LIFO (Last In First Out)

		// 추가적으로 스택 구조는 이미 자바가 만들어
		// 놨다. 심화 컬렉션 프레임워크 Stack

	}
}