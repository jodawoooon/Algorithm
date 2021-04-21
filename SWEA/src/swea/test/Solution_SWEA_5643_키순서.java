package swea.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서 {
	
	//학생들의 키를 비교한 결과가 주어질 때, 
	//자신의 키가 몇 번째인지 알 수 있는 학생들이 모두 몇 명인지 계산하여 출력하는 프로그램을 작성하시오.
	
	static int N,M,ans;
	
	static int INF = Integer.MAX_VALUE;
	static int[][] map; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); //tc 개수
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine()); //학생들의 수 N
			M = Integer.parseInt(br.readLine()); //두 학생의 키를 비교한 횟수 M
			
			ans = 0;
			map = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if(i!=j) map[i][j] = INF;
				}
			}
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//이는 번호가 a인 학생이 번호가 b인 학생보다 키가 작은 것을 의미한다. 
				
				map[a][b] = 1;
				
			}
			
			
			//플로이드 와샬 알고리즘
			for(int k=1; k<=N ; ++k) {
				for(int i=1; i<=N; ++i) {
					if(map[i][k]>=INF) continue; //가지치기
					if(i==k) continue;//가지치기
					
					for(int j=1; j<=N; ++j) {
						if(map[k][j]>=INF) continue;//가지치기
						if(i==j || k==j) continue;
						////경유지 들러서 가는게 더 빠르면
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			
			}
			
//			for (int[] ia : map) {
//				System.out.println(Arrays.toString(ia));
//			}
//			
			
			for (int i = 1; i <= N; i++) {
				boolean can = true;
				for (int j = 1; j <= N; j++) {
					if(map[i][j]==INF&&map[j][i]==INF) {
						can = false;
						break;
					}
				}
				
				if(can) {
					ans++;
				}
			}
			
			
			System.out.println("#"+t+" "+ans);
			
		}
	}
}
