package Queue;

import java.util.Scanner;

public class QueueEx {
	// 큐에 추가하는 함수
	public static int[] push(int[] arr, int count) {
		// 배열을 넘겨 받아서 기존에 있는 배열을 다른곳에 복사하고
		// 배열에 새로운 공간을 생성한다. rear가 증가한다
		// 값 추가하고 rear main에 넘겨주기
		
		// 만약 데이터가 없다면 데이터를 복사하는 문장을 쓸 필요가 없음
		if(count == 0) {
			arr = new int[1];
		}else { // 기존 데이터가 있다면
			int[] temp = arr;
			arr = new int[count + 1];
			
			for(int i = 0; i < temp.length; i++) {
				arr[i] = temp[i];
			}
		}
		Scanner sc = new Scanner(System.in);
		// 새로운 데이터 추가
		System.out.print("추가 할 정수 입력 : ");
		arr[count] = sc.nextInt();
		
		// 데이터의 개수가 증가
		count++;
		
		return arr;
	}	
	// 큐에 삭제하는 함수
	public static void delete() {
		
	}
	// 조회
	// 큐는 순서대로 출력!
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		
		/*
		 * Queue
		 * 사전적으로는 무엇을 기다리는 사람
		 * 줄을 서서 기다린다.
		 * 먼저 대기한 사람이 먼저 일을 해결하고 나간다.
		 * FIFO(First In First Out)
		 * 배열(LinkedList)
		 * 
		 * Enqueue
		 *  - 큐 맨뒤에 데이터 추가
		 * Dequeue
		 *  - 큐 맨 앞쪽의 데이터 삭제
		 *  
		 *  큐는 한 쪽 끝(앞쪽) Front로 정한다(삭제)
		 *  큐의 다른 한 쪽 끝(뒷쪽) Rear로 정한다(추가)
		 *  컴퓨터 버퍼(Scanner)에서 주로 사용
		 */
		
		// main이 가지고 있는 배열과 함수에서 새로만든 배열은 다르다!
		// main에 있는 arr에 적용을 시켜줘야함
		// retrun 배열 : 함수의 반환 타입도 int[]로 해야함
		
		int[] arr = new int[5];
		int front = 0; // 가장 앞쪽 데이터
		int rear = 4; // 가장 뒷쪽 데이터
		
		int count = arr.length;
		
		//count = push(arr, count);
		arr = push(arr, count);
		count = arr.length;
		rear = arr.length - 1;
		System.out.println("현재 rear : " + rear);
		System.out.println("현재 count : " + count);
		
		print(arr);


	}

}
