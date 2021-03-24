package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2606_바이러스 {
	static boolean com[][], visited[];
	static int N, M, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //컴퓨터의 수 
		M = Integer.parseInt(br.readLine()); //직접 연결된 컴퓨터 쌍의 수
		
		com = new boolean[N+1][N+1];
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			com[x][y] = true;
			com[y][x] = true;
		}

		
		//DFS
		visited = new boolean[N+1];
		dfs(1);
		
		System.out.println(cnt);
	}
	private static void dfs(int v) {
		
		visited[v] = true;
		
		for (int d = 1; d <= N; d++) {
			if(!visited[d]&&com[v][d]) {
				cnt++;
				dfs(d);
			}
		}
	}
}
