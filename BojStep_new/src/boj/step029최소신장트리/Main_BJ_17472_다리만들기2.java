package boj.step029최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17472_다리만들기2 {
	
	static int N, M, map[][], V, parents[];
	static boolean[][] visit;
	static ArrayList<Edge> edgeList;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][M];
		//1. 섬에 번호 매기기
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1&&!visit[i][j]) {
					numberingBFS(i,j,cnt);
					cnt++;
				}
				
			}
		}
		
		//print();
		
		V = cnt-1;
		
		
		//2. 다리 만들기
		edgeList = new ArrayList<>();

		
		checkBridge();
		//print();
		
		
		
		//크루스칼
		
		parents = new int[V+1];
		
		makeSet();
		
		int count = 0;
		int result = 0;
		
		Collections.sort(edgeList);
		for (Edge edge : edgeList) {
			//System.out.println(edge.v1+" "+edge.v2+" "+edge.weight);
			if(Union(edge.v1, edge.v2)) {
				//System.out.println(edge.v1+" "+edge.v2+" "+edge.weight);
				result+=edge.weight;
				count++;
			}
			
			if(count==V-1) break;
		}
		
		if(result==0 || count!=V-1) System.out.println(-1);
		else System.out.println(result);
		
	}
	
	
	

	private static boolean Union(int v1, int v2) {
		int aRoot = findSet(v1);
		int bRoot = findSet(v2);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}




	private static int findSet(int v1) {
		if(parents[v1] == v1) return v1;
		else return parents[v1] = findSet(parents[v1]);
	}




	private static void makeSet() {
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}




	private static void checkBridge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0) {
					int num = map[i][j];
					for (int d = 0; d < 4; d++) {
						int nx = i;
						int ny = j;
						int dis = 0;
						while(true) {
							nx += dx[d];
							ny += dy[d];
							if(nx>=0&&ny>=0&&nx<N&&ny<M) {
								if(map[nx][ny]==0) {
									dis++;
								}
								else if(map[nx][ny]!=num) {
									if(dis>1) {
										edgeList.add(new Edge(num, map[nx][ny], dis));
										dis = 0;
										break;
									}else {
										break;
									}
								}else {
									break;
								}
							}else {
								break;
							}
						}
					}
				}
			}
		}
	}



	private static void numberingBFS(int i, int j, int cnt) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(i,j));
		visit[i][j] = true;
		map[i][j] = cnt;
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0&&ny>=0&&nx<N&&ny<M) {
					if(!visit[nx][ny]) {
						if(map[nx][ny]==1) {
							visit[nx][ny]=true;
							map[nx][ny]=cnt;
							q.add(new Node(nx,ny));
						}
					}
				}
			}
			
		}
	}
	
	
	private static void print() {
		for (int[] is:map) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("============================");
	}

	
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int v1;
		int v2;
		int weight;
		public Edge(int v1,int v2, int weight) {
			super();
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
}
