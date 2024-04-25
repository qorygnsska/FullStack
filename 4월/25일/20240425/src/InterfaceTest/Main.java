package InterfaceTest;

public class Main {

	public static void main(String[] args) {
		Dog d1 = new Dog(11, "여름이", "셀티");
		
		Cat c1 = new Cat("우리집", "하얀색", "나비", "한국고양이");
		
		
		Animal[] list = {d1, c1};
		for(int i = 0; i < 2; i++) {
			list[i].speak();
		}

	}

}
