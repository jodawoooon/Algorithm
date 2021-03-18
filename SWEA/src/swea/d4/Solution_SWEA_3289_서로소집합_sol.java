package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_sol {
	static int T, N, M, parents[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t =1; t <=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			
			makeSet();
			System.out.print("#"+t+" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				//합집합은 0 a b
				//findSet은 1 a b
				
				int kind = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(kind==0) {
					union(a,b);
				}else if(kind==1){
					if(findSet(a)==findSet(b)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
			
		}
	}
	
	private static int findSet(int a) {
		if(parents[a]==a) return a;
		else return parents[a] = findSet(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot!=bRoot) parents[bRoot]= aRoot;
		
	}

	private static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	
}
