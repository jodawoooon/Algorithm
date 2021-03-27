package boj.im;

import java.util.Scanner;

public class Main_BJ_3985_费纳捞农 {
	
	static int BigNum, BigIdx, Num, NumIdx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();//费纳捞农辨捞
		boolean[] cake = new boolean[L+1];
		
		int N = sc.nextInt();//规没按荐
		int[][] arr = new int[N][2];
		for (int n = 0; n < N; n++) {
			arr[n][0] = sc.nextInt();
			arr[n][1] = sc.nextInt();
			
			if(arr[n][1]-arr[n][0]>Num){
				Num = arr[n][1]-arr[n][0];
				NumIdx = n+1;
			}
		}
		
		System.out.println(NumIdx);
		int cnt = 0;
		for (int n = 0; n < N; n++) {
			cnt = 0;
			for (int i = arr[n][0]; i <=arr[n][1]; i++) {
				if(!cake[i]) {
					cake[i] = true;
					cnt++;
				}
			}
			
			if(BigNum<cnt) {
				BigNum=cnt;
				BigIdx = n+1;
			}
			if(BigNum==cnt) {
				if(BigIdx>n+1) {
					BigIdx = n+1;
				}
			}
			
		}
		System.out.println(BigIdx);
	}
}
