package ClassArray;

class Student {
	String name;
	String subject;
	int score;

}

public class ClassArrayEx2 {

	public static void main(String[] args) {

//		// 학생 객체 생성 및 초기화
//        Student stu1 = new Student();
//        stu1.name = "김길동";
//        stu1.subject = "자바";
//        stu1.score = 100;
//        
//        if(stu1.equals("이길동")) {
//        	System.out.println(stu1.name);
//        }else {
//        	System.out.println("아닌데?");
//        }
//        
//        if(stu1.score >= 60) {
//        	System.out.println("통과");
//        }else {
//        	System.out.println("재시험");
//        }
//        
//
//        Student stu2 = new Student();
//        stu2.name = "박길동";
//        stu2.subject = "디비";
//        stu2.score = 50;
//        if(stu2.equals("이길동")) {
//        	System.out.println(stu2.name);
//        }else {
//        	System.out.println("아닌데?");
//        }
//
//        if(stu2.score >= 60) {
//        	System.out.println("통과");
//        }else {
//        	System.out.println("재시험");
//        }
//        Student stu3 = new Student();
//        stu3.name = "이길동";
//        stu3.subject = "화면";
//        stu3.score = 85;
//        
//        if(stu3.equals("이길동")) {
//        	System.out.println(stu3.name);
//        }else {
//        	System.out.println("아닌데?");
//        }
//
//        if(stu3.score >= 60) {
//        	System.out.println("통과");
//        	
//        }else {
//        	System.out.println("재시험");
//        }
//        Student stu4 = new Student();
//        stu4.name = "정길동";
//        stu4.subject = "서버";
//        stu4.score = 60;
//
//        if(stu4.equals("이길동")) {
//        	System.out.println(stu4.name);
//        }else {
//        	System.out.println("아닌데?");
//        }
//        if(stu4.score >= 60) {
//        	System.out.println("통과");
//        }else {
//        	System.out.println("재시험");
//        }
//        Student stu5 = new Student();
//        stu5.name = "홍길동";
//        stu5.subject = "자바";
//        stu5.score = 20;
//        if(stu5.equals("이길동")) {
//        	System.out.println(stu5.name);
//        }else {
//        	System.out.println("아닌데?");
//        }
//        if(stu5.score >= 60) {
//        	System.out.println("통과");
//        }else {
//        	System.out.println("재시험");
//        }
//        // 위에 있는 학생의 이름중에 이길동 있니?
//        // 이길동의 정보를 출력해라!
//        
//        // 위에처럼 코드를 작성하면 가독성
//        // 변경,추가,삭제 하기가 너무 힘들다(유지보수)
//        
//		// 학생 객체 생성 및 초기화
		Student stu1 = new Student();
		stu1.name = "김길동";
		stu1.subject = "자바";
		stu1.score = 100;

		Student stu2 = new Student();
		stu2.name = "박길동";
		stu2.subject = "디비";
		stu2.score = 50;

		Student stu3 = new Student();
		stu3.name = "이길동";
		stu3.subject = "화면";
		stu3.score = 85;

		Student stu4 = new Student();
		stu4.name = "정길동";
		stu4.subject = "서버";
		stu4.score = 60;

		Student stu5 = new Student();
		stu5.name = "홍길동";
		stu5.subject = "자바";
		stu5.score = 20;

		// 한 곳에 모아놓자!
		Student[] stuList = new Student[5];

		stuList[0] = stu1;
		stuList[1] = stu2;
		stuList[2] = stu3;
		stuList[3] = stu4;
		stuList[4] = stu5;
		

		// 반복
		for (int i = 0; i < stuList.length; i++) {
			if (stuList[i].name.equals("이길동")) {
				System.out.println(stuList[i].name);
			} else {
				System.out.println("아닌데?");
			}
		}

		// 성적이 60점 미만 재시험 대상
		// 통과
		// 1번째 학생: 통과
		// 2번째 학생: 재시험..
		for (int i = 0; i < stuList.length; i++) {

			if (stuList[i].score >= 60) {
				System.out.println("통과");
			} else {
				System.out.println("재시험");
			}

		}

	}
}