package Farm;

public class Nut extends Farm{
	private String name;

	public Nut(String name, String Farm) {
		super(Farm);
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
		return "Nut [name=" + name + "]";
	}
	
	
}
