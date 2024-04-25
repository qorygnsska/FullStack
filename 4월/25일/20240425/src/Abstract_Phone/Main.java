package Abstract_Phone;

public class Main {

	public static void main(String[] args) {
		
		GalaxyNote9 g1 = new GalaxyNote9();
		V40 v1 = new V40();
		Phone_2G p1 = new Phone_2G();
		
		
		// 다형성
		Phone[] list = {g1, v1, p1};
		
		for(int i = 0; i < 3; i++) {
			list[i].printInfomation();
		}

	}

}
