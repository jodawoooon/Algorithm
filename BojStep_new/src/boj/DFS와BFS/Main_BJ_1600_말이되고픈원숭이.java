package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1600_말이되고픈원숭이 {
	static int K, W, H, map[][];
	static int h_dx[] = {-1,-2,-2,-1,1,2,2,1};
	static int h_dy[] = {-2,-1,1,2,-2,-1,1,2};
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	/*
	 *  말은 격자판에서 체스의 나이트와 같은 이동방식을 가진다. 
	 *  참고로 말은 장애물을 뛰어넘을 수 있다.
	 *  말은 저렇게 움직일 수 있지만 원숭이는 능력이 부족해서 총 K번만 위와 같이 움직일 수 있고, 
	 *  그 외에는 그냥 인접한 칸으로만 움직일 수 있다.
	 *  격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 
	 *  원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성
	 *  
	 *  0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 장애물이 있는 곳으로는 이동할 수 없다. 
	 *   시작점과 도착점은 항상 평지이다
	 *  
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken()); //가로
		H = Integer.parseInt(st.nextToken()); //세로
		
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		bfs();
		
	}
	
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		boolean visited[][][] = new boolean[H][W][K+1];
		//벽뚫는 문제랑 비슷함.
		queue.offer(new Node(0,0,0,K));
		visited[0][0][K] = true;
		
		while(!queue.isEmpty()) {
			
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int k = n.k;
			int cnt = n.cnt;
			
			if(x==H-1&&y==W-1) {
				System.out.println(cnt);
				return;
			}
			
			//그냥 이동
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				
				if(nx>=0&&ny>=0&&nx<H&&ny<W) {
					if(map[nx][ny]==0&&!visited[nx][ny][k]) {
						visited[nx][ny][k] = true;
						queue.offer(new Node(nx,ny,cnt+1,k));
					}
				}
			}
			
			if(k!=0) {
				//말처럼 이동
				for (int d = 0; d < 8; d++) {
					int nx = x+h_dx[d];
					int ny = y+h_dy[d];
					
					if(nx>=0&&ny>=0&&nx<H&&ny<W) {
						if(map[nx][ny]==0&&!visited[nx][ny][k-1]) {
							visited[nx][ny][k-1] = true;
							queue.offer(new Node(nx,ny,cnt+1,k-1));
						}
					}
				}
			}

		}
		
		System.out.println(-1);
		return;
	}
	
	static class Node{
		int x,y,cnt,k;

		public Node(int x, int y, int cnt, int k) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
			
		}
		
		
	}

}
