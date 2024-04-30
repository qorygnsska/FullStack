package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserInfoClient {

	public static void main(String[] args) {

		// db.properties 파일을
		// 읽어오는 FileInputStream

		String dbType = "";

		// 바이트 단위로 읽어온다.
		FileInputStream fis = null;

		try {
			String filepath = "./src/Properties/db.properties";

			fis = new FileInputStream(filepath);

			// read() 메소드는 FileInputStream 클래스
			// 객체에서 1바이트의 데이터를 읽어온다.
			// read() 메소드는 코드값으로 읽어오기 때문에
			// 문자로 출력하려면 형변환(casting) 해야한다

			// System.out.println((char)fis.read());

			// read()메서드는 읽어들일 데이터가 없으면 -1
			// 있으면 데이터의 코드값(숫자)으로 리턴한다.
			// 끝까지 다 읽으면 역시나 -1로 리턴된다.

//			int ch;
//			String prop = "";

//			while(true) {
//				ch = fis.read();
//				if(ch == -1) {
//					break; // 읽을 데이터가 없으면 반복문 멈춤
//				}
//				prop += (char)ch;
//			}

			// ===============위 아래 동일 코드===================

//			while((ch = fis.read()) != -1) {
//				prop += (char)ch;
//				
//			}
//			System.out.println(prop);
//			
//			String[] dbProp = prop.split("=");
//			System.out.println(dbProp[1]);

//			=============더 간편한 버전 ==============
			Properties properties = new Properties();
			properties.load(fis);

			// getProperty(key, 기본값)
			// key가 있으면 value, 없으면 null
			// 기본 값을 설정하면 키가 없을 때 null이 아닌 기본값이 나온다
			System.out.println(properties.getProperty("DBTYPE", "잘못된 key"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				}
				// {} 중괄호를 비우면 예외를 무시
				catch (IOException e) {
				}
			}
		}

	}

}
