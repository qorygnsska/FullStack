import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문제 1. 10번 찍어 안 넘어가는 나무 없다. 라는 속담을 while 이용하여 출력
		int i = 1;
		while(i <= 10) {
			System.out.println("나무를 " + i + " 번 찍었다.");
			i++;
		}
		System.out.println("나무가 넘어갔다.");
		
		System.out.println();
		
		// 문제 2. 한 층과 다음 층 사이에 8개의 계단이 있다, 1층에서 2층으로 한 계단씩 올라가는 프로그램 while
		int j = 1;
		while(j <= 8) {
			System.out.println("계단을 " + j + " 칸 올라갔습니다.");
			j++;
		}
		System.out.println("다음 층에 도착하였습니다.");
		
		System.out.println();
		
		// 문제 3. 양의 정수들의 덧셈을 수행, 더하고자 하는 숫자들 입력 후 0을 입력하면 입력종료, 앞서 입력한 숫자들을 더하여 출력 while 사용
		int sum = 0;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int n = sc.nextInt();
			sum += n;
			if(n == 0) {
				break;
			}
		}
		System.out.println("입력한 숫자들의 합 : " + sum);
		
		System.out.println();
		
		
		// 문제 4. 두 정수 A, B를 입력받고, A+B를 출력하는 프로그램 작성
		System.out.print("몇 번 반복? : ");
		int count = sc.nextInt();
		int start = 1;
		int sum2 = 0;
		while(count >= start) {
			System.out.print("A, B 입력 : ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum = a + b;
			System.out.println("Case #" + start + " : " + sum);
			start++;
		}
		
		System.out.println();
		
		// 문제 5. 두 정수 A B 입력 받은다음 A+B 출력
		System.out.print("몇 번 반복? : ");
		int T = sc.nextInt();
		int start2 = 1;
		int sum3 = 0;
		while(T >= start2) {
			System.out.print("A, B 입력 : ");
			int a2 = sc.nextInt(), b2 = sc.nextInt();
			sum3 = a2 + b2;
			System.out.println("Case #" + start2 + " : " + a2 + " + " + b2 + " = " + sum3);
			start2++;
		}
		
		System.out.println();
		
		// 문제 6. 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째에는 별 N개를 찍는 문제
		System.out.print("별 몇줄 찍을래? : ");
		int star = sc.nextInt();
		for(int s = 1; s <= star; s++) {
			for(int s2 = 1; s2 <=s; s2++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 문제 7. 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째에는 별 N개를 찍는 문제 하지만 오른쪽을 기준으로 정렬한 별
		System.out.print("별 몇줄 찍을래? : ");
		int star2 = sc.nextInt();
		for(int r = 1; r <= star2; r++) {
			for(int r2 = 1; r2 <= star2 - r; r2++) {
				System.out.print(" ");
			}
			for(int r3 = 1; r3 <= r; r3++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
