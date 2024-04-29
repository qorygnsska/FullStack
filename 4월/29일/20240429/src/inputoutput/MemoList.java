package inputoutput;

import java.io.File;
import java.io.FileNotFoundException;
// java.io 입력과 출력을 담당하는 패키지
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoList {
	// 글들을 저장하는 리스트
	private ArrayList<Memo> memoList = new ArrayList<Memo>();

	public ArrayList<Memo> getMemoList() {
		return memoList;
	}

	public void setMemoList(ArrayList<Memo> memoList) {
		this.memoList = memoList;
	}

	// Main클래스에서 호출되는 momoList라는 ArrayList에 저장할 데이터가 저장된 vo클래스 객체를 넘겨받아
	// memoList라는 ArrayList에 저장하는 메서드
	public void addMemo(Memo vo) {
		memoList.add(vo);
	}

	// Main 클래스에서 호출되는 텍스트 파일의 이름을 넘겨받아 ArrayList에 저장된 데이터를 텍스트 파일에 저장하는 메서드
	public void writeMemo(String fileName) {
		PrintWriter printWriter = null;

		// 대부분 파일 입출력은 예외가 발생할 수 있다.
		try {
			// 파일을 저장하기 위해서는 파일명과 경로
			// String filepath = fileName + ".txt";
			String filepath = String.format("%s.txt", fileName);
			// 파일 생성!
			printWriter = new PrintWriter(filepath);
			System.out.println(filepath);

			// ArrayList가 가지고 있는 데이터를 저장
			for (int i = 0; i < memoList.size(); i++) {
				Memo m = memoList.get(i);
				printWriter.print(m.getIdx() + " ");
				printWriter.print(m.getName() + " ");
				printWriter.print(m.getPassword() + " ");
				printWriter.print(m.getMemo() + " ");
				printWriter.print(formatDateTime(m.getWriteDate()) + " ");
				// 줄바꿈
				printWriter.println();
			}

			// 저장
//			printWriter.write("Hello java");
//			printWriter.write("월요일은 힘들어..");

			// 모니터로 데이터를 운반하기 위해서 연결통로(자동으로 생성) 괄호안에 있는 데이터를 이동해서 모니터에 결과를 출력한다.
//			printWriter.println("Hello printWriter!!");
//			printWriter.println("줄바꿈 되니??");

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없거나 경로 지정을 잘못했다.");
		} finally {
			// 예외가 발생하든 안하든 무조건 실행
			if (printWriter != null) {
				printWriter.close();
			}
		}

	}

	// LocalDateTime을 원하는 형식으로 포맷하는 메서드
	private String formatDateTime(LocalDateTime date) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return date.format(format1);
	}

	// Main 클래스에서 호출되는 텍스트 파일의 이름을 넘겨받아 텍스트 파일에 저장된 데이터를
	public void readMemo(String fileName) {
		Scanner scan = null;
		// 텍스트 파일의 경로와 텍스트 파일의 이름을 저장
		String filepath = String.format("%s.txt", fileName);
		try {
			// 파일을 열기
			scan = new Scanner(new File(filepath));

			// 텍스트 파일에서 한 줄을 읽어 들인다
			// hasNextLine()
			// 다음 줄이 있니? 있으면 true 없으면 false
			// 파일의 데이터가 얼마나 있을지 모를 때 사용
			while (scan.hasNextLine()) {
				String str = scan.nextLine().trim();

				System.out.println(str);
				// 단순 출력 말고 Memo 객체를 생성해서 arraylist에 추가하기
				// 문자로 저장된 한 줄을 가지고 와서 문자열을 쪼개기!
				String[] res = str.split(" ");
				Memo temp = new Memo();
				// 문자 -> 숫자로 변환
				temp.setIdx(Integer.parseInt(res[0]));
				temp.setName(res[1]);
				temp.setPassword(res[2]);
				temp.setMemo(res[3]);

				// 공백으로 쪼갰는데 날짜에 공백이 있기 때문에 다시 합쳐준다
				String[] dateParts = res[4].split("-");
				String[] timeParts = res[5].split(":");
				int year = Integer.parseInt(dateParts[0]);
				int month = Integer.parseInt(dateParts[1]);
				int day = Integer.parseInt(dateParts[2]);
				int hour = Integer.parseInt(timeParts[0]);
				int min = Integer.parseInt(timeParts[1]);
				int sec = Integer.parseInt(timeParts[2]);
				
				// 하나씩 꺼내와서 숫자로 변경하고 각각 변수에 저장해서 of()를 이용해서 LocalDateTime 객체를 생성
				LocalDateTime writeDate = LocalDateTime.of(year, month, day, hour, min, sec);
				temp.setWriteDate(writeDate);

				memoList.add(temp);
				System.out.println("파일에서 성공적으로 읽음!");
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없다.");
		} finally {
			if (scan != null) {
				scan.close();
			}
		}

	}

}
/*
 * 원래 파일을 생성하기 위해서는 File 파일을 표현하는 클래스, 파일 크기, 파일 속성, 파일이름 등의 정보와 파일 생성 및 삭제 기능을
 * 제공
 * 
 * import java.io.* io 폴더가 가지고 있는 모든 클래스파일을 가져온다.
 * 
 * java.io 폴더안에 File 객체를 생성한다.
 * 
 * File 변수명 = new File("경로/파일명.확장자");
 * 
 * 
 * 
 * 파일 입출력할 때 주의사항 파일을 생성 저장 파일을 닫기!!!
 * 
 * 파일을 저장한다(내보내기 출력) - 파일명이 있으면 파일을 생성하지 않고 저장만 한다. - 파일명이 없으면 파일을 생성하고 저장한다. -
 * 단점이 줄바꿈이 없다
 * 
 * 
 * 경로를 설정할 때 절대 경로 - 드라이브를 기준으로 폴더를 찾아간다. C:\fullstack\part1\src\20240429\src
 * 
 * 상대 경로 - 현재 폴더를 기준으로 경로를 설정한다. - . 현재폴더 - .. 상위 폴더 이동
 * 
 */
// 실제 파일을 저장할 때 저장할 경로를 쓰지 않으면 기본적으로 프로젝트 폴더 안에 생성됨
