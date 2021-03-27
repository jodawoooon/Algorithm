package swea.im;

import java.io.*;
import java.util.*;

public class Solution_SWEA_2005_파스칼의삼각형 {
	
	static int N,ans,T;


	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			
			//첫번째줄은 항상1
			//두번째줄 왼쪽, 오른쪽 위의 합
			int[][] arr = new int[N][N];
			/*
			 * 1
			 * 1 1
			 * 1 2 1
			 * 1 3 3 1
			 * 1 4 6 4 1
			 * 1 5 10 10 5 1
			 * 1 6 15 20 15 6 1
			 * 1 7 21 35 35 21 7 1
			 * 1 8 28 56 70 56 28 8 1
			 * 1 9 36 81 126 126 81 36 9 1
			 */
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if(i==j) {
						arr[i][j] = 1;
					}else if(j==0) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
					}
				}
			}

			System.out.println("#"+t);
			//내려갈수있는 애들 내려감
			//교착 상태 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}

		}
	}
}
