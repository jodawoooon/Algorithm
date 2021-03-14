package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1952_수영장 {
	
	//1일 이용권, 1달이용권, 3달이용권, 1년이용권
	// 이달 이용계획이 0일이라면
	/*
	 * => 다음달로 넘어간다.
	 * => 3달 이용권 결제
	 * => 1년 이용권 결제 (1월 1일부터)
	 * 
	 * 
	 * 이달 이용계획이 있다면
	 * => 1일 이용권 결제
	 * => 1달 이용권 결제
	 * 
	 */
	static int T, N, K, ans;
	static int price[], plan[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("1952input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			

			price = new int[4];
			plan = new int[13];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			//
			

			st = new StringTokenizer(br.readLine()," ");
			for (int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			
			dfs(1,0);
			
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void dfs(int m, int res) {
		if(m>12) {
			ans = Math.min(ans, res);
			return;
		}
		
		int tmp=0;
		if(m==1) {
			tmp = price[3];
			dfs(m+12,res+tmp);
		}
		
		
		if(plan[m]==0) {
			dfs(m+1, res);
		}
		else {
			tmp = plan[m]*price[0]; //1일이용권
			dfs(m+1, res+tmp);
			
			
			tmp = price[1];//1달이용권
			dfs(m+1, res+tmp);
			
		}
		
		
		if(m+3<=15) {
			tmp = price[2];
			dfs(m+3, res+tmp);
		}
	}
}
