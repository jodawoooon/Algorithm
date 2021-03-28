package boj.step017스택;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
//짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
public class b4949균형잡힌세상 {
	static String str;
	static boolean check;
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("4949input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			stack.clear();
			check = true;
			str = br.readLine();
			if(str.equals(".")) break;


			for(int i =0;i<str.length(); i++) {
				char c = str.charAt(i);
				if(c=='('||c=='[') {
					stack.push(c);
					//System.out.println(stack);
				}
				else if(c==')') {
					if(!stack.isEmpty()) {
						if(stack.peek()=='(') {
							stack.pop();
						}else check=false;
					}else check=false;
				}
				else if(c==']') {
					if(!stack.isEmpty()) {
						if(stack.peek()=='[') {
							stack.pop();
						}else check=false;
					}else check=false;
				}
			}
			if(stack.isEmpty()&&check) System.out.println("yes");
			else System.out.println("no");
		}
		
	}
}
