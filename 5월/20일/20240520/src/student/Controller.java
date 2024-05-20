package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

// 로그인을 하면 로그인을 해결하는 controller
// 수강신청을 하면 수강신청 controller
public class Controller extends JFrame{
	// 로그인창 보이기
	// 로그인해서 팝업(실패)
	// 로그인이 되면 메인페이지 보이기!
	MemberService memberService = new MemberService();
	JPanel titlePan, hakPan, passPan, btnPan;
	JLabel titlelb;
	JTextField hakField, passField;
	JButton btn;
	Font ft = new Font("함초롱돋움", Font.BOLD, 30);
	Font ft2 = new Font("함초롱돋움", Font.BOLD, 15);
	
	public Controller() {
		setTitle("로그인");
		setLayout(new GridLayout(4, 1));
		setBounds(800, 300, 300, 350);
		
		init();
		
		
		
		setVisible(true);
	}
	
	public void init() {
		titlePan = new JPanel();
		titlePan.setBorder(new LineBorder(Color.black));
		titlelb = new JLabel("수강신청");
		titlelb.setFont(ft);
		titlelb.setHorizontalAlignment(JLabel.CENTER);
		titlePan.add(titlelb);
	
		hakPan = new JPanel();
		hakPan.setBorder(new LineBorder(Color.black));
		hakField = new JTextField(20);
		hakPan.add(hakField);
		
		passPan = new JPanel();
		passPan.setBorder(new LineBorder(Color.black));
		passField = new JPasswordField(20);
		passPan.add(passField);
		
		btnPan = new JPanel();
		btnPan.setBorder(new LineBorder(Color.black));
		btn = new JButton("로그인");
		btnPan.add(btn);
		
		
		add(titlePan);
		add(hakPan);
		add(passPan);
		add(btnPan);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String hak = hakField.getText();
				String pass = passField.getText();
			
				if(memberService.login(hak, pass)) {
					mainPage();
				}else {
					JOptionPane.showMessageDialog(hakPan, "학번 또는 비밀번호가 틀립니다!", "경고", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
	}
	
	public void mainPage() {
		JFrame mainFrame = new JFrame("수강신청");
		mainFrame.setLayout(null);
		mainFrame.setBounds(100, 100, 1000, 800);
		
		JPanel menuPan = new JPanel(new GridLayout(1, 4));
		menuPan.setBounds(300, 50, 600, 50);
		
		JButton btn1 = new JButton("공지사항");
		JButton btn2 = new JButton("교과목조회");
		JButton btn3 = new JButton("수강신청");
		JButton btn4 = new JButton("수강신청조회");
		
		menuPan.add(btn1); menuPan.add(btn2); menuPan.add(btn3); menuPan.add(btn4);
		
		mainFrame.add(menuPan);
		
		mainFrame.setVisible(true);
	}
	

}
