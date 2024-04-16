package Function;

public class FunctionEx6 {
	public static String name() {
		return "배교훈";
	}
	
	public static int add(int num) {
		// 매개변수로 1을 받으면 +10을 해서 남기는 함수
		return num + 10;
	}
	
	public static void main(String[] args) {
		
		
		//함수를 실행하고 나서 그 자리에 남겨놓을 값이 있으면 return을 쓴다
		// return은 2가지 기능을 함
		// 1. 함수 종료
		// 2. 함수가 종료되기 전에 함수를 실행한 함수에게 데이터를 돌려준다.
		System.out.println(name());
		System.out.println(add(10));
		
		int sum = add(20);
		System.out.println(sum);
		
		// 변수
		// - 메모리에 생존하는 시간
		
		// 전역변수
		// - 
		
		// 지역변수
		// - 중괄호 { 열리고,  중괄호 } 닫히는 사이에 만들어진 변수
		// - 중괄호가 닫히면 변수 삭제
		// 생존 시간은 main함수가 시작하고 끝날때 까지는 메모리에 유지된다
		int num = 10;
		
		print();
		
		System.out.println("main 함수 num : " + num);
		
		int total = add(10, 20);
		System.out.println("main 함수 : " + total);
		System.out.println();
	}// main함수 끝
	
	public static int add(int n1, int n2) {
		// 함수 안에서 지역변수를 만들면, 함수가 끝나고 결과값이 삭제되기 때문에
		// 함수가 끝나기 전에 내보내기 return
		int total = n1 + n2;
		return total;
	}
	
	// 함수를 만드는 공간
	public static void print() {
		// print() 함수가 시작되면 변수를 생성한다
		// 만들어진 공간이 다르면, 생존하는 시간이 다르면 중복적으로 이름을 써도 상관없다
		int num = 100;
		System.out.println("print() num : " + num);
	}

}
