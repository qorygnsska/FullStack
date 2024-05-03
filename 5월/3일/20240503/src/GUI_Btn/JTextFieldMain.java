package GUI_Btn;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame6 extends JFrame {
	MyFrame6() {
		setSize(500, 500);
		
		// 화면 배치
		setLayout(new FlowLayout());
		
		// 검색창이나 입력창을 만들 때 사용하는 한 줄 텍스트 입력
		// 기본 생성 시 아예 칸이 없어서 입력 불가
		//JTextField input1 = new JTextField();
		
		// 입력창의 칸을 설정할 수 있다.
		// 괄호안에 숫자를 넣으면 숫자 만큼 공간이 생긴다.
		//JTextField input1 = new JTextField(10);
		JTextField input1 = new JTextField("고양이", 10);
		
		// 체크박스
		// 체크박스만 생성
		JCheckBox ch1 = new JCheckBox();
		// 문자를 넣으면 체크박스 옆에 문자 생성
		JCheckBox ch2 = new JCheckBox("고양이");
		// true를 입력하면 체크박스가 선택된채로 생성
		JCheckBox ch3 = new JCheckBox("강아지", true);
		
		// 체크박스는 여러개를 선택해서 결과를 생성할 수 있다.
		// 라디오버튼
		// 각각의 버튼이 생성되기 때문에 그룹을 지어줘야 같이 동작한다.
		JRadioButton jr1 = new JRadioButton();
		JRadioButton jr2 = new JRadioButton("고양이");
		JRadioButton jr3 = new JRadioButton("강아지", true);
		
		// 콤보박스
		JComboBox obj1 = new JComboBox();
		String[] name = {"고양이", "강아지", "돼지"};
		JComboBox obj2 = new JComboBox(name);
		
		// 여러줄을 작성하는 텍스트 표시
		JTextArea jt1 = new JTextArea();
		// (행, 열)
		JTextArea jt2 = new JTextArea(5, 30);
		
		// JLabel
		// 텍스트를 배치하기 위한 구성요소
		// 읽기 전용 텍스트의 한줄을 표시하는데 사용함
		JLabel j1 = new JLabel("고양이");
		JLabel j2 = new JLabel(new ImageIcon("cat.png"));
		
		// JPasswordField
		// 클래스를 이용해서 비밀번호 입력에 특화된 텍스트 구성요소
		// 암호 기능을 처리하고 한 줄 텍스트를 편집할 수 있음
		JPasswordField pass1 = new JPasswordField(10);
		// 기본적으로 .으로 지정되어 있는데 변경 가능하다
		pass1.setEchoChar('ㅋ');
		
		// 윈도우에 추가
		add(pass1);
		
		add(j1);
		add(j2);
		
		add(jt1);
		add(jt2);
		
		add(obj1);
		add(obj2);
		
		add(input1);
		
		add(ch1);
		add(ch2);
		add(ch3);
		
		add(jr1);
		add(jr2);
		add(jr3);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class JTextFieldMain {

	public static void main(String[] args) {
		new MyFrame6();

	}

}
