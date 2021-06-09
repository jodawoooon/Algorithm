package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1107_G5_리모컨 {
	
	static int N, M, num, ans;
	static boolean[] button;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		button = new boolean[10];
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
	
		if(M!=0) { //안하면 null pointer 에러
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < M; i++) {
				button[Integer.parseInt(st.nextToken())]=true;
			}
		}
		
		
		
		solve();
		
		System.out.println(ans);
		
	}
	private static void solve() {
		//1.최대버튼수 (숫자버튼 안누르고 +,-만 누른다)
		ans = Math.abs(N-100);
		
		
		//2.숫자버튼으로 최대한 가깍이 이동
		//down
		for (int i = N; i >=0 ; i--) {
			if(isPossible(i)) {
				ans = Math.min(ans, Integer.toString(i).length()+(N-i));
				break;
			}
		}
		//up
		for (int i = N; Integer.toString(i).length()+(i-N) < ans  ; i++) {
			if(isPossible(i)) {
				ans = Math.min(ans, Integer.toString(i).length()+(i-N));
				break;
			}
		}
	}
	private static boolean isPossible(int n) {
		String str = Integer.toString(n);

		for (int i = 0; i < str.length() ; i++) {
			if(button[str.charAt(i)-'0']) {
				return false;
			}
		}
		return true;
	}
}
