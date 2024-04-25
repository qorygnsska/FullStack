package Interface_inheritance;

public interface Printer {
	
	void printBlack(String fileName);
	
}

// 인터페이스끼리 상속이 된다
interface ColorPinter extends Printer{
	// 추가되는 기능만 작성
	void printColor(String fileName);
	
}

