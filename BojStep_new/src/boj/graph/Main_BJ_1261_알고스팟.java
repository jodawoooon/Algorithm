package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1261_알고스팟 {
	 
	//다익스트라 + BFS
	
	static class Edge{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] dis = new int[N+1][M+1];
		int[][] arr = new int[N+1][M+1];
			
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = str.charAt(j-1)-'0';
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
			
		});
		
		dis[1][1] = 0;
		pq.add(new Edge(1,1,0));
		
		
		while(!pq.isEmpty()) {
			
			Edge e = pq.poll();
			int from = e.from;
			int to = e.to;
			int w = e.weight;
			
			if(from == N && to ==  M) {
				System.out.println(w);
				break;
			}
			
//			if(dis[from][to] < w) continue;
			for (int d = 0; d < 4; d++) {
				int nx = from  + dx[d];
				int ny = to + dy[d];
				
				
				if(nx>=1&&ny>=1&&nx<=N&&ny<=M) {
					int nW = arr[nx][ny] + w;
					if(dis[nx][ny] > nW) {
						dis[nx][ny] = nW;
						pq.add(new Edge(nx,ny,nW));
					}
					
				}
			}
			
		}
		
		
	}
}
