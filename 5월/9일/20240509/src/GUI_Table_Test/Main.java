package GUI_Table_Test;

public class Main {

	public static void main(String[] args) {
		/*
		 * 글 추가 버튼을 클릭하면
		 *  텍스트 필드에 있는 모든 내용을 꺼내온다
		 *  데이터가 하나라도 없으면(글 제목, 글 내용, 글 작성자) 글을 다시 입력하세요!
		 *  
		 *  Board 클래스를 이용해서 객체 생성 후 DB로 전송
		 *  전송이 잘 되었으면 값의 결과에 따라서 윈도우 창에서 팝업을 이용해서 정상적으로 출력했습니다!
		 *  팝업을 출력하는데 에러 표시로 출력! 제대로 저장되지 못했습니다!
		 */
		new TableController();
	}

}
