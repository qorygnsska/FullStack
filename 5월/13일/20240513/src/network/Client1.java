package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {
		
		// 통신 소켓
		Socket socket = null;
		
		// 서버에서 전송되는 데이터를 읽는 Scanner
		Scanner scan = null;
		
		// 서버로 데이터를 전송하는 PrintWriter
		PrintWriter printWriter = null;
		
		try {
			// 데이터를 제공하는 서버에 접속
			System.out.println("192.168.100.43 10002포트로 접속시도!");
			
			// 서버 ip주소 => host, port
			socket = new Socket("192.168.100.43", 10002);
			
			// 서버에서 전송되는 데이터를 수신하기 위해 수신용 객체를 생성한다.
			scan = new Scanner(socket.getInputStream());
			
			// 서버에서 전송된 데이터를 읽어서 출력한다.
			printWriter = new PrintWriter(socket.getOutputStream());
			
			// 서버에서 보내온 데이터를 읽어서 출력한다.
			System.out.println(scan.nextLine());
			
			// 클라이언트에서 서버로 메시지를 전송한다
			// 반드시 문자의 끝에 알려주기 위해서 개행 문자(\n)을 붙여준다
			printWriter.write("어련히 알아서 올까봐!!\n");
			
			// 버퍼가 가득 차지 않아도 데이터를 전송할 수 있는 메서드
			printWriter.flush();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 예외가 발생하든 안하든 무조건 통신한 포트스트림들은 무조건 닫는다.
			try {
				socket.close();
				// 예외 무시
			} catch (IOException e) {}
			
		}

	}

}
