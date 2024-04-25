package Interface_marker;

public class Unit {
	private int hp; // 유동적인 목숨
	private final int maxHp; // 고정된 목숨

	Unit(int maxHp) {
		this.maxHp = maxHp;
		this.hp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}
}

class Tank extends Unit {
	Tank() {
		super(1000);
		System.out.println("탱크생성");
	}
}

class Soldier extends Unit implements A{

	public Soldier() {
		super(100);
		System.out.println("군인 생성!");
	}
}

//의사도 캐릭터 이다!
class Doctor extends Unit implements A{

	Doctor() {
		super(80);
		System.out.println("의사 생성!");
	}

	
	// 사람만 치료를 해준다.
	// 군인,의사
	void operate(A unit) {
		// 인터페이스 타입으로 다형성에 의해서 구별했다
		// 비어있는 인터페이스로 업캐스팅을 하게되면 내가 원하는 변수에 접근이 불가능하다.
		Unit u = (Unit)unit;
		u.setHp(u.getMaxHp());
		System.out.println("다 고쳤다");
	}

}

