package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_2559_수열 {

	static int N,K,ans,sum;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
 
		arr = new int[N+1];
		
		K = Integer.parseInt(st.nextToken());
		ans = Integer.MIN_VALUE;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine()," ");
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		//다섯개를 계속 옮겨가면서 저장하지 않고
		//처음에 5개를 저장하고, 그 다음꺼 5개 저장하고 맨앞에거 떼는 방식으로 할 수있다
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}

		for (int k = 0; k < N-K+1; k++) {
			ans = Math.max(sum, ans);
			sum += arr[k+K];
			sum -= arr[k];
			
		}


		System.out.println(ans);
	}
}
