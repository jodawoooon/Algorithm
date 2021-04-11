package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10844_쉬운계단수 {
	/*
	 * 이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.

		세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.
		N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오
		0과 9, 0은 1밖에 선택할 수 없고, 9는 8밖에 선택할 수 없다는점.
	 */
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//dp[n][k] ; 길이가 n이고 k로 끝나는 계단수
		
		long[][] dp = new long[N+1][10];
		
		//첫번째 자릿 수는 오른쪽 맨 끝의 자리수 경우의 수가 1개
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1; // DP 배열 초기 상태 
		}
		
		// 2 ~ N 탐색
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if(j == 0) {    // 끝이 0이면 1만 가능
					dp[i][0] = dp[i - 1][1] % 1000000000;
				}else if (j == 9) { // 9라면 8만 가능
					dp[i][9] = dp[i - 1][8] % 1000000000;
				}else {    // -1,+1
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}
		
		
		long ans = 0;
		// 각 자릿값마다 경우의 수를 모두 더하기
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i];
		}
		
		ans %= 1000000000;
		
		System.out.println(ans);
	}
}
