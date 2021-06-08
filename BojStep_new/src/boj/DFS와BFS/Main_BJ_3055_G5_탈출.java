package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3055_G5_탈출 {
/*	
	. 빈곳
	* 물
	X 돌
	D 비버
	S 고슴도치
	
	
	*/
	static int R, C, ans, endX, endY;
	static char[][] map;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean[][] visited;
	static Queue<Node> hedge = new LinkedList<>();
	static Queue<Node> water = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		ans = Integer.MAX_VALUE;
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='S') {
					hedge.add(new Node(i,j,0));
					
				}else if(map[i][j]=='D') {
					endX = i;
					endY = j;
				}else if(map[i][j]=='*') {
					water.add(new Node(i,j));
				}
			}
		}
		
		//고슴도치 상하좌우 이동
		//물도 비어있는 칸으로 확장
		//물과 고슴도치는 돌을 통과할 수 없다
		//고슴도치는 물로 차있는 구역으로 이동할 수 없고
		//물도 비버의 소굴로 이동할 수 없다.
		
		bfs();
		if(ans==Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(ans);
		}
	
	}
	
	
	private static void bfs() {
		
		
		while(!hedge.isEmpty()) {
			
			waterFall();
			
			int size = hedge.size();
			while(size-- > 0) {
				Node n = hedge.poll();
				
				int x = n.x;
				int y = n.y;
				int cnt = n.cnt;
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					if(isIn(nx,ny)) {
						if(map[nx][ny]=='.'||map[nx][ny]=='D') {
							if(map[nx][ny]=='D') {
								ans = cnt+1;
								hedge.clear();
								return;
							}
							
							if(map[nx][ny]=='.'&&!visited[nx][ny]) {
								hedge.add(new Node(nx,ny,cnt+1));
								visited[nx][ny] = true;
								map[nx][ny]='S';
								map[x][y]='.';						}
						}
					}
				}
			}
			
			
		}
		
		
	}

	private static void waterFall() {
		
		int size = water.size();
		while(size-- >0) {
			Node n = water.poll();
			int x = n.x;
			int y = n.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(isIn(nx,ny)) {
					if(map[nx][ny]=='.') {
						water.add(new Node(nx,ny));
						map[nx][ny]='*';
					}
				}
			}
		}
	}


	private static boolean isIn(int nx, int ny) {
		if(nx<0||nx>=R||ny<0||ny>=C) return false;
		return true;
	}

	static class Node{
		int x,y;
		int cnt;
		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	
}