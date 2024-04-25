package Abstract_Phone;


public class Phone_2G extends Phone{

	@Override
	String makeCall() {
		return "버튼을 눌러 걸기";
	}

	@Override
	String takeCall() {
		return "버튼을 눌러 받기";
	}

	@Override
	void printInfomation() {
		System.out.println("2G폰 입니다.");
		
	}

}
