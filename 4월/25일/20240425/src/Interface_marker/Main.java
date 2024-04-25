package Interface_marker;

public class Main {
	public static void main(String[] args) {
		/*
		 * 마커 인터페이스
		 *   빈 인터페이스!
		 *   단순하게 클래스들끼리 연결하기 위해서 만들어 놓은 인터페이스
		 */
		
		Tank t1 = new Tank();
		Soldier s1 = new Soldier();
		Doctor d1 = new Doctor();
		d1.operate(s1);
		d1.operate(d1);
		//d1.operate(t1); -> 탱크는 마커인터페이스를 구현하지 않았기 때문에 다형성이 안 맞음
	}
}

interface A{
	
}