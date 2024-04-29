package inputoutputTest;

import java.io.*;

public class FileMain2 {
	public static void main(String[] args) {
		File file = new File("ex1.txt");
		String str = "hello java programing";
		try {
			// 자바 파일을 바이트를 이용해서 텍스트로 저장
			// exists()
			// 폴더에 위에 파일객체의 정보 파일이 있는지 확인하는 메서드
			// 있으면 true, 없으면 false
			if (file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fo = new FileOutputStream(file);
			fo.write('A');
			fo.write('\n');

			// 문자를 바이트 배열로 변경해서 보냄
			byte[] b = str.getBytes();
			fo.write(b);
			fo.write('\n');

			fo.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 위에서 저장을 했다면 읽기
		// 또 스트림을 작성하는 이유는 단방향이기 때문에
		// 위에 출력 닫고 새로운 입력 열어야 된다.
		file = new File("ex1.txt");
		try {
			FileInputStream fs = new FileInputStream(file);

			// read()
			// 데이터 바이트로 읽는다
			// 숫자로 읽어온다, 형변환 해야함
			int data;
//			while (true) {
//				data = fs.read();
//				System.out.println((char)data);
//				
//				// 더 이상 읽어올 데이터가 없으면 -1을 돌려줌
//				if(data == -1) {
//					break;
//				}
//			}
//			System.out.println("정상출력!");
			
			// 위의 while문 짧게 줄인 방식
			while((data = fs.read()) != -1) {
				System.out.println((char)data);
			}
			
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
