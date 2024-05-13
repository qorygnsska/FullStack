package networkGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 자바는 다중 상속이 안된다
// run() 메서드 하나만 구현한 인터페이스가 바로  Runnable
public class Server extends JFrame implements ActionListener, Runnable {
	// 전체 대화를 출력하는 영역
	JTextArea textArea;

	// 대화내용을 입력하는 텍스트 필드와 전송 버튼을 올릴 패널
	JPanel panel;
	JTextField textField;
	JButton btn;

	// 데이터를 주고 받을 수 있는 소켓 통신을 사용
	Socket socket;
	PrintWriter printWriter;
	Scanner scanner;
	String message;

	public Server() {
		setTitle("1:1 채팅 프로그램 - 서버");
		setBounds(1000, 50, 500, 700);

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void init() {
		textArea = new JTextArea();
		textArea.setBackground(Color.lightGray);

		// 텍스트 영역을 편집 불가능
		textArea.setEditable(false);
		add(textArea);

		// 영역을 나누는 패널은 기본 배치가 flowLayout
		panel = new JPanel();
		// BorderLayout
		// - 5개의 영역에 한 영역당 하나의 컴포넌트만 지정할 수 있다.
		// - 하나의 컴포넌트 공간을 여러개로 쪼개서 사용하려고 패널을 생성
		panel.setLayout(new BorderLayout());

		// 패널의 영역을 조절(사이즈)
		textField = new JTextField();
		panel.add(textField);

		btn = new JButton("전송");
		panel.add(btn, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);

		// 텍스트필드와 전송버튼을 눌렀을 때 이벤트 실행
		textField.addActionListener(this);
		btn.addActionListener(this);

	}

	public static void main(String[] args) {
		Server server = new Server();

		try {
			// 클라이언트에서 전송되는 메시지를 받는 스레드
			Thread th = new Thread(server);
			th.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// 서버가 동작해야되는 일을 작성
		
	}

}
