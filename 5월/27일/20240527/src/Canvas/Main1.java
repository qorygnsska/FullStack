package Canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

class MyCanvas extends Canvas { // 그림 그리기

	public MyCanvas() {

		setBackground(Color.white);

	}

	// 그래픽에서는 그림을 다시 그리는 메서드를
	// 오버라이딩 해서 그려준다.
	// paint() 실질적인 그림을 그려주는 메서드!
	
	
	@Override
	public void paint(Graphics g) {
		// 도형의 색상, 텍스트의 색상을 지정할 수있다.
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.red);
		
		// 문자를 적는 메서드 
		Font font = new Font("굴림체"
						,Font.BOLD,20);
		g2.setFont(font);
		
		g2.drawString("Canvas에 텍스트 넣기"
				   , 50, 50);
		g2.drawString("너만 그리니 ? 나도 그린다!"
				   , 50, 100);
		
		// 선 그리기 
		// drawLine(x1, y1, x2, y2)
		// x1 시작점X  y1 시작점y
		// x2 끝 점 x  y2 끝 점 y
		
		g2.setColor(Color.blue);
		g2.drawLine(50, 150, 300, 150);
		
		// 원 그리기  빈 원 그리기
		// g2.drawOval(50, 180,100, 100);
		
		// 안에 색상을 채운 그리기 
		g2.fillOval(50, 180,100, 100);
		
		
	}
}

class MyFrame extends JFrame { // 윈도우 판

	public MyFrame() {

		setBounds(0, 0,500,500);

		add(new MyCanvas());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

	}
}

public class Main1 {

	public static void main(String[] args) {
		new MyFrame();

		// Canvas 클래스
		// - 그래픽 적인 화면을 그리는 요소 객체
		// - 스케치북에 그림을 그리는 것!
		// - panel 버튼, 라벨 , 스크롤 ,등등
		// 사용가능 하지만 canvas는 안됨

		// 그래픽 주체: 그림을 그리도록 프로그래밍하는
		// 개발자, 혹은 jvm

		// 그래픽 도구 :스케치북, 연필, 펜,붓, 팔레트
		// Graphics클래스가 그리기,칠하기,
		// 이미지 출력하기 등 모든 필드와 메서드를 제공

		/*
		 * 
		 * setColor: 색상을 지정하는 함수 drawString: 문자를 적는 메소드 drawLine: 라인을 긋는 메소드 drawOval: 원
		 * 그리는 메소드 fillOval: 채우기가 되어 있는 원 그리는 메소드 drawRect: 사각형 그리는 메소드 fillRect: 채우기가
		 * 되어 있는 사각형 그리는 메소드 drawImage: 이미지를 그리는 메소드
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}
}
