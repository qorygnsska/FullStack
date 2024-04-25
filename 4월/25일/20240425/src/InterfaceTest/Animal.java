package InterfaceTest;

public class Animal implements Ani{
	private String name;
	private String kinds;
	
	public Animal() {}
	
	public Animal(String name, String kinds) {
		this.name = name;
		this.kinds = kinds;
	}

	@Override
	public void speak() {
		System.out.println("저의 이름은 " + name + "이고 종류는 " + kinds + "입니다.");
		
	}
}
