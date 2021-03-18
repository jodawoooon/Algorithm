package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합 {
	static int T, n, m, parents[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t =1; t <=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			
			makeSet();
			
			StringBuilder sb = new StringBuilder("#"+t+" ");

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				//합집합은 0 a b
				//findSet은 1 a b
				
				int kind = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(kind==0) {
					union(a,b);
				}else if(kind==1){
					if(findSet(a)==findSet(b)) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
			
		}
	}
	
	private static int findSet(int x) {
		if(parents[x]==x) return x;
		else return parents[x] = findSet(parents[x]);
	}

	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px<py) parents[py]= px;
		else parents[px] = py;
		
	}

	private static void makeSet() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	
}
