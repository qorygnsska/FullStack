package GUI_OnlineBook;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	public MyFrame() {
		setBounds(0, 0, 600, 600);
		setLayout(new GridLayout(5, 1));

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void init() {
		
		JLabel lb1 = new JLabel(new ImageIcon("images/user.png"));
		JPanel p1 = new JPanel();
		JLabel lb2 = new JLabel("-- 고객 정보를 입력하세요 --");
		p1.add(lb2);
		
		JPanel p2 = new JPanel();
		JLabel lb3 = new JLabel("이  름 :");
		JTextField tf1 = new JTextField(10);
		p2.add(lb3);
		p2.add(tf1);
		p2.setLayout(new FlowLayout());
		
		
		JPanel p3 = new JPanel();
		JLabel lb4 = new JLabel("연락처 :");
		JTextField tf2 = new JTextField(10);
		p3.add(lb4);
		p3.add(tf2);
		p3.setLayout(new FlowLayout());
		
		JPanel p4 = new JPanel();
		JButton btn = new JButton("쇼핑하기", new ImageIcon("images/shop.png"));
		p4.add(btn);

		add(lb1);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
	}
}

public class Main {

	public static void main(String[] args) {
		new MyFrame();

	}

}
