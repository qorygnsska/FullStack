package Book_Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminLogin extends JFrame{
	String adminid = "1234";
	String adminpw = "1234";
	public AdminLogin() {
		setTitle("관리자 로그인");
		setLayout(null);
		setBounds(0, 0, 500, 500);
		Font ft = new Font("함초롱돋움", Font.BOLD, 15);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 100, 500, 50);
		
		JLabel titleLabel = new JLabel("관리자 로그인");
		titleLabel.setFont(ft);
		titlePanel.add(titleLabel);
		add(titlePanel);
		
		JPanel idPanel = new JPanel();
		idPanel.setBounds(0, 150, 500, 50);
		
		JLabel idLabel = new JLabel("아 이 디  :");
		idLabel.setFont(ft);
		idPanel.add(idLabel);
		
		JTextField idField = new JTextField(10);
		idField.setFont(ft);
		idPanel.add(idField);
		add(idPanel);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(0, 200, 500, 50);
		JLabel pwLabel = new JLabel("비밀번호 :");
		pwLabel.setFont(ft);
		pwPanel.add(pwLabel);
		
		JTextField pwField = new JTextField(10);
		pwField.setFont(ft);
		pwPanel.add(pwField);
		add(pwPanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 250, 500, 50);
		
		JButton btnLabel = new JButton("로그인");
		btnPanel.add(btnLabel);
		add(btnPanel);
		
		btnLabel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idField.getText().equals(adminid) &&
					pwField.getText().equals(adminpw)) {
					System.out.println("로그인 성공!");
				}else {
					System.out.println("아이디 또는 비밀번호가 다릅니다!");
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
