package MVC;

// 데이터 저장, 찾기, 수정, 삭제, 조회
// 처리를 하는 클래스로 사용
public class BookController {
	
	private Book[] bookList = new Book[20];
	// 책의 개수를 저장하는 count 변수가 필요하다
	// 배열의 인덱스로도 사용된다
	private int count = 0;
	
	boolean insert(Book book) {
		boolean result;
		if (count < bookList.length) {
			// 책 저장
			bookList[count] = book;
			// 책이 들어왔으니 책 카운트 올리기
			count++;
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	public Book[] selectList() {
		
		return bookList;
	}
	BookController() {}
	
	public int getCount() {
		return count;
	}
	
	public Book[] searchBook(String keyword) {
		Book[] searchList = {};
		for(int i = 0; i < count; i++) {
			if(bookList[i].getTitle().contains(keyword)) {
				searchList[i] = bookList[i];
			}
		}
		return searchList;
	}
	
}
