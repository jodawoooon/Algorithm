package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ¼è¸·´ë±â {
	static int COUNT;
	static char[] arr;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		arr = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			
			if(arr[i]=='(') {
				stack.push(arr[i]);
			}else if(arr[i]==')'){
				if(arr[i-1]==')') {
					if(stack.peek()=='(') {
						stack.pop();
						COUNT += 1;
					}
				}
				else if(stack.peek()=='(') {
					stack.pop();
					COUNT += stack.size();
				}
			}
			
			
		}System.out.println(COUNT);
	}
}
