package boj.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10816_숫자카드2 {
	
	static int N, M, A[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		N = Integer.parseInt(br.readLine());
		
		A = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			A[n+10000000]++;
		}
		
		//mid 찾기
		
		
	    M = Integer.parseInt(br.readLine());
	    
	    
	    st = new StringTokenizer(br.readLine());
		
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < M; i++) {
	    	// 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지
	    	
			sb.append(A[Integer.parseInt(st.nextToken())+10000000]).append(" ");
			
		}
	    
	    System.out.println(sb.toString());
	 }
}
