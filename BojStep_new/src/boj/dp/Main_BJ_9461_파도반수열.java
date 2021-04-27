package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_9461_파도반수열 {
	
	static int N;
	static long dp[];
	static final int DIV = 15746;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new long[101];
			
			
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
	
			
			for (int i = 4; i <= N; i++) {
				dp[i] = (dp[i-2]+dp[i-3]);
			}
			
			
			System.out.println(dp[N]);
		}
		
		
		
	}
}
