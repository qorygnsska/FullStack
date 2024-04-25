package Abstract;

// 공통적인 내용을 묶은 것
// 각각의 클래스들한테 상속!

//추상 클래스
//추상메서드 구현부가 없는 메서드
//  {} 즉 몸통이 없는 메서드

//함수는 선언부(타입), 구현부(실행)
// 둘중 하나라도 없으면 미완성된 메서드 

/*
* 접근 제어자 반환타입 함수명 (매개변수 타입){
* 		실행문장;
* }
* 
* 추상메서드를 하나라도 가지고 있는 클래스는 미완성된 클래스로 객체를 생성할 수 없다.
* 
* abstract 키워드를 메서드에 붙인다.
* 정상적인 클래스를 만들 수 없기 때문에 클래스도 abstract 붙여서 사용한다.
* 
* 다른 클래스한테 도움을 줄 목적으로 사용한다.
* 
*/
public abstract class Animal {
	abstract void 운다();

	abstract void play(); 

	abstract void 먹는다();

	
}
