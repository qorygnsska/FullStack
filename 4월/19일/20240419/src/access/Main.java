package access;

import accessTest1.Info;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * public(전체 공개)
		 * - 같은 폴더에서도 접근이 가능
		 * - 다른 폴더에서도 접근이 가능
		 * - 같은 폴더든 다른 폴더에서든 객체를 생성할 수 있음
		 * - 클래스 안에 변수들도 접근 제한자를 붙일 수 있고 클래스에다가도 접근 제한자를 붙일 수 있다.
		 * - 다른 폴더에서 객체를 생성할 경우에는 경로를  import 해야한다.
		 * 
		 * - 단! public class 클래스명{}
		 *   .java파일명과 클래스명이 똑같아야된다!!
		 *   그래서 하나의 자바파일에서 public class 하나밖에 작성 못한다.
		 */
		
		
		// accessTest 패키지 안의 클래스
		// 가지고 와서 객체 생성
		Info info1 = new Info();
		info1.age = 10;
		info1.name = "배교훈";
		//info1.age2 = 20; -> ag2가 default로 선언되어서 사용 불가
		System.out.println(info1.name + " " + info1.age);

	}

}
