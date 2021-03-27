package boj.unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1717_집합의표현 {
	
	static int N, M, parents[];
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		makeSet();
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine()," ");
			int com = Integer.parseInt(st.nextToken());
			int a =  Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//com==1 합집합
			//com==1 포함되어있는지확인
			
			if(com==0) {
				Union(a,b);
			}else if(com==1) {
				if(findSet(a)==findSet(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
		
	}
	
	private static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static boolean Union(int a, int b) {
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
}
