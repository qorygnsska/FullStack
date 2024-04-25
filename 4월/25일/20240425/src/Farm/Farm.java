package Farm;

public class Farm {
	private String kind;
	
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

	@Override
	public String toString() {
		return "Farm [kind=" + kind + "]";
	}
	
}
