package Function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FunctionTest3 {

	public static void main(String[] args) {
		// 시간에 관한 클래스들
		// Date 클래스
		// DateTime 클래스
		// LocalDateTime 클래스 -> jdk8 이상부터 사용 가능
		
		// 현재 시스템의 날짜와 시간을 얻어온다.
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		// 날짜. 시간 서식을 지정하기
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy년 MM월 E요일");
		
		//LocalDateTime 클래스 안에 내가 만든 날짜 형식을 사용할 수 있다 format(내가만든 형식);
		System.out.println(now.format(format));
		
		// 년, 월, 일, 요일, 시, 분, 초 얻어오기
		System.out.println("년 : " + now.getYear());
		System.out.println("월 : " + now.getMonth());
		System.out.println("일 : " + now.getDayOfMonth());
		System.out.println("요일 : " + now.getDayOfWeek());
		System.out.println("시 : " + now.getHour());
		System.out.println("분 : " + now.getMinute());
		System.out.println("초 : " + now.getSecond());
		
		// Calendar 클래스
		// 날짜, 시간을 가져와서 포멧형식(서식) 지정할 수 있는데 필요한 함수가 있다.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.getTime());
		
		// Date 클래스
		// 포함할 때는 java.util 폴더안에 있는 클래스를 포함
		// 1900년 1월 1일 자정을 기준으로 날짜 데이터를 처리하게끔 설계가 되어있다.
		// Date클래스를 사용하려면 얻어온 값에 1900을 더해서 사용해야함
		Date date = new Date();
		System.out.println(date);
		
		System.out.println("년 : " + (date.getYear() + 1900)); // getYear()에 줄 표시가 뜨는 이유는 다른 버전에서 사용할 시 오류가 날 수도 있다는 의미
		
	}

}
