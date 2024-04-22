package Polymorphism;

import Inheritance_Person.Employee;
import Inheritance_Person.Person;
import Inheritance_Person.Student;

public class PolymorphismEx {

	public static void main(String[] args) {
		
		// 다형성(Polymorphism)
		// - 같은 자료형에 여러가지 타입의 데이터를 대입하여
		//   다양한 결과를 얻어 낼 수 있다!
		// - 하나의 타입으로 여러개의 다른 타입을 저장할 수 있다.
		// - 상속을 반드시 해야만 다형성을 사용할 수 있다.
		
		Person p1 = new Person();
		Person p2 = new Student();
		System.out.println(p2.getName());
		
		Person p3 = new Employee();
		System.out.println(p3.getName());
		
		Student s1 = new Student(); 
	}

}
