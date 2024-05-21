package network;

// 회원가입하는 한 명의 정보를 저장하는 클래스
public class User {
	
	// 이름, 아이디, 패스워드, 폰 번호, 이메일, 생년월일
	private String name;
	private String id;
	private String password;
	private String phone;
	private String email;
	private String birthdate;
	
	public User(String name, String id, String password, String phone, String email, String birthdate) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
	}

	public User() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", password=" + password + ", phone=" + phone + ", email=" + email
				+ ", birthdate=" + birthdate + "]";
	}
	
	
	
	
	
	
	

}
