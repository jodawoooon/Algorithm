package boj.step029최소신장트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_9372_상근이의여행 {
	
	static int T, N, M, arr[], ans;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//최대한 적은 종류의 비행기를 타고 국가들을 이동
		// 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
		
		
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			
			make();
			
			ans = 0;
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				//a-b왕복 비행기
				
				union(a,b);
				
			}
			
			System.out.println(ans);
		}
		
	}
	
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot!=bRoot) {
			arr[bRoot] = aRoot;
			ans++;
		}
		else return;
		
	}

	private static int findSet(int a) {
		if(arr[a]==a) return a;
		else return arr[a] = findSet(arr[a]);
	}

	private static void make() {
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
	}
}
