
public class OverloadingEx {

	public static void add(int n1, int n2) {
		System.out.println("정수 더한 값 : " +  (n1 + n2));
	}
	
	public static void add(double n1, double n2) {
		System.out.println("실수 더한 값 : " +  (n1 + n2));
	}
	
	public static void add(int n1, double n2) {
		System.out.println("정수 실수 더한 값 : " +  (n1 + n2));
	}
	
	public static void main(String[] args) {
		// 계산기
		
		// 오버로딩
		// - 새로운 함수를 계속 만드는데 함수의 이름은 같게 하는 것
		// - 매개변수의 타입이 다르거나 매개변수의 수가 달라야한다
		// - 그래야 자바 컴파일이 구별해서 함수를 호출할 수 있다.
		
		// 오버로딩
		// - 매개변수 타입과 개수가 달라야한다.
		// - 반환타입은 오버로딩에 해당되지 않기때문에 상관이 없다

	}

}
