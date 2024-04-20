package MVC;

// 책 한권의 정보를 저장하는 클래스
public class Book {
	private String title;
	private String author;
	private String category;
	int price;
	
	// 기본 생성자
	public Book() {}
	
	// 매개변수를 받는 생성자
	public Book(String title, String author, String category, int price) {
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void show() {
		System.out.println("책 이름 : " + title +
				", 책 가격 : " + price +
				", 책 분류 : " + category +
				", 책 저자 : " + author);
	}
	
}
