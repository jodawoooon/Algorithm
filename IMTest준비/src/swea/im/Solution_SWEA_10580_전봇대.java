package swea.im;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_10580_Àüº¿´ë {
	public static void main(String[] args) {
Scanner sc =  new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[N][2];
			for (int n = 0; n < N; n++) {
				arr[n][0] = sc.nextInt();
				arr[n][1] = sc.nextInt();
			}
			
			//Arrays.sort(arr, (o1,o2)->o1[0]-o2[0]);
			int cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i==j) continue; //º»ÀÎ»©°í
					
					if(arr[i][0] < arr[j][0]&&arr[i][1]>arr[j][1]) {
						cnt++;
					}
					else if(arr[i][0]>arr[j][0]&&arr[i][1]<arr[j][1]) {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt/2);
		}
	}
}
