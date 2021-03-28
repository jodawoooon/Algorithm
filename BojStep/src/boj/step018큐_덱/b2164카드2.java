package boj.step018큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2164카드2 {
	//1-N까지의 카드. 맨위에 1번, 맨 아래 N번
	//카드 한장 남을때 까지 -> while
	// 제일 위의 카드를 바닥에 버린다. 그 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다
	
	//if N=4이면. 1 버리고 234 남고, 2를 4밑으로 옮겨서 342가 된다. 
	// 그리고 3 버리면 42남고, 4를 2밑으로 옮기면 24가 된다. 마지막으로 2를 버리면 4가 남ㄴ는다
	
	//이런식으로해서 제일 마지막에 남는 카드는?
	static int[] q;
	static int N;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		q = new int[N+1];
		for (int n = 1; n <= N; n++) {
			q[n] = n;
			System.out.println(n);
		}

		while(true) {
			if(queue.size()==1) {
				System.out.println(queue.peek());
				return;
			}
			System.out.println(queue.peek());
			queue.poll();
			int nextTOP = queue.poll();

			
			
		}
		
	}

}
