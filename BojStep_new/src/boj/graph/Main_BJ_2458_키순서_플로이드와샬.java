package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2458_키순서_플로이드와샬 {
	
	static int[][] minEdge;
	static int N, M, answer;
	static int INF = 100000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		minEdge = new int[N+1][N+1];
        
        for (int i = 0; i <= N; i++) {
			Arrays.fill(minEdge[i], INF);
		}
		
        // 입력처리 : 키 순서를 안다면 1 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			minEdge[A][B] = 1;
		}
		
		// 플로이드 와샬 : 경유지 - 출발지 - 도착지 3중 for문
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(k==i) continue;
				for (int j = 1; j <= N; j++) {
					if(i == j || k == j) continue;
					minEdge[i][j] = Math.min(minEdge[i][j], minEdge[i][k] + minEdge[k][j]);
				}
			}
		}
		
		// 키를 알 수 있느 ㄴ경우.
		// INF가 아니고 cnt가 N-1
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				if(minEdge[i][j]==INF && minEdge[j][i]==INF) break;
				cnt++;
			}
			if(cnt==N-1) answer++;
		}
		
		System.out.println(answer);
	}
	
	
}
