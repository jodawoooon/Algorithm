package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1057_S3_토너먼트 {
	
	static int N, cnt;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		
		//몇 라운드에서 임한수와 대결하는지 궁금해졌다
		//김지민과 임한수는 서로 대결하기 전까지 항상 이긴다
		
		while(kim != lim) {
			cnt++;
			if(kim%2==0) {
				kim /= 2;
			}else {
				kim /= 2;
				kim++;
			}
			
			if(lim%2==0) {
				lim /= 2;
			}else {
				lim /= 2;
				lim ++;
			}

		}
		
		System.out.println(cnt);
	}
}
