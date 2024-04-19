package Constructor;

import java.util.Scanner;

class A{
	// 메모리 공간을 만드려면 동작이 필요하다
	// 컴파일하면 자동으로 빈 생성자를 만들어준다.
	// 생성자는 반환 타입이 없고 꼭 클래스 이름과 같아야한다!
	A(){}
}

class Song{
	String name;
	String singer;
	
	// 키보드로 입력받고 싶을 땐 기본 생성자 따로 생성
	Song(){}
	// 생성자를 만들어 놓으면 기본 생성자가 생기지 않는다.
	Song(String n, String s){
		name = n;
		singer = s;
	}
}

public class ConstructorEx3 {

	public static void main(String[] args) {
		/*
		 * 생성자
		 * - new 연산자에 의해서 무조건 한 번 호출된다.
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제목 : ");
		String name = sc.nextLine();
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		
		Song s1 = new Song(name, singer);
		System.out.println(s1.name);
		
		Song s2 = new Song();
		System.out.print("제목 : ");
		s2.name = sc.nextLine();
		System.out.print("가수명 : ");
		s2.singer = sc.nextLine();
		
		System.out.println(s2.name);
		
		Song[] songList = new Song[5];
		songList[0] = s1;
		songList[1] = s2;

	}

}
