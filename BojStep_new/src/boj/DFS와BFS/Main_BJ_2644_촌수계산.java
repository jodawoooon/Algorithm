package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2644_촌수계산 {
	
	static int N, M, X, Y, cnt;
	static boolean arr[][], visited[];
	static int tgtNum, compNum, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = -1;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		tgtNum = Integer.parseInt(st.nextToken());
		compNum = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		arr = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			
			arr[X][Y] = true;
			arr[Y][X] = true;
			
		}

		dfs(tgtNum, compNum,0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int v, int tgt, int cnt) {
		visited[v] = true;
		

		if(v==tgt) {
			
			ans = cnt;
			return;
		}
		
		
		for (int i = 1; i <= N ; i++) {
			if(!visited[i]) {
				if(arr[v][i]) {
					dfs(i, tgt, cnt+1);
				}
			}
		}
		
		return;
		
	}
}
