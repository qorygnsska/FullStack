package Map_Farm;

public class Farm {
private String kind;
private String name;
	
	public Farm() {}

	public Farm(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 이렇게 Farm 객체를 생성하면 Object객체가 자동으로 상속된다.
	// 오버라이딩을 해서 자식클래스의 멤버 변수값으로 하나의 문자를 만들어서 반환한다.
	@Override
	public String toString() {
		return "Farm [kind=" + kind + "]";
	}
	

	
}
