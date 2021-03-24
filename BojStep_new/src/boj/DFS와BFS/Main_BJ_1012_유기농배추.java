package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1012_유기농배추 {
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean arr[][], visited[][];
	static int cnt, M, N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			cnt = 0;
			arr = new boolean[M][N];
			visited = new boolean[M][N];
			
			for (int k = 0; k < K ; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = true;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]&&!visited[i][j]) {
						
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	private static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if(nx>=0&&ny>=0&&nx<M&&ny<N) {
				if(!visited[nx][ny]&&arr[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
}
