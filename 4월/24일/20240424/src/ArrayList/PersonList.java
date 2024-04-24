package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

class Person{
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	// 클래스 멤버를 출력하는 함수
	// 인스턴스 : 변수마다 각각 생성되는 변수 또는 메서드
	public void info() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
public class PersonList {

	public static void main(String[] args) {
//		System.out.println(new Person());
//		Person p1 = new Person();
//		System.out.println(p1);
//		
//		p1.setName("배교훈");
//		System.out.println(p1.getName());
//		p1.setAge(25);
//		System.out.println(p1.getAge());
		
		// 가변적인 Person 타입을 저장하는 배열
		// 동적할당
		ArrayList<Person> list = new ArrayList<Person>();
		Person p1 = new Person("이익준", 20);
		list.add(p1);
		
		Person p2 = new Person("김준완", 30);
		list.add(p2);
		list.add(new Person("양석형", 20));
		list.add(new Person("채송화", 20));
		list.add(new Person("안정원", 20));
		list.add(new Person("장겨울", 20));
		System.out.println("길이 : " + list.size());
		
		// Person 타입을 삭제
		// remove()
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String delName = sc.nextLine();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().equals(delName)) {
				// 삭제
				list.remove(i);
				System.out.println("삭제 되었습니다.");
			}
		}
		for(int i = 0; i < list.size(); i++) {
			list.get(i).info();
			System.out.println();
		}
		
	}

}
