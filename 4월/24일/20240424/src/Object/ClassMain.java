package Object;

public class ClassMain {

	public static void main(String[] args) {

		// Object
		//  getClass()
		//  어떤 클래스 파일의 클래스 정보를 갖고있는 Class 클래스 객체
		
		// Class 클래스
		// - 클래스 이름이 Class다.
		// - 클래스의 모든 정보(변수, 메서드, 타입)
		
		String str = "Class 클래스 테스트";
		
		// String 객체로 부터 클래스의 정보 얻어오기
		System.out.println(str.getClass());
		
		Class cls = str.getClass();
		
		// 클래스의 이름만 호출한다
		System.out.println("1. " + cls.getSimpleName());
		
		// 패키지의 이름을 호출한다
		System.out.println("2. " + cls.getPackageName());
		
		System.out.println("3. " + cls.getName());
		
		// 제어자 정보를 확인
		System.out.println("4. " + cls.toGenericString());

	}

}
