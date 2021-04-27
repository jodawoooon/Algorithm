package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14442_벽부수고이동하기2 {
/*
	당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
	 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.
	 벽을 K개 까지 부수고 이동하여도 된다.
	 */
	
	static int N, M, K, map[][], ans;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		
		bfs();
		
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N+1][M+1][K+1];
		
		queue.add(new Node(1,1,0,1));
		visited[1][1][0] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			int x = n.x;
			int y = n.y;
			int cnt= n.cnt;
			int drill = n.drill;

			if(x==N&&y==M) {
				ans = Math.min(ans, cnt);
			}
			
			//System.out.println(x+" "+y);
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx<=0||ny<=0||nx>N||ny>M) continue;
				
				
				if(visited[nx][ny][drill]) continue;

				
				if(map[nx][ny]==0) {
					visited[nx][ny][drill]=true;
					queue.add(new Node(nx,ny,drill,cnt+1));
				}
				else {

					if(drill+1<=K) {
						visited[nx][ny][drill]=true;
						queue.add(new Node(nx,ny,drill+1,cnt+1));
					}
				}
				
			}
		}
	}
	
	static class Node{
		int x,y,drill,cnt;

		public Node(int x, int y, int drill, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.drill = drill;
			this.cnt = cnt;
		}
		
	}
}
