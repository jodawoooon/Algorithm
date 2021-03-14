package boj.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_3085_사탕게임 {
	static int  N, ans;
	static char arr[][];
	
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		arr = new char[N][N];
		
		for (int i = 0; i <N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N-1; c++) {
				
				if(arr[r][c]!=arr[r][c+1]) {
					
					
					char tmp = arr[r][c];
					arr[r][c] = arr[r][c+1];
					arr[r][c+1] = tmp;
					
					//최대치 카운트
					int cnt =1;
					int res = 0;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N-1; j++) {
							if(arr[i][j]==arr[i][j+1]) {
							
								cnt++;
							}else {
								res = Math.max(cnt, res);
								//System.out.println("# "+1+" i,j "+i+j+" "+arr[i][j]+" "+res);
								cnt = 1;
							}
						}
						res = Math.max(cnt, res);
						cnt = 1;
					}
					
					
					
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N-1; j++) {
							if(arr[j][i]==arr[j+1][i]) {

								cnt++;
							}else {
								res = Math.max(cnt, res);
								//System.out.println("# "+2+" i,j "+j+i+" "+arr[j][i]+" "+res);
								cnt = 1;
							}
						}
						res = Math.max(cnt, res);
						cnt = 1;
					}
				
					
					
					tmp = arr[r][c];
					arr[r][c] = arr[r][c+1];
					arr[r][c+1] = tmp;
					
					
					ans = Math.max(res, ans);
				}
				
				
				
				
				if(arr[c][r]!=arr[c+1][r]) {
					char tmp = arr[c][r];
					arr[c][r] = arr[c+1][r];
					arr[c+1][r] = tmp;
					
					//최대치 카운트
					int cnt =1;
					int res = 0;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N-1; j++) {
							if(arr[i][j]==arr[i][j+1]) {
								cnt++;
							}else {
								res = Math.max(cnt, res);
								//System.out.println("# "+3+" i,j "+i+j+" "+arr[i][j]+" "+res);
								cnt = 1;
							}
						}
						res = Math.max(cnt, res);
						cnt = 1;
					}
					
					
					
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N-1; j++) {
							if(arr[j][i]==arr[j+1][i]) {
								cnt++;
							}else {
								res = Math.max(cnt, res);
								//System.out.println("# "+4+" i,j "+j+i+" "+arr[j][i]+" "+res);
								cnt = 1;
							}
						}
						res = Math.max(cnt, res);
						cnt = 1;
					}
				
					
				
					
					tmp = arr[c][r];
					arr[c][r] = arr[c+1][r];
					arr[c+1][r] = tmp;
					
					ans = Math.max(res, ans);

				}
				
			}
		}
		
		

		//사탕의 색이 다른 인접합 두 칸. 그 다음 고른 칸에 들어가 사탕 교환
		// 이제 모두 같은 색으로 이루어져있는 가장 긴 연속 부분을 고른다음 그 사탕을 모두 먹는다
		System.out.println(ans);
		
	}
	
	
}

