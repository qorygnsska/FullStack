package Map_Farm;

public class Fruit extends Farm{
	private String name;
	
	public Fruit() {}

	public Fruit(String name, String kind) {
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
		return "Fruit [name=" + name + ", Kind=" + getKind() + "]";
	}

	
	
}
