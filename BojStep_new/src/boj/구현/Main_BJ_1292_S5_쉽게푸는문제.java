package boj.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1292_S5_쉽게푸는문제 {
	
	static int A,B,sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int cnt = 0;

		for (int i = 1; i <= B; i++) {
			for (int j = 0; j < i; j++) {
				cnt++;
				
				if(cnt>=A) {
					sum += i;
				}
				if(cnt==B) {
					System.out.println(sum);
					return;
				}
			}
		}
		
	}
}
