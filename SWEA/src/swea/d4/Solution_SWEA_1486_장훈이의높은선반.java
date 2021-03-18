package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1486_장훈이의높은선반 {
	
	//서점의 높이가 B인 선반
	//N명의 점원. 
	//점원의 키는 Hi. 점원들이 쌓는 탑은 점원 1명 이상으로 이루어짐
	//탑의 높이는 점원들의 키의 합과 같다
	//탑 높이가 B이상인경우 사용할 수 있다.
	
	//높이가 B이상인 탑 중 가장 낮은탑 찾기
	static int T, N,B,S, arr[], ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				S += arr[i];
			}
			
			//1명부터 N명까지의 조합.
			
			for (int i = 1; i <= N; i++) {
				comb(i, 0, 0, 0);
			}
			
			
			
			System.out.println("#"+t+" "+Math.abs(B-ans));
		}
		
		
	}
	
	
	private static void comb(int n, int cnt, int idx, int sum) {
		if(idx==n) {
			//System.out.println(sum);
			if(sum>=B) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		for (int i = idx; i < N; i++) {
			comb(n, cnt+1, i+1, sum+arr[i]);
		}
	}
	
}
