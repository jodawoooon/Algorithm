package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_SUM {
	static int N, arr[][];
	

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1209input.txt"));
		Scanner sc = new Scanner(System.in);

		
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt();
			int ans =0;
			N=100;
			arr = new int[N][N];
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			
			//우하
			int sum1=0;
			for (int i = 0; i < N; i++) {
				sum1+= arr[i][i];
			}

			//좌하
			int sum2 =0;
			for (int i =0; i <N; i++) {
				sum2+= arr[i][N-i-1];
			}
			
			//행의 합
			int sum3=0;
			for (int i = 0; i < N; i++) {
				int tmp =0;
				for (int j = 0; j < N; j++) {
					tmp += arr[i][j];
				}
				sum3 = Math.max(tmp, sum3);
			}
			
			//열의 합
			int sum4=0;
			for (int i = 0; i < N; i++) {
				int tmp =0;
				for (int j = 0; j < N; j++) {
					tmp += arr[j][i];
				}
				sum4 = Math.max(tmp, sum4);
			}
			
			
			ans = Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4)));
			System.out.println("#"+t+" "+ans);
		}
	}
}
