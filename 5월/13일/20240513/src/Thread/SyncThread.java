package Thread;

class Washroom{
	// synchronized 특정 부분만 순차적으로 실행
	public synchronized void openDoor(String name) {
		System.out.println(name + " 입장");
		
		for(int i = 0; i < 1000000; i++) {
			if(i == 1000) {
				System.out.println("끄으응");
			}
		}
		System.out.println(name + " 시원해");
	}
}

class FamilyThread extends Thread{
	private Washroom wr;
	private String who;
	
	public FamilyThread(Washroom wr, String who) {
		super();
		this.wr = wr;
		this.who = who;
	}
	
	@Override
	public void run() {
		wr.openDoor(who);
	}
	
	
}

public class SyncThread {

	public static void main(String[] args) {
		
		/*
		 * 스레드를 사용하다보면 동시 다발적으로 하나의 함수를 사용할 때
		 * 동기화라는 문제가 발생한다.
		 */
		// 화장실 객체 만들기
		Washroom wr = new Washroom();
		
		FamilyThread father = new FamilyThread(wr, "Father");
		FamilyThread mother = new FamilyThread(wr, "Mother");
		FamilyThread sister = new FamilyThread(wr, "Sister");
		FamilyThread brother = new FamilyThread(wr, "Brother");
		FamilyThread me = new FamilyThread(wr, "Me");
		
		// 각각의 스레드 실행
		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();
		

	}

}
