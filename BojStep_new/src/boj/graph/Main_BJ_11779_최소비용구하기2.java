package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_BJ_11779_최소비용구하기2 {

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
		
		//그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용과 경로를 출력하여라. 
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(to, weight));
			//adjList[to].add(new Edge(from, weight));
		}
		
		
		ArrayList<Integer>[] route = new ArrayList[N+1];
		for (int i = 1; i <=N; i++) {
			route[i] = new ArrayList<>();
		}
		
		
		cost = new int[N+1];
		for (int i = 1; i <= N; i++) {
			cost[i] = INF;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight-o2.weight;
			}
			
		});
		
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		cost[A] = 0;
		pq.add(new Edge(A, 0));

		
		while(!pq.isEmpty()) {
			
			Edge e = pq.poll();
			int v = e.v;
			int w = e.weight;
			
			if(cost[v] < w ) continue;
			if(v==B) break;
			for (Edge edge : adjList[v]) {
				int nv = edge.v;
				int nw = edge.weight + w;
				
				if(cost[nv] > nw) {
					route[nv].clear();
					for (int i = 0; i < route[v].size(); i++) {
						route[nv].add(route[v].get(i));
					}
					route[nv].add(v);
					cost[nv] = nw;
					pq.add(new Edge(nv, nw));
				}
				
			}

		}
		
		
		//결과
		System.out.println(cost[B]);
		route[B].add(B);
		System.out.println(route[B].size());
		for (int i : route[B]) {
			System.out.print(i+" ");
		}
		
	}
}
