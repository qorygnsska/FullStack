package Shape;

public class Shape {
	int type;
	double height;
	double width;
	String color = "white";

	public String information() {

		return "의 높이 : " + height + ", 너비 : " + width + ", 색 : " + color;
	}

}
