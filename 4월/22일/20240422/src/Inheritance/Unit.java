package Inheritance;

public class Unit {
	// 어떤 캐릭터든 목숨과 마력이 있다
	private int hp;
	
	public Unit(int hp) {
		this.hp = hp;
	}

}
// 마린이라는 군인은 테란의 캐릭터이다
// 다중상속이 안된다
class Marine extends Teran{
	public Marine(int hp) {
		super(hp);
	}
}

class Teran extends Unit{
	public Teran(int hp) {
		super(hp);
	}
}

class Jug extends Unit{
	public Jug(int hp) {
		super(hp);
	}
}
