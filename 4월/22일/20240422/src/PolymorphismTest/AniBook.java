package PolymorphismTest;

public class AniBook extends Book{
	
	private int accessAge;
	
	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}
		
}

class CookBook extends Book{
	
	private boolean coupon;

	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}
	
}