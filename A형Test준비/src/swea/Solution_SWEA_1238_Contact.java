package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact {
	static int T, N, startV, ans;
	static boolean[][] arr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("1238input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//T = Integer.parseInt(br.readLine());
		for (int t =1; t <=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			startV = Integer.parseInt(st.nextToken());
			
			arr = new boolean[101][101];
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				arr[from][v]=true;

			}
		
			bfs();
			
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int visited[] = new int[101];
		int cnt = 0;
		ans = Integer.MIN_VALUE;
		//System.out.println(startV);
		q.add(startV);
		visited[startV] = 1;
		
		while(true) {
			if(q.isEmpty()) break;
			
			int V = q.poll();
			
			for (int i = 1; i <= 100; i++) {
				
				if(visited[i]==0&&arr[V][i]) {
					//System.out.println(V+" "+i);
					visited[i]=visited[V]+1;
					q.add(i);
					
				}
				
			}
			cnt = visited[V];
		}
		
		for (int i = 1; i <= 100; i++) {
			
			if(cnt==visited[i]) {
				ans = Math.max(ans, i);
			}
			
		}
		
		
	}
}
