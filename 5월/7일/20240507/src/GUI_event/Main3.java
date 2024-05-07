package GUI_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame3 extends JFrame implements ActionListener{

	JButton btn = new JButton("버튼을 누르세요!");

	MyFrame3() {
		setBounds(0, 0, 300, 300);

		init(); // 컴포넌트(버튼, 체크박스)

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {
		// GUI는 순서에 민감하기 때문에 컴포넌트들을 생성하고 윈도우창에 추가하기 전에 모든 설정을 하는것이 좋다!

		// 버튼에 이벤트가 발생하면 실행하는 메서드
		btn.addActionListener(this);

		// 객체 생성 후 무조건 윈도우 창에 추가하기
		add(btn);
	}
	
	// myframe3 멤버로 메서드를 구현할 수 있다.
	// 이벤트가 발생했을 때 이벤트 객체를 만들어야되는데
	// 나 자신안에 메서드를 구현했다
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btn.getText().equals("눌렀니?")) {
			btn.setText("버튼 눌렀음");
		} else {
			btn.setText("눌렀니?");
		}
		
	}
}

public class Main3 {

	public static void main(String[] args) {
		new MyFrame3();
	}

}
