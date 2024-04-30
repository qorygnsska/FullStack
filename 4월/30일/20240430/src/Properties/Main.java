package Properties;

import java.util.Enumeration;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		/*
		 * Properties
		 * 	key - value 저장이 된다.
		 * 	new Properties(String, String)
		 * 
		 * 	주로 애플리케이션의 환경 설정, 관련 속성을 저장하는데 사용되며
		 * 	데이터를 파일로부터 읽고 쓰기 편리한 기능을 제공한다.
		 */
		Properties prop = new Properties();
		/* prop  저장할 때는 key-value*/
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		// 설정된 속성 출력
		prop.list(System.out);
		
		Enumeration en = prop.propertyNames();
		
		while(en.hasMoreElements()) {
			String element = (String)en.nextElement();
			
			// 데이터의 key를 이용해서 value를 출력
			// getProperty(element)
			// 설정 파일에서 값을 꺼내올 때는 element 변수에 key값을 넣어서 찾는다
			System.out.println("key : " + element);
			System.out.println("value : " + prop.getProperty(element));
		}
	}

}

/*
 *  Enum 열거타입 
		- 멤버라 불리는 값의 집합을 이루는 
		    자료형  (상수들의 데이터 집합)
 */