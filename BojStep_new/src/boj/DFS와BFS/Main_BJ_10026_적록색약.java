package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10026_적록색약 {
	
	
	static int N, wrongAns, trueAns, cnt;
	static char arr[][];
	static boolean visited[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					wrongAns++;
				}
			}
		}
		
		//dfs로 상하좌우 갚 중 현 문자와 동일한 경우에 끝까지 탐색. 색 다르면 종료
		//종료시 cnt++, 그리고 visit으로 동일한 장소 재방문하지 않게 함
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]=='G') {
					arr[i][j]='R';
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					trueAns++;
				}
			}
		}

		System.out.println(wrongAns + " " + trueAns);
	
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visited[nx][ny]) {

				if(arr[x][y]==arr[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
		
	}
	
}
