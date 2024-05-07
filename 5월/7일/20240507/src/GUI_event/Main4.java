package GUI_event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame4 extends JFrame{

	JButton btn = new JButton("버튼을 누르세요!");

	MyFrame4() {
		setBounds(0, 0, 300, 300);

		init(); // 컴포넌트(버튼, 체크박스)

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {
		// GUI는 순서에 민감하기 때문에 컴포넌트들을 생성하고 윈도우창에 추가하기 전에 모든 설정을 하는것이 좋다!

		// 버튼에 이벤트가 발생하면 실행하는 메서드
		btn.addActionListener(
				
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (btn.getText().equals("눌렀니?")) {
							btn.setText("버튼 눌렀음");
						} else {
							btn.setText("눌렀니?");
						}
						
					}
				}
				);

		// 객체 생성 후 무조건 윈도우 창에 추가하기
		add(btn);
	}
	
	
}

public class Main4 {

	public static void main(String[] args) {
		new MyFrame4();

	}

}
/*
 * 무명 클래스(익명 클래스)
 * - 클래스 몸체가 정의 되었지만 클래스 이름이 없는 클래스
 * - 클래스를 정의하는 동시에 객체를 생성하며 이름이 없기 때문에 한번만 사용할 수 있다.
 */
