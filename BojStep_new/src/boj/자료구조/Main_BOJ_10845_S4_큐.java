package boj.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_10845_S4_큐 {
	static int N, cnt;
	static int input;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //참가자 수
		
		queue = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			
			switch(cmd) {
			case "push":
				input = Integer.parseInt(st.nextToken());
				queue.add(input);
				cnt++;
				break;
			
			case "front":
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.peek()+"\n");
				}
				
				break;
				
			case "back":
				if(cnt==0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(input+"\n");
				}
				break;
				
			case "size":
				sb.append(cnt).append("\n");
				break;
				
			case "empty":
				if(cnt==0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
				
			case "pop":
				if(cnt==0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(queue.poll()+"\n");
					cnt--;
				}
				break;
			
		}
		
		
		}
		System.out.println(sb);
	}
}
