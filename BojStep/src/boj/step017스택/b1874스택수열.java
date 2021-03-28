package boj.step017스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874스택수열 {

/*	1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
	이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
	임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
	있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
	이를 계산하는 프로그램을 작성하라.*/
	
	// 4 3 6 8 7 5 2 1
	// 오름차수 push -> pop을 하더라도 몇까지 push했는지 기억해야한다 . -> cnt 변수
	
	//만약 tmp가 cnt보다 크면. (입력받은값이 아직 push한적 없으면)
	// stack에 tmp까지 push하고 stack의 top을 pop한다.
	//만약 tmp가 cnt보다 작다면, tmp는 이미 stack에 들어있다.
	//stack.peek()을 한다 => tmp==peek이 아니면 수열을 만들수 없다 => NO
	//tmp==peek이면 pop한다.
	static int K;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int k = 0; k < K; k++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp>cnt) {
				for (int i = cnt+1; i <= tmp; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				cnt = tmp;
				stack.pop();
				sb.append("-\n");
			}else if(stack.peek()==tmp){
				stack.pop();
				sb.append("-\n");
			}
			else if(stack.peek()!=tmp){
				System.out.println("NO");
				return;

			}
				

		}

		System.out.println(sb);
	}
}
