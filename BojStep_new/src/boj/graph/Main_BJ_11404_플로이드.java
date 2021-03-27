package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11404_플로이드 {
	static int N, M, arr[][], ans;
	static int INF = 100000001;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //정점개수
		M = Integer.parseInt(br.readLine()); //간선개수
	
	
		arr = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i!=j) arr[i][j] = INF;
			}
		}
		
		StringTokenizer st = null;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[from][to] = Math.min(arr[from][to], cost);
		}
		
		//플로이드와샬
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(arr[i][k]>INF) continue;
				
				if(i==k) continue;
				for (int j = 1; j <= N; j++) {
					if(arr[k][j]>INF) continue;
					if(i==j||j==k) continue;
					
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		
		//n개의 줄 출력
		//1->1 1->2 1->3 1->4 1->5
		//2->2 ....
		//....
		//5->1
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(arr[i][j]==INF) System.out.print("0 ");
				else System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
		
	}
	
}
