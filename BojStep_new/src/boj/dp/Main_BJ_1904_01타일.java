package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1904_01타일 {
	
	static int N, dp[];
	static final int DIV = 15746;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들
		
		//지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다.
		
		//N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수
		//N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
		/*
		N=1 1 => 1
		N=2 11 00 => 2
		N=3 111 100 001 => 3
		N=4 1111 1100 1001 0011 0000 => 5
		N=5 11111 11100 11001 10011 00111 10000 00100 00001 => 8
		
		*/
		
		dp = new int[1000001];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1]+dp[i-2])%DIV;
		}
		
		System.out.println(dp[N]);
		
	}
}
