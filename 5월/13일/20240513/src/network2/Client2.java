package network2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

	public static void main(String[] args) {
		// 간단한 대화하기!
		
		Socket socket = null;
		
		// 문자 전송을 쉽게하기 위해서 사용하는 클래스
		PrintWriter printWriter = null;
		
		// 키보드로 입력(서버로 전송할 메시지를 입력)
		Scanner input = null;
		
		// 소켓에서 데이터를 꺼내기!
		Scanner output = null;
		
		try {
			socket = new Socket("192.168.100.43", 10003);
			
			System.out.println("접속 성공 : " + socket);
			
			// 데이터 송수신에 사용할 객체들을 선언
			printWriter = new PrintWriter(socket.getOutputStream());
			
			input = new Scanner(System.in);
			output = new Scanner(socket.getInputStream());
			
			// 서버에서 넘어온 접속 확인 메시지 출력
			System.out.println(output.nextLine());
			
			// 서버에서 접속이 되면 키보드로 입력한 메시지 또는 서버에서 전송받는 메시지가
			// BYE면 통신을 끝낸다.
			
			// 서버로 메시지를 전송하는 명령문
			String msg = "";
			
			do {
				
				// 서버로 전송할 메시지를 입력받는다
				System.out.print("client>> ");
				msg = input.nextLine().trim();
				
				// 입력받은 메시지를 서버로 전송
				printWriter.write(msg + "\n");
				printWriter.flush();
				
				msg = output.nextLine();
				System.out.println("server>> " + msg);
			} while (!msg.toUpperCase().equals("BYE"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {socket.close();}
			catch (IOException e) {}
		}

	}

}

/*
 * 
 *   System 클래스의 표준 입출력 멤버
 *   System.out : 표준 출력(모니터)스트림
 *   System.in  : 표준 입력(키보드)스트림
 *   System.err : 표준 에러 출력(모니트)스트림
 *   
 *   스트림(연결 통로) 
 *   단방향,양방향(소켓)
 * 
 * 
 * 
 */
