package Thread;

public class ThreadMain1 {
	
	public static void show() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			
			// 1초 1000  0.5초 500
			// 프로그램 지연! sleep()
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
		System.out.println("main 스레드 실행!");
		
		// 함수 실행
		show();
		
		System.out.println("main 스레드 실행끝!");
		/*
	 	스레드(Thread)
	 	 - 하나의 프로세스 안에서 독립적으로 
	 	    실행되는 작은 실행 단위
	 	    
	 	프로세스(Process)
	 	 - 시스템에서 실행 중인 프로그램을 의미한다.
	 
	 	작업관리자
	 	 ctrl + shift + esc
	 	 
		하나의 시행 단위를 스레드 하나만 동작한다. 
		단일 스레드
		
		스레드가 여러개의 실행 단위를 말하는 것
		멀티 스레드(동시 다발적으로 한꺼번에 실행)
		
		블로킹(Blocking I/O)
		 - 입력과 출력이 동작되고 있는 동안에 다른 일을 처리를 하지 못하는 상태를 의미
		 
		논블로킹(Non-Blocking I/O)
		 - 입력과 출력이 동작하면서 다른 요청을 받아서 다음 처리를 할 수 있는 함수를 실행
		 
		단일 스레드
		다운로드를 진행한다.
		main이 실행 -> A다운 -> B다운 -> C다운
		 - 하나의 프로세스 내에서 하나의 스레드만 실행되는 것(순차 실행)
		 - 프로그램이 하나의 작업만 처리할 수 있다는 의미
		 
		멀티 스레드
		 - 하나의 프로세스 내에서 동시에 여러 개의 스레드가 실행되는 것
		 - 스레드가 동시에 여러 작업을 처리하기 때문에 시스템의 성능을 향상 할 수 있다.
		 
		// Thread 클래스, Runnable 인터페이스
	 */

	}

}
