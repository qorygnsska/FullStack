package Constructor;

import java.util.Scanner;

class Hero{
	String name;
	int hp;
	
	Hero(String n, int h){
		name = n;
		hp = h;
		System.out.println("생성완료!");
	}
	
	void show() {
		System.out.println("Hero { name : " + name + ", hp : " + hp + " }");
	}
	
	String toStr() {
		// 실수 %.보고싶은자리수f ex) %.1f = 10.1
		// print()문으로 출력가능
		return String.format("Hero { name : %s, hp : %d }", name, hp);
	}
	
}

public class ConstructorEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hero[] heroList = new Hero[5]; // 배열 선언
		
		for(int i = 0; i < heroList.length; i++) {
			System.out.print("이름 : ");
			String n = sc.nextLine();
			System.out.print("hp : ");
			int h = sc.nextInt();
			
			heroList[i] = new Hero(n, h);
			sc.nextLine(); // 버퍼 비우기
		}
		for(int i = 0; i < heroList.length; i++) {
			heroList[i].show();
			//System.out.println(heroList[i].toStr());
		}
	}

}
