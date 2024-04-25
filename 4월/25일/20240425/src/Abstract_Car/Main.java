package Abstract_Car;

public class Main {

	public static void main(String[] args) {
		// Car car1 = new Car(); -> Car가 추상클래스이므로 객체생성 불가
		
		BMW b1 = new BMW();
		Benz b2 = new Benz();
		Hyundai h1 = new Hyundai();
		
		// 객체는 생성할 수 없지만
		// 다형성을 이용할 수는 있다.
		// 여러개의 객체를 관리할 수 있다.
		Car[] list = {b1, b2, h1};
		
		for(int i = 0; i < 3; i++) {
			list[i].전진한다();
		}
		
		// 추상클래스에 새로운 내용이 추가되거나 삭제되면
		// 추상 클래스를 상속해 간 자식 클래스들은 꼭 오버라이딩을 하던지
		// 메서드를 삭제해줘야한다.

	}

}
