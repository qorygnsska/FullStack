package Book_Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	// 메인 페이지에서 메뉴를 설정
	// 고객 메뉴 고객정보, 종료
	// 상품메뉴 상품목록보기
	// 장바구니 메뉴 장바구니 추가, 항목 줄이기, 항목 삭제, 장바구니
	// 주문 메뉴 영수증 표시
	
	public MainWindow(){
		setTitle("온라인 서점");
		setLayout(null);
		setBounds(0, 0, 1000, 750);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("고객");
		JMenu menu2 = new JMenu("상품");
		JMenu menu3 = new JMenu("장바구니");
		JMenu menu4 = new JMenu("주문");
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		JMenuItem item1 = new JMenuItem("고객정보");
		JMenuItem item2 = new JMenuItem("종료");
		menu1.add(item1);
		menu1.add(item2);
		
		JMenuItem item3 = new JMenuItem("상품목록 보기");
		menu2.add(item3);
		
		JMenuItem item4 = new JMenuItem("장바구니 추가");
		JMenuItem item5 = new JMenuItem("항목 줄이기");
		JMenuItem item6 = new JMenuItem("항목 삭제");
		JMenuItem item7 = new JMenuItem("장바구니 비우기");
		menu3.add(item4);
		menu3.add(item5);
		menu3.add(item6);
		menu3.add(item7);
		
		JMenuItem item8 = new JMenuItem("영수증 표시");
		menu4.add(item8);
		
		setJMenuBar(menuBar);
		
		JPanel btnPanel1 = new JPanel();
		btnPanel1.setBounds(50, 10, 800, 35);
		JButton btn1 = new JButton("고객 정보 확인하기", new ImageIcon("./images/1.png"));
		JButton btn2 = new JButton("장바구니 상품목록보기", new ImageIcon("./images/2.png"));
		JButton btn3 = new JButton("장바구니 비우기", new ImageIcon("./images/3.png"));
		JButton btn4 = new JButton("장바구니에 항목추가하기", new ImageIcon("./images/4.png"));
		btnPanel1.add(btn1);
		btnPanel1.add(btn2);
		btnPanel1.add(btn3);
		btnPanel1.add(btn4);
		
		add(btnPanel1);
		
		JPanel btnPanel2 = new JPanel();
		btnPanel2.setBounds(50, 50, 800, 35);
		JButton btn5 = new JButton("장바구니에 항목수량 줄이기", new ImageIcon("./images/5.png"));
		JButton btn6 = new JButton("장바구니에 항목삭제하기", new ImageIcon("./images/6.png"));
		JButton btn7 = new JButton("주문하기", new ImageIcon("./images/7.png"));
		JButton btn8 = new JButton("종료", new ImageIcon("./images/8.png"));
		JButton btn9 = new JButton("관리자", new ImageIcon("./images/9.png"));
		btnPanel2.add(btn5);
		btnPanel2.add(btn6);
		btnPanel2.add(btn7);
		btnPanel2.add(btn8);
		btnPanel2.add(btn9);
		
		add(btnPanel2);
		
		btn9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminLogin();
				
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
