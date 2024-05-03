package GUI_layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame4 extends JFrame {

	MyFrame4() {
		setSize(500, 500);
		
		// 16개의 각각의 변수를 만들어도 상관 없지만
		// 중복도 많고 불편하니 배열로 선언
		JButton[] btnList = new JButton[16];
		

		// 화면 배치 설정
		// GridLayout(rows, cols)
		// - 격자 모양의 배치를 한다
		// - 바둑판!
		// - 행과 열로 화면이 구성됨
		// - 똑같은 크기로 자동으로 칸에 데이터가 들어간다
		// - 무조건 행을 기준으로 설정
		setLayout(new GridLayout(4, 4));
		for(int i = 0; i < btnList.length; i++) {
			btnList[i] = new JButton("버튼 " + (i+1));
			add(btnList[i]);
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class GridLayoutMain {

	public static void main(String[] args) {
		new MyFrame4();

	}

}
