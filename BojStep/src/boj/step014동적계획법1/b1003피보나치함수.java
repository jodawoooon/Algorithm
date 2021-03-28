package boj.step014동적계획법1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1003피보나치함수 {
	static int T;
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		
		dp[0][0] = 1; //N=0일때
		dp[0][1] = 0;
		dp[1][0] = 0; //N=1일때
		dp[1][1] = 1;
		for (int t = 0; t < T; t++) {
	
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			bw.write(dp[N][0]+" "+dp[N][1]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static Integer[] fibonacci(int n) {
		//아직 탐색하지 않은 값.
		if(dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
		}
		return dp[n];
	}
}