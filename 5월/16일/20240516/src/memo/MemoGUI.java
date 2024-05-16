package memo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemoGUI extends JFrame {
	Connection con;
	PreparedStatement ps;

	private JTable table;
	private DefaultTableModel model;
	private ArrayList<MemoVO> list;
	private JButton btn, btnWrite;
	private ArrayList<MemoVO> selectList = new ArrayList<MemoVO>();

	public MemoGUI() {
		setBounds(0, 0, 700, 500);

		// 기존에 있는 데이터를 가져오기
		list = Dao.select();

		model = new DefaultTableModel();

		model.addColumn("idx");
		model.addColumn("name");
		model.addColumn("password");
		model.addColumn("momo");
		model.addColumn("writeDate");

		// MemoVO 클래스를 한 행씩 추가하기
		for (MemoVO temp : list) {
			// 한 행씩 추가하기
			model.addRow(new Object[] { temp.getIdx(), temp.getName(), temp.getPassword(), temp.getMemo(),
					temp.getWriteDate() });
		}

		// 테이블 생성 및 모델 설정
		table = new JTable(model);

		// 스크롤 가능한 테이블 패널을 생성
		JScrollPane s = new JScrollPane(table);

		add(s);

		btn = new JButton("추가");

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 테이블에서 선택한 행 가져오기
				int selectRow = table.getSelectedRow();
				System.out.println("선택한 행 : " + selectRow);

				// 선택한 행이 있는 지 확인
				if (selectRow != -1) {
					// 선택된 행에서 MemoVO 객체 가져와서
					// 선택 된 리스트에 추가하기
					selectList.add(list.get(selectRow));

					// 새로운 JFrame 생성 (새로운 창)
					JFrame newFrame = new JFrame("New Table");

					// 새로운 테이블을 생성 해야하니 데이터를 저장하는 표형식!
					DefaultTableModel newModel = new DefaultTableModel();

					newModel.addColumn("idx");
					newModel.addColumn("name");
					newModel.addColumn("password");
					newModel.addColumn("momo");
					newModel.addColumn("writeDate");

					// 선택된 행이 여러개일 경우에는
					// 반복하면서 출력하기

					for (MemoVO selectMemo : selectList) {
						newModel.addRow(new Object[] { selectMemo.getIdx(), selectMemo.getName(),
								selectMemo.getPassword(), selectMemo.getMemo(), selectMemo.getWriteDate() });
					}

					// 새로운 테이블 생성 및 설정
					JTable newTable = new JTable(newModel);
					JScrollPane newSc = new JScrollPane(newTable);

					newFrame.add(newSc);

					// 새로운 JFrame의 크기 설정하고 화면에 표시
					newFrame.setSize(700, 200);
					newFrame.setVisible(true);
				}

			}
		});

		/*
		 * 버튼을 하나 더 추가해서 글쓰기 새로운 창을 열어서 글제목,내용,비밀번호 입력 받아서 그 안에 글 쓰기 버튼 을 다시 누르면 데이터베이스도
		 * 추가되고 기존 게시글에도 맨 마지막에 추가되는 코드를 작성 하시오!
		 * 
		 */
		btnWrite = new JButton("글쓰기");
		btnWrite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 새로운 창
				JFrame writeFrame = new JFrame("글쓰기 창");
				JPanel panel = new JPanel();
				
				JLabel titleLabel = new JLabel("글 제목");
				JTextField titleField = new JTextField(20);

				JLabel contentLabel = new JLabel("내용");
				JTextArea contentArea = new JTextArea(10, 20);
				JScrollPane contentScroller = new JScrollPane(contentArea);

				JLabel passwordLabel = new JLabel("비밀번호");
				JPasswordField passwordField = new JPasswordField(20);

				JButton submitButton = new JButton("가입하기");
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// 텍스트 필드에 있는 모든 내용을 가져오기
						String title = titleField.getText();
						String content = contentArea.getText();
						String password = new String(passwordField.getPassword());
						
						// 데이터베이스에 추가
						Dao.insert(title, password, content);
						
						// 추가 후 새로고침
						refreshTable();
						
					}

				});
				
				// 패널에 컴포넌트 추가
				panel.add(titleLabel);
				panel.add(titleField);
				panel.add(contentLabel);
				panel.add(contentScroller);
				panel.add(passwordLabel);
				panel.add(passwordField);
				panel.add(submitButton);
				
				// 글쓰기 새창에 추가하기
				writeFrame.add(panel);
				writeFrame.setSize(300, 300);
				writeFrame.setVisible(true);
			}
		});
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 테이블에서 선택한 행 가져오기
				int selectRow = table.getSelectedRow();
				System.out.println("선택한 행 : " + selectRow);
				
				if (selectRow != -1) {
					con = DBUtil.getConnection();
					try {
						String sql = "delete from board where idx = ?";
						ps = con.prepareStatement(sql);
						ps.setInt(1, selectRow + 1);
						int result = ps.executeUpdate();
						
						if(result > 0) {
							refreshTable();
							System.out.println("삭제가 완료되었습니다!");
						}else {
							System.out.println("삭제 불가능!!");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				
			}
		});

		// 버튼을 아래쪽에 추가한다.
		JPanel btnPanel = new JPanel();
		btnPanel.add(btn);
		btnPanel.add(btnWrite);
		btnPanel.add(deleteBtn);
		
		add("South", btnPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void refreshTable() {
		// 데이터를 새로고침하고 테이블 모델에 새로운 데이터를 설정
		list = Dao.select();
		
		// 모든 행이 삭제된다
		model.setRowCount(0);
		
		for(MemoVO temp : list) {
			// 한 행씩 추가
			model.addRow(new Object[] {temp.getIdx(), temp.getName(), temp.getPassword(), temp.getMemo(), temp.getWriteDate()});
		}
		
	}
	
	public static void main(String[] args) {
		new MemoGUI();

	}

}
