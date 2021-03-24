package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7569_토마토 {
	
	static int dx[] = {0,0,-1,1,0,0}; 
	static int dy[] = {0,0,0,0,-1,1};
	static int dz[] = {-1,1,0,0,0,0};
	
	static int N,M,H, arr[][][], ans, tomatoNum;
	static Queue<State> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M][H];
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m = 0; m < M; m++) {
					arr[n][m][h] = Integer.parseInt(st.nextToken());
					
					if(arr[n][m][h]==1) {
						queue.add(new State(n,m,h));
					}else if(arr[n][m][h]==0) {
						tomatoNum++;
					}
				}
			}
		}
		
		
		bfs();
		if(tomatoNum>0) System.out.println(-1);
		else System.out.println(ans);
		
	}
	private static void bfs() {
		while(true) {
			if(queue.isEmpty()) break;
			
			State s = queue.poll();
			int x = s.x;
			int y = s.y;
			int z = s.z;
			
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(nx>=0&&ny>=0&&nz>=0&&nx<N&&ny<M&&nz<H) {
					if(arr[nx][ny][nz]==0) {
						queue.add(new State(nx,ny,nz));
						tomatoNum--;
						arr[nx][ny][nz] = arr[x][y][z] + 1;
						ans = Math.max(ans, arr[x][y][z]);
					}
				}
			}
		}
	}
	
}

class State{
	int x,y,z;

	public State(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}