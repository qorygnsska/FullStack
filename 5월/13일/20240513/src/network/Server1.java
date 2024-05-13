package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

	public static void main(String[] args) {
		
		/*
		 * Socket 클래스
		 * 
		 * TCP통신
		 *  - 연결 기반 프로토콜(전화)
		 *  
		 * 데이터를 보내는 쪽(보통 클라이언트)에서 객체를 생성하여 데이터를 받는 쪽(서버)에서
		 * 클라이언트 요청을 받으면 요청에 대한 Socket 객체를 생성하여 데이터를 처리한다.	 
		 */
		
		// 서버소켓(연결만 받는다.)
		// 소켓(데이터를 주고 받는 역할)
		
		// 서버소켓 생성
		ServerSocket server = null;
		// 통신소켓
		Socket socket = null;
		
		// 클라이언트가 전송한 데이터를 읽는 스캐너생성
		Scanner scan = null;
		
		// 클라이언트에게 데이터를 전송하는 객체
		PrintWriter printWriter = null;
		
		try {
			// 서버 만들기
			// 192.168.100.43의 ip주소를 가지는 10004번 포트를 열어 서버 소켓을 생성
			server = new ServerSocket(10002);
			
			System.out.println("서버 시작 : " + server);
			
			// 클라이언트가 접속하기를 무한정 기다린다.
			// accept() 메서드는 지정한 포트로 클라이언트가 접속하기를 무한 대기한다.
			socket = server.accept();
			System.out.println("클라이언트 접속확인");
			
			// 서버에서 클라이언트에게 데이터를 전송용 객체를 생성
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("어서와!\n");
			printWriter.flush();
			
			// 클라이언트에서 전송되는 데이터를 수신하기 위해 수신용 객체 생성
			scan = new Scanner(socket.getInputStream());
			// 클라이언트에서 전송된 데이터를 읽어서 출력
			System.out.println(scan.nextLine());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 클라이언트와 통신이 종료되면 통신에 사용된 서버소켓과 소켓을 닫는다.
			try {
				socket.close();
				server.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

}
/*
 * 0.0.0.0
 *  모든 ip를 다 받는다.
 * 
 * 
 * 포트 사용중인지 확인하고 싶을 경우
 * 명령프롬프트 -> netstat
 * 
 * java.net.BindException
 *  포트번호를 누군가 사용하고 있는 것!
 *  중복되는 포트번호 에러다!
 *  포트번호를 변경하면 된다.
 */
