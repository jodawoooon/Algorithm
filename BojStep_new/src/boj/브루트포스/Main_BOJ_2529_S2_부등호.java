package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2529_S2_부등호 {
	
	static int N;
	static Long max = Long.MIN_VALUE;
	static String strMax, strMin;
	static Long min = Long.MAX_VALUE;
	static char arr[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) arr[i] = st.nextToken().charAt(0);
		
		for(int i = 0 ; i < 10 ; i++) {
			boolean[] visited = new boolean[10];
			visited[i] = true;
			dfs(0, i+"", visited);
		}
		
		
		System.out.println(strMax);
		System.out.println(strMin);
	}
	
	private static void dfs(int idx, String res, boolean[] visited) {
		if(idx==N) {
			if(max<Long.parseLong(res)) {
				max = Long.parseLong(res);
				strMax = res;
			}
			if(min>Long.parseLong(res)) {
				min = Long.parseLong(res);
				strMin = res;
			}
			return;
		}
		
		for(int num = 0 ; num < 10 ;num++) {
			if(visited[num]) continue;
			if(arr[idx]=='<') {
				if(res.charAt(idx)-'0'<num) {
					visited[num] = true;
					dfs(idx+1, res+num, visited);
				}
			}else {
				if(res.charAt(idx)-'0'>num) {
					visited[num] = true;
					dfs(idx+1, res+num, visited);
				}
			}
			visited[num] = false;
			
		}
	}
}
