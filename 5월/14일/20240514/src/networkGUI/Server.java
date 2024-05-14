package networkGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
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

	// 서버를 생성
	ServerSocket serverSocket;

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
			// 어떤 클라이언트든 접속을 허용한다.
			// 접속 포트를 생성한다.
			server.serverSocket = new ServerSocket(10002);
			server.message = "어떤 클라이언트가 들어올까?! 1002번 포트로 서버시작\n";

			server.textArea.setText(server.message);

			// 클라이언트가 접속하기 전에는 텍스트 필드와 전송버튼을 비활성화 시킨다
			server.textField.setEnabled(false);
			server.btn.setEnabled(false);

			// 클라이언트 접속하기를 기다린다
			server.socket = server.serverSocket.accept();
			server.message = server.message + server.socket + "접속 성공 \n";
			server.textArea.setText(server.message);

			// 클라이언트가 접속했으므로 텍스트 필드와 전송 버튼을 활성화(true)로 변경하고
			// 메시지를 입력할 수 있도록 텍스트 필드로 포커스를 옮겨준다.
			server.textField.setEnabled(true);
			server.btn.setEnabled(true);
			server.textField.requestFocus();

			// 클라이언트와 메시지를 주고 받기 위해서 송수신 객체 생성
			server.printWriter = new PrintWriter(server.socket.getOutputStream());
			server.scanner = new Scanner(server.socket.getInputStream());

			// 클라이언트에서 전송되는 메시지를 받는 스레드
			Thread th = new Thread(server);
			th.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 텍스트 필드에 입력된 메시지를 받는다.
		String msg = textField.getText().trim();

		if (msg.length() > 0) {
			message = message + "\nserver >> " + msg;

			textArea.setText(message);

			// 클라이언트로 전송
			if (printWriter != null) {
				printWriter.write(msg + "\n");
				printWriter.flush();
			}
		}

		// 다음 메시지를 입력 받기 위해서 텍스트필드에 입력된 메시지를 지우고 다시 입력할 수 있도록 포커스를 텍스트 필드로 이동
		textField.setText("");
		textField.requestFocus();

	}

	@Override
	public void run() {
		// 서버가 동작해야되는 일을 작성
		// 클라이언트가 통신을 유지하고 있는 동안 반복
		while (socket != null) {
			// 클라이언트 메시지를 보낸걸 읽기!
			String msg = "";
			msg = scanner.nextLine().trim();

			// 서버 창에 표시
			if (msg.length() > 0) {
				message = message + "\nclient >> " + msg;
				textArea.setText(message);

				if (msg.toLowerCase().equals("bye")) {
					break; // 통신 종료
				}
			}
			// 위에 있는 내용을 확인하기 위해서 프로그램을 약간 지연시킨다.
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

		}
		// 클라이언트와 통신이 종료되면 메시지를 입력할 수 없도록 비활성화 시킨다.
		textField.setEnabled(false);
		btn.setEnabled(false);

		// 소켓 닫기
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
