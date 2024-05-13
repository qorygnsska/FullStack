package network2;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {

	public static void main(String[] args) {
		// 1. 1:1 혹은 양방향 통신을 하기 위해서
		// 서버(데이터를 제공하는 컴퓨터) 내 컴퓨터에 생성
		
		ServerSocket server = null;
		Socket socket = null;
		Scanner input = null;
		Scanner output = null;
		PrintWriter printWriter = null;
		
		try {
			server = new ServerSocket(10003);
			System.out.println("클라이언트 기다리는중");
			socket = server.accept();
			
			// 데이터를 송수신에 사용할 객체를 생성
			printWriter = new PrintWriter(socket.getOutputStream());
			
			// 데이터 읽기
			input = new Scanner(socket.getInputStream());
			
			// 데이터 보내기
			output = new Scanner(System.in);
			
			printWriter.write("어서와\n");
			
			// 메시지 전송
			printWriter.flush();
			
			// 키보드로 입력한 메시지 또는 클라이언트가 보내온 메시지 중 BYE면 통신 끝
			String msg = "";
			do {
				// 클라이언트에서 전송된 메시지를 출력
				msg = input.nextLine();
				System.out.println("client >> " + msg);
				
				// 만약 bye가 아니면 클라이언트한테 보내는 메시지 입력
				System.out.print("server?>> ");
				msg = output.nextLine().trim();
				
				// 입력받은 메시지 클라이언트에게 전송
				printWriter.write(msg + "\n");
				printWriter.flush();
				
			} while (!msg.toUpperCase().equals("BYE"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
/*
 *  TCP
 *   연결기반 연결후 통신(전화기 ) 1:1통신방식
 *   데이터의 경계 구분 안함 
 *   신뢰성있는 데이터를 전송 
 *   
 *  UDP
 *   비 연결기반 통신, 연결없이 통신(택배)
 *   다운로드 할떄 주로 사용한다.
 
 	Port 
 	 IP로 컴퓨터를 찾아가서 어떤 프로그램을 실행시킬지
 	 선택하는 역할 
 	 port 충돌시 나중에 실행되는 프로그램은 실행 안됨!
    
 */
