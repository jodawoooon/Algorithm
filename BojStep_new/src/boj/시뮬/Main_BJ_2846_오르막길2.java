package boj.시뮬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2846_오르막길2 {
	static int N, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	    
	    int tmp = 0;
	    int ans = 0 ;
	    for (int i = 1; i < N; i++) {
	    	if(arr[i-1]<arr[i]) {
	    		tmp += arr[i]-arr[i-1];
	    	}else
	    		tmp = 0;
	    	
	    	ans = Math.max(tmp, ans);
		}
	    
	    System.out.println(ans);
	}
}
