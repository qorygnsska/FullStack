package Function;

import java.util.Scanner;

public class FunctionTest2 {
	public static String checkPW(String passwd) {
		if(passwd.length() >= 9) {
			return "Good";
		}else if(passwd.length() >= 5) {
			return "Normal";
		}else {
			return "Bad";
		}
	}
	public static void main(String[] args) {
		
		// 문제 1. 비밀번호의 안전성을 측정하는 프로그램 작성
		// 9이상 good, 9미만 5이상 normal, 5미만 bad
		System.out.println("Your Password : " + checkPW("adsasdasd"));
		
	}

}
