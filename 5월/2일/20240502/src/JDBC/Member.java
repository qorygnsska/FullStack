package JDBC;

import java.time.LocalDateTime;

public class Member {

	private int member_no;
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_gender;
	private int member_point;
	private LocalDateTime member_reg_date;
	
	public Member() {}
	
	public Member(int member_no, String member_id, String member_pw, String member_name, String member_gender,
			int member_point, LocalDateTime member_reg_date) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_gender = member_gender;
		this.member_point = member_point;
		this.member_reg_date = member_reg_date;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public int getMember_point() {
		return member_point;
	}

	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}

	public LocalDateTime getMember_reg_date() {
		return member_reg_date;
	}

	public void setMember_reg_date(LocalDateTime member_reg_date) {
		this.member_reg_date = member_reg_date;
	}

	@Override
	public String toString() {
		return "[member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", member_name=" + member_name + ", member_gender=" + member_gender + ", member_point=" + member_point
				+ ", member_reg_date=" + member_reg_date + "]\n";
	}

	
}
