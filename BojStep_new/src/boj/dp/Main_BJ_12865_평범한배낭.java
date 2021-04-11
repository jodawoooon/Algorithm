package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭 {

	// N개의 물건
	//무게 W와 가치 V
	//최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다
	
	
	static int N, K, W[], V[], dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N+1];
		V = new int[N+1];
		
		for (int i = 1; i <=N ; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		//knapsack
		//dp : 최대 가치
		//dp[1][K] : 첫번째 물건만 고려했을 때  K무게 이하에서 얻을 수 있는 최대가치
		//dp[N][K] : 첫번째물건~N번째 물건을 고려했을 때 K무게 이하에서 얻을 수 있는 최대가치
		
		dp = new int[N+1][K+1]; //dp[n][k] : n은 번호, k는 무게
		
		//각 물건은 하나씩만 존재하고, 반복해서 넣을 수 없음
		for (int i = 1; i <=N ; i++) {
			for (int j = 1; j <= K; j++) {
				
				// 현재의 상태(dp[i-1][j-W[n]])에 현재의 물건(W[n])을 추가로 넣을 수 있는지
				
				if(W[i] > j) {
					//i번째 아이템을 선택할 수 없다.
					
					//i-1번째 까지 선택하는 경우에서의 최대값 => dp[i-1][j]
					dp[i][j] = dp[i-1][j]; //이전 입력을 넣음
				}
				else {
					//j가 W[i]와 같거나 크다면 i번째 아이템을 선택할 수 있다.
					
					//dp[i-1][j]는 i번째 아이템을 넣지 않은 경우.
					
					//V[i]+dp[i-1][j-W[i]]은 i번째 아이템을 넣은 경우
					//i번째 물건의 가치 (V[i]) + 이전 행의 j-i번 열의 가치값 (dp[i-1][j-W[i])이
					//이전 행에서 j무게일때 담은 아이템의 최대가치값(dp[i-1][j]보다 크면)
					
					dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j-W[i]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
		
	}
}
