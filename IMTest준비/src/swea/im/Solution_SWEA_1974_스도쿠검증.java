package swea.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_SWEA_1974_스도쿠검증 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1974input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int t = 1; t <= T; t++) {
			
			int N= 9;
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			

			int ans = 1;
			//가로
			boolean flag = true;
			int sum = 0;
			loop1:
			for (int i = 0; i < N; i++) {
				sum=0;

				for (int j = 0; j < N; j++) {
					sum += arr[i][j];
				}
				if(sum!=45) {
					flag = false;
					break loop1;
				}
			}
			if(!flag) {
				System.out.println("#"+t+" "+0);
				continue;
			}
			//세로
			loop2:
			for (int i = 0; i < N; i++) {
				
				sum=0;

				for (int j = 0; j < N; j++) {
					sum+=arr[j][i];
				
				}
				if(sum!=45) {
					flag = false;
					break loop2;
				}
			}
			if(!flag) {
				System.out.println("#"+t+" "+0);
				continue;
			}

			//네모
			loop3:
			for (int i = 0; i <= N-3; i+=3) {
				for (int j = 0; j <= N-3; j+=3) {
					sum=0;
					for (int x =i; x < i+3; x++) {
						for (int y =j; y < j+3; y++) {
							sum+=arr[x][y];
						
						}
					}
					if(sum!=45) {
						flag = false;
						break loop3;
					}
				}
			}
			if(!flag) {
				System.out.println("#"+t+" "+0);
				continue;
			}

			System.out.println("#"+t+" "+1);

			
		}
	}
}
