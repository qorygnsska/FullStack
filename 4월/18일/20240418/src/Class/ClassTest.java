package Class;

class Product {
	String pName;
	int price;
	String brand;
	
	void information(String n, int p, String b) {
		pName = n;
		price = p;
		brand = b;
		
		System.out.println(brand + " " + pName +" 가격 : " + price);
	}
}

class Circle {
	Double PI = 3.14;
	int radius;
	
	void getAreaOfCircle(int r) {
		System.out.println("반지름이 " + r + "인 원의 넓이 : " + (r * r * PI));
	}
}

class Student {
	int grade;
	int classroom;
	String name;
	double height;
	char gender;
	
	
	void information(int g, int c, String n, double h, char ge) {
		grade = g;
		classroom = c;
		name = n;
		height = h;
		gender = ge;
		
		System.out.println(grade + "학년 " + classroom + "반, 이름 : " + name + ", 키 : " + height + ", 성별 : " + gender);
	}

	// 클래스 멤버들을 하나의 문자열로 만들어서 결과를 남기는 함수(특별한 함수)
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classroom=" + classroom + ", name=" + name + ", height=" + height
				+ ", gender=" + gender + "]";
	}
}
public class ClassTest {

	public static void main(String[] args) {
		// 1. 제품에 대한 클래스 작성, 객체 생성, 데이터 저장
		Product p1 = new Product();
		p1.information("초코파이", 4500, "오리온");
		
		// 2. Circle 클래스 작성 후 원의 넓이를 출력
		Circle c1 = new Circle();
		c1.getAreaOfCircle(10);
		
		// 3. Student 클래스 작성 후 정보 출력
		Student s1 = new Student();
		s1.classroom = 2;
		s1.grade = 3;
		s1.name = "홍길동";
		s1.height = 174;
		s1.gender = '남';
		
		// toString() 특별한 함수를 이용해서 멤버들을 하나의 문자열로 반환해서 출력
		System.out.println(s1);
		
		s1.information(3, 2, "홍길동", 174, '남');
		

	}

}
