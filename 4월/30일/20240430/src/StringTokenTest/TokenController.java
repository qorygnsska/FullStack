package StringTokenTest;

import java.util.StringTokenizer;

public class TokenController {
	
	public String afterToken(String str) {
		String result = "";
		StringTokenizer st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens())
			result += st.nextToken();
		return result;
		
	}
	
	public String firstCap(String input) {
		String input2 = input.substring(0, 1).toUpperCase() + input.substring(1);
		return input2;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == one) {
				count++;
			}
		}
		
		return count;
	}
}
