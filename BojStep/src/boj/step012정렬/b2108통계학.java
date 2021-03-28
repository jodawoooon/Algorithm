package boj.step012정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class b2108통계학 {
	static int N,ans;

	static int[] arr, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		//산술평균 : N개의 수들의 합을 N으로 나눈 값. 소수점 첫째자리에서 반올림한 값
		double sum = 0;
		
		for (int n : arr) {
			sum += n;
		}
		double res = Math.round(sum/N);
		bw.write((int)res+"\n");
		
		//중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		bw.write(arr[N/2]+"\n");
		
		//최빈값 : N개의 수들 중 가장 많이 나타나는 값. 여러개 있으면 최빈 값 중 두번째로 작은 값
		//입력되는 정수의 절댓값은 4000을 넘지 않는다. -4000~+4000
		
		cnt = new int[8001];
		ArrayList<Integer> list = new ArrayList<>();
		int max = 0;
		for (int n : arr) {
			cnt[4000+n]++;
		}
		
		for (int i = 0; i < cnt.length; i++) {
			if(max<cnt[i]) {
				max = cnt[i];
			}
		}
		//다 하나씩만 있는거
		if(max==1) { 
			if(arr.length==1) {
				bw.write(arr[0]+"\n");
			}else {
				bw.write(arr[1]+"\n"); //오름차순 정렬된 arr에서 2번째 값을 print함
			}
			
		}else {
			for (int i = 0; i < cnt.length; i++) {
				if(max == cnt[i]) {
					list.add(i-4000);
				}
			}
			Collections.sort(list);
			if(list.size()==1) {
				bw.write(list.get(0)+"\n");
			}else {
				bw.write(list.get(1)+"\n"); //오름차순 정렬된 arr에서 2번째 값을 print함
			}
			
		}


		//범위 : N개의 수들 중 최댓값과 최솟값의 차이
		bw.write(arr[N-1]-arr[0]+"\n");
		bw.flush();
		bw.close();
		br.close();

	}
	
		
}
