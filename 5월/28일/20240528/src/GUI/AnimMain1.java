package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//사각형 정보를 저장하는 클래스 
class Rect {

	int x;
	int y;
	int w;
	int h;

	// 색상
	Color color = null;

	// 이동 여부 저장
	boolean is_move = false;

	public Rect() {
	}

	public Rect(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		// 기본 검정색으로 설정함
		color = Color.black;

	}

	// 각각의 사각형들은 클릭 되었는지 확인
	// 메서드
	// 사각형 안에서 클릭이 됬는지 밖에서 클릭됬는지
	// 확인
	boolean getClicked(int rx, int ry) {

		if (rx > x && rx < x + w && ry > y && ry < y + h) {
			return true;
		}
		return false;
	}

	// 사각형들이 위에 메서드에서 클릭이 되었다면
	// 움직인다. 움직이는 모습을 업데이트 !
	void update() {

		if (is_move) {

			y += 1; // 이동 중이면 y값을 증가해서
					// 아래로 이동시킨다.
		}
		// 한없이 증가를 하면 한없이 아래로 내려가서
		// 윈도우창 밖으로 나간다.

		if (y > 300) {
			y = 50; // 위에서 50만큼 떨어진 위치로 이동
			is_move = false;
		}
	}
}

//실제 사각형을 객체를 생성하고 움직이는 클래스
class GameBoard {
	// 사각형을 저장하는 배열
	Rect[] rc = new Rect[5];

	int x = 0, y = 0;

	// 사각형 배치하는 생성자
	public GameBoard() {
		// 사각형 5개를 초기화
		for (int i = 0; i < 5; i++) {
			rc[i] = new Rect(); // 사각형 객체 생성
			rc[i].x = 100 + i * 50;
			rc[i].y = 50;
			rc[i].w = 50;
			rc[i].h = 50;
		}
	}

	// 모든 사각형 그리기
	// Graphics 도구를 가지고온다.
	void render(Graphics g) {

		// drawRect(x,y,w,h)
		// 사각형그리는 메서드
		for (int i = 0; i < 5; i++) {
			g.drawRect(rc[i].x, rc[i].y, rc[i].w, rc[i].h);
		}
	}

	// 마우스가 클릭했을 처리
	public void mousePressed(MouseEvent e) {

		// 마우스 클릭 위치를 가져오기
		int rx = e.getX();
		int ry = e.getY();

		// 사각형 5개를 마우스가 눌렸는지 확인하는
		// 명령문 써야된다.

		for (int i = 0; i < 5; i++) {
			if (rc[i].is_move == false && rc[i].getClicked(rx, ry)) {
				// 사각형 이동 상태로 변경
				rc[i].is_move = true;
			}
		}
	}

	// 모든 사각형이 이동할 수있도록 업데이터메서드를
	// 호출한다.
	void update() {

		for (int i = 0; i < 5; i++) {
			rc[i].update();
		}
	}
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

	// 게임보드 인스턴스를 생성
	GameBoard gameBoard = new GameBoard();
	
	// 패널을 초기화
	public MyPanel() {

		setLayout(null);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g); // 패널 지우기
		
		// 0.01초 후에 다시 그리기
		try {Thread.sleep(10);
			repaint();} 
		catch (InterruptedException e) {}
		
		gameBoard.update(); // 업데이트 호출
		gameBoard.render(g); // 그리기 호출
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		gameBoard.mousePressed(e);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}


}

public class AnimMain1 {

	public static void main(String[] args) {

		// 프레임 생성
		JFrame frame = new JFrame();
		frame.setTitle("Test1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(600, 400);
		frame.setLocation(100, 0);
		// 우리가 만든 패널을 추가하기
		frame.setContentPane(new MyPanel());
		frame.setVisible(true);

	}
}