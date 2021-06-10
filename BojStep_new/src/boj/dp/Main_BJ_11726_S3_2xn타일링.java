package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11726_S3_2xn타일링 {
	static int N,ans;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		/*
		 * N=1 1
		 * N=2 2
		 * N=3 
		 * 
		 */
		int dp[] = new int[N+1];
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		if(N==2) {
			System.out.println(2);
			return;
		}
		
		dp[1]=1;
		dp[2]=2;
		for (int i = 3; i <=N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i]%=10007;
		}
		System.out.println(dp[N]);
		//2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
		
	}
}
