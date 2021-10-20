package boj.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import week30.BOJ_20058_G4_마법사상어와파이어스톰.Main_BOJ_20058_G4_마법사상어와파이어스톰.Node;

public class Main_BOJ_20058_G4_마법사상어와파이어스톰 {
	static int N,Q, map[][], M, command[], totalIce, maxIce;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken()); //파이어스톰 횟수
		
		M = (int) Math.pow(2, N);
		map = new int[M][M];
		command = new int[Q];
		visited = new boolean[M][M];
		
		for(int r = 0 ; r < M ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < M ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < Q ; i++) {
			int L = Integer.parseInt(st.nextToken());
			divide(L);
			reduce();
			
		}
		
		findMax();
		
		
		System.out.println(totalIce);
		System.out.println(maxIce);
	}


	private static void reduce() {
		
		ArrayList<Node> reduceList = new ArrayList<>();
		//각 정점에서 인접해있는 얼음 칸의 개수를 체크한다.
		for(int r = 0 ; r < M ; r++) {
			for(int c = 0 ; c < M ; c++) {
				int cnt = 0;
				for(int d = 0 ; d < 4 ;d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(isIn(nr,nc) && map[nr][nc]>0) {
						cnt++;
					}
				}
				
				if(cnt<3) reduceList.add(new Node(r,c));
			}
		}
		
		//얼음이 있는 칸 3개 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다
		for(Node n : reduceList) {
			if(map[n.r][n.c]>0) map[n.r][n.c]--;
			
		}
	}



	private static void divide(int L) {
		//먼저 격자를 2L × 2L 크기의 부분 격자로 나눈다
		int LEN = (int) Math.pow(2, L); //부분 격자의 길이
		
		
		for(int r = 0 ; r < M ; r += LEN) {
			for(int c = 0 ; c < M ; c += LEN) {
				
				rotate(r,c,LEN);
			}
		}


	}

	private static void rotate(int r, int c, int LEN) {
		int[][] res = new int[M][M];
		//길이가 L인 부분 격자를 시계방향으로 90도 회전시킨다.
		
	
		for(int x = 0 ; x < LEN ; x++) {
			for(int y = 0 ; y < LEN ; y++) {
				
				int nr = r + (LEN - 1 - y) ;
				int nc = c + x;
				res[x][y] = map[nr][nc];
			}
		}
		
		for(int x = 0 ; x < LEN ; x++) {
			for(int y = 0 ; y < LEN ; y++) {
				map[r+x][c+y] = res[x][y];
			}
		}
	}


	private static void findMax() {
		
		for(int r = 0 ; r < M ; r++) {
			for(int c = 0 ; c < M ; c++) {
				if(visited[r][c]) continue;
				if(map[r][c]==0) continue;
				bfs(r,c);
			}
		}
		
	}
	


	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(r,c));
		visited[r][c] = true;
		totalIce += map[r][c];
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int d = 0 ; d < 4 ;d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc]>0) {
					visited[nr][nc] = true;
					totalIce += map[nr][nc];
					cnt++;
					queue.add(new Node(nr,nc));
				}
			}
		}
		
		maxIce = Math.max(cnt, maxIce);
	}


	private static boolean isIn(int nr, int nc) {
		if(nr<0||nc<0||nr>=M||nc>=M) return false;
		return true;
	}
	
	static class Node {
		int r,c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}


}