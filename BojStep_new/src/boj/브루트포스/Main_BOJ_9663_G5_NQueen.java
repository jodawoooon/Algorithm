package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * 
 * 
 * ✨ Algorithm ✨
 * @Problem : BOJ 9663 NQueen
 * @Author : Daun JO
 * @Date : 2021. 10. 6. 
 * @Algorithm : DFS
 *
 */

public class Main_BOJ_9663_G5_NQueen {
	static int N, map[], ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//같은 열에 다른 퀸이 있으면 X
		//같은 행에 다른 퀸이 있으면 X
		//대각선에 다른 퀸이 있으면 X
		//map[row]=col . (r,c) 체크

		map =new int[N];

		dfs(0);
		
		System.out.println(ans);
		
	}
	
	private static void dfs(int row) {
		if(row==N) {
			ans++;
			return;
		}
		
		for(int col = 0 ; col < N ; col++) {
			
			if(canGo(row, col)) {
				map[row] = col;
				dfs(row+1);
			}
		}
	}

	private static boolean canGo(int row, int col) {
		for(int r = 0 ; r<row ; r++) {
			if(map[r] == col) return false; //같은 열에 있다
			if(Math.abs(r - row)==Math.abs(map[r] - col)) return false; //대각선
		}
		return true;
	}
}
