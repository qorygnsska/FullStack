package networkChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 특정 클라이언트에서 입력한 모든 메시지를
// 자신을 포함해서 모든 클라이언트에게 전송하는 클래스

public class MultiChatThread extends Thread {

	// 서버에서 접속한 모든 클라이언트의 목록 가지고 있어야
	// 특정 클라이언트에서 보낸 메시지를 다른 사람에게 보낼 수 있다.
	// 여러 스레드가 한꺼번에 들어와도 충돌 되지 않게 안전하게 요소를 추가 혹은 삭제할 수 있도록 만들어진 메서드!
	static List<PrintWriter> chatList = Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket;
	PrintWriter printWriter;

	public MultiChatThread(Socket socket) {
		this.socket = socket;

		try {
			// 생성자의 인수로 넘겨받은 소켓으로 클라이언트 메시지를 전송할 때 사용하는 PrintWriter 클래스 객체 생성
			printWriter = new PrintWriter(socket.getOutputStream());

			// 클라이언트의 접속 ip 주소랑 포트번호를 출력
			// getLocalAddress()
			// - 특정 호스트에 연결할 때 해당 호스트의 ip를 반환
			System.out.println(socket.getLocalAddress() + "(" + socket.getPort() + ")");

			// 특정 클라이언트에서 입력된 메시지를 전송할 모든 클라이언트 목록을 기억하는 chatList에 저장
			chatList.add(printWriter);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// 여러명을 구별할 수 있는 대화명 변수를 만든다.
		String name = "";

		// 대용량의 데이터를 한꺼번에 읽어올 때
		// Scanner는 버퍼의 크기를 조절할 수 없다.
		// 간단한 문장을 읽어오거나 정수나 실수를 읽어올 때는 사용이 가능하지만
		// 채팅프로그램이나 파일을 읽어올 때는
		// BufferedReader 클래스를 이용해서 읽어오는 것이 더 효율적이다.
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 접속한 모든 클라이언트가 처음 입력하는 메시지는 대화명으로 사용
			// readLine() 한 줄 가져오기
			name = reader.readLine();

			// 새로운 클라이언트가 서버에 접속하면 모든 클라이언트(서버에 접속중인) 메시지 전송하기
			for (PrintWriter pw : chatList) {
				pw.write("#" + name + "# 님이 접속 했습니다.");
				pw.flush();
			}

			// 서버에 접속된 모든 클라이언트가 입력하는 2번째 메시지부터는 채팅 메시지를 작성
			// 채팅이 끝날 때까지 계속 반복하면서 모든 클라이언트에게 메시지를 보내면 된다.
			while (true) {

				// 특정 클라이언트에서 입력한 채팅 메시지를 받는다.
				String msg = "";

				msg = reader.readLine();
				// 채팅창을 닫아서 메시지를 받지 못하면 무한 루프 멈춤
				if (msg == null) {
					break;
				}
				// 정상적으로 채팅 메시지가 입력된 경우 서버에 접속한 모든 클라이언트 들에게 메시지를 전송
				for (PrintWriter pw : chatList) {
					pw.write("[" + name + "]>> " + msg + "\n");
					pw.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 서버에서 접속한 특정 클라이언트가 채팅창을 닫았거나 오류로 인해 채팅이 중지된 경우 채팅목록에서 제거
			chatList.remove(printWriter);
			
			// 자신이 제외된 모든 접속자에게 채팅을 종료했다는 메시지 전송
			
			// 소켓을 닫으면 된다.
		}
	}

}
