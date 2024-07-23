package com.ss.mvc.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ss.mvc.board.dto.Board;
import com.ss.mvc.board.dto.Reply;
import com.ss.mvc.board.service.BoardService;
import com.ss.mvc.board.util.PageInfo;
import com.ss.mvc.member.dto.Member;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

// 요청 url의 상위 url을 모두 처리할 때 사용
@Slf4j
@RequestMapping("/board") 
@Controller
public class BoardController {

	// BoardService객체를 가져와됨
	@Autowired
	private BoardService service;
	
	
	// Get전송 방식만 처리하는 메서드를 
	// 생성할 수 있다. 
	@GetMapping("/list")
	public String list(Model model,
				@RequestParam 
				Map<String, String> param) {
		System.out.println("boardController 안에 list()실행");
		System.out.println("리스트 요청: "+ param);
		
		// 탐색할 맵을 선언!
		Map<String, String> searchMap
			= new HashMap<String, String>();
		
		try {
			String searchValue = param.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = param.get("searchType");
				searchMap.put(searchType, searchValue);
			}
//			page = Integer.parseInt(param.get("page"));
		} catch (Exception e) {}
		
		
		// 현재 페이지를 기준으로! 검색
			
		
		// 만약에 처음 게시판을 실행했을 때는 
		// 현재 페이지가 없을 수 있다. 
		// nullpointerException 발생할수
		// 있다. 그래서 무조건 page는 1부터 시작
		
		int page = 1;
		// 1. boardService에서 
		//    10개의 데이터를 반환 받아서 
		// 2. model에 담아서 뷰페이지로
		//    전송 
		
		// 현재 밑에 코드는 전체!
		// 혹시 검색어를 이용해서 원하는 검색을 했을때
		// 개수는 달라질 수 있다.
		int boardCount = service
						.getBoardCount(searchMap);
		
		// 3. 현재 페이지를 기준으로  버튼을
		//   클릭했을 때 페이징 처리하는 것!
		PageInfo pageInfo = new PageInfo(page, 10,
							 			boardCount,
							 			10);
		List<Board> list = service
						 .getBoardList(pageInfo
								 	  ,searchMap);
		
		model.addAttribute("list",list);
		model.addAttribute("pageInfo", pageInfo);
		
		// 라디오버튼이 새로고침 되면서 
		// checked가 사라진다. 
		model.addAttribute("param",param);
		return "board/list";
	}
	
	@RequestMapping("/view")
	public String view(Model model,
						int no) {
		System.out.println("BoardController view()");
		System.out.println("no :" +no);
		// 1. boardService를 이용해서
		// 먼저 글 번호가 있는지 확인하는 메서드
		Board board = service.findByNo(no);
		System.out.println(board);
		// 2. mapper인터페이스에 글번호가
		//   있는지 메서드 확인 
		// 3. xml 파일에 sql 실행문 작성
		// 4. 만약 게시글이 없다면 Controller
		//   에서 error페이지로 가기!
		if(board == null) {
			return "common/error";
//			return "redirect:error"
		}		
		
		// 5. 4번까지 했는데 글번호가 있으면 
		// 6. 게시글을 리턴받아서 
		//    view.jsp 로 보내기 
		
		model.addAttribute("board", board);
		model.addAttribute("replyList"
						  , board.getReplies());
		
		return "board/view";
	}
	@RequestMapping("/reply")
	public String writeReply(Model model,
			@SessionAttribute(name="loginMember",
	 			required = false) 
     		Member loginMember,
			@ModelAttribute Reply reply
		 )
	{
		// 1. boardService클래스를
		// 이용해서 댓글을 추가하는 명령문!
		
		reply.setWriterNo(loginMember
				 .getNo());
		
		int result = service.saveReply(reply);
		System.out.println("댓글 추가후: "
								+ result);
		// writerNo작성자의 번호가 
		// 없으면 조인해서 댓글을 가져올 때 
		// 예외가 발생할 수 있다. 
		
		
		System.out.println("Reply:" +
				reply);

		
		if(result > 0) {
			model.addAttribute("msg"
			 , "리플이 등록 되었습니다.");
		}else {
			model.addAttribute("msg"
		  , "리플이 등록에 실패하였습니다.");
		}
		
		// model에 다음 페이지로 갈 페이지명
		// 저장하기 
		model.addAttribute("location", "/board/view?no="+reply.getBoardNo());
		
		return "common/msg";
	}	
	
	// 1. replyDel
	//   url 매핑,매개변수로 replyNo,
	//               boardNo
	// 2. deleteReply 메서드명
	// 3. 서비스에서 리플을 삭제하는 메서드
	// 4. mapper 인터페이스에 메서드 작성
	// 5. xml 태그에 sql구문을 작성 하고 실행
	// 6.int 값으로 리턴 받아서 
	// 7. 모델에 데이터를 저장하고 페이지가 
	// 8. jsp 로 이동했을 전송한 모델안에
	//   필요한 변수값을 꺼내서 사용함.
	// 9. msg.jsp로 이동
	// 10. alert창 띄우고 페이지이동
	//    상세페이지로 이동하기!
	@RequestMapping("/replyDel")
	public String deleteReply(Model model,int replyNo
							 ,int boardNo) {
		System.out.println("deleteReply()");
		System.out.println("r: "+ replyNo +"  "+
				           "b: "+ boardNo);
		
		int result = service
					.deleteReply(replyNo);
		System.out.println("result: " 
							+ result);
		if(result > 0) {
			model.addAttribute("msg"
						,"리플 삭제 되었습니다.");
		}else {
			model.addAttribute("msg"
					,"리플 삭제에 실패하였습니다");
		}
				
		model.addAttribute("location"
			, "/board/view?no="+ boardNo);
		
		
		return "common/msg";
	}
	
	
	
}



