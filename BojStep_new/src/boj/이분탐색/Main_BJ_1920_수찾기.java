package boj.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1920_수찾기 {
	
	static int N, M, A[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); //오름차순 정렬
		
		//mid 찾기
		
		
	    M = Integer.parseInt(br.readLine());
	    
	    
	    st = new StringTokenizer(br.readLine());
		
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = A.length-1;
			
			int mid = 0;
			
			while(true) {
				
				if(start>end) {
					sb.append(0).append("\n");
					break;
				}
				
				mid = (start+end)/2;
				
				if(num==A[mid]) {
					sb.append(1).append("\n");
					break;
				}
				
				if(num<A[mid]) end = mid -1;
				else start = mid + 1;
			}
			
			
		}
	    
	    System.out.println(sb.toString());
	 }
}
