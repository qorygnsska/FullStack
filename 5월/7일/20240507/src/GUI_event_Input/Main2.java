package GUI_event_Input;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyFrame6 extends JFrame {

	public MyFrame6() {
		setBounds(0, 0, 300, 300);

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {

		// 키를 눌렀을 때
		// KeyListener 인터페이스를 이용해서 객체를 생헝하여 이벤트를 실행

		// 윈도우 색상에 관련된 클래스
		// Color 클래스
		JPanel p = new JPanel();
		p.setBackground(Color.cyan);

		// 문자를 저장하는 변수 선언
		StringBuilder sb = new StringBuilder();

		// 키 이벤트는 윈도우창에 이벤트를 설정한다
		// 그때는 앞에 아무것도 작성 안 한다.
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// System.out.println("타이핑");

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// System.out.println("뗼 때");

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("누를 때");
				// 특수 키들은 문자로 표현을 못한다.
				// char 아스키코드표 안에 있는 내용만 표시!
				// System.out.println(e.getKeyChar()); // 누른 값 가져오기
				System.out.println(e.getKeyCode()); // 입력된 키가 숫자로 온다.
				int getKey = e.getKeyCode();

				// 엔터를 눌렀을 때 현재 입력한 문자까지만 팝업에 출력
				if (getKey == 10) {
					JOptionPane.showMessageDialog(null, sb);
					
					// 기존에 문자를 지우는 내용을 작성
					sb.setLength(0); // 길이를 0으로 초기화시켜서 내용을 지움
				}
				// 입력된 문자를 sb에 저장
				sb.append((char)getKey);
			}
		});
		add(p);
	}
}

public class Main2 {

	public static void main(String[] args) {
		new MyFrame6();

	}

}
