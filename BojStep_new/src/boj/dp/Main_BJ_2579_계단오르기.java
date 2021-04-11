package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2579_계단오르기 {
	//계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임
	//1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 
	//		즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
	//2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
	//3. 마지막 도착 계단은 반드시 밟아야 한다.
	
	//bottom-up 방식
	//경우의 수는 2가지이다.
	//현재 계단 기준 => 몇칸을 올라왔는가?
	//dp[i][n] ; i=계단의 번호, n=올라온 칸수
	//1칸씩 올라가는 것은 연속으로 나타날 수 없다.
	
	static int N, dp[][], arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][3];
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());//계단의 점수
		}
		
		dp[1][1] = arr[1]; //1번째 칸은 1칸만 올라가야함
		
		if(N>1) {
			dp[2][1] = dp[1][1] + arr[2];
			dp[2][2] = arr[2];
			
		}
		
		for (int i = 3; i <= N; i++) {
			dp[i][1] = dp[i-1][2] + arr[i]; //직전 칸을 밟고 올라온 경우. 
											//연속해서 밟을 수 없다. => 그 전에 2칸 올라왔다
			dp[i][2] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
		}

		System.out.println(Math.max(dp[N][1], dp[N][2]));
	}
}
