package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2210_S2_숫자판점프 {
	
	static int LEN = 5;
	static int map[][], ans;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<String> res;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[LEN][LEN];
		
		res = new ArrayList<>();
		
		for(int i = 0 ; i < LEN ; i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < LEN ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < LEN ; i++) {
			for(int j = 0 ; j < LEN ; j++) {
				dfs(i,j,"");
			}
		}
		
		System.out.println(res.size());
		
	}
	
	private static void dfs(int i, int j, String num) {
		if(num.length()==6) {
			if(!res.contains(num)) res.add(num);
			return;
		}
		
		for(int d = 0 ; d < 4 ; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(!isIn(nx,ny)) continue;
			dfs(nx,ny,num+map[nx][ny]);
			
		}
	}

	private static boolean isIn(int nx, int ny) {
		if(nx<0||ny<0||nx>=LEN||ny>=LEN) return false;
		return true;
	}

	
}
