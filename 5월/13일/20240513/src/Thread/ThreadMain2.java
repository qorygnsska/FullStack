package Thread;

class MyThread extends Thread {
	// 각각의 객체가 동작할 수 있도록 실행되는 코드 작성
	// run() 메서드에 정의
	// 그리고 start() 메서드 : 스레드 시작 메서드
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);

			// 1초 1000 0.5초 500
			// 프로그램 지연! sleep()
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadMain2 {

	public static void main(String[] args) {
		// 스레드 객체를 가지고 있는 MyThread 생성
		System.out.println("main 스레드 실행!");
		
		MyThread mt = new MyThread();
		mt.start(); // 자동으로 run() 메서드 실행
		
		System.out.println("main 스레드 실행 끝!");
		
		Car c1 = new Car(1000, "현다이");
		Car c2 = new Car(150, "페라리");
		Car c3 = new Car(300, "포르쉐");
		c1.start();
		c2.start();
		c3.start();

	}

}

class Car extends Thread{
	int time; // 지연 시키는 시간을 저장
	String name; // 자동차 이
	
	public Car(int time, String name) {
		super();
		this.time = time;
		this.name = name;
	}



	// 스레드들의 실행하는 코드
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " 움직인다.");
			System.out.println(i);

			// 1초 1000 0.5초 500
			// 프로그램 지연! sleep()
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * 자동차 객체 3개를 생성하고 각각 시간은 따로주고
		 * 각각의 스레드를 실행하는 start 
		 */
	}
}
