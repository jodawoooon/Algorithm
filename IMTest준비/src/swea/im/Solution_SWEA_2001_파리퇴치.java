package swea.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_SWEA_2001_파리퇴치 {
	
	static int N, M, arr[][];
	

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("2001input.txt"));
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		//M*M 사이즈 파리채 내리쳐 최대한 많이 죽이자
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			int ans =0;
			arr = new int[N][N];
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum=0;
					
					for (int x = i; x < i+M; x++) {
						for (int y = j; y < j+M; y++) {
							
							if(x>=0&&x<N&&y>=0&&y<N) {
								
								sum+=arr[x][y];
							}
						}
					}

					ans = Math.max(ans, sum);
				}
			}

			System.out.println("#"+t+" "+ans);
		}
	}
}
