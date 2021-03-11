package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2206_벽부수고이동하기 {
	static int N, M, ans;
	static int arr[][][];

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M][2];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				int tmp = str.charAt(m)-'0';
				if(tmp!=1) {
					arr[n][m][0] = tmp;
					arr[n][m][1] = tmp;
				}else {
					arr[n][m][0] = -1;
					arr[n][m][1] = -1;
				}
					
			}
		}
		
		
		//bfs
		bfs();
/*		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j][0]+" ");
			}System.out.println();
		}
		System.out.println("==============");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j][1]+" ");
			}System.out.println();
		}*/
		
		if(arr[N-1][M-1][0]==0&&arr[N-1][M-1][1]==0) {
			System.out.println(-1);
		}
		else {
			int ans = Math.min(arr[N-1][M-1][0], arr[N-1][M-1][1]);
			System.out.println(ans);
		}
		
	}
	private static void bfs() {
		Queue<Nodee> queue = new LinkedList<>();
		queue.add(new Nodee(1,1,0));

		int cnt = 1;
		while(true) {
			if(queue.isEmpty()) break;
			
			Nodee n = queue.poll();
			int x = n.x;
			int y = n.y;
			int drilled = n.drilled;
			if(x==N-1&&y==M-1) break;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(arr[nx][ny][0]==0) {
						queue.add(new Nodee(nx,ny,drilled));
						arr[nx][ny][0] = cnt++;
					}else if(arr[nx][ny][1]==-1&&drilled==0) {

						queue.add(new Nodee(nx,ny,drilled+1));
						arr[nx][ny][1] = cnt++;
					}
				}
			}
		}
	}
	
	
}

class Nodee{
	int x,y, drilled;

	public Nodee(int x, int y, int drilled) {
		super();
		this.x = x;
		this.y = y;
		this.drilled = drilled;
	}
	
}