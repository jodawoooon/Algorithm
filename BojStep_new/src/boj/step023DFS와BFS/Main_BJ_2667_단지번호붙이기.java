package boj.step023DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_2667_단지번호붙이기 {
	static boolean arr[][], visited[][];
	static int N, M, cnt, allCount;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //컴퓨터의 수 
		
		visited = new boolean[N][N];
		arr = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				int tmp = str.charAt(j)-'0';
				if(tmp==1) {
					arr[i][j] = true;
				}
			}
		}

		//연결되었다 -> 좌우 혹은 아래위로 다른 집이 있는 경우. (대각선은 X)
		
		
		ArrayList<Integer> count = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]&&!visited[i][j]) {
					cnt = 0;
					allCount++;
					dfs(i,j);
					count.add(cnt);
				}
			}
		}
		
		System.out.println(allCount);
		Collections.sort(count);
		for (Integer integer : count) {
			System.out.println(integer);
		}
	}
	private static void dfs(int x,int y) {

		cnt++;
		visited[x][y]= true;
		
		for (int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&ny>=0&nx<N&&ny<N) {
				if(!visited[nx][ny]&&arr[nx][ny]) {
					
					dfs(nx,ny);
				}
			}
		}
		
	}
}
