package Map_Farm;

public class Nut extends Farm{
	private String name;

	public Nut(String name, String kind) {
		super(kind);
		this.name = name;
	}
	
	public Nut() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Nut [name=" + name + ", getKind()=" + getKind() + "]";
	}

	
	
	
}
