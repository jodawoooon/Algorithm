package boj.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11050_이항계수 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// nCk = n!/k!(n-k)!

		int ans = solve(N,K);
		System.out.println(ans);
	}

	private static int solve(int n, int k) {
		if(n==k || k==0) return 1;
		else return solve(n-1,k)+solve(n-1,k-1);
	}

	

}
