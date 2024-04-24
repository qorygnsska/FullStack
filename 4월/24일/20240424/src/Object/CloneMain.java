package Object;

// 객체를 복사하기 위해서는 clone 메서드도 오버라이드 해야하지만
// Clonealbe이라는 인터페이스도 구현해야한다
class B implements Cloneable{
	String str;
	
	B(String s){
		str = s;
	}
	
	// 객체를 복사하기 위해서는 clone 메서드 오바리이딩 해야함
	
	// 오버라이딩 할 때는 함수 안에 내용을 변경하는 것도 있지만
	// 단순하게 접근 제어자만 변경할 때도 있다.
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}
public class CloneMain {

	public static void main(String[] args) {
		B ori = new B("hello");
		B copy = null;  
		try {
			copy = (B)ori.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		ori.str = "world";
		System.out.println("원본 : " + ori.str);
		System.out.println("복사본 : " + copy.str);
		
		// clone 메서드
		// - 객체를 깊은 복사
		//   Object클래스 clone() 메서드는 기본적으로 접근 제한자 protected
		
		// protected
		// - 부모클래스에 대해서는 public멤버처럼 취급되는데,
		//   외부에서는 private 멤버처럼 취급된다.
		// - 같은 폴더에서는 모두 접근이 되지만 다른 폴더에서는 접근을 막았다
		
		// protected를 선언한 클래스를 상속한 자식클래스의 멤버만 접근
		
		// 참조변수
		// - 직접적으로 데이터를 저장하는 것!
		// - heap 영역에 저장되어 있는 주소를 저장
		
		// 객체의 복사
		// 1. 얕은 복사
		//  객체의 주소만 복사
		//  원본만 데이터를 수정하려고 해도 복사본까지 수정이 된다
		// 2. 깊은 복사
		//  새로운 공간에 객체의 복사본을 그대로 복사
		//  원본 데이터를 변경해도 복사본까지는 영향이 가지 않는다.

	}

}
