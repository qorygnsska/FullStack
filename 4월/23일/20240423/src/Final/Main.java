package Final;

public class Main {

	public static void main(String[] args) {
		
		// 변수
		// 기본적으로 자바에서 변수들은 데이터를 저장하고 변경(가변적)
		String hello = "hello";
		
		// 변수에 처음 저장된 값을 변경하지 못하게 하는 키워드 final
		final String hello2 = "hello";
		// hello2 = "HELLO"; -> 에러 : final로 선언돼서 변경 불가능
		
		Tank t1 = new Tank();
		Soldier s1 = new Soldier();
		Doctor d1 = new Doctor();
		
		System.out.println(t1.getHp());
		System.out.println(s1.getHp());
		System.out.println(d1.getHp());
		
		s1.setHp(10);
		d1.setHp(10);
		t1.setHp(10);
		
		d1.operate(s1);
		d1.operate(d1);
		d1.operate(t1);
		
	}

}
// 클래스 멤버변수로 final 고정된 값을 사용해 각각 다른값을 사용해야하면 생성자를 이용
class Unit{
	private int hp; // 유동적인 목숨
	private final int maxHp; // 고정된 목숨
	
	Unit(int maxHp){
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

class Tank extends Unit{
	Tank(){
		super(1000);
		System.out.println("탱크 생성!");
	}
}

class Soldier extends Unit{
	Soldier(){
		super(100);
		System.out.println("군인 생성!");
	}
}

class Doctor extends Unit{

	Doctor() {
		super(80);
		System.out.println("의사 생성");
	}
	// 치료를 해준다
	// 참조변수 instanceof 클래스명
	// 상속관계던가 자기 자신의 타입이라면 true 아니라면 false
	// instanceof를 이용해 탱크는 치료불가
	void operate(Unit unit) {
		if(unit instanceof Soldier || unit instanceof Doctor) {
			unit.setHp(unit.getHp()); 
			System.out.println("회복 되었다.");			
		}else {
			System.out.println("난 기계 못 고쳐");
		}
	}
	
	
}

