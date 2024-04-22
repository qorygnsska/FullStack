package linkedList;

class Node {
	// 데이터 + 주소를 한꺼번에 저장하는 노드
	int data; // 데이터
	Node next; // 다음 노드를 가리키는 주소

	// 생성자
	// new 키워드를 사용하는 것들은 데이터가
	// 없다는 의미로 null
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	// 자동으로 초기화 null
	private Node head;

	// 추가하는 함수
	public void addNode(int data) {
		// 먼저 추가할 노드(객체)생성
		Node newNode = new Node(data);

		// 연결 리스트가 비어있을 경우
		if (head == null) {
			head = newNode;
			return;
		}
		// 비어있지 않으면 마지막 노드를 찾는다.
		// next값이 null인 객체를 찾는다.
		// head는 연결리스트의 시작점 절대로
		// 주소값이 변하면 안된다.

		Node current = head;

		while (current.next != null) {
			current = current.next;

		}
		// 가장 마지막 노드를 찾았으면 새로운 노드
		// 추가
		current.next = newNode;

	}

	void printList() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("출력완료!");
		System.out.println();
	}
}

public class Main {

	public static void main(String[] args) {

		// 연결 리스트
		// 시작점 head
		// head 부분은 데이터를 저장하지 않는다

		LinkedList list = new LinkedList();

		list.addNode(10);
		list.addNode(20);
		list.addNode(30);

		list.printList();

		// 배열(유동적인 배열)

		// 리스트
		// 선형리스트 (배열 )
		// 연결리스트
		// 연결리스트를 만들기 위해서는
		// 데이터와 주소값을 저장하는 변수
		// Node
		// 주소(포인터)

		// 연결 리스트 종류
		// 1. 단방향 리스트
		// 한쪽 방향으로만 데이터를 저장하고
		// 검색할 수있다.

		// 2. 양방향 리스트
		// 양쪽으로 검색하고 추가할 수 있도록
		// 사용하는 리스트!

		// 3. 양방향 원형 연결 리스트

	}
}