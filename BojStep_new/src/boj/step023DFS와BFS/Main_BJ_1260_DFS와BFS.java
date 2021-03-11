package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1260_DFS와BFS {
	static int N, M, V;
	static boolean visited[], arr[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new boolean[N+1][N+1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = true;
			arr[y][x] = true;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		
	}
	
	private static void bfs(int v) {

		Queue<Integer> queue = new LinkedList<>();
		
		
		queue.add(v);
		visited[v] = true;
		
		System.out.print(v+" ");
		while(true) {
			if(queue.isEmpty()) break;
			
			int nextV = queue.poll();
			
			for (int i = 1; i <=N; i++) {
				if(!visited[i]) {
					if(arr[nextV][i]) {
						visited[i] = true;
						queue.add(i);
						System.out.print(i+" ");
					}
				}
			}
		}
		
	}
	private static void dfs(int i) {
		System.out.print(i+" ");
		visited[i] = true;
		
		for (int j = 0; j <= N; j++) {
			if(!visited[j]) {
				if(arr[i][j]) {
					dfs(j);
				}
			}
		}
	}
	
	
}
