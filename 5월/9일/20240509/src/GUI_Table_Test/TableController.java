package GUI_Table_Test;

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

public class TableController extends JFrame {
	TableService service = new TableService();

	// 패널
	JPanel titlePan = new JPanel();
	JPanel writerPan = new JPanel();
	JPanel contentPan = new JPanel();
	JPanel btnPan = new JPanel();
	JPanel tablePan = new JPanel(new GridLayout());

	// 라벨
	JLabel title;
	JLabel writer;
	JLabel content;

	// 텍스트 필드
	JTextField titleField;
	JTextField writerField;
	JTextField contentField;

	// 버튼
	JButton insertBtn;
	JButton deleteBtn;

	// 테이블
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel tableModel;

	public TableController() {
		setBounds(0, 0, 1000, 1000);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();

		setVisible(true);

	}

	void init() {
		// 제목 패널 생성
		titlePan.setBounds(0, 0, 1000, 50);
		title = new JLabel("글 제목 : ");
		titleField = new JTextField(20);
		titlePan.add(title);
		titlePan.add(titleField);

		// 작성자 패널 생성
		writerPan.setBounds(0, 50, 1000, 50);
		writer = new JLabel("작성자 : ");
		writerField = new JTextField(20);
		writerPan.add(writer);
		writerPan.add(writerField);

		// 내용 패널 생성
		contentPan.setBounds(0, 100, 1000, 50);
		content = new JLabel("글 내용 : ");
		contentField = new JTextField(20);
		contentPan.add(content);
		contentPan.add(contentField);

		// 버튼 패널 생성
		btnPan.setBounds(0, 150, 1000, 50);
		insertBtn = new JButton("글 추가");
		deleteBtn = new JButton("글 삭제");
		btnPan.add(insertBtn);
		btnPan.add(deleteBtn);

		// 테이블 생성
		tablePan.setBounds(0, 200, 1000, 1000);
		String[] header = { "글 제목", "작성자", "내용" };
		// 컬럼이름 추가(열 이름)
		tableModel = new DefaultTableModel(header, 0);
		// 테이블생성
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table);
		tablePan.add(scrollPane);

		// 윈도우에 추가
		add(titlePan);
		add(writerPan);
		add(contentPan);
		add(btnPan);
		add(tablePan);

		insertBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText();
				String writer = writerField.getText();
				String content = contentField.getText();
				Board board = new Board(title, writer, content);

				if (title.isEmpty() || writer.isEmpty() || content.isEmpty()) {
					JOptionPane.showMessageDialog(null, "빈 칸이 있어요!", "에러", JOptionPane.ERROR_MESSAGE);
				} else {
					boolean check = service.insert(board);
					if (check == true) {
						JOptionPane.showMessageDialog(null, "추가 성공", "성공", JOptionPane.DEFAULT_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "추가 실패", "실패", JOptionPane.ERROR_MESSAGE);
					}

					// 현재 board를 테이블에 추가!

					service.select(tableModel);

					// 기존 input 창들을 비우기
					titleField.setText(" ");
					writerField.setText(" ");
					contentField.setText(" ");

				}

			}
		});

		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

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
					// 현재 클릭된 행의 정보를 매개변수로 넘겨서 데이터를 먼저 가져온다
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
}
