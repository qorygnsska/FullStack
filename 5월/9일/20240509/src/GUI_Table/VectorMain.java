package GUI_Table;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VectorMain {

	public static void main(String[] args) {
		// 윈도우 생성
		JFrame frame = new JFrame("테이블 예제");

		frame.setBounds(0, 0, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 테이블 데이터 생성(벡터의 벡터)
		Vector<Vector<Object>> dataList = new Vector<Vector<Object>>();
		
		Vector<Object> data1 = new Vector<Object>();
		data1.add("홍길동");
		data1.add("30");
		data1.add("남자");
		
		Vector<Object> data2 = new Vector<Object>();
		data2.add("홍길순");
		data2.add("35");
		data2.add("여자");
		
		// 테이블 열 이름 생성
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("이름");
		columnNames.add("나이");
		columnNames.add("성별");
		
		// 위에서 생성한 데이터를 한곳에 저장한다.
		dataList.add(data1);
		dataList.add(data2);
		
		// 테이블 생성 및 모델 설정
		// JTable(데이터, 컬럼명);
		JTable table = new JTable(dataList, columnNames);

		// 테이블 생성후 스크롤을 사용을 가능하도록 설정
		JScrollPane scrollPane = new JScrollPane(table);

		// 윈도우에 추가한다.
		frame.add(scrollPane);

		// 윈도우를 보이기
		frame.setVisible(true);

	}
}

/*
 * Vector는 ArrayList와 같이 List 인터페이스를 상속 받은 컬렉션 프레임워크
 * ArrayList랑 크게 다르지 않다.
 * 
 * 가변 개수의 배열이 필요할 때 과거에 사용되었다.
 */
