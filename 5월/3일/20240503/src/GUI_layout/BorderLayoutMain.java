package GUI_layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame3 extends JFrame{
	
	MyFrame3(){
		setSize(500, 500);
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		JButton btn6 = new JButton("버튼6");
		
		// 공간을 분리 시키는 클래스
		JPanel pan = new JPanel();
		
		// 분리한 공간에 화면 배치를 다시 하면된다.
		pan.setLayout(new GridLayout(1, 2));
		
		// 분리한 공간에 버튼을 먼저 추가한다.
		pan.add(btn1);
		pan.add(btn6);
		
		// 화면 배치 설정
		// BorderLayout
		// 상, 하, 좌, 우, 가운데로 배치가능
		// 기본적으로 swing 프레임을 만들면 BorderLayout이 기본으로 설정
		// 기본 가운데로 컴포넌트들을 추가한다
		setLayout(new BorderLayout());
		
		add(pan);
		add(btn2, BorderLayout.NORTH); // 위
		add(btn3, BorderLayout.SOUTH); // 아래
		add(btn4, BorderLayout.EAST); // 오른쪽
		add(btn5, BorderLayout.WEST); // 왼쪽
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
public class BorderLayoutMain {

	public static void main(String[] args) {
		new MyFrame3();

	}

}
