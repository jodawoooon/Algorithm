package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1868_파핑파핑 {
	static int N, ans, newMap[][];
	static char map[][];
	static boolean[][] visited;
	static int[] dx = {1,1,1,0,0,-1,-1,-1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = null;
	    
	    int T = Integer.parseInt(br.readLine()); //TC갯수
	    
	    for (int t = 1; t <= T; t++) {
	    	N = Integer.parseInt(br.readLine());
	    	
	    	ans = 0;
	    	
			map = new char[N][N];
	    	visited = new boolean[N][N];
	    	
	    	for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					
				}
			}
//	    	
//	    	for (char[] ca : map) {
//				System.out.println(Arrays.toString(ca));
//			}
	    	
	    	for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if(map[x][y]=='.') { 
						int cnt = 0;
						
						for (int d = 0; d < 8; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							
							if(nx<0||ny<0||nx>=N||ny>=N) continue;
							
							if(map[nx][ny]=='*') cnt++;
							
						}
						if(cnt==0) { //탐색가능하다면 => dfs 클릭
							ans++;
							dfs(x,y);
						}
						
					}
				}
			}
//	    	
//	    	for (char[] ca : map) {
//				System.out.println(Arrays.toString(ca));
//			}
	    	
	    	//남은것들
	    	for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if(map[x][y]=='.') ans++;
				}
	    	}
	    	
	    	System.out.println("#"+t+" "+ans);
	    	
	    }
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		int cnt = 0;
		
		//지뢰있는지 검사
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			
			if(map[nx][ny]=='*') cnt++;
			
		}
		
		
		map[x][y] = (char)(cnt+'0');
		
		if(map[x][y]!='0') return; //지뢰가 있다면 return
		
		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0||ny<0||nx>=N||ny>=N) continue;
			if(visited[nx][ny]) continue;
			
			if(map[nx][ny]=='.') dfs(nx,ny);
			
		}
		
		
	}

	
}
