package boj.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_10974_S3_모든순열 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		perm(0, new boolean[N+1], new int[N]);
	}

	private static void perm(int cnt, boolean[] visited, int[] arr) {
		if(cnt==N) {
			for(int n : arr)  System.out.print(n+" ");
			System.out.println();
		}
		
		for(int i = 1; i <= N ; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = i;
			perm(cnt+1, visited, arr);
			visited[i] = false;
		}
	}
}
