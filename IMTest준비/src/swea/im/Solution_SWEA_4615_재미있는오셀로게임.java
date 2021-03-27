package swea.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_SWEA_4615_재미있는오셀로게임 {
	
	static int N,ans;
	static int arr[][];
	static int[] dx = {-1,1,0,0,-1,1,-1,1};
	static int[] dy = {0,0,-1,1,-1,1,1,-1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("4615input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			int M = sc.nextInt();
			
			arr= new int[N][N];
			
			arr[N/2-1][N/2-1] = 2;
			arr[N/2-1][N/2] = 1;
			arr[N/2][N/2-1] = 1;
			arr[N/2][N/2] = 2;
			
			int cntB=0;
			int cntW=0;
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				int color = sc.nextInt();
				arr[x][y] = color;
				
				for (int d = 0; d < 8; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					
					boolean flag = false;
					while(true) {
						if(nx<0||nx>=N||ny<0||ny>=N||arr[nx][ny]==0) break;
						if(arr[nx][ny]==color) {
							//직선 이동 중 자기돌 찾았다면. 그 전에있는 남의돌 내돌 만들기
							flag = true;
							break;
						}
						//못찾아쓰면
						nx+=dx[d];
						ny+=dy[d];
					}
					if(flag) {
						while(true) {
							if(nx==x&&ny==y) break;
							arr[nx][ny]=color;
							nx-=dx[d];
							ny-=dy[d];
						}
					}
					
					
					
				}

				
				
			}
			
			
			for (int p = 0; p < N; p++) {
				for (int q = 0; q < N; q++) {
					if(arr[p][q]==1) {
						cntB++;
					}else if(arr[p][q]==2) {
						cntW++;
					}
				}
			}
			
			
			System.out.println("#"+t+" "+cntB+" "+cntW);
		
		}
	}
}
