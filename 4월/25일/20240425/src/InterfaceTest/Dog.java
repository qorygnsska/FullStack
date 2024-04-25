package InterfaceTest;

public class Dog extends Animal{
	final private String PLACE = "애견카페";
	private int weight;
	
	Dog(){}

	
	
	public Dog(int weight, String name, String kinds) {
		super(name, kinds);
		this.weight = weight;
	}



	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPLACE() {
		return PLACE;
	}

	@Override
	public void speak() {
		super.speak();
		System.out.println("몸무게는 " + weight + "kg 입니다.");
	}
	
}
