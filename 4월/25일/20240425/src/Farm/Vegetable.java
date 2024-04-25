package Farm;

public class Vegetable extends Farm{
	private String name;
	
	public Vegetable() {}

	public Vegetable(String name, String Farm) {
		super(Farm);
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vegetable [name=" + name + "]";
	}
	
	
}
