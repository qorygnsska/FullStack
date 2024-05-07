package Book_Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// 가장 첫 화면! 고객의 정보를 입력하는 페이지!
public class GuestWindow extends JFrame{
	
	public GuestWindow() {
		setTitle("고객 정보 입력");
		setLayout(null); // layout을 null로 설정하면 setBounds로 위치 설정을 해줘야한다.
		setBounds(0, 0, 1000, 750);
		
		Font ft = new Font("함초롱돋움", Font.BOLD, 15);
		
		// Dimension 클래스 너비랑 높이를 자동으로 저장하는
		// 클래스 Toolkit 클래스안에 정보를 가져와서 반으로 계산해서 저장하는 것!
		
		JPanel userPanel = new JPanel();
		userPanel.setBounds(0, 100, 1000, 250);
		
		ImageIcon imageIcon = new ImageIcon("./images/user.png");
		// 아이콘 자체로 표시가 될 수 없으니 라벨에다가 올려야함
		JLabel userLabel = new JLabel(imageIcon);
		userPanel.add(userLabel);
		add(userPanel);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 350, 1000, 50);
		
		JLabel titleLabel = new JLabel("-- 고객 정보를 입력하세요 --");
		titleLabel.setFont(ft);
		titleLabel.setForeground(Color.blue);
		titlePanel.add(titleLabel);
		add(titlePanel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 400, 1000, 50);
		
		JLabel nameLabel = new JLabel("이    름 :");
		nameLabel.setFont(ft);
		namePanel.add(nameLabel);
		
		JTextField nameField = new JTextField(10);
		nameField.setFont(ft);
		namePanel.add(nameField);
		add(namePanel);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 450, 1000, 50);
		JLabel phoneLabel = new JLabel("연락처 :");
		phoneLabel.setFont(ft);
		phonePanel.add(phoneLabel);
		
		JTextField phoneField = new JTextField(10);
		phoneField.setFont(ft);
		phonePanel.add(phoneField);
		add(phonePanel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 500, 1000, 100);
		
		JButton btn = new JButton("쇼핑하기", new ImageIcon("./images/shop.png"));
		btnPanel.add(btn);
		add(btnPanel);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameField.getText().isEmpty() || phoneField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btn, "고객 정보를 입력하세요", "고객 정보",JOptionPane.ERROR_MESSAGE);
				}else {
					// user 객체 생성하고 
					new MainWindow();
				}
				
			}
		});
		
		
		
		
		// 버튼에 들어가는 가게모양 아이콘 가져오기
		setIconImage(new ImageIcon("./images/shop.png").getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
