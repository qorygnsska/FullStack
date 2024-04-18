package Shape;

public class SquareController {
	public Shape s = new Shape();

	public double calcPerimeter(double height, double width) {

		s.height = height;
		s.width = width;
		return 2 * (height + width);
	}

	public double calcArea(double height, double width) {

		s.height = height;
		s.width = width;
		return height * width;
	}

	public void paintColor(String color) {

		s.color = color;
	}

	public String print() {

		return "사각형" + s.information();
	}
}
