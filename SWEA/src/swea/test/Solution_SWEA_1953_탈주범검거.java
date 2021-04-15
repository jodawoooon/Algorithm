package swea.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1953_탈주범검거 {
	static int N, M, R, C, L, map[][], ans;
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	static int res[][];
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1953input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			
			map = new int[N][M];
			
			//탈주범이 있을 수 있는 위치의 개수
			res = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			bfs(R,C);
			
//			for (int[] ia : res) {
//				System.out.println(Arrays.toString(ia));
//			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans += res[i][j];
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
		
	}
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		
		queue.add(new Node(r,c,0));
		visited[r][c] = true;
		
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int x = n.x;
			int y = n.y;
			int time = n.time;
			if(time==L) break;
			res[x][y]++;
			//System.out.println(time);
			
			
			switch(map[x][y]) {
			case 1:
				for (int d = 0; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			case 2:
				for (int d = 0; d < 2; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			case 3:
				for (int d = 2; d < 4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			case 4:
				for (int d = 0; d < 4; d++) {
					if(d==1||d==2) continue;
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			case 5:
				for (int d = 0; d < 4; d++) {
					if(d==0||d==2) continue;
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			case 6:
				for (int d = 0; d < 4; d++) {
					if(d==0||d==3) continue;
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			case 7:
				for (int d = 0; d < 4; d++) {
					if(d==1||d==3) continue;
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(rangeCheck(nx,ny)&&map[nx][ny]!=0&&matchCheck(d,map[nx][ny])&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						queue.add(new Node(nx,ny,time+1));
					}
				}
				break;
			}
		}
	}
	
	private static boolean matchCheck(int d, int next) {
		if(next==1) return true;
	
			if(d==0) {
				if(next==2||next==5||next==6) return true;
				else return false;
			}else if(d==1) {
				if(next==2||next==4||next==7) return true;
				else return false;
			}else if(d==2) {
				if(next==3||next==4||next==5) return true;
				else return false;
			}else if(d==3) {
				if(next==3||next==6||next==7) return true;
				else return false;
			}
			return false;
	}

	private static boolean rangeCheck(int nx, int ny) {
		if(nx>=0&&ny>=0&&nx<N&&ny<M) return true;
		return false;
	}

	static class Node{
		int x,y,time;

		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
}
