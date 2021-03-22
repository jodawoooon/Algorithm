package boj.step029최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1197_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int a,b,c;

		public Edge(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.c, o.c);
		}
		
		
	}
	static int V, E, ans;
	static int[] parents;
	static Edge[] edgeList;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		V = Integer.parseInt(st.nextToken()); //정점의개수
		E = Integer.parseInt(st.nextToken()); //간선의개수
		
		parents = new int[V+1];
		edgeList = new Edge[E];
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			//C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
			edgeList[e] = new Edge(a,b,c);
		}
		
		
		
		Arrays.sort(edgeList);
		
		make();
		
		
		
		int sum = 0;
		int count = 0;
		
		for (Edge e : edgeList) {
			if(union(e.a, e.b)) {
				sum += e.c;
				count++;
				if(count==E-1) break;
			}
		}
		
		//첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.
			
		System.out.println(sum);
		
		
	}
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		else parents[bRoot] = aRoot;
		return true;
	}
	private static int findSet(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	private static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	
}
