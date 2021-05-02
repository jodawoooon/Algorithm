package boj.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11050_이항계수2 {
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//nCk = n!/k!(n-k)!
		
		int pascal[][] = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if(i==j || j==0) pascal[i][j] = 1;
				else {
					pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
					pascal[i][j] %= 10007;
				}
			}
		}
		
		System.out.println(pascal[N][K]);
	}
	
}
