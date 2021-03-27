package swea.im;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_1954_´ŞÆØÀÌ¼ıÀÚ {
	
	static int[][] arr;
	
	static int[] dx = {0,1,0,-1};//¿ì ÇÏ ÁÂ »ó
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T= sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			arr = new int[N][N];
			int nx = 0;
			int ny = 0;
			int cnt =1;
			int tmp = 0;
			arr[nx][ny] = cnt++;
			while(true) {
				if(cnt>N*N) break;
				for (int d = 0; d < 4 ; d++) {
					nx += dx[d];
					ny += dy[d];
					while(true) {
						if(nx>=N||ny>=N||nx<0||ny<0) {
							nx-=dx[d];
							ny-=dy[d];
							break;
						}
						tmp = arr[nx][ny];
						if(arr[nx][ny]==0) {
							arr[nx][ny]=cnt++;
						}else {
							nx-=dx[d];
							ny-=dy[d];
							break;
						}
						nx+=dx[d];
						ny+=dy[d];
					}
					
					
				}
			}
			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}

		}
	}
}
