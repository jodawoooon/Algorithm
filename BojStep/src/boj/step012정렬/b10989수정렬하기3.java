package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b10989수정렬하기3 {
	static int N,ans;

	static int[] arr, sort;
	//카운팅정렬 (수의 범위가 작다면.)
	//카운팅정렬  : 중복되는 숫자의 갯수를 세어 정렬하는 방식.. 
	//정렬할 배열에서 최대값 구함. 0부터 최대값까지 각 숫자가 몇번 등장하는지 카운팅. 
	// 카운팅을 바탕으로 누적카운팅
	// 누적카운팅은 정렬된 배열의 인덱스가 된다. 뒤에서부터 차례대로 인덱스값을 계산해 정렬
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		sort = countingSort(arr);

			
		for (int n : sort) {
			bw.write(n+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static int[] countingSort(int[] array) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, array[i]);
		}
		
		int[] ans = new int[N];
		int[] cnt = new int[max+1];
		
		for (int i : array) {
			cnt[i]++;
		}
		
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for (int i = N-1; i >= 0; i--) {
			ans[--cnt[array[i]]] = array[i];
		}
		return ans;
	}
		
}
