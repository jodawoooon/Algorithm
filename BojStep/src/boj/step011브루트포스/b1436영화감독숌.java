package boj.step011브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1436영화감독숌 {
	static int N,ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		//종말의 숫자란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수.
		// 제일 작은 종말의 수는 666. 그담은 1666, 2666, 3666 .....
		//N번째 종말의 수는?
		int tmp = 666;
		int cnt = 1;
		while(true) {
			if(cnt==N) break;
			tmp++;
			if(String.valueOf(tmp).contains("666")) {
				cnt++;
			}
		}
		ans = tmp;
	
		System.out.println(ans);

	}
	
	

}
