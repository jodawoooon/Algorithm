package boj.step017스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10773제로 {
	static int K, sum;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		for (int k = 0; k < K; k++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp==0) {
				stack.pop();
			}else {
				stack.push(tmp);
			}
		}

		
		while(!stack.isEmpty()) {
			sum = sum + stack.pop();
			
		}
		System.out.println(sum);
	}
}
