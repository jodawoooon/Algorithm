package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SWEA_1251_하나로 {
	
	// N개의 섬
	//환경 부담금 정책이 있습니다.
	//환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L2)만큼 지불
	//총 환경 부담금을 최소로 지불하며, N개의 모든 섬을 연결할 수 있는 교통 시스템을 설계
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;

		

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}



		@Override
		public int compareTo(Edge o) {
			//return this.weight-o.weight;
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static int N, T;
	static double E;
	static long ans;
	static int parents[];
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("1251input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> xList = new ArrayList<>();
			ArrayList<Integer> yList = new ArrayList<>();
			
			
			//x좌표
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				xList.add(Integer.parseInt(st.nextToken()));
			}
			
			//y좌표
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				yList.add(Integer.parseInt(st.nextToken()));
			}
			
			// 환경 부담 세율 실수 E
			E = Double.parseDouble(br.readLine()); 
			parents = new int[N];
			
			//모든 섬을 연결하는 최소비용 => 크루스칼 알고리즘
			
			edgeList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i!=j) {
						//각 해저터널 길이(L)의 제곱의 곱(E * L2)만큼 지불
						long tmp1 = Math.abs(xList.get(i)-xList.get(j));
						long tmp2 = Math.abs(yList.get(i)-yList.get(j));
						long L2 = tmp1*tmp1 + tmp2*tmp2;
						//각 해저터널 길이(L)의 제곱 . 루트 빼고 (tmp1^2+tmp2^2)

						
						edgeList.add(new Edge(i,j, L2));
					}
				}
			}
			
			Collections.sort(edgeList);
			make();
			
	
			int count = 0; // 선택한 간선수
			ans = 0;
			for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {//싸이클이 발생하지 않았다면
					
					ans += edge.weight; 
					if(++count == N-1) break; //모든섬이 연결되면 break; 더이상 돌 필요가 없다.
				}
			}

			System.out.println("#"+t+" "+Math.round(ans*E));
			
		}
	}
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) return false;
		else parents[bRoot] = aRoot;
		return true;
	}
	
	private static int findSet(int a) {
		if(parents[a]==a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i; //크기가 1인 단위집합 만들기
		}
	}
}
