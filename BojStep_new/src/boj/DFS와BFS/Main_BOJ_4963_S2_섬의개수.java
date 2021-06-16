package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main_BOJ_4963_S2_섬의개수 {
	
	static int w,h,map[][],ans;
	static boolean[][] visit;
	
	
	static int dx[] = {-1,1,0,0,-1,-1,1,1};
	static int dy[] = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			//입력 종료 조건
			if(w==0&&h==0) System.exit(0);
			
			//map setting
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j]==1&&!visit[i][j]) {
						ans++;
						bfs(i,j);
					}
				}
			}
			System.out.println(ans);
			
		}
		
		
		
	}
	private static void bfs(int i, int j) {
		visit[i][j] = true;
		
			for (int d = 0; d < 8; d++) {
				int nx = i + dx[d];
				int ny = j + dy[d];
				if(isIn(nx,ny)) {
					if(map[nx][ny]==1&&!visit[nx][ny]) {
						bfs(nx,ny);
					}
				}
			}
			
	}
	
	private static boolean isIn(int nx, int ny) {
		if(nx<0||ny<0||nx>=h||ny>=w) return false;
		return true;
	}

	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
