package boj.시뮬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2846_오르막길 {
	static int N, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	    
	    int before= arr[0];
	    int start = arr[0];
	    int ans = 0 ;
	    for (int i = 1; i < N; i++) {
	    	if(before>=arr[i]) {
	    		ans = Math.max(ans, before-start);
	    		start = arr[i];
	    		before = arr[i];
	    	}
	    	
	    	if(before<arr[i]) {
	    		before=arr[i];
	    		ans = Math.max(ans, before-start);
	    	}
		}
	    
	    System.out.println(ans);
	}
}
