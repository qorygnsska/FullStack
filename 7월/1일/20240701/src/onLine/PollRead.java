package onLine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PollRead {

	// 텍스트 파일의 이름을 넘겨 받고 내용을 읽어서
	// ArrayList에 저장해서 리턴하는 메서드
	public static ArrayList<String> pollRead(String filepath) {

		// 텍스트파일의 내용을 읽어서 리턴시킬
		// 객체를 선언한다.
		ArrayList<String> poll = null;
		try {
			Scanner sc = new Scanner(new File(filepath));

			poll = new ArrayList();

			// hasNextLine()
			// 다음 데이터가 있는지 확인
			// 다음 데이터가 있다면 true
			// 다음 데이터가 없다면 false

			// 파일의 끝까지 읽어서 arraylist저장

			while (sc.hasNextLine()) {
				String str = sc.nextLine().trim();

				// 파일을 무조건 저장하는 것이 아니라
				// 빈 줄일 수도 있다. 그러면 빈줄은
				// 제거하고 list에 저장한다.
				if (str.length() > 0) {
					poll.add(str);
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		// 실제 파일에서 내용을 읽어서 처리하는 것은
		//
		return poll;
	}

}