package Shape;

public class TriangleController {
	public Shape s = new Shape();

	public double calcArea(double height, double width) {

		s.height = height;
		s.width = width;
		return height * width / 2;

	}

	public void paintColor(String color) {

		s.color = color;
	}

	public String print() {

		return "삼각형" + s.information();
	}
}
