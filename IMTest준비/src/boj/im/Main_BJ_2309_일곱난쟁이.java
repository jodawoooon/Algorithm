package boj.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_2309_ÀÏ°ö³­ÀïÀÌ {
	
	static int[] arr;
	static int[] tgt;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		tgt = new int[7];
		ans = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0,0);
		Arrays.sort(ans);
		for (int i : ans) {
			System.out.println(i);
		}
	}

	private static void comb(int idx, int k, int sum) {
		if(idx==7) {
			if(sum==100) {
				for (int i = 0; i < 7; i++) {
					ans[i] = tgt[i];
				}
			}
			return;
		}
		
		for (int i = k; i < 9; i++) {
			tgt[idx] = arr[i];
			comb(idx+1, i+1, sum+tgt[idx]);
		}
	}
}
