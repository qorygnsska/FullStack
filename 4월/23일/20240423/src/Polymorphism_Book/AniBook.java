package Polymorphism_Book;

public class AniBook extends Book{
	
	private int accessAge;
	
	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
		
	}
	// 오버라이딩
	@Override
	void show() {
		super.show();
		System.out.println("연령제한 : " + accessAge);
	}
		
}

class CookBook extends Book{
	
	private boolean coupon;

	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}
	
	// 오버라이딩
		@Override
		void show() {
			super.show();
			System.out.println("쿠폰 유무 : " + coupon);
		}
	
}


// it도서를 추가하는 클래스
// 채쌤의 자바프로그래밍 핵심
class ItBook extends Book{

	// 동영상쿠폰 유무
	private boolean vdCoupon;
	// 예제 코드 유무
	private boolean exCode;
	public ItBook(String title, String author, String publisher, boolean vdCoupon, boolean exCode) {
		super(title, author, publisher);
		this.vdCoupon = vdCoupon;
		this.exCode = exCode;
	}
	@Override
	void show() {
		super.show();
		System.out.println("동영상 쿠폰 유무 : " + vdCoupon);
		System.out.println("예제 코드 유무 : " + exCode);
	}
	
}








