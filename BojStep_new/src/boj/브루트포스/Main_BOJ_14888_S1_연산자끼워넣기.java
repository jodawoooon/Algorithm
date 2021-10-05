package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14888_S1_연산자끼워넣기 {
	
	static int N, arr[], oper[];
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		oper = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4 ; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
			//덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
		}
		
		dfs(0, arr[0]); 
		
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
	private static void dfs(int idx, int res) {
		if(idx==N-1) {
			MAX = Math.max(MAX, res);
			MIN = Math.min(MIN, res);
			return;
		}
		
		//덧셈
		if(oper[0]>0) {
			oper[0]--;
			dfs(idx+1, res + arr[idx+1]);
			oper[0]++;
		}
		//뺄셈
		if(oper[1]>0) {
			oper[1]--;
			dfs(idx+1, res - arr[idx+1]);
			oper[1]++;
		}
		//곱셈
		if(oper[2]>0) {
			oper[2]--;
			dfs(idx+1, res * arr[idx+1]);
			oper[2]++;
		}
		//나눗셈
		if(oper[3]>0) {
			oper[3]--;
			dfs(idx+1, res / arr[idx+1]);
			oper[3]++;
		}
		
	}
}
