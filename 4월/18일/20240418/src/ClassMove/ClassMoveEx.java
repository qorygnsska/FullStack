package ClassMove;

/*
 * Student 학번, 수강과목
 * 
 * 클래스 안에 클래스를 만든다
 */

class Student{
	int hakbun; // 학번
	Subject sub1 = new Subject();
}
class Subject{
	// 과목에 대한 정보를 저장하는 클래스 멤버들
	String subName;	// 과목명
	int score;		// 과목의 점수
}
public class ClassMoveEx {

	public static void main(String[] args) {
		// 위에 있는 학생 객체를 먼저 만들어야함
		Student temp = new Student();
		
		// 수강과목의 이름
		temp.sub1.subName = "Java";
		temp.sub1.score = 100;
		System.out.println("과목 : " + temp.sub1.subName);
		System.out.println("점수 : " + temp.sub1.score);

	}

}
