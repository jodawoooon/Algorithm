package boj.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10815_숫자카드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			int first = 0;
			int last = N-1;
			int mid = 0;
			boolean flag = false;
			
			while(first<=last) {
				mid = (first+last)/2; //중간 idx
				if(arr[mid]==input) {
					System.out.print("1 ");
					flag =true;
					break;
				}
				if(arr[mid]<input) {
					first = mid+1;
				}else {
					last = mid-1;
				}
				
			}
			
			if(!flag) System.out.print("0 ");
		}
		
		
		
		Arrays.sort(arr);
		
		
	}
}
