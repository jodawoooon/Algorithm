package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4008_숫자만들기 {
	static int T, N,number[], ans, oper[], max, min;
	static boolean select[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("4008input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			oper = new int[4];
			number = new int[12];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			
			dfs(1, number[0]);
			ans = max-min;
			System.out.println("#"+t+" "+ans);
		}
	}
	
	private static void dfs(int idx, int res) {
		if(idx==N) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			
			return;
		}
		
		
		if(oper[0]>0) {
			oper[0]--;
			dfs(idx+1, res+number[idx]);
			oper[0]++;
		}
		if(oper[1]>0) {
			oper[1]--;
			dfs(idx+1, res-number[idx]);
			oper[1]++;
		}
		if(oper[2]>0) {
			oper[2]--;
			dfs(idx+1, res*number[idx]);
			oper[2]++;
		}
		if(oper[3]>0) {
			oper[3]--;
			dfs(idx+1, res/number[idx]);
			oper[3]++;
		}
		
	}

	
}
