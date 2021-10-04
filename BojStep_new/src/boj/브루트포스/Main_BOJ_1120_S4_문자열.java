package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1120_S4_문자열 {
	
	static String A, B;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = st.nextToken();
		B = st.nextToken();
		
		int lenA = A.length();
		int lenB = B.length();
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i <= (lenB- lenA) ; i++) {
			String tmpB = B.substring(i, i+lenA);
			int cnt = 0;
			for(int j = 0; j < tmpB.length() ; j++) {
				if(A.charAt(j)!=tmpB.charAt(j)) cnt++;
			}
			min = Math.min(cnt, min);
		}
		
		System.out.println(min);
	}
}
