import java.util.Scanner;

public class Size {

	public static void main(String[] args) {
		
		// 사람의 덩치를 담은 배열 people이 주어질 때 유니폼 사이즈 수를 s, m, l, xl 순으로 배열에 담아 출력
		// people의 길이는 1 이상 100 이하의 자연수
		// 사람들의 덩치는 80 이상 120 이하인 자연수
		Scanner sc = new Scanner(System.in);
		boolean result = true;
		int num = 0; // 사람 숫자 변수
		System.out.println("|     덩치           |  사이즈    |");
		System.out.println("| ----------- |--------|");
		System.out.println("|    95 미만       |   S    |");
		System.out.println("| 95이상 100 미만|   M    |");
		System.out.println("|100이상 105 미만|   L    |");
		System.out.println("|    105이상       |   XL   |");
		System.out.println();
		while(result) {
			System.out.print("인원 입력(1~100) : ");
			num = sc.nextInt();
			if(num >= 1 && num <= 100) {
				result = false;
			}else {
				System.out.println("인원은 1명 이상 100명 이하입니다.");
			}
		}
		int[] people = new int[num];
		int[] size = new int[4];
		for(int i = 0; i < people.length; i++) {
			System.out.print("덩치를 입력 : ");
			people[i] = sc.nextInt();
			if(people[i] <= 120 && people[i] >= 80) {
				if(people[i] >= 105) {
					size[3] += 1;
				}else if(people[i] >= 100) {
					size[2] += 1;
				}
				else if(people[i] >= 95) {
					size[1] += 1;
				}else {
					size[0] += 1;
				}
			}else {
				System.out.println("덩치를 다시 입력하세요");
				i--;
			}
		}
		System.out.println("|      people     |   return   |");
		System.out.println("|-----------------|------------|");
		System.out.print("| [ ");
		for(int j = 0; j < people.length; j++) {
			System.out.print(people[j] + " ");
		}
		System.out.print("] | [ ");
		for(int p = 0; p < size.length; p++) {
			System.out.print(size[p] + " ");
		}
		System.out.println("] |");
		
		
		

	}

}
