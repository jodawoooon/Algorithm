package boj.step011브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b1182부분수열의합 {
	//N개의 정수로 이루어진 수열이 있을 때, 
	//크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
	
	static int N, S, cnt;
	static int[] arr, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			tgt = new int[i];
			comb(0,0,0);
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();
		br.close();
	}

	private static void comb(int idx, int k, int sum) {
		if(idx==tgt.length) {
			
			if(sum==S) cnt++;
			return;
		}
		
		if(idx==N) {	
			return;
		}
		for (int i = k; i < N; i++) {
			tgt[idx] = arr[i];
			comb(idx+1, i+1, sum+tgt[idx]);
		}
	}
}
