package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	// JFrame
	// - 기본 창은 레이아웃이 보더레이아웃
	// 동서남북가운데 기본적으로 가운데 하나의 컴포넌트만
	// 올라간다.

	// JPanel
	// - 공간을 나눠서 쓰고싶을 때 사용하는 클래스
	// - 레이아웃은 플로우레이아웃
	// 한줄에 쭈욱! 나열하는 레이아웃!

	// 레이아웃을 관리자가 직접 설정
	// setLayout(null)

	// 패널을 저장할 인스턴스 변수선언
	private JPanel displayPanel; // 메인 패널
	private JPanel filePanel; // 파일 패널
	private JPanel editPanel; // 수정 패널
	private JPanel deletePanel; // 삭제 패널

	// 기본창 설정
	public Main() {
		setTitle("윈도우"); // 제목 설정
		setSize(600, 400); // 기본창의 너비,높이

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 기본창 닫기
		setLocationRelativeTo(null);// 기본창을 화면 중앙에 배치

		// 메뉴 생성
		JMenuBar menuBar = new JMenuBar();

		// 각각의 메뉴들을 생성
		// 파일 메뉴를 생성
		JMenu fileMenu = new JMenu("파일");
		JMenuItem fileMenuItem = new JMenuItem("파일");

		// 익명클래스를 이용해서 바로 이벤트를 설정해도
		// 괜찮다!
		fileMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 패널들을 전환하는 메서드
				swtichPanel(filePanel);
			}
		});

		// 수정 메뉴
		// 클릭되면 발생하는 이벤트!
		// 수정 메뉴 생성
		JMenu editMenu = new JMenu("수정");
		JMenuItem editMenuItem = new JMenuItem("수정");
		editMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				swtichPanel(editPanel);
			}
		});
		editMenu.add(editMenuItem);

		// 삭제 메뉴
		// 클릭 되면 발생하는 이벤트!
		JMenu deleteMenu = new JMenu("삭제");
		JMenuItem deleteMenuItem = new JMenuItem("삭제");
		deleteMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				swtichPanel(deletePanel);
			}
		});
		deleteMenu.add(deleteMenuItem);

		// 파일 메뉴에 파일메뉴아이템을 추가하기
		fileMenu.add(fileMenuItem);

		// 메뉴바에 파일 메뉴를 추가하기
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(deleteMenu);

		// 메뉴바는 프레임에 추가하기
		setJMenuBar(menuBar);

		// 표시할 패널 생성 (메인패널 생성)
		displayPanel = new JPanel();
		// 가운데를 기준으로 패널들이 올라올 수있도록
		// 보더 레이아웃으로 변경
		displayPanel.setLayout(new BorderLayout());

		// 각 패널 생성
		createPanels();

		// 만약에 처음에 보여지는 main페이지가
		// 있다면 displayPanel 곳에 추가하기

		// 프레임에 메인패널을 추가
		add(displayPanel);

	}

	public static void main(String[] args) {

		// 객체를 생성
		Main win = new Main();
		win.setVisible(true);// 화면 보이기

	}

	// 각각의 패널을 생성하는 메서드
	private void createPanels() {

		// 파일 패널 생성
		filePanel = new JPanel(new BorderLayout());
		filePanel.setBackground(Color.white);
		JLabel fileLabel = new JLabel("파일창", SwingConstants.CENTER);
		fileLabel.setForeground(Color.red);
		filePanel.add(fileLabel);

		// 수정 패널
		editPanel = new JPanel(new BorderLayout());
		editPanel.setBackground(Color.magenta);
		JLabel editLabel = new JLabel("수정창", SwingConstants.CENTER);
		editPanel.setForeground(Color.white);
		editPanel.add(editLabel);

		// 삭제 패널
		deletePanel = new JPanel(new BorderLayout());
		deletePanel.setBackground(Color.green);
		JLabel deleteLabel = new JLabel("삭제창", SwingConstants.CENTER);
		deletePanel.setForeground(Color.white);
		deletePanel.add(deleteLabel);
	}

	// 패널을 매개변수로 입력 받아서
	// 메인패널에 추가하는 메서드
	private void swtichPanel(JPanel panel) {

		// 현재 패널에 표시된 모든 내용을 지운다.
		displayPanel.removeAll();
		// 새로운 패널을 추가
		// displayPanel.add(panel);
		// displayPanel.add("Center",panel);

		displayPanel.add(panel, BorderLayout.CENTER);

		// 레이아웃을 재배치
		displayPanel.revalidate();
		// 패널 다시 그리기!
		displayPanel.repaint();

	}

}