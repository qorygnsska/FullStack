import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		// 2차원 배열
		// 이름을 저장하는 배열 생성
		// 5개를 저장

		String[] nameList = { "이서희", "이익준", "채송화", "김준완", "양석형" };

		System.out.println(Arrays.toString(nameList));

		String[] info = { "이서희", "A" };
		String[] info2 = { "이익준", "O" };
		String[] info3 = { "채송화", "B" };
		String[] info4 = { "김준완", "AB" };
		String[] info5 = { "양석형", "O" };

	}

}
