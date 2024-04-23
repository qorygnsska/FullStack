package ArrayList_Book;

public class AniBook extends Book{
	
	private int accessAge;
	
	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
		
	}

	@Override
	public String toString() {
		return "AniBook [accessAge=" + accessAge + ", toString()=" + super.toString() + "]";
	}
	
	
		
}

class CookBook extends Book{
	
	private boolean coupon;

	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "CookBook [coupon=" + coupon + ", toString()=" + super.toString() + "]";
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
	public String toString() {
		return "ItBook [vdCoupon=" + vdCoupon + ", exCode=" + exCode + ", toString()=" + super.toString() + "]";
	}
	
	
}








