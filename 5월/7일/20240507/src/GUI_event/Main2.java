package GUI_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 내부클래스 이벤트 처리하기
// 클래스안에 클래스를 집어 넣는 것!
// myframe2 클래스 안에 멤버로 속해있기 때문에 전역변수로 선언된 btn 컴포넌트를 형변환 할 필요 없이 사용 가능

class MyFrame2 extends JFrame {

	JButton btn = new JButton("버튼을 누르세요!");
	
	// 내부 클래스는 private 설정이 가능하다.
	private class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//JButton btn = (JButton) e.getSource();

			// 변경
			if (btn.getText().equals("눌렀니?")) {
				btn.setText("버튼 눌렀음");
			} else {
				btn.setText("눌렀니?");
			}
		}

	}

	MyFrame2() {
		setBounds(0, 0, 300, 300);

		init(); // 컴포넌트(버튼, 체크박스)

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {
		// GUI는 순서에 민감하기 때문에 컴포넌트들을 생성하고 윈도우창에 추가하기 전에 모든 설정을 하는것이 좋다!

		// 버튼에 이벤트가 발생하면 실행하는 메서드
		btn.addActionListener(new MyListener());

		// 객체 생성 후 무조건 윈도우 창에 추가하기
		add(btn);
	}
}

public class Main2 {

	public static void main(String[] args) {
		new MyFrame2();

	}

}
