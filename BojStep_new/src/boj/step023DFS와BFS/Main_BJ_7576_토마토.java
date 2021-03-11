package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_7576_토마토 {
	static int N, M, arr[][], ans, tomatoNum;
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static Queue<Node> queue = new LinkedList<>();
	//익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	//하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
	//며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
	//단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(arr[n][m]==0) {
					tomatoNum++;
				}else if(arr[n][m]==1) {
					queue.add(new Node(n,m));
				}
			}
		}
		
		bfs();
		

		if(tomatoNum!=0) {
			System.out.println(-1);
		}else {
			if(ans<=1) System.out.println(0);
			else System.out.println(ans-1);
		}
	}
	
	private static void bfs() {

		while(true) {
			if(queue.isEmpty()) break;
			
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(arr[nx][ny]==0) {
						queue.add(new Node(nx,ny));
						tomatoNum--;
						arr[nx][ny] = arr[x][y] +1;
						ans = Math.max(ans, arr[nx][ny]);
					}
				}
			}
		}
	}
	
	

	
}
class Node{
	int x,y=0;

	public Node(int x, int y) {

		this.x = x;
		this.y = y;
	}
	
}
