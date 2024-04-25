package InterfaceTest;

public class Cat extends Animal{
	private String location;
	private String color;
	
	Cat(){}

	public Cat(String location, String color, String name, String kinds) {
		super(name, kinds);
		this.location = location;
		this.color = color;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void speak() {
		super.speak();
		System.out.println(location + "에 서식하며 색상은 " + color + "입니다.");
	}
	
	
}
