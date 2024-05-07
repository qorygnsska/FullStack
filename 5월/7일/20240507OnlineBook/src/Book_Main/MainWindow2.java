package Book_Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow2 extends JFrame{
	// 메인 페이지에서 메뉴를 설정 
	// 고객 메뉴  고객정보 , 종료
	// 상품 메뉴 상품목록보기 
	// 장바구니 메뉴  장바구니 추가,항목줄이기,항목삭제,장바구니비우기
	// 주문 메뉴 영수증 표시
	static JPanel mMenuPanel,mPagePanel;
	
	public MainWindow2(String title
				,int x,int y
				,int width , int height) {
	
		
		initContainer(title,x,y,width,height);
		initMenu();
		
		setVisible(true);
		setIconImage(new ImageIcon
				("./images/shop.png")
				.getImage());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void initMenu() {
		
		Font font = new Font("함초롬돋움",Font.BOLD,15);
		
		// 1. 첫번째 메뉴바 생성
		JMenuBar menubar = new JMenuBar();
		
		// 2. 메뉴들 생성 
		JMenu menu01 = new JMenu("고객");
		
		// 3. 하위 메뉴 생성 
		JMenuItem item01 =
					new JMenuItem("고객 정보");
		
		JMenuItem item02 =
				new JMenuItem("종료");
		
		// 4. 메뉴에 추가
		menu01.add(item01);
		menu01.add(item02);
				
	
		JMenu menu02 = new JMenu("상품");
		JMenuItem item03 =
				new JMenuItem("상품 목록");
		
		menu02.add(item03);
		
		JMenu menu03 = new JMenu("장바구니");
		
		JMenuItem item04 =
				new JMenuItem("항목 추가");
		JMenuItem item05 =
				new JMenuItem("항목 수량 줄이기");
		JMenuItem item06 =
				new JMenuItem("항목 삭제");
		JMenuItem item07 =
				new JMenuItem("장바구니 비우기");
		
		menu03.add(item04);	
		menu03.add(item05);	
		menu03.add(item06);	
		menu03.add(item07);	
		
		
		JMenu menu04 = new JMenu("주문");
		JMenuItem item08 =
				new JMenuItem("영수증 표시");
		
		menu04.add(item08);
		
		// 메뉴들을 메뉴 바에 추가
		menubar.add(menu01);
		menubar.add(menu02);
		menubar.add(menu03);
		menubar.add(menu04);		
		
		// 윈도우 메뉴를 수정 
		setJMenuBar(menubar);
		
	}

	private void initContainer(String title, int x, int y, int width, int height) {
		
		setTitle(title);
		setBounds(x, y, width, height);
		setLayout(null);
		
		// 실질적으로 공유할 static 객체들을 생성
		mMenuPanel = new JPanel();
		mMenuPanel.setBounds(0, 20, width, 130);
		
		// menuBtn 버튼들만 만들고 이벤트 설정하는
		// 메서드 
		menuBtn();
		
		
	}

	private void menuBtn() {
		// 폰트는 static으로 변경해서 
		// 버튼에 적용될 수있도록 ! 세팅!
		
		JButton btn1 = 
			new JButton("고객 정보 확인하기"
				 ,new ImageIcon("./images/1.png"));
		
		JButton btn2 = 
				new JButton("장바구니 상품 목록보기"
					 ,new ImageIcon("./images/2.png"));
		JButton btn3 = 
				new JButton("장바구니 비우기"
					 ,new ImageIcon("./images/3.png"));
		JButton btn4 = 
				new JButton("장바구니에 항목 추가하기"
					 ,new ImageIcon("./images/4.png"));
		JButton btn5 = 
				new JButton("장바구니에 항목수량 줄이기"
					 ,new ImageIcon("./images/5.png"));
		JButton btn6 = 
				new JButton("장바구니에 항목 삭제하기"
					 ,new ImageIcon("./images/6.png"));
		JButton btn7 = 
				new JButton("주문하기"
					 ,new ImageIcon("./images/7.png"));
		JButton btn8 = 
				new JButton("종료"
					 ,new ImageIcon("./images/8.png"));
		JButton btn9 = 
				new JButton("관리자"
					 ,new ImageIcon("./images/9.png"));
	
	}
	
	// 배열을 이용해서 참고용!
		void ex() {

			// 버튼에 사용될 아이콘들의 경로
			String[] iconPaths = { "./images/1.png", "./images/2.png", "./images/3.png", "./images/4.png", "./images/5.png",
					"./images/6.png", "./images/7.png", "./images/8.png", "./images/9.png" };

			// 버튼에 사용될 텍스트들
			String[] buttonTexts = { "고객 정보 확인하기", "장바구니 상품 목록보기", "장바구니 비우기", "장바구니에 항목 추가하기", "장바구니에 항목수량 줄이기",
					"장바구니에 항목 삭제하기", "주문하기", "종료", "관리자" };

			JButton[] btnList = new JButton[9];

			for (int i = 0; i < btnList.length; i++) {
				btnList[i] = new JButton(buttonTexts[i], new ImageIcon(iconPaths[i]));
				// 각각의 버튼을 클릭했을 때 이벤트 추가
				btnList[i].addActionListener(

						new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								
							}
						}
				);

			}

		}
	
	
	
	
	
}