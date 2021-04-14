package boj.DFS와BFS;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17144_미세먼지안녕 {
	//항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 
	//공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.
	
	static int R,C,T, airTopX, airTopY, airBottomX, airBottomY;
	static int map[][];
	static int[] dx = {-1,1,0,0}; //상 하 좌 우
	static int[] dy = {0,0,-1,1};
	
	
	static int[] dr1 = {0,-1,0,1}; //우 상 좌 하
	static int[] dc1 = {1,0,-1,0};
	
	static int[] dr2= {0,1,0,-1}; //우 하 좌 상
	static int[] dc2 = {1,0,-1,0};
	
	static Queue<Node> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map= new int[R][C];
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1&&!flag) {
					flag=true;
					airTopX = i;
					airTopY = j;
					airBottomX = i+1;
					airBottomY= j;
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			//1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
			
			queue = new LinkedList<>();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if(map[r][c]>0) {
						queue.add(new Node(r,c,map[r][c])); //동시이동 => 미세먼지 큐에 저장
					}
				}
			}
//			System.out.println("=========================");
//			for (int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
//			
			
			bfs(); //확산
//			System.out.println("------------------------");
//			
//			for (int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
			
			//2. 공기청정기
			
			//airTop
			int nr = airTopX;
			int nc = airTopY;
			int tmp = 0;

			for (int d = 0; d < 4; d++) {
				while(true) {
					nr += dr1[d];
					nc += dc1[d];
					//System.out.println(nr+" "+nc);
					if(nr>=0&&nc>=0&&nr<R&&nc<C) {
						if(map[nr][nc]!=-1) {
							int dust = map[nr][nc]; //지금값 저장
							map[nr][nc] = tmp; //이전값을 넣기
							tmp = dust;
						}else {
							nr -= dr1[d];
							nc -= dc1[d];
							break;
						}
					}else {
						nr -= dr1[d];
						nc -= dc1[d];
						break;
					}
					
				}
			}
//			System.out.println("------------------------");
//			for (int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
//			
			//airBottom
			nr = airBottomX;
			nc = airBottomY;

			tmp = 0;
			for (int d = 0; d < 4; d++) {
				while(true) {
					nr += dr2[d];
					nc += dc2[d];
					if(nr>=0&&nc>=0&&nr<R&&nc<C) {
						if(map[nr][nc]!=-1) {
							int dust = map[nr][nc];
							map[nr][nc] = tmp;
							tmp = dust;
						}else {
							nr -= dr2[d];
							nc -= dc2[d];
							break;
						}
					}else {
						nr -= dr2[d];
						nc -= dc2[d];
						break;
					}
				}
			}
//			System.out.println("------------------------");
//			for (int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
//			System.out.println("=========================");
		}
		
		
		//T초가 지난 후 미세먼지 양
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>0) {
					ans+=map[i][j];
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	private static void bfs() {
		int tmp[][] = new int[R][C];
		tmp[airTopX][airTopY] =-1;
		tmp[airBottomX][airBottomY] =-1;
		while(!queue.isEmpty()) {
			
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int w = n.w;
			

			int cnt = 0;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx>=0&&ny>=0&&nx<R&&ny<C) {
					if(map[nx][ny]!=-1) {
						tmp[nx][ny] += w/5;
						cnt++;
					}
				}
			}
			

			tmp[x][y] += w - (w/5*cnt);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}

	static class Node{
		int x,y,w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;

		}
		
		
	}
}
