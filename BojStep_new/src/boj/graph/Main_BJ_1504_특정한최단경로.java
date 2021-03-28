package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1504_특정한최단경로 {

	static class Edge{
		int v;
		int dis;
		public Edge(int v, int dis) {
			super();
			this.v = v;
			this.dis = dis;
		}
		
	}
	
	/*
	 * 방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 
	 * 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 
	 * 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.
	 * 방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 
	 * 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 
	 * 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 
하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 
1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.

첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.
	 */
	
	static int N, E, dis[];
	static int INF = Integer.MAX_VALUE;
	static ArrayList<Edge>[] edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		dis = new int[N+1];
		edgeList = new ArrayList[N+1];
		for (int i = 0; i <=N; i++) {
			edgeList[i] = new ArrayList<>();
		}
		
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList[a].add(new Edge(b,c));
			edgeList[b].add(new Edge(a,c));
			
			//a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (
		}
		
		
		
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		
		long ans1 = solve(1,v1);
		ans1 += solve(v1,v2);
		ans1 += solve(v2,N);
		
		
		long ans2 = solve(1,v2);
		ans2 += solve(v2,v1);
		ans2 += solve(v1,N);
		//1->N 가는 사이에 v1과 v2를 지나야 한다.
		
		//경우의 수 1. 1->v1->v2->N
		
		
		long ans = Math.min(ans1, ans2);
		//System.out.println(INF);
		if(ans>=INF) System.out.println(-1);
		else System.out.println(ans);
	
	}
	private static int solve(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.dis-o2.dis;
			}
		});
		
		for (int i = 0; i <= N; i++) {
			dis[i] = INF;
		}
		
		dis[start] = 0;
		pq.add(new Edge(start,dis[start]));

		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int cur = e.v;
			int curDis = e.dis;
	
			if(curDis > dis[cur]) continue;
			for (Edge edge : edgeList[cur]) {
				int next = edge.v;
				int nextDis = edge.dis + dis[cur];

				if(dis[next] > nextDis) {
					dis[next] = nextDis;
					pq.add(new Edge(next, nextDis));
				}
				
			}
		}
		return dis[end];
	}
}
