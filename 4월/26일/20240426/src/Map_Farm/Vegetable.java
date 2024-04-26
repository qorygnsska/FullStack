package Map_Farm;

public class Vegetable extends Farm{
	private String name;
	
	public Vegetable() {}

	public Vegetable(String name, String kind) {
		super(kind);
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
		return "Vegetable [name=" + name + ", getKind()=" + getKind() + "]";
	}

	
	
	
}
