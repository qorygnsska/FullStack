package Properties;

// VO(Value Object)
// 사용자 정보 데이터 1건과 데이터를 처리할 수 있는 메서드를 모아놓은 클래스
// DTO 라고도 함
public class UserInfo {
	private String userID;
	private String userName;
	private String userPassword;
	
	public UserInfo() {}
	
	public UserInfo(String userID, String userName, String userPassword) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "UserInfo [userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
	
}
