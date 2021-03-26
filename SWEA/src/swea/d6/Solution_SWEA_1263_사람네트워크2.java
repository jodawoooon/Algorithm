package swea.d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1263_사람네트워크2 {
	static int T, N, matrix[][];
	static int INF = 1000000;
	public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("1263input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	
        	matrix = new int[N][N];
        	
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j]==0&&i!=j) matrix[i][j] = INF;
				}
			}        	
        
        	
        	
        	for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(k==i) continue;
					for (int j = 0; j < N; j++) {
						if(i==j||k==j) continue;
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
					}
				}
			}
        	
        	
        	int ans = Integer.MAX_VALUE;
        	//사람들의 CC 값들 중에서 최솟값
        	for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum+=matrix[i][j];
				}
				
				ans = Math.min(sum, ans);
			}
        	
        	
        	System.out.println("#"+t+" "+ans);
        	
        }
        
        
        //네트워크 상에서 한 사용자가 다른 모든 사람에게 얼마나 가까운가
	}
}
