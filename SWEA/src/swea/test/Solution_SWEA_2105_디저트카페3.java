package swea.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SWEA_2105_디저트카페3 {
	
	static int T, N, ans;
	static int[] dx = {1,1,-1,-1}; //우하, 좌하, 좌상, 우상
	static int[] dy = {1,-1,-1,1};
	static boolean[] select;
	static int[][] arr;
	static int tmpI, tmpJ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//인덱스 지키고, 같은 종류 디저트 X, 한지역 X
		//왔던길 되돌아가기 X
		//서로 다른 디저트를 먹으면서 사각형 모양을 그리며 다시 출발점으로 돌아오는경우
		//디저트를 가장 많이 먹을 수 있는 경우의 수 찾고, 그 수 출력
		//먹을수없는경우 -1 출력
		
		System.setIn(new FileInputStream("2105input.txt"));
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			
			
			N= sc.nextInt();
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			ans =-1;
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					select = new boolean[101];
					select[arr[i][j]] = true;
					tmpI =i;
					tmpJ =j;
					solve(i,j,0,0);
					
				}
			}
			System.out.println("#"+t+" "+ans);
	
		}

		
	}

	private static void solve(int i, int j, int cnt, int dir) {
		for (int d = dir; d < 4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			if(nx<0||ny<0||nx>=N||ny>=N)  continue;
			if(nx==tmpI&&ny==tmpJ) {
				ans = Math.max(ans, cnt+1);
				return;
			}
			
			if(select[arr[nx][ny]]) {
				continue;
			}
			select[arr[nx][ny]] =true;
			solve(nx,ny,cnt+1,d);
			select[arr[nx][ny]] =false;
		}
		
	}

}
