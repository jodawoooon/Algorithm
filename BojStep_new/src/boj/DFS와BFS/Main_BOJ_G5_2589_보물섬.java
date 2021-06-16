package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_G5_2589_보물섬 {
	
	static int H,W,ans;
	static char map[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		
		for (int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
				
			}
		}
		
		System.out.println(ans);
		
	}
	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		
		queue.add(new Node(i,j,0));
		visited[i][j] = true;
		int tmp = 0;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int cnt = n.cnt;
			tmp = cnt;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(isIn(nx,ny)&&!visited[nx][ny]&&map[nx][ny]==map[i][j]) {
					visited[nx][ny] = true;
					
					queue.add(new Node(nx,ny,cnt+1));
					
				}
			}
		}
		
		ans = Math.max(ans, tmp);
	}
	private static boolean isIn(int nx, int ny) {
		if(nx<0||ny<0||nx>=H||ny>=W) return false;
		return true;
	}
	static class Node{
		int x,y,cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
}
