package Interface_NoteBook;

public interface Main {
	public static void main(String[] args) {
		
		AppleNoteBook a1 = new AppleNoteBook();
		GalaxyNoteBook g1 = new GalaxyNoteBook();
		LGNoteBook l1 = new LGNoteBook();
		GalaxyTab g2 = new GalaxyTab();
		
		// 크롬을 다운받은 모든 기계들을 관리
		// 다형성!
		Chrom[] list = {a1, g1, l1, g2};
		
		for(int i = 0; i < 4; i++) {
			list[i].browser();
		}
		/*
		 * 인터페이스
		 *   서로 다른 두 개의 시스템 장치 사이에서 정보나 신호를 주고 받는 경우
		 *   사용자가 기기를 쉽게 동작시키는데 도움을 주는 상호 작용
		 *    
		 * 인터페이스는 다중상속이 된다.
		 * 다중 상속할 때 콤마로 구분
		 * 키워드 implements 인터페이스명, 인터페이스명, ....
		 * 
		 * 인터페이스를 구현하는 멤버
		 *   추상메서드
		 *   고정된 상수만 (final) 만 저장 가능하다
		 *   public abstract 생략이 가능하다.
		 * 
		 */
	}
}
