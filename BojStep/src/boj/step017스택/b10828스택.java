package boj.step017스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b10828스택 {
	static int N;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.contains("push")) {
				StringTokenizer st = new StringTokenizer(str);
				String tmp = st.nextToken();
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(str.contains("top")){
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			}else if(str.contains("size")){
				System.out.println(stack.size());
			}else if(str.contains("pop")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			}else {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
		}
		
	}
}
