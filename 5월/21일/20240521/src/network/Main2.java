package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	private static MovieService service = new MovieService();
	private static UserService uservice = new UserService();
	private static TicketService ticketService = new TicketService();
	private static Scanner sc = new Scanner(System.in);

	// 로그인된 유저를 저장
	private static User loginUser = null;

	public static void main(String[] args) {
		/*
		 * 데이터베이스에 영화 정보가 있으면 Mainmenu 메서드 실행 만약에 데이터베이스에 영화 정보가 없으면 init 메서드 실행해서
		 * 데이터베이스에 저장하고 Mainmenu 메서드 실행
		 */
		try {
			if (!hasMovieData()) {
				init();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mainMenu();

	}

	// 데이터가 있는 지 확인하는 메서드
	public static boolean hasMovieData() throws Exception {

		return service.hasMovieData();

	}

	public static void mainMenu() {
		int menu = 0;

		/*
		 * 1. 영화 목록 보기 2. 로그인 3. 회원 가입 4.영화 예매
		 */
		while (true) {
			System.out.println("============= Main =============");
			System.out.println("1. 영화 목록 보기");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 가입");
			System.out.println("4. 영화 예매");
			System.out.println("5. 구매 목록");
			System.out.println("6. 종료");
			System.out.print("메뉴를 입력 : ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				break;

			case 2:
				loginUser = uservice.login();

				if (loginUser == null) {
					System.out.println();
				} else {
					System.out.println(loginUser);
				}
				break;

			case 3:
				uservice.signup();
				break;

			case 4:
				try {
					reservation();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				buylist();
				return;

			case 6:
				System.out.println("프로그램 종료");
				return;

			default:
				System.out.println("1~6까지의 번호를 선택하세요");
				break;
			}

		}

	}
	
	// 구매 목록을 확인하는 메서드
	private static void buylist() throws Exception{
		// 구매 목록을 출력할 때
		// 티켓을 구매한 사람의 이름을 출력
		ticketService.select();
		
	}

	private static void reservation() throws Exception {
		ArrayList<Movie> movielist = service.select();
		if (loginUser != null) {
			System.out.printf("%-5s %-30s %-15s%n", "순위", "영화명", "개봉일");
			System.out.println("----------------------------------------------------------");
			if (movielist != null && !movielist.isEmpty()) {
				for (Movie movie : movielist) {
					System.out.printf("%-5s %-30s %-15s%n", movie.getRank(), movie.getMovieNm(), movie.getOpenDt());
				}
				System.out.println();
				
				sc.nextLine();
				// 티켓 구매 시 입력할 데이터
				System.out.print("영화명 : ");
				String name = sc.nextLine();
				
				System.out.print("인원 수 : ");
				int count = sc.nextInt();
				
				sc.nextLine();
				
				System.out.print("시간(ex) 5월 16일 오후 7시) : ");
				String time = sc.nextLine();
				
				System.out.print("좌석(ex) G열 1번) : ");
				String seat = sc.nextLine();
				
				boolean result = ticketService.insert(new Ticket(loginUser.getId(), name, time, count, seat));
				
				if(result) {
					System.out.println("정상적으로 구매 완료 되었습니다!");
				}else {
					System.out.println("구매 실패");
				}
				
			}else {
				System.out.println("영화 정보가 없습니다!");
			}
		} else {
			System.out.println("로그인을 하셔야합니다!");
		}

	}

	// 만약 디비에 데이터가 없다면 init()
	// 메서드를 이용해서 영화 정보를 웹에서 가져오는 메서드
	public static void init() {
		// 자바에서 네트워크 통신을 이용해서
		// 직접 읽어 드려서 데이터 분리할 것!
		// 클래스에 저장해서 DB에 저장

		try {

			// 1.url을 만들기 위한 문자열 객체가
			// 필요하다!
			StringBuilder urlBuilder = new StringBuilder(
					"http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?");

			// 2. api의 요청할 때 같이 저장하는
			// 변수의 값들을 저장 해야된다. 발급키
			// 영문자나 숫자는 상관없는데 한글 같은 경우에는
			// url에 보내면 1byte단위로 변환하기 때문에
			// 한글을 에러 발생할 수있다. utf-8
			urlBuilder.append(URLEncoder.encode("key", "UTF-8") + "=f5eef3421c602c6cb7ea224104795888");
			urlBuilder.append(
					"&" + URLEncoder.encode("targetDt", "UTF-8") + "=" + URLEncoder.encode("20240520", "UTF-8"));

			// 3. url 객체 생성
			URL url = new URL(urlBuilder.toString());

			// 4. 요청하고 하는 URL 통신하기위한 Connection 객체 생성
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// 5. 통신을 위한 메서드(전송방식)
			// get url에 내가 작성한 변수값들이 모두 보인다
			// post url만 보임
			conn.setRequestMethod("GET");

			// 6. 통신 응답 코드 확인
			System.out.println("응답 코드 : " + conn.getResponseCode());

			// 7. 만약 에러코드가 발생할 경우는 꺼내오면 안됨
			BufferedReader rd;
			if (conn.getResponseCode() == 200) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			// 9/ 저장된 데이터를 라인별로(한 줄씩) 읽어들이기
			StringBuilder sb = new StringBuilder();
			String line;
			// 문자가 저장되는데 다음 읽을 데이터가 없으면 null
			while (true) {
				line = rd.readLine();

				// 만약 line이 null이면 멈춤
				if (line == null) {
					break;
				}

				sb.append(line);
			}

			// 10. 객체 해제
			rd.close();
			conn.disconnect();

			// 11. 전달된 데이터 확인
			System.out.println(sb.toString());

			// 12. 전달된 데이터를 이용해서 클래스에 저장하는 내용을 작성하기!
			// movieservice로 넘겨서 insert() 메서드 안에서 데이터를
			// ArrayList 타입으로 저장하고 movieDAO로 넘겨서 데이터베이스에 저장
			service.insert(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
