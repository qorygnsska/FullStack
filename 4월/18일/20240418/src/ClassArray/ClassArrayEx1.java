package ClassArray;

class Join{ // 로그인
	String id;
	String pw;
}
public class ClassArrayEx1 {

	public static void main(String[] args) {
		// Join 클래스를 1000개 생성
		// 클래스는 각각의 다른 타입의 변수 여러개를 묶어서 하나의 단어로 표현
		
		// 같은 타입으로 여러개의 변수를 한꺼번에 생성하는 기법
		Join join1 = new Join();
		
		// 내가 만든 타입으로 Join타입 5개
		Join[] joinList = new Join[5];
		
		// 실제 데이터를 저장하기 위해서는 new 타입(); 필요함
		joinList[0] = new Join();
		joinList[0].id = "qwer";
		joinList[0].pw = "qwer";
		
		System.out.println(joinList[0].id);
		
		// 배열을 사용할 때는 공간에 각각 저장될 수 있도록 새로운 변수를 new 생성해줘야함
		joinList[1] = new Join();
		joinList[1].id = "qwer";
		joinList[1].pw = "qwer";
		
		System.out.println(joinList[1].id);
	}

}
