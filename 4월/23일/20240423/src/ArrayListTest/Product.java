package ArrayListTest;

import java.time.LocalDateTime;

public class Product {
	private String name;
	private int Price;
	private LocalDateTime date;
	private int reviewCount;
	
	public Product(String name, int price, LocalDateTime date, int reviewCount) {
		super();
		this.name = name;
		Price = price;
		this.date = date;
		this.reviewCount = reviewCount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", Price=" + Price + ", date=" + date + ", reviewCount=" + reviewCount + "]";
	}
	
	
}

class Clothes extends Product{
	private String size;
	private String color;
	
	public Clothes(String name, int price, LocalDateTime date, int reviewCount, String size, String color) {
		super(name, price, date, reviewCount);
		this.size = size;
		this.color = color;
	}
}

class Food extends Product{
	private LocalDateTime exDate; // 유통기한
	
	public Food(String name, int price, LocalDateTime date, int reviewCount, LocalDateTime exDate) {
		super(name, price, date, reviewCount);
		this.exDate = exDate;
	}
}





