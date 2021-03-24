package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2206_벽부수고이동하기 {
	static int N, M, ans;
	static int arr[][];

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				int tmp = str.charAt(m)-'0';
				arr[n][m] = tmp;	
				// 맵에서 0은 이동할 수 있는 곳을 나타내고, 
				//1은 이동할 수 없는 벽이 있는 곳을 나타낸다.
			}
		}
		
		
		bfs();

	
		
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		boolean visited[][][] = new boolean[N][M][2];
		queue.add(new Node(0,0,0,1));
		visited[0][0][1] = true;
		
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int dis = n.dis;
			int avail = n.avail;
			
			if(x==N-1&&y==M-1) {
				System.out.println(dis+1);
				return;
			}
			
			
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(!visited[nx][ny][avail]) {
						if(arr[nx][ny]==0) {
							visited[nx][ny][avail] = true;
							queue.add(new Node(nx,ny,dis+1,avail));
						}else if(avail==1) {
							if(!visited[nx][ny][avail-1]) {
								visited[nx][ny][avail-1] = true;
								queue.add(new Node(nx,ny,dis+1,avail-1));
								
							}
						}
					}
				}
			}
			
		}
		
		System.out.println(-1);
		return;
	}

	static class Node{
		int x,y,avail,dis;

		public Node(int x, int y, int dis,int avail) {
		
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.avail = avail;
		}
	
	}
	
	
}
