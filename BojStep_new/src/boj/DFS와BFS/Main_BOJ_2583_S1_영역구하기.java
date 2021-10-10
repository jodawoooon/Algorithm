package boj.DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2583_S1_영역구하기 {
	static boolean[][] map, visited;
	static int N, M, K, cnt;
	static ArrayList<Integer> areaList;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		visited = new boolean[M][N];
		areaList = new ArrayList<>();
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int x = x1 ; x < x2 ; x++) {
				for(int y = y1 ; y < y2 ; y++) {
					if(!map[x][y]) map[x][y]=true;
				}
			}
		}
		
		
		for(int x = 0 ; x < M ; x++) {
			for(int y = 0 ; y < N ; y++) {
				if(!visited[x][y]&&!map[x][y]) {
					bfs(x,y);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(areaList);
		for(int area : areaList) System.out.print(area+" ");
		
	}
	private static void bfs(int x, int y) {
		visited[x][y] = true;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		int area = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0 ; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				if(isIn(nx,ny)&&!visited[nx][ny]&&!map[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
					area++;
				}
			}
		}
		
		areaList.add(area);
		
		
	}
	private static boolean isIn(int nx, int ny) {
		if(nx<0||ny<0||nx>=M||ny>=N) return false;
		return true;
	}
}
