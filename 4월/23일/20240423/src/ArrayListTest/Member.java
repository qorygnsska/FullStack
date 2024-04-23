package ArrayListTest;

import java.util.ArrayList;

public class Member {
	
	   private String email;
	   private String pass;
	   private String name;
	   private String phone;
	   
	   // 장바구니에 물건을 담는다.
	   // 어떤 물건이든 담을 수 있어야한다
	   // 업캐스팅
	   ArrayList<Product> cart = new ArrayList<Product>();
	   
	public Member(String email, String pass, String name, String phone) {
		super();
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", pass=" + pass + ", name=" + name + ", phone=" + phone + "]";
	}
	
	   
	   
	
}

class Vip extends Member{
	private double point;
	private double discount;
	private int couponCount;
	
	public Vip(String email, String pass, String name, String phone, double point, double discount, int couponCount) {
		super(email, pass, name, phone);
		this.point = point;
		this.discount = discount;
		this.couponCount = couponCount;
	}
}
