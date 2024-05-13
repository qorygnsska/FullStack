package Thread;

class MusicThread extends Thread{
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("배경음악 나오는 중!!!");
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {
		
		MusicThread mt = new MusicThread();
		
		// 다른 스레드가 종료될 때 모든 스레드가 종료될 수 있도록 설정
		// 단 설정은 스레드 시작전에 설정!
		mt.setDaemon(true);
		
		mt.start();
		
		for(int i = 0; i < 100; i++) {
			System.out.println("열심히 게임중!!!");
			if(i == 50) {
				System.out.println("헉스 엄마다!");
				break;
			}
		}
		System.out.println("공부중인데용?~");
		// 데몬 스레드
		//  일반 스레드랑은 다른 특성을 가진다.
		//  백그라운드에서 동작하며 주로 서비스 스레드의 보조역할을 수행하거나
		//  특정 작업을 주기적으로 처리하는 목적으로 사용된다.

	}

}

/*
 * 동기화
 *  - 멀티스레드를 사용하다보면 두 개 이상의 스레드가 공유 데이터에 동시에 접근하게 되면
 *    예상과 벗어난 결과를 나타낼 때가 있는데 이런 문제를 해결해주는 것이 스레드 동기화!
 */ 
