package linkedList;

import java.util.Scanner;

import Inheritance_Person.Person;

class Node2 {

	Person data;
	Node2 next;
}

public class PersonMain {

	public static void main(String[] args) {

		Node2 head = null;

		// 첫번째 객체
		Node2 node1 = new Node2();
		node1.data = new Person("이서희", 20, 165.15, 43);
		node1.next = null;
		head = node1;

		// 두번째 객체 생성
		Node2 node2 = new Node2();
		node2.data = new Person("이익준", 35, 175.12, 60);
		node2.next = null;
		node1.next = node2;

		// 세번째 객체 생성
		Node2 node3 = new Node2();
		node3.data = new Person("김준완", 35, 186.12, 70);
		node3.next = null;
		node2.next = node3;

		// 출력
		Node2 cur = head;
		while (cur != null) {
			System.out.println(cur.data);
			cur = cur.next;
		}

		// 검색!
		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 이름:");
		String findName = sc.nextLine();

		cur = head;
		Person findObj;

		while (cur != null) {
			if (cur.data.getName().equals(findName)) {
				System.out.println(cur.data);
				break;
			}
			// 데이터를 못 찾으면 다음 데이터로 이동
			cur = cur.next;

		}
		if(cur == null) {
			System.out.println("검색한 이름은 없습니다.");
		}
	}
}