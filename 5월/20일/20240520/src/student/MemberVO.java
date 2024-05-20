package student;

// 학생들의 대한 정보를 저장하는 클래스
// 한 건의 값을 저장하는 클래스!
// 
public class MemberVO {

	private String hakbun;
	private String passwd;
	private String name;
	private String address;
	private String tel;
	private String email;
	private int major;
	private int grade;
	private int hakjom;

	public MemberVO() {
	}

	// 로그인을 할 때 학번과 비밀번호를 저장하는
	// 생성자

	public MemberVO(String hakbun, String passwd) {
		this.hakbun = hakbun;
		this.passwd = passwd;
	}

	public MemberVO(String hakbun, String passwd, String name, String address, String tel, String email, int major,
			int grade, int hakjom) {
		this.hakbun = hakbun;
		this.passwd = passwd;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.major = major;
		this.grade = grade;
		this.hakjom = hakjom;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getHakjom() {
		return hakjom;
	}

	public void setHakjom(int hakjom) {
		this.hakjom = hakjom;
	}

}
