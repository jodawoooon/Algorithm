package boj.unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1976_여행가자 {
	static int N, M, parents[];
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		N = Integer.parseInt(br.readLine()); //도시의 수
		M = Integer.parseInt(br.readLine()); //여행계획에 속한 도시의 수
		
		parents = new int[N+1];
		
		makeSet();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <=N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1){
					union(i,j);
				}
			}
		}
		boolean flag = false;
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		
		for (int m = 1; m < M; m++) {
			int b = Integer.parseInt(st.nextToken());
			if(findSet(a)!=findSet(b)) {
				flag = true;
				break;
			}
			a = b;
		}
		
		if(flag) System.out.println("NO");
		else System.out.println("YES");
	}
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot!=bRoot) parents[bRoot]=aRoot;
		
	}
	private static int findSet(int a) {
		if(parents[a]==a) return a;
		else return parents[a] = findSet(parents[a]);
	}
	
	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
}
