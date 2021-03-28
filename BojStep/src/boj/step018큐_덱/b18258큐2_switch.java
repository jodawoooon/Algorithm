package boj.step018Å¥_µ¦;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b18258Å¥2_switch {
	static int N;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int last = 0;
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			st = new StringTokenizer(str, " ");
		
			String order = st.nextToken();
			
			switch(order){
			case "push":
				last = Integer.parseInt(st.nextToken());
				queue.offer(last);
				break;
			case "pop":
				Integer i = queue.poll();
				if(i==null) sb.append("-1\n");
				else sb.append(i+"\n");
				break;
			case "size":
				sb.append(queue.size()+"\n");
				break;
			case "empty":
				if(queue.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "front":
				Integer i2 = queue.peek();
				if(i2==null)sb.append("-1\n");
				else sb.append(i2+"\n");
				break;
			case "back":
				if(queue.isEmpty()) sb.append("-1\n");
				else sb.append(last+"\n");

				
				break;
				
			}

		}
		
		System.out.println(sb);
	}
}
