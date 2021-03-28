package boj.step017½ºÅÃ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012°ýÈ£ {
	static int T;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			stack.clear();
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				//System.out.println(stack.toString());
				char c = str.charAt(i);
				if(c=='(') {
					stack.push(c);
				}else if(c==')'){
					if(!stack.isEmpty()&&stack.peek()=='(') {
						stack.pop();
					}else {
						stack.push(c);
					}
				}

			}
			if(stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
