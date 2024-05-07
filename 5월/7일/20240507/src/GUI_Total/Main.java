package GUI_Total;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ColorChart extends JFrame implements MouseWheelListener{

	// totalPan
	JPanel totalPan = new JPanel();

	// colorPan r,g,b 저장
	JPanel colorPan = new JPanel();

	JPanel redPan = new JPanel();
	JPanel bluePan = new JPanel();
	JPanel greenPan = new JPanel();

	// 색상을 저장하는 변수
	// 0~255사이의 색상 표현의 범위!
	int red = 128;
	int blue = 128;
	int green = 128;

	ColorChart() {
		setBounds(500, 500, 600, 800);

		// 윈도우 배치를 똑같은 크기로 설정
		setLayout(new GridLayout(2, 1));

		// 실제 각각의 판에 배경색 저장
		redPan.setBackground(Color.red);
		bluePan.setBackground(Color.blue);
		greenPan.setBackground(Color.green);

		// colorPan판에 추가를 해야된다.
		// 기본 배치가 한줄에 배치하는 Flowlayout
		// 으로 되어있기 때문에 gridlayout으로 변경하기
		colorPan.setLayout(new GridLayout(1, 3));

		colorPan.add(redPan);
		colorPan.add(bluePan);
		colorPan.add(greenPan);

		// 이벤트 추가
		redPan.addMouseWheelListener(this);
		bluePan.addMouseWheelListener(this);
		greenPan.addMouseWheelListener(this);

		// 윈도우 추가
		add(totalPan);
		add(colorPan);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// 어떤 패널에서 휠이 굴렀는지 판단한다.
		// getSource() : 이벤트가 발생된 객체의 컴포넌트 정보를 얻어온다.
		// 어떤 컴포넌트가 올 지 모르기 때문에 가장 최상위 부모 클래스인 Object 타입으로 받는다.
		// 발생한 패널의 객체를 가지고 있다.
		// 발생한 패널의 주소값을 temp가 저장하고 있다.
		Object obj = e.getSource();
		JPanel temp = (JPanel)obj;
		
		if(temp == redPan) {
			if(e.getWheelRotation() < 0) {
				red = --red < 0 ? 0 : red;
			}else {
				red = ++red > 255 ? 255 : red;
			}
		}else if(temp == bluePan) {
			if(e.getWheelRotation() < 0) {
				blue = --blue < 0 ? 0 : blue;
			}else {
				blue = ++blue > 255 ? 255 : blue;
			}
		}else if(temp == greenPan) {
			if(e.getWheelRotation() < 0) {
				green = --green < 0 ? 0 : green;
			}else {
				green = ++green > 255 ? 255 : green;
			}
		}
		
		totalPan.setBackground(new Color(red, green, blue));
		
	}

}

public class Main {

	public static void main(String[] args) {
		new ColorChart();
	}
}