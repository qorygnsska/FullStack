package Constructor;

import java.util.Scanner;

class Member{
	String id;
	String name;
	String password;
	String email;
	char gender;
	int age;
	
	Member(){}
	
	Member(String i, String n, String p, String e, char g, int a){
		id = i;
		name = n;
		password = p;
		email = e;
		gender = g;
		age = a;
		System.out.println("생성완료!");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member[] list = new Member[5];
		for(int i = 0; i < list.length; i++) {
			System.out.print("id : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String p = sc.nextLine();
			System.out.print("이름 : ");
			String n = sc.nextLine();
			System.out.print("email : ");
			String e = sc.nextLine();
			System.out.print("성별 : ");
			char g = sc.nextLine().charAt(0);
			System.out.print("나이 : ");
			int a = sc.nextInt();
			list[i] = new Member(id, p, n, e, g, a);
			sc.nextLine();
		}
		for(int i = 0; i < list.length; i++) {
			System.out.println("id : " + list[i].id + ", 비밀번호 : " + list[i].password + ", 이름 : " + list[i].name + ", 이메일 : " + list[i].email + ", 성별 : " + list[i].gender + ", 나이 : " + list[i].age);
		}

	}

}
