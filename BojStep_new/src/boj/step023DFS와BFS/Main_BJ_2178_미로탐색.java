package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	static int N, M, cnt, arr[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		arr = new int[N][M];
		for (int x = 0; x < N; x++) {
			String str = br.readLine();
			for (int y = 0; y < M; y++) {
				int tmp = str.charAt(y)-'0';
				arr[x][y] = tmp;
			}
		}
		
		//최단거리 => BFS
		bfs(0,0);
		
		
		System.out.println(arr[N-1][M-1]);
	}
	private static void bfs(int i, int j) {
		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(i,j));

		
		while(true) {
			if(queue.isEmpty()) break;
			
			Location l = queue.poll();
			int x = l.x;
			int y = l.y;
			
			if(x==N-1&&y==M-1) break;
			

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(arr[nx][ny]==1) {
						queue.add(new Location(nx,ny));
						arr[nx][ny] = arr[x][y]+1;
					}
				}
			}
		}
	}
	
	
}

class Location{
	int x,y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
