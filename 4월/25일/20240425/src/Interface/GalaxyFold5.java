package Interface;

import Interface_NoteBook.Chrom;

public class GalaxyFold5 extends SmartPhone implements NotePen, Chrom{

	@Override
	void printInfomation() {
		
		
	}

	@Override
	String makeCall() {
	
		return null;
	}

	@Override
	String takeCall() {
		
		return null;
	}

	@Override
	public void button() {
		System.out.println("폴드만의 버튼");
		
	}

	@Override
	public void connect() {
		System.out.println("폴드만의 연결");
		
	}

	@Override
	public void browser() {
		System.out.println("폴드만의 크롬버전");
		
	}

}
