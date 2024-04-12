import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		// 문제 1. 수를 입력받아 짝수인 지 홀수인 지 판별하는 프로그램 작성
		// 무한루프 사용하고 0을 입력하면 exit 출력후 break로 탈출
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			if(num == 0) {
				System.out.println("프로그램 종료");
				break;
			}else if(num % 2 == 0) {
				System.out.println(num + " 짝수 입니다.");
			}else {
				System.out.println(num + " 홀수 입니다.");
			}
		}
		
		
		// 문제 2. 사용자에게 양의 정수 n을 입력 받아 1부터 n까지 짝수들의 합을 구해라
		// for문 사용해서 구해보자
		int sum = 0;
		while (true) {
			System.out.print("양의 정수 n 입력 : ");
			int n = sc.nextInt();
			if (n > 0) {
				for (int i = 1; i <= n; i++) {
					if (i % 2 == 0) {
						sum += i;
					}
					
				}
				break;
			}else {
				System.out.println("자연수를 입력하세요");
			}
		}
		System.out.println("짝수의 합 : " +  sum);
		
		sc.nextLine(); // 버퍼 비우기
		
		// 문제 3. 시험을 치른 후 맞은 개수를 알려주는 프로그램이다. 사용자의 이름과 문제의 개수를 입력하고
		// 문제를 맞혔는지 아닌지를 입력하면 맞은 개수를 출력해준다. for문을 이용해라
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("문제 개수 : ");
		int num = sc.nextInt();
		
		sc.nextLine(); // 버퍼 비우기
		String answer;
		int count = 0;
		
		for(int i = 1; i <= num; i++) {
			System.out.println(i + "번 문제를 해결했나요?(y/n)");
			answer = sc.nextLine();
			if(answer.equals("y")) {
				count += 1;
			}
			
		}
		System.out.println(name + " 학생, 총" + count + " 문제를 해결했습니다.");
	

	}

}
