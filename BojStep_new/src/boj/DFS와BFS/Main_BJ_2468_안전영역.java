package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2468_안전영역 {
	//장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오. 
	static int N, arr[][], maxHeight, minHeight, ans;
	static boolean visited[][];
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		maxHeight = Integer.MIN_VALUE;
		minHeight = Integer.MAX_VALUE;
		ans = 1;
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i][j]);
				minHeight = Math.min(minHeight, arr[i][j]);
			}
		}
		
		for (int h = minHeight; h < maxHeight; h++) {
			int cnt = 0;
			visited = new boolean[N][N];
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]&&arr[i][j]>h) {

						visited[i][j] = true;
						dfs(i,j,h);
						cnt++;
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		
		System.out.println(ans);

		
	}
	private static void dfs(int i, int j, int k) {
		
		
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if(nx>=0&&ny>=0&&nx<N&&ny<N) {
				if(!visited[nx][ny]&&arr[nx][ny]>k) {
					visited[nx][ny] = true;
					dfs(nx,ny,k);
				}
			}
		}
	}

}
