package networkGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener, Runnable {

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

	public Client() {
		setTitle("1:1 채팅 프로그램 - 클라이언트");
		setBounds(1000, 50, 500, 700);

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void init() {
		textArea = new JTextArea();
		textArea.setBackground(Color.cyan);

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
		Client client = new Client();

		try {
			Thread th = new Thread(client);
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
		// 클라이언트가 실행해야되는 문장
		// 서버에서 언제 메시지를 보내올 지 모르기 때문에
		// 통신이 종료될 때까지 반복하며 서버에서 전송되는 메시지를 스레드로 받는다.

		// 서버와 통신유지되고 있는 동안 반복한다.
		// 스캐너를 이용해서 메시지를 읽는다.
		// InputStream 동작!

		// 서버에서 전송된 메시지를 클라이언트 채팅창에 표시한다.
		while (socket != null) {
			String msg = "";
			
			textArea.setText("");
			
			// 서버에서 bye라는 문자가 오면 반복문 종료 후 채팅창 종료
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 서버와 통신이 종료되면 메시지를 입력할 수 없도록
		// 텍스트 필드와 전송 버튼을 비활성화 시킨다.
		textField.setEnabled(false);
		btn.setEnabled(false);
		
		// 통신에 사용한 모든 객체를 닫는다.
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
