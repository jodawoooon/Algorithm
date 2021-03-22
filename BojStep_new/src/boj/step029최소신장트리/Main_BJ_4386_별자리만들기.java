package boj.step029최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_4386_별자리만들기 {
	
	
	static int N, M, X, ans;
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		int from, to, time;

		public Edge(int from, int to, int time) {
			super();
			this.from = from;
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.time, o.time);
		}
		
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(br.readLine()); //마을 수 . 학생 한명씩 살고 있다
		
		
		M = Integer.parseInt(br.readLine()); //총 M개의 단방향 도로가 있다.
		X = Integer.parseInt(br.readLine()); //N명 학생이 X번 마을에 모여서 파티를 벌인다
		
		//각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다.
		//오고가는데 걸리는 최소시간이 가장 긴 학생의 시간은?
		
		parents = new int[N+1];
		edgeList = new Edge[M];
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int from = Integer.parseInt(br.readLine());
			int to = Integer.parseInt(br.readLine());
			int time = Integer.parseInt(br.readLine());
			
			edgeList[m] = new Edge(from, to, time);
		}
		
		Arrays.sort(edgeList);
		
		//X번까지 마을까지 이동하는 방법.
		//그리고 다시 되돌아오는 방법
		
		
	}
	
	
}
