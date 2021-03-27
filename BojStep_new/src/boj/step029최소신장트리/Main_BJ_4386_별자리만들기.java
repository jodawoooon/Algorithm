package boj.step029최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_4386_별자리만들기 {
	
	//별자리를 만드는 최소 비용
	
	
	static class Edge implements Comparable<Edge>{
		int from,to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		
		public int compareTo(Edge o) {
			if(this.weight < o.weight) return -1;
			else return 1;
		}

	}
	
	static class Point {
		double x,y;
		public Point(double x,double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, parents[];
	static ArrayList<Edge> edgeList;
	static Point[] pointList;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pointList = new Point[N];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			double x = Double.parseDouble(st.nextToken()); //별의 x좌표
			double y = Double.parseDouble(st.nextToken()); //별의 y좌표
			
			pointList[n] = new Point(x,y);
					
		}
		
		edgeList = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i!=j) {
					double weight = Math.sqrt(Math.pow(pointList[i].x - pointList[j].x,2)+
							Math.pow(pointList[i].y - pointList[j].y,2));
					edgeList.add(new Edge(i,j,weight));
				}
			}
		}
		
		Collections.sort(edgeList);
		
		parents = new int[N];
		makeSet();
		
		double result = 0;
		int count = 0;
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(count==N-1) break;
			}
		}
		
		System.out.printf("%.2f", result);
	}
	private static boolean union(int from, int to) {
		int aRoot = findSet(from);
		int bRoot = findSet(to);
		if(aRoot==bRoot) return false;
		else parents[bRoot] = aRoot;
		return true;
	}
	
	private static int findSet(int from) {
		if(parents[from]==from) return from;
		else return parents[from] = findSet(parents[from]);

	}
	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	
}
