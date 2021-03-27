package boj.step029최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_1774_우주신과의교감 {
	
	static int N,M, parents[];
	
	static class point{
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int from,to;
		double dis;

		public Edge(int from, int to, double dis) {
			super();
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dis, o.dis);
		}
		
	}
	
	static ArrayList<point> pointList;
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		pointList = new ArrayList<>();
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pointList.add(new point(x,y));
		}
		

		parents = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Union(x,y);
		}
		
		// 우주신들과 황선자씨는 2차원 좌표계로 나타낼 수 있는 세상에 살고 있다. 
		//통로들의 길이는 2차원 좌표계상의 거리와 같다.
		
		//첫째 줄에 만들어야 할 최소의 통로 길이를 출력하라. 출력은 소수점 둘째짜리까지 출력하여라.
		
		
		edgeList = new ArrayList<>();
		//edgeList 만들기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				point a = pointList.get(i);
				point b = pointList.get(j);
				double dis = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
				
				edgeList.add(new Edge(i,j,dis));
			}
		}
		
		Collections.sort(edgeList);
		
		makeSet();

		
		double result = 0;
		int count = 0;
		for (Edge edge : edgeList) {
			if(Union(edge.from, edge.to)) {
				result += edge.dis;
				
			}
		}
		
		
		
		System.out.printf("%.2f", result);
		
	}
	
	private static boolean Union(int from, int to) {
		int fRoot = findSet(from);
		int tRoot = findSet(to);
		if(fRoot==tRoot) return false;
		else parents[tRoot] = fRoot;
		return true;
	}
	
	private static int findSet(int from) {
		if(parents[from] == from) return from;
		else return parents[from] = findSet(parents[from]);
	}
	
	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
}
