package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solution_SWEA_1949_등산로조성 {
	static int T, N, K, ans, arr[][], maxH;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("1949input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			ans=0;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxH=Integer.MIN_VALUE;
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					maxH = Math.max(arr[i][j], maxH);
				}
			}
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==maxH) {
						
						visited[i][j] =true;
						dfs(i,j,K,1);
						visited[i][j] =false;
					}
				}
			}
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
	
	private static void dfs(int x, int y, int k, int cnt) {
		ans = Math.max(ans, cnt);
//			for (int[] is : arr) {
//				System.out.println(Arrays.toString(is));
//			}
//			System.out.println("i,j "+x+","+y+"   cnt: "+cnt);
//			System.out.println();
			
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0&&ny>=0&&nx<N&&ny<N&&!visited[nx][ny]) {
					
					if(arr[nx][ny]<arr[x][y]) {
						visited[nx][ny]=true;
						dfs(nx,ny,k,cnt+1);
						visited[nx][ny]=false;
					}else {
						int gap = arr[nx][ny]-arr[x][y];
						
						if(k>=gap+1) {
							arr[nx][ny]-=(gap+1);
							visited[nx][ny]=true;
							dfs(nx,ny,0,cnt+1);
							arr[nx][ny]+=(gap+1);
							visited[nx][ny]=false;
						}
					}
				}
			}
			
	}
}