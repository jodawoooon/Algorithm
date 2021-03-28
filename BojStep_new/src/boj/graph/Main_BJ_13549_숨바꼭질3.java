package boj.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_13549_숨바꼭질3 {
	static class Edge{
		int v;
		int time;
		public Edge(int v, int time) {
			super();
			this.v = v;
			this.time = time;
		}
		
	}
	static int N, K;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		//만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
		//순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
		
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.time - o2.time;
			}
			
		});
		
		int time[] = new int[2*100000+1];
		for (int i = 0; i <=2*100000; i++) {
			time[i] = INF;
		}
		
		
		time[N] = 0;
		pq.add(new Edge(N,0));
		
		while(!pq.isEmpty()) {
			
			Edge e= pq.poll();
			int v = e.v;
			int t = e.time;
			
			if(v==K) break;
			//if(time[v] < t) continue;
			//경우의수 1. 걷는다 => X-1 :1초
			
			int nv = 0;
			int nt = 0;
			
			nv = v - 1;
			nt = t + 1;
			if(nv>=0&&time[nv]>nt) {
				time[nv] = nt;
				pq.add(new Edge(nv, nt));
			}
	
			nv = v + 1;
			nt = t + 1;
			if(nv<=K&&time[nv]>nt) {
				time[nv] = nt;
				pq.add(new Edge(nv, nt));
			}
				
			nv = 2*v;
			nt = t;
			if(nv<=2*K&&time[nv]>nt) {
				time[nv] = nt;
				pq.add(new Edge(nv, nt));
			}

			

		}
		
		
		System.out.println(time[K]);
		
	}
}
