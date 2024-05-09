package GUI_Table_Test_Teacher;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TableController extends JFrame implements ActionListener {

	/*
	 * 윈도우 창을 띄우고 입력받는 것! 이벤트 설정
	 * 
	 */
	// 입력과 테이블 영역으로 나눔!
	private JPanel inputPanel;
	private JPanel tablePanel;

	// 텍스트 입력
	private JTextField titleField;
	private JTextField writerField;
	private JTextField contentField;

	// 텍스트필드 앞에 글씨
	private JLabel title;
	private JLabel writer;
	private JLabel content;

	// 추가버튼, 삭제버튼
	private JButton addBtn;
	private JButton removeBtn;

	// 테이블 생성하는 클래스 변수
	private JTable table;
	private DefaultTableModel tableModel;

	private TableService service = new TableService();

	// 위에 처럼 전역변수로 선언하면 어떤 메서드에서든
	// 접근해서 컴포넌트를 조작할 수 있다.

	TableController() {
		// 윈도우 설정
		setBounds(0, 0, 1000, 500);
		setLayout(new GridLayout(2, 1));

		// 컴포넌트들 설정
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {

		// inputPanel생성 (공간 생성)
		// 라벨,버튼,입력
		// 객체를 생성할 때 레이아웃 객체를 생성해서
		// 넘겨주면 자동으로 레이아웃 설정되어서
		// setLayout()메서드 안써도됨

		// JPanel 공간분리하는 클래스
		// 실제 기본 배치가 flowlayout
		// 한줄에 배치가 된다

		Font font = new Font("굴림체", Font.BOLD, 25);

		inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));

		title = new JLabel("글 제목 ");
		title.setFont(font);
		titleField = new JTextField(10);

		writer = new JLabel("작성자 ");
		writer.setFont(font);
		writerField = new JTextField(10);

		content = new JLabel("내용 ");
		content.setFont(font);
		contentField = new JTextField(10);

		addBtn = new JButton("추가");
		addBtn.setFont(font);

		removeBtn = new JButton("삭제");
		removeBtn.setFont(font);

		// 패널 추가!
		inputPanel.add(title);
		inputPanel.add(titleField);
		inputPanel.add(writer);
		inputPanel.add(writerField);
		inputPanel.add(content);
		inputPanel.add(contentField);
		inputPanel.add(addBtn);
		inputPanel.add(removeBtn);

		// 윈도우 추가
		add(inputPanel);

		// 테이블 생성
		// 테이블이 올라간 영역을 생성
		// JFrame 윈도우창은 기본적으로
		// BorderLayout
		// 가운데로 컴포넌트 하나가 올라간다.

		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());

		// 데이터를 저장하는 표 생성

		String[] header = { "글 제목", "작성자", "내용" };
		// 컬럼이름 추가(열 이름)
		tableModel = new DefaultTableModel(header, 0);
		// 테이블생성
		table = new JTable(tableModel);
		// table.setFont(font);

		// 스크롤 생성
		JScrollPane scrollPane = new JScrollPane(table);

		// 테이블영역에 추가
		tablePanel.add(scrollPane);

		// 테이블영역을 윈도우에 추가
		add(tablePanel);

		// 버튼을 클릭했을 때 실행하는 메서드 연결하기
		addBtn.addActionListener(this);
		removeBtn.addActionListener(this);

		/*
		 * 테이블에서 특정 행이 선택 되었을 때 발생하는 이벤트를 처리하는 TableSelectionListener
		 * 
		 * 
		 * getSelectionModel() - 선택 모델(데이터를 저장하는 표) 행을 선택하는 방법을 관리하는 메서드!
		 */
		table.getSelectionModel().addListSelectionListener(new TableSelectionListener());

	}

	class TableSelectionListener implements ListSelectionListener {
		// 마우스로 테이블의 행을 조작하고 있니?
		// 값을 조정 중인지 아닌지 확인해서 값을 조정하고 있을 않을 때 실행할 수 있도록!
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// 테이블에서 값이 조정되지 않고 한번 클릭 했을 때 실행해라! 뜻으로 사용된다
			// 테이블에 한 행을 더블클릭을 하면 수정
			// 상태가 아니면 그냥 클릭만 햇다면 실행해라!
			if (!e.getValueIsAdjusting()) {
				// getSelectRow()
				// - 선택된 행의 공간번호(인덱스)를 가져온다.
				int selectRow = table.getSelectedRow();

				// -1일 경우에는 선택된 행이 없다는 뜻!
				if (selectRow != -1) {
					// 클릭을 했을 때 조회수를 하나 증가해서 팝업창에 띄우기
					int readCount1 = service.readCount(selectRow);
					
					String title = table.getValueAt(selectRow, 0).toString();

					String writer = table.getValueAt(selectRow, 1).toString();

					String content = table.getValueAt(selectRow, 2).toString();

					String message = "제목 : " + title + ", 작성자 : " + writer + ", 내용 : " +  content + ", 조회수 : " + readCount1;
					// 팝업에 출력
					JOptionPane.showMessageDialog(null, message);

				}
			}

		}

	}

	// 버튼을 클릭했을 때 실행하는 메서드
	// 하나의 메서드를 이용해서 추가버튼을 클릭했는지
	// 삭제버튼을 클릭했는지 구별을 해야된다.
	@Override
	public void actionPerformed(ActionEvent e) {

		// 1. 어떤 버튼이 눌렸는지 정보를 가져온다.
		// 어떤 컴포넌트가 눌렸는지 모르기때문에
		// Object로 받는다.
		Object src = e.getSource();

		// 2. src변수에 저장된 주소값을 이용해서
		// 삭제버튼과 추가버튼을 구별한다.
		if (src == addBtn) {
					//추가 버튼을 클릭했을 때 실행!
					//System.out.println("추가 버튼!");
					
					Board board = new Board(
							
							titleField.getText(),
							writerField.getText(),
							contentField.getText()					
							);
					
					// 디비 전송전 서비스클래스로 객체를 전송
					if(service.insert(board) > 0) {
						JOptionPane
						.showMessageDialog
						   (null, "게시글이 추가 되었습니다.");
			
					}else {
						JOptionPane
						.showMessageDialog
						   (null, "게시글 추가에 실패하였습니다.");
			
					}
			// 팝업메뉴를 꼭 닫고 실행된다.
			String[][] rowData = service.select();

			// 2차원 배열의 주소값을 그대로 저장하면 안된다
			// 1차원배열의 주소값을 하나씩 꺼내서
			// index(공간의 번호)를 이용해서 한 줄씩
			// row에 추가해야된다.
			for (String[] row : rowData) {
				tableModel.addRow(row);
			}

		} else if (src == removeBtn) {
			// 삭제 버튼을 클릭했을 때 실행!
			System.out.println("삭제 버튼!");
		}
	}

}
