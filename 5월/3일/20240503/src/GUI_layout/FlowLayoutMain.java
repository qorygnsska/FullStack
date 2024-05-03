package GUI_layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame2 extends JFrame{
	MyFrame2(){
		setSize(500, 500);
		
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		
		// 화면 배치 설정
		// FlowLayout
		// 왼쪽에서 오른쪽으로 한 줄에 차례대로 하면을 배치
		setLayout(new FlowLayout());
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class FlowLayoutMain {

	public static void main(String[] args) {
		new MyFrame2();

	}

}
