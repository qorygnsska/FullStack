package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyFrame extends JFrame{
	
	MyFrame(){
		setSize(500, 500);
		
		// 버튼 생성
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		
		// 윈도우 창에 버튼을 추가
		add(btn1);
		add(btn2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
public class Main {

	public static void main(String[] args) {
		
		new MyFrame();
		/*
		 * GUI(Graphical user Interface)
		 * - 그래픽을 이용하기 위함
		 * - 사용자에게 이해하기 쉬운 모양의 정보 제공
		 * 
		 * 자바 GUI
		 * - 패키지 두 개
		 *   AWT
		 *   - 자바가 처음 나온 시기에 함께 배포된 GUI
		 *   - 운영체제에 영향을 많이 받아서 빠르게 처리
		 *   - 속도는 빠르지만 부담되는 라이브러리
		 *   Swing(스윙)
		 *   - 순수 자바 언어로 만들어진 라이브러리
		 *   - 패키지 이름은 J 시작
		 *   
		 *   컴포넌트(Component)
		 *   - 화면에 출력하는 모든 데이터들(버튼, 키보드, 마우스, 스크롤 ...)
		 */
		
		// 1. GUI를 하기 위해서는 윈도우 창이 하나 필요하다
		// 프레임(스윙 프로그램의 기본 틀) 윈도우 창
		//JFrame frame = new JFrame();
//		JFrame frame = new JFrame("제목없는 윈도우");
//		// 창의 크기
//		frame.setSize(300, 300);
//		
//		// 엑스 표시를 누르면 자바도 같이 종료될 수 있도록 설정
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// 창을 보이기
//		frame.setVisible(true);

	}

}
