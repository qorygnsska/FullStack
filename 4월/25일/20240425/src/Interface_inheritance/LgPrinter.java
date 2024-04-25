package Interface_inheritance;

public class LgPrinter implements Printer{
	
	@Override
	public void printBlack(String fileName) {
		System.out.println("Lg 프린터 출력 : " + fileName);
	}
	
}

class ColorPrintLg implements ColorPinter{

	@Override
	public void printBlack(String fileName) {
		System.out.println("Lg 흑백 출력 : " + fileName);
		
	}

	@Override
	public void printColor(String fileName) {
		System.out.println("Lg 컬러 출력 : " + fileName);
		
	}
	
}
