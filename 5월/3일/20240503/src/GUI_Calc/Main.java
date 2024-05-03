package GUI_Calc;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrameCalc extends JFrame{
	
	public MyFrameCalc() {
	
		// 기본적으로 보더레이아웃을 실행하고 
		// 있어서 무조건 가운데 정렬을 하는 것!
		// 기본적인 레이아웃을 없앤다! 
		// 사용자가 원하는 x,y를 저장 할 수 있다.
		
		setTitle("계산기 화면");
		setSize(300,250);
		setLayout(null);
		
		// 타이틀 작성하는 영역 나눈다.계산기
		JPanel titlePan = new JPanel();
		
		// 영역의 크기를 설정하는 것
		// setBounds(x, y, 너비, 높이)
		// 한번에 여러개를 설정할 수 있다. 
		titlePan.setBounds(0, 0, 300, 40);
		JLabel title = new JLabel("계산기");
		
		// 글씨체랑 글씨 크기를 조절하는 Font클래스
		// Font(글씨체,스타일,사이즈)
		Font font = new Font("궁서체"
							,Font.BOLD,25);
		
		title.setFont(font);
		//타이틀 영역에 라벨을 추가하기 
		titlePan.add(title);
		add(titlePan);
		
		// input창 두개를 한 줄에 표현 
		// JPanel 클래스는 기본적으로 배치가 
		// FlowLayout되어있다. 
		
		// 한 줄에 여러개를 표현한다 
		JPanel numPanel = new JPanel();
		
		numPanel.setBounds(0, 40,300,40);
		
		JTextField num1 = new JTextField(5);
		JTextField num2 = new JTextField(5);
		
		numPanel.add(num1);
		numPanel.add(num2);
			
		// 숫자 버튼들을 설정 
		JPanel btnPan = new JPanel();
		btnPan.setBounds(100, 80, 100, 40);
		
		// GridLayout(행,열,좌우여백,상하여백)
		btnPan.setLayout(
					new GridLayout(2,2,5,10));
			
		
		JButton btn1 = new JButton("+");
		JButton btn2 = new JButton("-");
		JButton btn3 = new JButton("*");
		JButton btn4 = new JButton("/");
		
		btnPan.add(btn1); btnPan.add(btn2);
		btnPan.add(btn3); btnPan.add(btn4);
		
		JPanel resultPan = new JPanel();
		resultPan.setBounds(0, 120, 300, 40);
		
		JLabel result  =new JLabel("계산결과:");
		resultPan.add(result);
				
		// 윈도우에 추가 
		add(numPanel);
		add(btnPan);
		add(resultPan);
		//엑시표시를 누르면 닫기
		setDefaultCloseOperation
				(JFrame.EXIT_ON_CLOSE);
		
		// 윈도우 보이기 
		setVisible(true);
	
	}	
}
public class Main {

	public static void main(String[] args) {
	
		new MyFrameCalc();
		
	}
}