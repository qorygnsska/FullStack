package fileupload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadOK.nhn")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		servlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		servlet(request, response);
	}

	protected void servlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 한글 깨짐
		request.setCharacterEncoding("UTF-8");
		
		try {
			// enctype 속성이 multipart/form-data
			// 넘어온 데이터를 받으려면 MultipartRequest
			// 를 지원하는 객체로 받으면 된다.
			MultipartRequest mr = new MultipartRequest(
					request, // 클라이언트의 요청 객체
					getServletContext().getRealPath("./upload/"), // 파일이 업로드 될 실제 경로
					10 * 1024 * 1024, // 업로드 될 최대 파일 크기설정
					"UTF-8", // 인코딩 방식
					new DefaultFileRenamePolicy() // 업로드 되는 파일과 upload 폴더에 같은 이름이 있으면 자동으로
												  // 변경해주는 객체!
					);
			// 업로드 된 파일 정보 가져오기
			String fileName = mr.getFilesystemName("filename");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
