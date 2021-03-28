package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1916_최소비용구하기 {
	
	static class Edge{
		int v,weight;

		public Edge(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}
		
	}
	static int N, M;
	static ArrayList<Edge>[] adjList;
	static int[] cost;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine()); //정점의 개수
		M=Integer.parseInt(br.readLine()); //간선의 개수
		
		StringTokenizer st = null;
		
		adjList = new ArrayList[N+1];
		for (int i = 1; i <=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to, weight));
		
		}
		
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight-o2.weight;
			}
			
		});
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		

		cost = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cost[i] = INF;
		}
		cost[start] = 0;
		
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int cur = e.v;
			int curW = e.weight;
			
			if(curW > cost[cur]) continue;
			for (Edge edge : adjList[cur]) {
				int next = edge.v;
				int nextW = edge.weight + curW;
				
				if(cost[next] > nextW) {
					cost[next] = nextW;
					pq.add(new  Edge(next, nextW));
				}
				
				
				
			}
			
		}
		
		
		
		
		System.out.println(cost[end]);
	}
}
