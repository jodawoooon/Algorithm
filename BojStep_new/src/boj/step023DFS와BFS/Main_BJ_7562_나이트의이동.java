package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7562_나이트의이동 {
	static int[][] arr;
	static int tgtX, tgtY, nowX, nowY, L, cnt;
	static int[][] visited;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {-2,-1,1,2,-2,-1,1,2};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			L = Integer.parseInt(br.readLine());
			
			arr = new int[L][L];
			visited = new int[L][L];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			nowX = Integer.parseInt(st.nextToken());
			nowY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			tgtX = Integer.parseInt(st.nextToken());
			tgtY = Integer.parseInt(st.nextToken());
			
			if(nowX==tgtX&&nowY==tgtY) {
				System.out.println(0); continue;
			}

			bfs(nowX, nowY);
			
		}
		
	}
	
	private static void bfs(int i, int j) {
		
		Queue<Can> queue = new LinkedList<>();
		queue.add(new Can(i,j));

		while(true) {
			if(queue.isEmpty()) break;
			
			Can c = queue.poll();
			int x = c.x;
			int y = c.y;
			
			if(x==tgtX&&y==tgtY) {
				System.out.println(visited[x][y]);
				queue.clear();
			}
			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx>=0&&ny>=0&&nx<L&&ny<L) {
					if(visited[nx][ny]==0) {
						visited[nx][ny] = visited[x][y]+1;
						queue.add(new Can(nx,ny));
					}
				}
			}
		}
		
	}
}

class Can{
	int x;
	int y;
	public Can(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
