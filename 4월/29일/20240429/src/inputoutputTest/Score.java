package inputoutputTest;

/*
 *  입출력 
 *   
 *   - 파일은 데이터는 영구적으로 보존 방법중에 하나다
 *     프로그램이 종료되더라도 파일에 저장된 데이터는 
 *     유지!
 *   - 데이터 공유
 *     파일을 사용하여 데이터를 다른 프로그램이나 
 *     시스템과 공유할 수있도록 한다.
 *   - 대용량 데이터를 메모리에 모두 로드하는 것은
 *     비효율적 일 수 있다. 파일입출력을 이용해서
 *     대용량의 데이터를 조금씩 읽고 처리할 수있다.
 */
public class Score {
	private static int count;
	private int idx;
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Score() {

	}

	public Score(String name, int kor, int eng, int math) {
		idx = ++count;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Score.count = count;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "[idx=" + idx + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}

}
