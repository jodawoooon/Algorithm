package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_9095_S3_123더하기 {
	static int N,ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			//n을 1, 2, 3의 합으로 나타내는 방법의 수
			/*
			 * n=1 {1} 1
			 * n=2 {1,1} {2} 2
			 * n=3 {1,1,1} {1,2} {2,1} {3} 4
			 * n=4 {1,1,1,1} {1,1,2} {1,2,1} {2,1,1} {2,2} {1,3} {3,1} 7
			 * 
			 */
			
			
			if(N==1) {
				System.out.println(1);
				continue;
			}else if(N==2) {
				System.out.println(2);
				continue;
			}else if(N==3) {
				System.out.println(4);
				continue;
			}else {
				int dp[] = new int[N+1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				
				for (int i = 4; i <= N; i++) {
					dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
				}
				
				System.out.println(dp[N]);
			}
			
			
		}
		
	}
}
