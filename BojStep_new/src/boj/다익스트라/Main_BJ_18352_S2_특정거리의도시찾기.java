package boj.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_18352_S2_특정거리의도시찾기 {
	
	static class Node implements Comparable<Node>{
		int v,cost;

		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost- o.cost;
		}
		
		
	}
	static int N, M, K, X, ans;
	static ArrayList<Node>[] adjList;
	static int[] dist;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		dist = new int[N+1];

		for (int i = 1; i <=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adjList[A].add(new Node(B, 1));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
	    
		dist[X] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int from = n.v;
			int fromCost = n.cost;
			
			if(dist[from]<fromCost) continue;
			
			for (Node node : adjList[from]) {
				int to = node.v;
				int toCost = node.cost+fromCost;
				
				if(dist[to] > toCost) {
					dist[to] = toCost;
					pq.add(new Node(to, toCost));
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(dist[i]==K) {
				ans++;
				System.out.println(i);
			}
		}
		
		if(ans==0) System.out.println(-1);
		
	}
}
