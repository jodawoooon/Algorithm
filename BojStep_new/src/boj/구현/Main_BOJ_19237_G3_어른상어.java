package boj.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 
 * ✨ Algorithm ✨
 * @Problem : BOJ 19237 어른상어
 * @Author : Daun JO
 * @Date : 2021. 9. 16. 
 *
 */

public class Main_BOJ_19237_G3_어른상어 {
	
	static int N, M, k, map[][];
	static int dx[] = {0,-1,1,0,0};
	static int dy[] = {0,0,0,-1,1}; //1~4 상하좌우
	static Queue<Shark> queue = new LinkedList<>();
	static class Shark{
		int x,y,num,dir;

		public Shark(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			
		}
		
	}

}
