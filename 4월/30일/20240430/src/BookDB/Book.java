package BookDB;

public class Book {
	/*
	 * 시간에 관한 DateTime 변수 만들지 말기
	 * book_no  책의 고유 번호
	 * book_kind 책의 종류 
	 * book_title 책의 제목
	 * book_price 책의 가격
	 * book_count 책의 재고 수량
	 * book_author 책의 저자
	 * book_publishing 출판사
	 * book_image 책의 이미지 
	 * book_count 책의 내용
	 * book_discount_rate 책의 할인율
	 */
	private Integer book_no;
	private String book_kind;
	private String book_title;
	private Integer price;
	private Integer count;
	private String author;
	private String book_publishing_com;
	private String book_publishing_date;
	private String book_image;
	private String book_content;
	private Integer book_discount_rate;
	
	public Book(Integer book_no, String book_kind, String book_title, Integer price, Integer count, String author,
			String book_publishing_com, String book_publishing_date, String book_image, String book_content,
			Integer book_discount_rate) {
		super();
		this.book_no = book_no;
		this.book_kind = book_kind;
		this.book_title = book_title;
		this.price = price;
		this.count = count;
		this.author = author;
		this.book_publishing_com = book_publishing_com;
		this.book_publishing_date = book_publishing_date;
		this.book_image = book_image;
		this.book_content = book_content;
		this.book_discount_rate = book_discount_rate;
	}

	@Override
	public String toString() {
		return "[book_no=" + book_no + ", book_kind=" + book_kind + ", book_title=" + book_title + ", price="
				+ price + ", count=" + count + ", author=" + author + ", book_publishing_com=" + book_publishing_com
				+ ", book_publishing_date=" + book_publishing_date + ", book_image=" + book_image + ", book_content="
				+ book_content + ", book_discount_rate=" + book_discount_rate + "]";
	}
	
	
	
	
	

}
