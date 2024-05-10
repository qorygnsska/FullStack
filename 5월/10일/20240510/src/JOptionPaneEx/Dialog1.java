package JOptionPaneEx;

import javax.swing.JOptionPane;

public class Dialog1 {
	public static void confirm() {
		// 정보와 함께 선택지를 옵션으로 대화상자를 보여준다
		/*
		 * JOptionPane.
		 * showConfirmDialog
		 * (parentComponent,  (부모 컴포넌트) null 
		 * message,   (메시지)
		 * title,     (제목창)
		 * optionType, (팝업창에 고를 수 있는 옵션 종류)
		 * messageType);
		 * 
		 * 옵션 타입에 따라서 정수를 리턴한다
		 * OK : 0
		 * YES : 0
		 * NO : 1
		 * CANCEL : 2
		 * X(팝업 종료) : -1
		 */
		
		// yes or no
		int choice1 = JOptionPane.showConfirmDialog(null, "계속 진행하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
		System.out.println("Yes or No 결과 : " + (choice1 == JOptionPane.YES_OPTION ? "예" : "아니요"));
		
		// yes or no or cancel
		int choice2 = JOptionPane.showConfirmDialog(null, "다음으로 진행하시겠습니까?", "확인", JOptionPane.YES_NO_CANCEL_OPTION);
		if(choice2 == JOptionPane.YES_OPTION) {
			System.out.println("예!");
		}else if(choice2 == JOptionPane.NO_OPTION) {
			System.out.println("아니요!");
		}else {
			System.out.println("취소!");
		}
	}
	
	public static void input() {
		// showInputDialog
		// 키보드로 입력을 직접 받는 형태
		// OK를 누르면 자동으로 입력받은 창 안에 내용이 문자열로 넘어온다
		String input = JOptionPane.showInputDialog(null, "내용", "임시 입력 값");
		System.out.println("콘솔 : " + input);
		
		// 여러개의 드롭다운 메뉴 중에서 하나를 선택해서 보여줘야될 때 Object 반환이 된다
		// 내가 원하는 문자열로 변환하려면 형변환
		/*
		 * (parentComponent,  (부모 컴포넌트) null 
		 * message,   (메시지)
		 * title,     (제목창)
		 * messageType,
		 * Icon,  아이콘 이미지를 지정해서 사용 가능하다.
		 * value[] 직접 데이터는 배열 형태로 저장
		 * initialValue 기본적으로 보여줄 메뉴
		 * );
		 */
		String[] list = {"A", "B", "C"};                                                            // 아이콘, 드롭다운메뉴, 기본으로 보일 메뉴
		String n = (String)JOptionPane.showInputDialog(null, "내용", "타이틀", JOptionPane.WARNING_MESSAGE, null, list, list[0]);
	}

	public static void main(String[] args) {
		/*
		 * JOptionPane - 사용자에게 값을 묻거나 정보를 알려주는 표준 대화상자(팝업창)
		 * 
		 * 4가지로 나뉜다. showMessageDialog showConfirmDialog showInputDialog
		 * showOptionDialog
		 * 
		 * ------------------
		 * 
		 * showMessageDialog - 단순히 정보만 알려준다.
		 * JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
		 * parentComponet - 주로 null, 부모 컴포넌트를 지정해서 팝업 활성화를 제어할 수 있다. message - 문자열 형식으로
		 * 들어가야 된다. - 팝업에 표시될 내용이다 title - 팝업 상자에 표시될 타이틀 messageType - 에러, 정보, 경고, 아무것도
		 * 표현 안함
		 */
//		// 정보 메시지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "정보메시지", JOptionPane.INFORMATION_MESSAGE);
//		// 경고 메시지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "경고메시지", JOptionPane.WARNING_MESSAGE);
//		// 결과를 보기 위해서 팝업을 설정하면 팝업에 입력받던 확인을 누르던 팝업 실행 다음에 내가 원하는 문장이 실행된다.
//		// 에러 메시지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "에러메시지", JOptionPane.ERROR_MESSAGE);
//		// 질문 메시지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "질문메시지", JOptionPane.QUESTION_MESSAGE);
//		// 일반 메시지 팝업
//		JOptionPane.showMessageDialog(null, "졸려", "일반메시지", JOptionPane.PLAIN_MESSAGE);
		
		//confirm();
		input();
	}

}
