package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1697_숨바꼭질2 {
	static int N, K, visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//수빈은 N에있고 동생은 K
		//N+1. N-1 N*2
		visited = new int[100001];
		if(N==K) {
			System.out.println(0);
		}else {
			bfs();
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		
		while(true) {
			if(queue.isEmpty()) break;
			
			
			
			int num = queue.poll();
			//System.out.println(num);
			int[] next = {num-1, num+1, num*2};
			for (int i : next) {
				if(i==K) {
					System.out.println(visited[num]+1);
					return;
				}
				

				if(i<0||i>=100001) continue;
				if(visited[i]>0) continue;
				visited[i] = visited[num]+1;
				queue.add(i);
			}
			
		}
	}
}
	
