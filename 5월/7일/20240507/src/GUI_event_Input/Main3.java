package GUI_event_Input;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame7 extends JFrame implements MouseListener, MouseWheelListener{
	// 클래스 멤버 변수로 설정
	JPanel p1;
	JPanel p2;
	int size = 15;
	
	// 글씨의 설정
	Font font = new Font("궁서체", Font.PLAIN, size);
	// 실제 글씨
	JLabel label = new JLabel("Hello");
	
	public MyFrame7() {
		setBounds(500, 400, 500, 500);
		setLayout(new GridLayout(2, 1));

		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void init() {
		// 컴포넌트
		p1 = new JPanel();
		p2 = new JPanel();
		p2.setBackground(Color.cyan);
		
		// 이벤트
		//p2.addMouseListener(this);
		
		// 마우스 휠을 이용해서 이벤트를 추가
		p2.addMouseWheelListener(this);
		
		// 라벨 추가
		p1.add(label);
		
		// 윈도우 추가
		add(p1);
		add(p2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		p1.setBackground(Color.BLUE);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		p1.setBackground(Color.RED);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		p1.setBackground(Color.GREEN);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		p1.setBackground(Color.YELLOW);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		p1.setBackground(Color.magenta);
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		//System.out.println(e.getWheelRotation());
		int wheel = e.getWheelRotation();
		if(wheel < 0) {
			// 휠을 앞으로 굴림
			size++;
			
		}else {
			// 휠을 뒤로 굴림
			size--;
		}
		font = new Font("궁서체", Font.PLAIN, size);
		// 라벨에 수정
		label.setFont(font);
		
	}
	
}
public class Main3 {

	public static void main(String[] args) {
		new MyFrame7();

	}

}
