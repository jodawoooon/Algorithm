package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사 {
	static int T, N,S[][],ans;
	static boolean select[];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("4012input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			S = new int[N+1][N+1];
			
			for (int i = 1; i <= N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			// N/2개씩 식재료 나누기
			select = new boolean[N+1];
			comb(0,1);
			
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void comb(int cnt, int k) {
		if(cnt==N/2) {
			//시너지구하기
			solve();
			return;
		}
		
		for (int i = k; i <=N; i++) {
			select[i] = true;
			comb(cnt+1, i+1);
			select[i]= false;
		}
	}
	
	private static void solve() {
		int sumA =0 ;
		int sumB =0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(select[i]&&select[j]) {
					sumA += S[i][j];
				}else if(!select[i]&&!select[j]) {
					sumB += S[i][j];
				}
			}
		}
		
		ans = Math.min(ans, Math.abs(sumA-sumB));
	}
}
