package ConstructorTest;

import java.util.Scanner;

// 패키지
// - 디렉토리 구조
// - 폴더를 여러개로 나눠서 관리(클래스들의 중복을 제거하기 위해서)

// 접근 제어자
// - 사용자가 굳이 알 필요없는 정보는 사용자로부터 숨긴다.

// private(비공개)
// - 같은 클래스에서만 사용
// - 선언한 클래스에서만 사용
class Member {
	private String id;
	private String name;
	private String password;
	private String email;
	private char gender;
	private int age;

	
	// 생성자도 자동 생성 가능하다
	// Source -> Generate Constructor using Field... 클릭
	public Member(String id, String name, String password, String email, char gender, int age) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	// this
	// 클래스 멤버를 구별하는 것!
	// 객체를 가리키는 것!(자기 자신의 객체를 가리키는 것)
	// 메서드에서 매개변수 이름이 클래스 멤버변수 이름과 같다면 구분을 못하기 때문에 사용한다.
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	void show() {
		System.out.println(name); // 같은 클래스에서는 접근 가능
	}
}


public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int count;
	
	public static void updateMember(Member[] memberList) {
		// main에서 멤버를 저장하고 있는 배열을 가져왔다
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기    ");
		System.out.println("3. 이메일 수정하기  ");
		System.out.println("9. 메인으로 돌아기기");
		System.out.print("메뉴 번호 : ");
		int sel = sc.nextInt();
		
		if(sel == 1) {
			// id와 pw를 입력 받고 아이디와 패스워드가 배열의 저장이 되어있다면 
			// 변경할 비밀번호를 입력받고 저장하기
			System.out.println("아이디를 입력 : ");
			String id = sc.nextLine();
			
			System.out.println("비밀번호를 입력 : ");
			String password = sc.nextLine();
			
			for(int i = 0; i < count; i++) {
				if(memberList[i].getId().equals(id) &&
				   memberList[i].getPassword().equals(password)) {
					// 새로운 비밀번호 입력!
					System.out.print("새 비밀번호 입력 : ");
					String newPw = sc.nextLine();
					
					memberList[i].setPassword(newPw);
					System.out.println("비밀번호 수정 완료");
				}
			}
			
		}else if(sel == 2) {
			
		}else if(sel == 3) {
			
		}else if(sel == 9) {
			return;
		}

	}
	public static void main(String[] args) {
		
		Member[] memberList = {
				new Member("aaaaa", "박신우", "aa", "aaa@aaa.aaa", 'F', 33),
			    new Member("bbbbb", "강고결", "bb", "bbb@bbb.bbb", 'M', 34),
			    new Member("ccccc", "남나눔", "cc", "ccc@ccc.ccc", 'M', 28),
			    new Member("ddddd", "도대담", "dd", "ddd@ddd.ddd", 'M', 35),
			    new Member("eeeee", "류라라", "ee", "eee@eee.eee", 'F', 17),
			    new Member("fffff", "문미미", "ff", "fff@fff.fff", 'F', 20),
			    new Member("ggggg", "박보배", "gg", "ggg@ggg.ggg", 'M', 26),
			    new Member("hhhhh", "송성실", "hh", "hhh@hhh.hhh", 'M', 41),
			    new Member("iiiii", "윤예의", "ii", "iii@iii.iii", 'F', 28),
			    new Member("jjjjj", "정재주", "jj", "jjj@jjj.jjj", 'M', 23),
			    null, null, null, null
		};
		
		// 멤버의 수를 저장하는 변수
		int count = 10;
		
		while(true) {
			System.out.println("현재 등록회원 수 : " + count + "입니다.");
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 새 회원 등록");
			System.out.println("3. 새 회원 등록");
			System.out.println("4. 새 회원 등록");
			System.out.println("5. 새 회원 등록");
			System.out.println("9. 새 회원 등록");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			
			sc.nextLine(); // 키보드 버퍼 비우기
			
			if(menu == 1) {
				System.out.print("아이디 : ");
				String id = sc.nextLine();
				// 아이디 중복확인
				// 배열에 각각의 공간에 접근해서 비교한다
				boolean check = false;
				for(int i = 0; i < count; i++) {
					if(memberList[i].getId().equals(id)) {
						System.out.println("중복입니다.");
						check = true;
						break;
					}
				}
				if(check == true) {
					continue;
				}
				System.out.print("이름 : ");
				String name = sc.nextLine();
				
				System.out.print("비번 : ");
				String password = sc.nextLine();
				
				System.out.print("이메일 : ");
				String email = sc.nextLine();
				
				System.out.print("성별 : ");
				char gender = sc.nextLine().charAt(0);
				if(gender != 'm' && gender != 'M' && gender != 'f' && gender != 'F') {
					System.out.println("성별을 다시 입력하세요.");
					continue;
				}
				
				System.out.print("나이 : ");
				int age = sc.nextInt();
				
				Member member = new Member(id, name, password, email, gender, age);
				// 배열에 저장하기
				// 배열의 마지막에 추가한다.
				memberList[count] = member;
				System.out.println("정상적으로 추가되었습니다.");
				
			}else if(menu == 2) {
				while(true) {
					System.out.println("1. 아이디로 검색하기");
					System.out.println("2. 이름으로 검색하기");
					System.out.println("3. 이메일로 검색하기");
					System.out.println("9. 메인으로 돌아가기");
					System.out.print("메뉴 : ");
					int sel = sc.nextInt();

					sc.nextLine();

					if (sel == 1) {
						boolean check = false;
						System.out.print("아이디 : ");
						String findId = sc.nextLine();
						for(int i = 0; i < count; i++) {
							// 객체 배열의 아이디
							// 각각의 공간의 아이디를 가지고 와서 저장
							String member = memberList[i].getId();
							if(member.equals(findId)) {
								System.out.println("찾았다");
								System.out.println(memberList[i].getName());
								check = true;
								break;
							}
						}// 만약 데이터를 찾지 못하면 찾는 아이디가 없습니다.
						if(check == false) {
							System.out.println("찾는 아이디가 없습니다.");
							continue;
						}
						
					} else if (sel == 2) {
						boolean check = false;
						System.out.print("이름 : ");
						String findName = sc.nextLine();
						for(int i = 0; i < count; i++) {
							// 객체 배열의 아이디
							// 각각의 공간의 아이디를 가지고 와서 저장
							String member = memberList[i].getName();
							if(member.equals(findName)) {
								System.out.println("찾았다");
								System.out.println(memberList[i].getId());
								check = true;
								break;
							}
						}// 만약 데이터를 찾지 못하면 찾는 아이디가 없습니다.
						if(check == false) {
							System.out.println("찾는 이름이 없습니다.");
							continue;
						}
					} else if (sel == 3) {
						boolean check = false;
						System.out.print("이메일 : ");
						String findEmail = sc.nextLine();
						for(int i = 0; i < count; i++) {
							// 객체 배열의 아이디
							// 각각의 공간의 아이디를 가지고 와서 저장
							String member = memberList[i].getEmail();
							if(member.equals(findEmail)) {
								System.out.println("찾았다");
								System.out.println(memberList[i].getId());
								System.out.println(memberList[i].getName());
								check = true;
								break;
							}
						}// 만약 데이터를 찾지 못하면 찾는 아이디가 없습니다.
						if(check == false) {
							System.out.println("찾는 이메일이 없습니다.");
							continue;
						}
					} else if (sel == 9) {
						break; // 메인메뉴로 돌아가기
					}
				}
				
				
			}else if(menu == 3) {
				updateMember(memberList);
			}else if(menu == 4) {
				
			}else if(menu == 5) {
				
			}else if(menu == 9) {
				
			}else {
				System.out.println("메뉴 제대로 입력하세요!");
			}
			
		}
		
		
		
		
		
	}

}
// --------설명---------
//Member mem1 = new Member("배교훈", "qwer", "123", "12@12", 24, '남');

//System.out.println(mem1.getName());
//System.out.println(mem1.getId());

//mem1.setName("최교훈");
//System.out.println(mem1.getName());

// private
// 다른 클래스에서 직접적인 접근을 막았다.
// mem1.name = "배교훈"; 에러발생

// private 접근 방법
// 1. 생성자
// - 변수를 만들 때 안에 있는 private 멤버들을 초기화 한다
// Member mem1 = new Member("배교훈", "qwer");

// 2. getter() 사용 : 값을 받아올 때
// - 클래스안에 메서드를 만들고 return으로 private 변수 값을 받아온다.
// System.out.println(mem1.getName());

// 3. setter() 사용 : 값을 수정할 때
// - 클래스안에 메서드를 만들어 매개변수로 받아온 값을 private 변수에 저장
// mem1.setName("최교훈");

// getter와 setter는 자동 생성이 가능하다
// 마우스 우클릭 -> source -> Generate getters and setters클릭
