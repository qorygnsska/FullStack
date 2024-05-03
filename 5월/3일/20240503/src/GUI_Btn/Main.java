package GUI_Btn;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame5 extends JFrame{
	MyFrame5(){
		
		setSize(400, 400);
		
		// 버튼의 글씨를 없애고 아이콘으로 대체
		// ImageIcon 클래스를 이용해서 객체를 생성
		JButton btn1 = new JButton("고양이", new ImageIcon("cat.png"));
		JButton btn2 = new JButton();
		JButton btn3 = new JButton();
		
		setLayout(new FlowLayout());
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
public class Main {

	public static void main(String[] args) {
		// 윈도우 창은 400, 400 설정
		// 버튼은 3개 생성
		// 화면의 배치는 한줄로 배치하는 윈도우창
		new MyFrame5();
	}

}
