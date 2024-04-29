package inputoutputTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {
		// 입출력 스트림
		// 바이트 스트림
		// - 한번에 8비트(1바이트) 데이터를 처리하고 8비트당 입출력 연산을 수행하므로
		// 주로 바이트 데이터의 입출력을 처리한다.
		// 콘솔이나 소켓이나 파일을 바이트 스트림
		// 대표적으로 많이 사용하는 것은 스트림(연결통로) 방향이 한 방향으로 정해져있음
		FileInputStream fs = null;
		FileOutputStream fo = null;

		// 문자 스트림
		// printWriter
		// 한번에 16비트(2바이트) 유니코드
		// 스트림보다 2배의 빠른 연산을 수행할 수 있다.
		FileWriter fw = null;
		FileReader fr = null;

		// wirte() 메서드
		// 텍스트로 문자로만 저장, 줄바꿈이 없음
		// \n : new Line 줄을 바꾼다.
		// \r : carriage return 커서를 그 줄의 맨 앞으로 이동한다.

		// 파일 클래스를 이용해서 파일 객체를 생성
		// 절대 경로
		File file = new File("C:\\fullstack\\part1\\io\\test.txt");

		// 상대 경로
		// - 작업중인 파일이 위치한 프로젝트 이름의 폴더(".")
		// 부터 작업중인 파일이 위치한 폴더까지의 경로를 말한다
		File file2 = new File("./scorelist2.txt");
		File file3 = new File("./src/inputoutputTest/scorelist2.txt");

		try { // 예외가 발생할 공간에서 어떤 예외가 발생할 지 모른다.
				// 위에 file의 정보를 저장한 객체를 이용
				// 실제 객체를 생성해야된다.
				// createNewFile()
				// 파일을 생성했다면 true 파일이 기존에 존재한다면 false
			boolean fileRes = file.createNewFile();
			file2.createNewFile();
			file3.createNewFile();
			if (fileRes) {
				System.out.println("파일 생성 성공");
			} else {
				System.out.println("파일 생성 실패");
			}
			System.out.println("파일 이름 : " + file.getName());
			System.out.println("파일 경로 : " + file.getAbsolutePath());
			System.out.println("파일쓰기 가능 : " + file.canWrite());
			System.out.println("파일읽기 가능 : " + file.canRead());
			System.out.println("파일의 크기 : " + file.length());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
